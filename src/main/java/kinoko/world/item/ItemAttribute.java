package kinoko.world.item;

public enum ItemAttribute {
    // GW_ItemSlotEquip
    EQUIP_PROTECTED(0x1),
    EQUIP_PREVENT_SLIP(0x2),
    EQUIP_SUPPORT_WARM(0x4),
    EQUIP_BINDED(0x8),
    EQUIP_POSSIBLE_TRADING(0x10),
    EQUIP_TRAIT_GAINED(0x20),

    EQUIP_CRAFTED(0x80),
    EQUIP_SHIELD(0x100),
    EQUIP_LUCKY_DAY(0x200),

    // GW_ItemSlotBundle
    BUNDLE_PROTECTED(0x1),
    BUNDLE_POSSIBLE_TRADING(0x02),

    // GW_ItemSlotPet
    PET_POSSIBLE_TRADING(0x01);

    private final short value;

    ItemAttribute(int value) {
        this.value = (short) value;
    }

    public final short getValue() {
        return value;
    }

    public static ItemAttribute getPossibleTradingAttribute(ItemType itemType) {
        return switch (itemType) {
            case EQUIP -> EQUIP_POSSIBLE_TRADING;
            case BUNDLE -> BUNDLE_POSSIBLE_TRADING;
            case PET -> PET_POSSIBLE_TRADING;
        };
    }
}