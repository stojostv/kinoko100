package kinoko.server.header;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum InHeader {
    CHECK_PASSWORD(1),
    WORLD_INFORMATION(4),
    SELECT_WORLD(5),
    CHECK_USER_LIMIT(6),
    LICENSE_RESPONSE(7),
    SET_GENDER(8),
    CHECK_PIN_CODE(9),
    CREATE_PIN_CODE(10),
    VIEW_WORLD_SELECT(11),
    INCORRECT_LOGIN_STEP(12),
    VIEW_ALL_CHAR(13),
    SELECT_CHAR_BY_VAC(14),
    VIEW_ALL_CHAR_RESPONSE(15),
    CHECK_NAME_CHANGE_POSSIBLE(16),
    CHECK_TRANSFER_WORLD_POSSIBLE(18),
    SELECT_CHAR(19),
    MIGRATE_IN(20),
    CHECK_DUPLICATE_ID(21),
    NEW_CHAR(22),
    NEW_CHAR_SALE(23),
    DELETE_CHAR(24),
    ALIVE_ACK(25),
    EXCEPTION_LOG(26),
    CHECK_CLIENT_INTEGRITY(27),
    INITIALIZE_SPW(28),
    CHECK_SPW(29),
    INITIALIZE_SPW_BY_VAC(30),
    CHECK_SPW_BY_VAC(31),
    LOGIN_INIT(34),
    LOGIN_ERROR(35),
    CLIENT_ERROR(36),
    TRANSFER_FIELD(41),
    TRANSFER_CHANNEL(42),
    MIGRATE_TO_CASHSHOP(43),
    USER_MOVE(44),
    USER_SIT(45),
    USER_PORTABLE_CHAIR(46),
    USER_MELEE_ATTACK(47),
    USER_SHOOT_ATTACK(48),
    USER_MAGIC_ATTACK(49),
    USER_BODY_ATTACK(50),
    USER_MOVING_SHOOT_ATTACK_PREPARE(51),
    USER_DAMAGED(52),
    USER_CHAT(54),
    USER_AD_BOARD_CLOSE(55),
    USER_EMOTION(56),
    USER_ACTIVE_EFFECT_ITEM(57),
    USER_UPGRADE_TOMB_EFFECT(58),
    USER_BAN_MAP_BY_MOB(61),
    SCRIPT_START(63),
    REMOTE_SHOP_OPEN(64),
    SCRIPT_ACTION(65),
    SHOP_DLG(66),
    TRUNK_DLG(67),
    ENTRUSTED_SHOP_CHECK(68),
    STORE_BANK_DLG(69),
    PARCEL_DLG(70),
    USER_SKILL_EFFECT(71),
    SHOP_SCANNER(72),
    SHOP_SCANNER_LINK(73),
    ADMIN_SHOP_DLG(74),
    GATHER_ITEM(75),
    SORT_ITEM(76),
    CHANGE_SLOT_POSITION(77),
    USE_STAT_CHANGE_ITEM(78),
    CANCEL_STAT_CHANGE_ITEM(79),
    STAT_CHANGE_BY_PORTABLE_CHAIR(80),
    USE_MOB_SUMMON_ITEM(81),
    USE_PET_FOOD_ITEM(82),
    USE_TAMING_MOB_FOOD_ITEM(83),
    SCRIPT_RUN_ITEM(84),
    USE_CONSUME_CASH_ITEM(85),
    PET_REMOVE(86),
    USE_BRIDLE_ITEM(87),
    USE_SKILL_LEARN_ITEM(88),
    USE_SKILL_RESET_ITEM(89),
    USE_SHOP_SCANNER_ITEM(90),
    USE_MAP_TRANSFER_ITEM(91),
    USE_PORTAL_SCROLL(92),
    USE_UPGRADE_ITEM(93),
    USE_HYPER_UPGRADE_ITEM(94),
    USE_ITEM_OPTION_UPGRADE_ITEM(95),
    UI_OPEN_ITEM(96),
    ITEM_RELEASE(97),
    ABILITY_UP(98),
    AUTO_AP_UP(99),
    STAT_CHANGE(100),
    STAT_CHANGE_BY_ITEM_OPTION(101),
    SKILL_UP(102),
    SKILL_USE(103),
    SKILL_CANCEL(104),
    SKILL_PREPARE(105),
    USER_DROP_MONEY(106),
    GIVE_POPULARITY(107),
    CHARACTER_INFO(109),
    PET_ACTIVATE(110),
    CHECK_TEMPORARY_STAT_DURATION(111),
    PORTAL_SCRIPT(112),
    PORTAL_TELEPORT(113),
    MAP_TRANSFER(114),
    USE_ANTI_MACRO_ITEM(115),
    ANTI_MACRO_SKILL(116),
    ANTI_MACRO_RESPONSE(117),
    CLAIM(118),
    USER_QUEST_ACTION(119),
    CALC_DAMAGE_STAT(120),
    USER_THROW_GRENADE(121),
    MACRO_SYS_FLUSH(122),
    USE_SELECT_NPC_ITEM(123),
    USE_LOTTERY_ITEM(124),
    ITEM_MAKER(125),
    CHAT_MSG_SLASH_UNK_126(126),
    USE_BOX_GACHAPON_ITEM(127),
    USE_GACHAPON_REMOTE_ITEM(128),
    USE_WATER_OF_LIFE(129),
    REPAIR_DURABILITY_ALL(130),
    REPAIR_DURABILITY(31),
    SAVE_DAMAGE_INFO(132),
    USER_UPDATE_CLIENT_TIMER(133),
    FOLLOW_CHARACTER(134),
    PQ_SELECT_REWARD(136),
    PQ_REQUEST_REWARD(137),
    FOLLOW_CHARACTER_ACTION(138),
    CHAT_MSG_SLASH_UNK_139(139),
    GROUP_MESSAGE(140),
    WHISPER(141),
    COUPLE_MESSAGE(142),
    MESSENGER(143),
    MINIROOM(144),
    PARTY_REQUEST(145),
    PARTY_RESPONSE(146),
    EXPEDITION_REQUEST(147),
    EXPEDITION_RESPONSE(148),
    GUILD_REQUEST(149),
    GUILD_RESPONSE(150),
    CHAT_MSG_SLASH_UNK_151(151),
    CHAT_MSG_SLASH_UNK_152(152),
    FRIEND_REQUEST(153),
    MEMO_REQUEST(154),
    ENTER_TOWN_PORTAL(156),
    ENTER_OPEN_GATE(157),
    CHAT_MSG_SLASH_UNK_158(158),
    SAVE_FUNC_KEY_MAP(159),
    RPS_GAME_DLG(160),
    MARRIAGE_REQUEST(161),
    WISH_LIST_DLG(162),
    WEDDING_PROGRESS(163),
    WEDDING_BLESS(164),
    BOOBY_TRAP_ALERT(165),
    MINIMAP_MOUSE_BUTTON_UNK_166(166),
    ALLIANCE_REQUEST(167),
    ALLiANCE_RESPONSE(168),
    FAMILY_CHART(169),
    FAMILY_INFO(170),
    REGISTER_JUNIOR(171),
    UNREGISTER_JUNIOR(172),
    UNREGISTER_PARENT(173),
    FAMILY_INVITE_RESULT(174),
    FAMILY_PRIVILEGE(175),
    FAMILY_PRECEPT(176),
    FAMILY_SUMMON(177),
    GUILD_BBS(179),
    MIGRATE_TO_ITC(180),
    USE_EXP_UP_ITEM(181),
    USE_TEMP_EXP(182),
    NEW_YEAR_CARD_DLG(183),
    RANDOM_MORPH_DLG(184),
    USE_CASH_ITEM_GACHAPON(185),
    USE_CASH_GACHAPON(186),
    CHANGE_MAPLE_POINT(187),
    USER_SELECT_TUTOR(188),
    USER_INC_COMBO(189),
    MOB_CRC_KEY_CHANGED_ACK(190),
    REQUEST_SESSION_VALUE(191),
    CHECK_OP_BOARD_HAS_NEW(192),
    ACCOUNT_MORE_INFO(193),
    FIND_FRIEND(194),
    APSP_EVENT_RESPONSE(195),
    DRAGON_BALL_BOX(196),
    DRAGON_BALL_SUMMON(197),
    PET_MOVE(199),
    PET_ACTION(200),
    PET_COMMAND(201),
    PET_DROP_PICK_UP(202),
    PET_USE_STAT_CHANGE_ITEM(203),
    PET_UPDATE_EXCEPTION_LIST(204),
    SUMMON_MOVE(207),
    SUMMON_ATTACK(208),
    SUMMON_DAMAGED(209),
    SUMMON_SKILL(210),
    SUMMON_REMOVE(211),
    DRAGON_MOVE(214),
    SAVE_QUICKSLOT_KEY_MAP(216),
    USER_UPDATE_PASSIVE_SKILL(217),
    UPDATE_CLIENT_ENVIRONMENT(218),
    USER_MAGIC_ATTACK_UNK_219(219),
    USE_PAMS_SONG_RESPONSE(220),
    QUEST_HELPER(221),
    USER_REMOVE_REPEAT_EFFECT(222),
    MOB_MOVE(227),
    MOB_APPLY_CONTROL(228),
    MOB_DROP_PICK_UP(229),
    MOB_HIT_BY_OBSTACLE(230),
    MOB_HIT_BY_MOB(231),
    MOB_SELF_DESTRUCTION(232),
    MOB_ATTACK_MOB(233),
    MOB_SKILL_DELAY_END(234),
    MOB_TIME_BOMB_END(235),
    MOB_ESCORT_COLLISION(236),
    MOB_ESCORT_PATH_REQUEST(237),
    MOB_ESCORT_STOP_END_REQUEST(238),
    NPC_MOVE(241),
    NPC_SPECIAL_ACTION_REQUEST(242),
    USER_DROP_PICK_UP(243),
    REACTOR_HIT(249),
    REACTOR_TOUCH(250),
    USER_RESET_NLCPQ(251),
    SNOWBALL_HIT(255),
    SNOWBALL_UNK_256(256),
    COCONUT_HIT(257),
    CHAT_MSG_SLASH_MATCHTABLE(258),
    GUILD_BOSS_HIT(259),
    MONSTER_CARNIVAL_REQUEST(262),
    CONTI_MOVE_INIT(264),
    PARTY_WANTED_REQUEST(266),
    PARTY_WANTED_CANCEL(267),
    SET_FIELD_UNK_269(269),
    REQUEST_FOOT_HOLD_INFO(270),
    CASHSHOP_QUERY_CASH(274),
    CASHSHOP_ACTION(275),
    CASHSHOP_CHECK_COUPON(276),
    RAISE_CREATE(283),
    RAISE_UI_STATE(284),
    RAISE_PUT_ITEM(285),
    RAISE_PUT_PIECE(286),
    CLASS_COMPETITION_REQUEST_AUTH_KEY(291),
    WEB_EVENT_REQUEST_AUTH_KEY(292),
    ITEM_UPGRADE_RESULT(296),
    BATTLE_RECORD_REQUEST_ON_CALC(299),
    ITC_STATUS_CHARGE(306),
    ITC_STATUS_CHECK(307),
    ITC_ACTION(308),
    CHECK_DUPLICATE_ID_SALE(311),
    LOGOUT_GIFT(313);


    private static final Map<Short, InHeader> headerMap;
    private static final Set<InHeader> ignoreHeaders;

    static {
        headerMap = new HashMap<>();
        for (InHeader header : values()) {
            headerMap.put(header.getValue(), header);
        }
        ignoreHeaders = Set.of(
                UPDATE_CLIENT_ENVIRONMENT,
                USER_MOVE,
                NPC_MOVE
        );
    }

    private final short value;

    InHeader(int value) {
        this.value = (short) value;
    }

    public final short getValue() {
        return value;
    }

    public final boolean isIgnoreHeader() {
        return ignoreHeaders.contains(this);
    }

    public static InHeader getByValue(short op) {
        return headerMap.get(op);
    }
}
