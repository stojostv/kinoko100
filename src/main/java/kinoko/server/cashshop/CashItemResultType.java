package kinoko.server.cashshop;

public enum CashItemResultType {
    // CashItemRes
    CharacterSaleSuccess(56),
    CharacterSaleFail(57),
    CharacterSaleInvalidName(58),
    CharacterSaleInvalidItem(59),

    ItemUpgradeSuccess(61),
    ItemUpgradeFail(62), // CashItemReq_ItemUpgradeFail
    ItemUpgradeDone(65),
    ItemUpgradeErr(66),

    VegaSuccess1(68),
    VegaSuccess2(69),
    VegaErr(70),
    VegaErr2(71),
    VegaErr_InvalidItem(72),
    VegaFail(73),

    CheckFreeCashItemTable_Done(79),
    CheckFreeCashItemTable_Failed(80),

    SetFreeCashItemTable_Done(82),
    SetFreeCashItemTable_Failed(83),

    LimitGoodsCount_Changed(87),
    WebShopOrderGetList_Done(88),
    WebShopOrderGetList_Failed(89),
    WebnShopReceive_Done(90),
    LoadLocker_Done(91),
    LoadLocker_Failed(92),
    LoadGift_Done(93),
    LoadGift_Failed(94),
    LoadWish_Done(95), //was 92
    LoadWish_Failed(96),
    MapleTV_Failed_Wrong_User_Name(97), //94
    MapleTV_Failed_User_Not_Connected(98),
    AvatarMegaphone_Queue_Full(99),
    AvatarMegaphone_Level_Limit(100),
    SetWish_Done(101),
    SetWish_Failed(102),
    Buy_Done(103),
    Buy_Failed(104),
    UseCoupon_Done(105),
    UseCoupon_Done_NormalItem(106),
    GiftCoupon_Done(107),
    UseCoupon_Failed(108),
    UseCoupon_CashItem_Failed(109),
    Gift_Done(110),
    Gift_Failed(111),
    IncSlotCount_Done(112),
    IncSlotCount_Failed(113),
    IncTrunkCount_Done(114),
    IncTrunkCount_Failed(115),
    IncCharSlotCount_Done(116),
    IncCharSlotCount_Failed(117),
    IncBuyCharCount_Done(118),
    IncBuyCharCount_Failed(119),
    EnableEquipSlotExt_Done(120),
    EnableEquipSlotExt_Failed(121),
    MoveLtoS_Done(122),
    MoveLtoS_Failed(123),
    MoveStoL_Done(124),
    MoveStoL_Failed(125),
    Destroy_Done(126),
    DestroyFailed(127),
    Expire_Done(128),
    Expire_Failed(129),
    Use_Done(130),
    Use_Failed(131),
    StatChange_Done(132),
    StatChange_Failed(133),
    SkillChange_Done(134),
    SkillChange_Failed(135),
    SkillReset_Done(136),
    SkillReset_Failed(137),
    DestroyPetItem_Done(138),
    DestroyPetItem_Failed(139),
    SetPetName_Done(149),
    SetPetName_Failed(150),
    SetPetLife_Done(151),
    SetPetLife_Failed(152),
    MovePetStat_Failed(153), // some of these are flipped
    MovePetStat_Done(154),
    SetPetSkill_Failed(155),
    SetPetSkill_Done(156),
    SendMemo_Done(157),
    SendMemo_Warning(158),
    SendMemo_Failed(159),
    GetMaplePoint_Done(160),
    GetMaplePoint_Failed(161),
    Rebate_Done(162),
    Rebate_Failed(163),
    Couple_Done(164),
    Couple_Failed(165),
    BuyPackage_Done(166),
    BuyPackage_Failed(167),
    GiftPackage_Done(168),
    GiftPackage_Failed(169),
    BuyNormal_Done(170),
    BuyNormal_Failed(171),
    ApplyWishlistEvent_Done(172),
    ApplyWishlistEvent_Failed(173),
    Friendship_Done(174),
    Friendship_Failed(175),
    LoadExceptionList_Done(176),
    LoadExceptionList_Failed(177),
    UpdateExceptionList_Done(178),
    UpdateExceptionList_Failed(179),
    LoadFreeCashItem_Done(180),
    LoadFreeCashItem_Failed(181),
    FreeCashItem_Done(182),
    FreeCashItem_Failed(183),
    Script_Done(184),
    Script_Failed(185),
    Bridge_Failed(186),
    PurchaseRecord_Done(187),
    PurchaseRecord_Failed(188),
    EvolPet_Failed(189),
    EvolPet_Done(190),
    NameChangeBuy_Done(191),
    NameChangeBuy_Failed(192),
    TransferWorld_Done(193),
    TransferWorld_Failed(194),
    CashGachaponOpen_Done(195),
    CashGachaponOpen_Failed(196),
    CashGachaponCopy_Done(197),
    CashGachapon_Copy_Failed(198),
    ChangeMaplePoint_Done(199),
    ChangeMaplePoint_Failed(200),

    Give_Done(201),
    GIve_Failed(202),
    GashItemGachapon_Failed(203), // [sic]
    CashItemGachapon_Done(204);


    private final int value;

    CashItemResultType(int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }
}
