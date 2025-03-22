package kinoko.server.dialog;

public enum UIType {
    // UI
    ITEM(0),
    EQUIP(1),
    STAT(2),
    SKILL(3),
    MINIMAP(4),
    KEYCONFIG(5),
    QUESTINFO(6),
    USERLIST(7),
    MESSENGER(8),
    MONSTERBOOK(9),
    USERINFO(10),
    SHORTCUT(11),
    MENU(12),
    QUESTALARM(13),
    PARTYHP(14),
    QUESTTIMER(15),
    QUESTTIMERACTION(16),
    MONSTERCARNIVAL(17),
    ITEMSEARCH(18),
    ENERGYBAR(19),
    GUILDBOARD(20),
    PARTYSEARCH(21),
    ITEMMAKE(22),
    CONSULT(23),
    CLASSCOMPETITION(24),
    RANKING(25),
    FAMILY(26),
    FAMILYCHART(27),
    OPERATORBOARD(28),
    OPERATORBOARDSTATE(29),
    MEDALQUESTINFO(30),
    WEBEVENT(31),
    SKILLEX(32),
    REPAIRDURABILITY(33),
    CHATWND(34),
    BATTLERECORD(35),
    GUILDMAKEMARK(36),
    GUILDMAKE(37),
    GUILDRANK(38),
    GUILDBBS(39),
    ACCOUNTMOREINFO(40),
    FINDFRIEND(41),
    DRAGONBOX(42),
    CREATE_PREMIUMADVENTURER(43),
    WNDNO(44),
    UNRELEASE(45),
    PROFESSION(46),
    UNK47(47),
    UNK48(48),
    UNK49(49),
    UNK50(50),
    UNK51(51),
    UNK52(52),
    PVP(53),
    ITEMPOT(54),
    CRUSADERSET(55),
    CARDSET1(56), //Tutorial
    CARDSET2(57);

    private final int value;

    UIType(int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }

    public static UIType getByValue(int value) {
        for (UIType type : values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        return ITEM;
    }
}
