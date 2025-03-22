package kinoko.packet.world;

import kinoko.server.header.OutHeader;
import kinoko.server.packet.OutPacket;
import kinoko.world.user.data.MapTransferInfo;
import kinoko.world.user.data.MapTransferResultType;

public final class MapTransferPacket {
    // CWvsContext::OnMapTransferResult --------------------------------------------------------------------------------

    public static OutPacket deleteList(MapTransferInfo mapTransferInfo, int rockType) {
        return MapTransferPacket.update(MapTransferResultType.DeleteList, mapTransferInfo, rockType);
    }

    public static OutPacket registerList(MapTransferInfo mapTransferInfo, int rockType) {
        return MapTransferPacket.update(MapTransferResultType.RegisterList, mapTransferInfo, rockType);
    }

    public static OutPacket unknown() {
        return MapTransferPacket.of(MapTransferResultType.Unknown);
    }

    public static OutPacket notAllowed() {
        return MapTransferPacket.of(MapTransferResultType.NotAllowed);
    }

    public static OutPacket targetNotExist() {
        return MapTransferPacket.of(MapTransferResultType.TargetNotExist);
    }

    public static OutPacket registerFail() {
        return MapTransferPacket.of(MapTransferResultType.RegisterFail);
    }

    private static OutPacket update(MapTransferResultType resultType, MapTransferInfo mapTransferInfo, int rockType) {
        final OutPacket outPacket = OutPacket.of(OutHeader.MapTransferResult);
        outPacket.encodeByte(resultType.getValue());
        outPacket.encodeByte(rockType);
        switch (rockType) {
            case 1 -> { //RegRocks
                mapTransferInfo.encodeMapTransfer(outPacket);
            }
            case 2 -> { //VIP rock
                mapTransferInfo.encodeMapTransferEx(outPacket);
            }
            case 3 -> { //Premium rock
                mapTransferInfo.encodeMapTransferPremium(outPacket);
            }
            case 4 -> { //Hyper rock
                mapTransferInfo.encodeMapTransferHyper(outPacket);
            }
        }
        return outPacket;
    }

    private static OutPacket of(MapTransferResultType resultType) {
        final OutPacket outPacket = OutPacket.of(OutHeader.MapTransferResult);
        outPacket.encodeByte(resultType.getValue());
        outPacket.encodeByte(0); // ignored unless result type is DeleteList or RegisterList
        return outPacket;
    }
}
