package kinoko.provider;

import io.fury.Fury;
import io.fury.ThreadLocalFury;
import io.fury.ThreadSafeFury;
import io.fury.config.Language;
import kinoko.provider.map.*;
import kinoko.provider.wz.*;
import kinoko.provider.wz.property.WzListProperty;
import kinoko.provider.wz.property.WzProperty;
import kinoko.server.Server;
import kinoko.server.ServerConfig;
import kinoko.server.ServerConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public final class MapProvider {
    public static final Path MAP_WZ = Path.of(ServerConfig.WZ_DIRECTORY, "Map.wz");
    public static final Path MAP_DIRECTORY = Path.of(ServerConfig.DAT_DIRECTORY, "map");
    private static final Logger log = LogManager.getLogger(MapProvider.class);
    private static final ThreadSafeFury fury = new ThreadLocalFury(classLoader -> {
        final Fury f = Fury.builder().withLanguage(Language.JAVA)
                .withClassLoader(classLoader)
                .build();
        f.register(MapInfo.class);
        f.register(Foothold.class);
        f.register(LifeType.class);
        f.register(LifeInfo.class);
        f.register(PortalType.class);
        f.register(PortalInfo.class);
        f.register(ReactorInfo.class);
        return f;
    });

    public static void initialize(boolean reset) {
        if (!Files.isDirectory(MAP_DIRECTORY) || reset) {
            try {
                if (Files.isDirectory(MAP_DIRECTORY)) {
                    try (final Stream<Path> walk = Files.walk(MAP_DIRECTORY)) {
                        walk.sorted(Comparator.reverseOrder())
                                .map(Path::toFile)
                                .forEach(File::delete);
                    }
                }
                Files.deleteIfExists(MAP_DIRECTORY);
                Files.createDirectories(MAP_DIRECTORY);
                try (final WzReader reader = WzReader.build(MAP_WZ, new WzReaderConfig(WzConstants.WZ_GMS_IV, ServerConstants.GAME_VERSION))) {
                    final WzPackage wzPackage = reader.readPackage();
                    loadMapInfos(wzPackage);
                } catch (ProviderError e) {
                    log.error("Exception caught while loading Map.wz", e);
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public static Optional<MapInfo> getMapInfo(int mapId) {
        try {
            final byte[] data = Files.readAllBytes(getPath(mapId));
            return Optional.of(fury.deserializeJavaObject(data, MapInfo.class));
        } catch (IOException e) {
            log.error("Exception caught while loading MapInfo for map ID : {}", mapId, e);
        }
        return Optional.empty();
    }

    private static Path getPath(int mapId) {
        return Path.of(MAP_DIRECTORY.toString(), String.format("%d.dat", mapId));
    }

    private static void loadMapInfos(WzPackage source) throws ProviderError, IOException {
        final WzDirectory mapDirectory = source.getDirectory().getDirectories().get("Map");
        if (mapDirectory == null) {
            throw new ProviderError("Could not resolve Map.wz/Map");
        }
        for (var dirEntry : mapDirectory.getDirectories().entrySet()) {
            final String directoryName = dirEntry.getKey();
            if (!directoryName.matches("Map[0-9]")) {
                continue;
            }
            for (var mapEntry : dirEntry.getValue().getImages().entrySet()) {
                final String imageName = mapEntry.getKey();
                final int mapId = Integer.parseInt(imageName.replace(".img", ""));
                final MapInfo mapInfo = resolveMapInfo(mapId, mapEntry.getValue());

                final byte[] data = fury.serializeJavaObject(mapInfo);
                Files.write(getPath(mapId), data);
            }
        }
    }

    private static MapInfo resolveMapInfo(int mapId, WzImage image) throws ProviderError {
        final Map<String, Object> props = image.getProperty().getItems();

        final List<Foothold> foothold = resolveFoothold((WzListProperty) props.get("foothold"));
        final List<LifeInfo> life = resolveLife((WzListProperty) props.get("life"));
        final List<PortalInfo> portal = resolvePortal((WzListProperty) props.get("portal"));
        final List<ReactorInfo> reactor = resolveReactor((WzListProperty) props.get("reactor"));

        if (!(props.get("info") instanceof WzListProperty infoProp)) {
            throw new ProviderError("Failed to resolve info property");
        }
        return MapInfo.from(mapId, foothold, life, portal, reactor, infoProp);
    }

    private static List<Foothold> resolveFoothold(WzListProperty layerList) throws ProviderError {
        final List<Foothold> foothold = new ArrayList<>();
        for (var layerEntry : layerList.getItems().entrySet()) {
            final int layerId = Integer.parseInt(layerEntry.getKey());
            if (!(layerEntry.getValue() instanceof WzListProperty groupList)) {
                throw new ProviderError("Failed to resolve foothold property");
            }
            for (var groupEntry : groupList.getItems().entrySet()) {
                final int groupId = Integer.parseInt(groupEntry.getKey());
                if (!(groupEntry.getValue() instanceof WzListProperty footholdList)) {
                    throw new ProviderError("Failed to resolve foothold property");
                }
                for (var footholdEntry : footholdList.getItems().entrySet()) {
                    final int footholdId = Integer.parseInt(footholdEntry.getKey());
                    if (!(footholdEntry.getValue() instanceof WzListProperty footholdProp)) {
                        throw new ProviderError("Failed to resolve foothold property");
                    }
                    foothold.add(Foothold.from(layerId, groupId, footholdId, footholdProp));
                }
            }
        }
        return foothold;
    }

    private static List<LifeInfo> resolveLife(WzListProperty lifeList) throws ProviderError {
        final List<LifeInfo> life = new ArrayList<>();
        for (var lifeEntry : lifeList.getItems().entrySet()) {
            if (!(lifeEntry.getValue() instanceof WzListProperty lifeProp)) {
                throw new ProviderError("Failed to resolve life property");
            }
            final LifeType lifeType = LifeType.fromString(lifeProp.get("type"));
            if (lifeType == null) {
                throw new ProviderError("Unknown life type : %s", lifeProp.get("type"));
            }
            life.add(LifeInfo.from(lifeType, lifeProp));
        }
        return life;
    }

    private static List<PortalInfo> resolvePortal(WzListProperty portalList) throws ProviderError {
        final List<PortalInfo> portal = new ArrayList<>();
        for (var portalEntry : portalList.getItems().entrySet()) {
            final int portalId = Integer.parseInt(portalEntry.getKey());
            if (!(portalEntry.getValue() instanceof WzListProperty portalProp)) {
                throw new ProviderError("Failed to resolve portal property");
            }
            final PortalType portalType = PortalType.fromInt(portalProp.get("pt"));
            if (portalType == null) {
                throw new ProviderError("Unknown portal type : %d", portalProp.get("pt"));
            }
            portal.add(PortalInfo.from(portalType, portalId, portalProp));
        }
        return portal;
    }

    private static List<ReactorInfo> resolveReactor(WzListProperty reactorList) throws ProviderError {
        final List<ReactorInfo> reactor = new ArrayList<>();
        for (var reactorEntry : reactorList.getItems().entrySet()) {
            if (!(reactorEntry.getValue() instanceof WzListProperty reactorProp)) {
                throw new ProviderError("Failed to resolve reactor property");
            }
            reactor.add(ReactorInfo.from(reactorProp));
        }
        return reactor;
    }
}
