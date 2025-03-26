package kinoko.packet.world;

public enum MessageType {
    // MS
    DropPickUp(0),
    QuestRecord(1),
    CashItemExpire(2),
    IncEXP(3),
    IncSP(4),
    IncPOP(5),
    IncMoney(6),
    IncGP(7),
    IncCommitment(8),
    GiveBuff(9),
    GeneralItemExpire(10),
    System(11),
    QuestRecordEx(12),
    ItemProtectExpire(13),
    ItemExpireReplace(14),
    SkillExpire(15),
    IncTrait(16),
    MaxTrait(17),
    RecipeExpire(18),
    NoAndroidHeart(19),
    RestFatigue(20),
    IncBattlePoint(21),
    PvpItem(22), //Gray text, up to 2 lines
    ReturnStones(23);

    private final byte value;

    MessageType(int value) {
        this.value = (byte) value;
    }

    public byte getValue() {
        return value;
    }
}
