package kinoko.server.header;

import java.util.HashMap;
import java.util.Map;

public enum OutHeader {
    // CClientSocket::ProcessPacket
    MIGRATE_COMMAND(16),
    ALIVE_REQ(17),
    AUTHEN_CODE_CHANGED(18),
    AUTHEN_MESSAGE(19),
    CHECK_CLIENT_INTEGRITY(20),
    CHECK_CRC_RESULT(23),

    // CLogin::OnPacket
    CHECK_PASSWORD_RESULT(0),
    GUEST_ID_LOGIN_RESULT(1),
    ACCOUNT_INFO_RESULT(2),
    CHECK_USER_LIMIT_RESULT(3),
    SET_ACCOUNT_RESULT(4),
    CONFIRM_EULA_RESULT(5),
    CHECK_PIN_CODE_RESULT(6),
    UPDATE_PIN_CODE_RESULT(7),
    VIEW_ALL_CHAR_RESULT(8),
    SELECT_CHARACTER_BY_VAC_RESULT(9),
    WORLD_INFORMATION(10),
    SELECT_WORLD_RESULT(11),
    SELECT_CHARACTER_RESULT(12),
    CHECK_DUPLICATED_ID_RESULT(13),
    CREATE_NEW_CHARACTER_RESULT(14),
    DELETE_CHARACTER_RESULT(15),
    ENABLE_SPW_RESULT(21),
    LATEST_CONNECTED_WORLD(24),
    RECOMMEND_WORLD_MESSAGE(25),
    EXTRA_CHAR_INFO_RESULT(26),
    CHECK_SPW_RESULT(27),

    // CWvsContext::OnPacket
    INVENTORY_OPERATION(28),
    INVENTORY_GROW(29),
    STAT_CHANGED(30),
    TEMPORARY_STAT_SET(31),
    TEMPORARY_STAT_RESET(32),
    FORCED_STAT_SET(33),
    FORCED_STAT_RESET(34),
    CHANGE_SKILL_RECORD_RESULT(35),
    SKILL_USE_RESULT(36),
    GIVE_POPULARITY_RESULT(37),
    MESSAGE(38),
    OPEN_FULL_CLIENT_DOWNLOAD_LINK(39),
    MEMO_RESULT(40),
    MAP_TRANSFER_RESULT(41),
    ANTI_MACRO_RESULT(42),
    CLAIM_RESULT(44),
    SET_CLAIM_SVR_AVAILABLE_TIME(45),
    CLAIM_SVR_STATUS_CHANGED(46),
    SET_TAMING_MOB_INFO(47),
    QUEST_CLEAR(48),
    ENTRUSTED_SHOP_CHECK_RESULT(49),
    SKILL_LEARN_ITEM_RESULT(50),
    SKILL_RESET_ITEM_RESULT(51),
    GATHER_ITEM_RESULT(52),
    SORT_ITEM_RESULT(53),
    SUE_CHARACTER_RESULT(55),
    TRADE_MONEY_LIMIT(57),
    SET_GENDER(58),
    GUILD_BBS_PACKET(59),
    CHARACTER_INFO(61),
    PARTY_RESULT(62),
    EXPEDITION_RESULT(64),
    FRIEND_RESULT(65),
    GUILD_RESULT(67),
    ALLIANCE_RESULT(68),
    TOWN_PORTAL(69),
    OPEN_GATE(70),
    BROADCAST_MSG(71),
    INCUBATOR_RESULT(72),
    SHOP_SCANNER_RESULT(73),
    SHOP_LINK_RESULT(74),
    MARRIAGE_REQUEST(75),
    MARRIAGE_RESULT(76),
    WEDDING_GIFT_RESULT(77),
    NOTIFY_MARRIED_PARTNER_MAP_TRANSFER(78),
    CASH_PET_FOOD_RESULT(79),
    SET_WEEK_EVENT_MESSAGE(80),
    SET_POTION_DISCOUNT_RATE(81),
    BRIDLE_MOB_CATCH_FAIL(82),
    IMITATED_NPC_RESULT(83),
    IMITATED_NPC_DATA(84),
    LIMITED_NPC_DISABLE_INFO(85),
    MONSTER_BOOK_SET_CARD(86),
    MONSTER_BOOK_SET_COVER(87),
    HOUR_CHANGED(88),
    MINI_MAP_OFF(89),
    CONSULT_AUTH_KEY_UPDATE(90),
    CLASS_COMPETITION_AUTH_KEY_UPDATE(91),
    WEB_BOARD_AUTH_KEY_UPDATE(92),
    SESSION_VALUE(93),
    PARTY_VALUE(94),
    FIELD_SET_VARIABLE(95),
    BONUS_EXP_RATE_CHANGED(96),
    POTION_DISCOUNT_RATE_CHANGED(97),
    FAMILY_CHART_RESULT(98),
    FAMILY_INFO_RESULT(99),
    FAMILY_RESULT(100),
    FAMILY_JOIN_REQUEST(101),
    FAMILY_JOIN_REQUEST_RESULT(102),
    FAMILY_JOIN_ACCEPTED(103),
    FAMILY_PRIVILEGE_LIST(104),
    FAMILY_FAMOUS_POINT_INC_RESULT(105),
    FAMILY_NOTIFY_LOGIN_OR_LOGOUT(106),
    FAMILY_SET_PRIVILEGE(107),
    FAMILY_SUMMON_REQUEST(108),
    NOTIFY_LEVEL_UP(109),
    NOTIFY_WEDDING(110),
    NOTIFY_JOB_CHANGE(111),
    MAPLE_TV_USE_RES(113),
    AVATAR_MEGAPHONE_RES(114),
    SET_AVATAR_MEGAPHONE(115),
    CLEAR_AVATAR_MEGAPHONE(116),
    CANCEL_NAME_CHANGE_RESULT(117),
    CANCEL_TRANSFER_WORLD_RESULT(118),
    DESTROY_SHOP_RESULT(119),
    FAKE_GM_NOTICE(120),
    SUCCESS_IN_USE_GACHAPON_BOX(121),
    NEW_YEAR_CARD_RES(122),
    RANDOM_MORPH_RES(123),
    CANCEL_NAME_CHANGE_BY_OTHER(124),
    SET_BUY_EQUIP_EXT(125),
    FOLLOW_CHARACTER_REQUEST(126),
    SCRIPT_PROGRESS_MESSAGE(127),
    DATA_CRC_CHECK_FAILED(128),
    CAKE_PIE_EVENT_RESULT(129),
    UPDATE_GM_BOARD(130),
    SHOW_SLOT_MESSAGE(131),
    WILD_HUNTER_INFO(132),
    ACCOUNT_MORE_INFO(133),
    FIND_FRIEND(134),
    STAGE_CHANGE(135),
    DRAGON_BALL_BOX(136),
    ASK_WHETHER_USE_PAMS_SONG(137),
    TRANSFER_CHANNEL(138),
    DISALLOWED_DELIVERY_QUEST_LIST(139),
    MACRO_SYS_DATA_INIT(140),

    // CStage::OnPacket
    SET_FIELD(141),
    SET_ITC(142),
    SET_CASH_SHOP(143),

    // CMapLoadable::OnPacket
    SET_BACK_EFFECT(144),
    SET_MAP_OBJECT_VISIBLE(145),
    CLEAR_BACK_EFFECT(146),

    // CField::OnPacket
    TRANSFER_FIELD_REQ_IGNORED(147),
    TRANSFER_CHANNEL_REQ_IGNORED(148),
    FIELD_SPECIFIC_DATA(149),
    GROUP_MESSAGE(150),
    WHISPER(151),
    COUPLE_MESSAGE(152),
    SUMMON_ITEM_UNAVAILABLE(153),
    FIELD_EFFECT(154),
    FIELD_OBSTACLE_ON_OFF(155),
    FIELD_OBSTACLE_ON_OFF_STATUS(156),
    FIELD_OBSTACLE_ALL_RESET(157),
    BLOW_WEATHER(158),
    PLAY_JUKEBOX(159),
    ADMIN_RESULT(160),
    QUIZ(161),
    DESC(162),
    FEAR_EFFECT_ON(163),
    SET_QUEST_CLEAR(166),
    SET_QUEST_TIME(167),
    WARN_MESSAGE(168),
    SET_OBJECT_STATE(169),
    DESTROY_CLOCK(170),
    STALK_RESULT(172),
    QUICKSLOT_KEY_MAP_INIT(175),
    FOOT_HOLD_INFO(176),
    REQUEST_FOOT_HOLD_INFO(177),
    HONTALE_TIMER(359),
    CHAOS_ZAKUM_TIMER(360),
    HONTAIL_TIMER(361),
    ZAKUM_TIMER(362),
    TRUNK_DLG(368),
    RPS_GAME_DLG(371),
    MESSENGER(372),
    MINIROOM(373),
    PARCEL_DLG(381),
    LOGOUT_GIFT(432),

    // CUserPool::OnPacket
    USER_ENTER_FIELD(179),
    USER_LEAVE_FIELD(180),

    // CUserPool::OnUserCommonPacket
    USER_CHAT(181),
    USER_CHAT_REMOTE(182),
    USER_AD_BOARD(183),
    USER_MINIROOM_BALLOON(184),
    USER_SET_CONSUME_ITEM_EFFECT(185),
    USER_SHOW_ITEM_UPGRADE_EFFECT(186),
    USER_SHOW_ITEM_HYPER_UPGRADE_EFFECT(187),
    USER_SHOW_ITEM_OPTION_UPGRADE_EFFECT(188),
    USER_SHOW_ITEM_RELEASE_EFFECT(189),
    USER_SHOW_ITEM_UNRELEASE_EFFECT(190),
    USER_HIT_BY_USER(191),
    USER_TESLA_TRIANGLE(192),
    USER_FOLLOW_CHARACTER(193),
    USER_SHOW_PQ_REWARD(194),
    USER_SET_PHASE(195),
    USER_SHOW_RECOVER_UPGRADE_COUNT_EFFECT(197),

    // CUser::OnPetPacket
    PET_ENTER_FIELD(198),
    PET_EVOL(199),
    PET_LEAVE_FIELD(200),
    PET_MOVE(201),
    PET_ACTION(202),
    PET_NAME_CHANGED(203),
    PET_LOAD_EXCEPTION_LIST(204),
    PET_ACTION_COMMAND(205),

    // CUser::OnDragonPacket
    DRAGON_ENTER_FIELD(206),
    DRAGON_MOVE(207),

    // CUserPool::OnUserRemotePacket
    REMOTE_MOVE(210),
    REMOTE_MELEE_ATTACK(211),
    REMOTE_SHOOT_ATTACK(212),
    REMOTE_MAGIC_ATTACK(213),
    REMOTE_BODY_ATTACK(214),
    REMOTE_SKILL_PREPARE(215),
    REMOTE_MOVING_SHOOT_ATTACK_PREPARE(216),
    REMOTE_SKILL_CANCEL(217),
    REMOTE_HIT(218),
    REMOTE_EMOTION(219),
    REMOTE_SET_ACTIVE_EFFECT_ITEM(220),
    REMOTE_SHOW_UPGRADE_TOMB_EFFECT(221),
    REMOTE_SET_ACTIVE_PORTABLE_CHAIR(222),
    REMOTE_AVATAR_MODIFIED(223),
    REMOTE_EFFECT(224),
    REMOTE_SET_TEMPORARY_STAT(225),
    REMOTE_RESET_TEMPORARY_STAT(226),
    REMOTE_RECEIVE_HP(227),
    REMOTE_GUILD_NAME_CHANGED(228),
    REMOTE_GUILD_MARK_CHANGED(229),
    REMOTE_THROW_GRENADE(230),

    // CUserPool::OnUserLocalPacket
    SIT_RESULT(231),
    EMOTION(232),
    EFFECT(233),
    TELEPORT(234),
    MESO_GIVE_SUCCEEDED(236),
    MESO_GIVE_FAILED(237),
    RANDOM_MESOBAG_SUCCEEDED(238),
    RANDOM_MESOBAG_FAILED(239),
    FIELD_FADE_IN_OUT(240),
    FIELD_FADE_OUT_FORCE(241),
    QUEST_RESULT(242),
    NOTIFY_HP_DEC_BY_FIELD(243),
    BALLOON_MSG(245),
    PLAY_EVENT_SOUND(246),
    PLAY_MINIGAME_SOUND(247),
    MAKER_RESULT(248),
    OPEN_CLASS_COMPETITION_PAGE(250),
    OPEN_UI(251),
    OPEN_UI_WITH_OPTION(252),
    SET_DIRECTION_MODE(253),
    SET_STAND_ALONE_MODE(254),
    HIRE_TUTOR(255),
    TUTOR_MSG(256),
    INC_COMBO_RESPONSE(257),
    RANDOM_EMOTION(258),
    RESIGN_QUEST_RETURN(259),
    PASS_MATE_NAME(260),
    RADIO_SCHEDULE(261),
    OPEN_SKILL_GUIDE(262),
    NOTICE_MSG(263),
    CHAT_MSG(264),
    BUFFZONE_EFFECT(265),
    GO_TO_COMMODITY_SN(266),
    DAMAGE_METER(267),
    TIME_BOMB_ATTACK(268),
    PASSIVE_MOVE(269),
    FOLLOW_CHARACTER_FAILED(270),
    VENGEANCE_SKILL_APPLY(271),
    EX_JABLIN_APPLY(272),
    ASK_APSP_EVENT(273),
    QUEST_GUIDE_RESULT(274),
    DELIVERY_QUEST(275),
    SKILL_COOLTIME_SET(276),

    // CSummonedPool::OnPacket
    SUMMON_ENTER_FIELD(278),
    SUMMON_LEAVE_FIELD(279),
    SUMMON_MOVE(280),
    SUMMON_ATTACK(281),
    SUMMON_SKILL(282),
    SUMMON_HIT(283),

    // CMobPool::OnPacket
    MOB_ENTER_FIELD(284),
    MOB_LEAVE_FIELD(285),
    MOB_CHANGE_CONTROLLER(286),
    MOB_MOVE(287),
    MOB_CTRL_ACK(288),
    MOB_STAT_SET(290),
    MOB_STAT_RESET(291),
    MOB_SUSPEND_RESET(292),
    MOB_AFFECTED(293),
    MOB_DAMAGED(294),
    MOB_SPECIAL_EFFECT_BY_SKILL(295),
    MOB_CRC_KEY_CHANGED(297),
    MOB_HP_INDICATOR(298),
    MOB_CATCH_EFFECT(299),
    MOB_EFFECT_BY_ITEM(300),
    MOB_SPEAKING(301),
    MOB_INC_MOB_CHARGE_COUNT(302),
    MOB_SKILL_DELAY(303),
    MOB_ESCORT_FULL_PATH(304),
    MOB_ESCORT_STOP_END_PERMISSION(305),
    MOB_ESCORT_STOP_SAY(306),
    MOB_ESCORT_RETURN_BEFORE(307),
    MOB_NEXT_ATTACK(308),
    MOB_ATTACKED_BY_MOB(309),

    // CNpcPool::OnPacket
    NPC_IMITATE_DATA(84),
    NPC_UPDATE_LIMITED_DISABLE_INFO(85),
    NPC_ENTER_FIELD(311),
    NPC_LEAVE_FIELD(312),
    NPC_CHANGE_CONTROLLER(313),
    NPC_MOVE(314),
    NPC_UPDATE_LIMITED_INFO(315),
    NPC_SET_SPECIAL_ACTION(316),
    NPC_SET_SCRIPT(317),

    // CEmployeePool::OnPacket
    EMPLOYEE_ENTER_FIELD(319),
    EMPLOYEE_LEAVE_FIELD(320),
    EMPLOYEE_MINIROOM_BALLOON(321),

    // CDropPool::OnPacket
    DROP_ENTER_FIELD(322),
    DROP_LEAVE_FIELD(324),

    // CMessageBoxPool::OnPacket
    MESSAGE_BOX_CREATE_FAILED(325),
    MESSAGE_BOX_ENTER_FIELD(326),
    MESSAGE_BOX_LEAVE_FIELD(327),

    // CAffectedAreaPool::OnPacket
    AFFECTED_AREA_ENTER_FIELD(328),
    AFFECTED_AREA_LEAVE_FIELD(329),

    // CTownPortalPool::OnPacket
    TOWN_PORTAL_ENTER_FIELD(330),
    TOWN_PORTAL_LEAVE_FIELD(331),

    // COpenGatePool::OnPacket
    OPEN_GATE_ENTER_FIELD(332),
    OPEN_GATE_LEAVE_FIELD(333),

    // CReactorPool::OnPacket
    REACTOR_CHANGE_STATE(334),
    REACTOR_MOVE(335),
    REACTOR_ENTER_FIELD(336),
    REACTOR_LEAVE_FIELD(337),

    // CScriptMan::OnPacket
    SCRIPT_MESSAGE(363),

    // CShopDlg::OnPacket
    SHOP_DLG_INIT(364),
    SHOP_DLG_RESULT(365),

    // CAdminShopDlg::OnPacket
    ADMIN_SHOP_RESULT(366),
    ADMIN_SHOP_INIT(367),

    // CStoreBankDlg::OnPacket
    STORE_BANK_DLG_RESULT(369),
    STORE_BANK_DLG_INIT(370),

    // CFuncKeyMappedMan::OnPacket
    FUNC_KEY_MAP_INIT(398),
    FUNC_KEY_PET_CONSUME_ITEM_INIT(399),
    FUNC_KEY_PET_CONSUME_MP_ITEM_INIT(400),

    // CMapleTVMan::OnPacket
    MAPLE_TV_SET_MESSAGE(405),
    MAPLE_TV_CLEAR_MESSAGE(406),
    MAPLE_TV_SEND_MESSAGE_RESULT(407),

    // CUICharacterSaleDlg::OnPacket
    CHARACTER_SALE_CHECK_DUPLICATED_ID_RESULT(413),
    CHARACTER_SALE_CREATE_NEW_CHARACTER_RESULT(414),

    // CBattleRecordMan::OnPacket
    BATTLE_RECORD_DOT_DAMAGE_INFO(421),
    BATTLE_RECORD_SERVER_ON_CALC_RESULT(422),

    // CUIItemUpgrade::OnPacket
    ITEM_UPGRADE_RESULT(425),

    // CUIVega::OnPacket
    VEGA_RESULT(429),

    // -----------------------------------------------------------------------------------------------------------------

    // CField_ContiMove::OnPacket
    CONTI_MOVE(164),
    CONTI_STATE(165),

    // CField_Massacre::OnPacket
    MASSACRE_INC_GAUGE(173),

    // CField_MassacreResult::OnPacket
    MASSACRE_RESULT(174),

    // CField_KillCount::OnPacket
    KILL_COUNT_INFO(178),

    // CField_SnowBall::OnPacket
    SNOWBALL_STATE(338),
    SNOWBALL_HIT(339),
    SNOWBALL_MSG(340),
    SNOWBALL_TOUCH(341),

    // CField_Coconut::OnPacket
    COCONUT_HIT(342),
    COCONUT_SCORE(343),

    // CField_GuildBoss::OnPacket
    GUILD_BOSS_HEALER_MOVE(344),
    GUILD_BOSS_PULLEY_STATE_CHANGE(345),

    // CField_MonsterCarnival::OnPacket
    MONSTER_CARNIVAL_ENTER(346),
    MONSTER_CARNIVAL_PERSONAL_CP(347),
    MONSTER_CARNIVAL_TEAM_CP(348),
    MONSTER_CARNIVAL_REQUEST_SUCCESS(349),
    MONSTER_CARNIVAL_REQUEST_FAIL(350),
    MONSTER_CARNIVAL_PROCESS_FOR_DEATH(351),
    MONSTER_CARNIVAL_SHOW_MEMBER_OUT_MSG(352),
    MONSTER_CARNIVAL_SHOW_GAME_RESULT(353),

    // CField_MonsterCarnivalRevive::OnPacket
    MONSTER_CARNIVAL_REVIVE_ENTER(346),
    MONSTER_CARNIVAL_REVIVE_SHOW_GAME_RESULT(353),

    // CField_AriantArena::OnPacket
    ARIANT_ARENA_SHOW_RESULT(171),
    ARIANT_ARENA_USER_SCORE(354),

    // CField_Battlefield::OnPacket
    BATTLEFIELD_SCORE_UPDATE(356),
    BATTLEFIELD_TEAM_CHANGED(357),

    // CField_Witchtower::OnPacket
    WITCHTOWER_SCORE_UPDATE(358),

    // CField_Tournament::OnPacket
    TOURNAMENT_INIT(374),
    TOURNAMENT_MATCH_TABLE(375),
    TOURNAMENT_SET_PRIZE(376),
    TOURNAMENT_UEW(377),

    // CField_Wedding::OnPacket
    WEDDING_PROGRESS(379),
    WEDDING_CEREMONY_END(380),

    // -----------------------------------------------------------------------------------------------------------------

    // CCashShop::OnPacket
    CASHSHOP_CHARGE_PARAM_RESULT(382),
    CASHSHOP_QUERY_CASH_RESULT(383),
    CASHSHOP_CASH_ITEM_RESULT(384),
    CASHSHOP_PURCHASE_EXP_CHANGED(385),
    CASHSHOP_GIFT_MATE_INFO_RESULT(386),
    CASHSHOP_CHECK_DUPLICATED_ID_RESULT(387),
    CASHSHOP_CHECK_NAME_CHANGE_POSSIBLE_RESULT(388),
    CASHSHOP_CHECK_TRANSFER_WORLD_POSSIBLE_RESULT(390),
    CASHSHOP_GACHAPON_STAMP_RESULT(391),
    CASHSHOP_GACHAPON_RESULT(393),
    CASHSHOP_ONE_A_DAY(395),
    CASHSHOP_NOTICE_FREE_CASH_ITEM(396),

    // CITC::OnPacket
    ITC_CHARGE_PARAM_RESULT(410),
    ITC_QUERY_CASH_RESULT(411),
    ITC_NORMAL_ITEM_RESULT(412);


    private static final Map<Short, OutHeader> headerMap;

    static {
        headerMap = new HashMap<>();
        for (OutHeader header : values()) {
            headerMap.put(header.getValue(), header);
        }
    }

    private final short value;

    OutHeader(int value) {
        this.value = (short) value;
    }

    public final short getValue() {
        return value;
    }

    public static OutHeader getByValue(short op) {
        return headerMap.get(op);
    }
}
