package kinoko.world.user.data;

import kinoko.server.packet.OutPacket;
import kinoko.world.GameConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public final class MapTransferInfo {
    private final List<Integer> mapTransfer = new ArrayList<>();
    private final List<Integer> mapTransferEx = new ArrayList<>();
    private final List<Integer> mapTransferPremium = new ArrayList<>();
    private final List<Integer> mapTransferHyper = new ArrayList<>();

    private static final Logger log = LogManager.getLogger(MapTransferInfo.class);

    public List<Integer> getMapTransfer() {
        return mapTransfer;
    }

    public List<Integer> getMapTransferEx() {
        return mapTransferEx;
    }

    public List<Integer> getMapTransferPremium() {
        return mapTransferPremium;
    }

    public List<Integer> getMapTransferHyper() {
        return mapTransferHyper;
    }

    public boolean delete(int fieldId, int rockType) {
        switch (rockType) {
            case 1 -> {
                return mapTransfer.remove(Integer.valueOf(fieldId));
            }
            case 2 -> {
                return mapTransferEx.remove(Integer.valueOf(fieldId));
            }
            case 3 -> {
                return mapTransferPremium.remove(Integer.valueOf(fieldId));
            }
            case 4 -> {
                return mapTransferHyper.remove(Integer.valueOf(fieldId));
            }
            default -> {
                log.debug("Unknown rock type: {}", rockType);
                return false;
            }
        }
    }

    public boolean register(int fieldId, int rockType) {
        switch (rockType) {
            case 1 -> {
                if (mapTransfer.size() >= 5) {
                    return false;
                }
                mapTransfer.add(fieldId);
            }
            case 2 -> {
                if (mapTransferEx.size() >= 10) {
                    return false;
                }
                mapTransferEx.add(fieldId);
            }
            case 3 -> {
                if (mapTransferPremium.size() >= 13) {
                    return false;
                }
                mapTransferPremium.add(fieldId);
            }
            case 4 -> {
                if (mapTransferHyper.size() >= 13) {
                    return false;
                }
                mapTransferHyper.add(fieldId);
            }
            default -> {
                log.debug("Unknown rock type: {}", rockType);
                return false;
            }
        }
        return true;
    }

    public void encodeMapTransfer(OutPacket outPacket) {
        for (int i = 0; i < 5; i++) {
            if (i < mapTransfer.size()) {
                outPacket.encodeInt(mapTransfer.get(i));
            } else {
                outPacket.encodeInt(GameConstants.UNDEFINED_FIELD_ID);
            }
        }
    }

    public void encodeMapTransferEx(OutPacket outPacket) {
        for (int i = 0; i < 10; i++) {
            if (i < mapTransferEx.size()) {
                outPacket.encodeInt(mapTransferEx.get(i));
            } else {
                outPacket.encodeInt(GameConstants.UNDEFINED_FIELD_ID);
            }
        }
    }

    public void encodeMapTransferPremium(OutPacket outPacket) {
        for (int i = 0; i < 13; i++) {
            if (i < mapTransferPremium.size()) {
                outPacket.encodeInt(mapTransferPremium.get(i));
            } else {
                outPacket.encodeInt(GameConstants.UNDEFINED_FIELD_ID);
            }
        }
    }

    public void encodeMapTransferHyper(OutPacket outPacket) {
        for (int i = 0; i < 13; i++) {
            if (i < mapTransferHyper.size()) {
                outPacket.encodeInt(mapTransferHyper.get(i));
            } else {
                outPacket.encodeInt(GameConstants.UNDEFINED_FIELD_ID);
            }
        }
    }
}
