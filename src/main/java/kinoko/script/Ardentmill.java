package kinoko.script;

import kinoko.packet.user.UserLocal;
import kinoko.provider.map.PortalInfo;
import kinoko.script.common.Script;
import kinoko.script.common.ScriptHandler;
import kinoko.script.common.ScriptManager;
import kinoko.server.dialog.UIType;
import kinoko.world.GameConstants;
import kinoko.world.field.Field;
import kinoko.world.quest.QuestRecordType;
import kinoko.world.user.User;

import java.util.Map;
import java.util.Optional;

public class Ardentmill extends ScriptHandler {

    private static final int HERBALISM = 92000000;
    private static final int MINING = 92010000;
    private static final int SMITHING = 92020000;
    private static final int ACC_CRAFTING = 92030000;
    private static final int ALCHEMY = 92040000;

    //TODO: Add profession count method for limiting professions learned?s

    @Script("profession01")
    public static void profession01(ScriptManager sm) {

        sm.setQRValue(QuestRecordType.Ardentmill, String.valueOf(sm.getFieldId()));
        sm.playPortalSE();
        sm.warp(910001000, "st00");

    }
    @Script("out_profession")
    public static void out_profession(ScriptManager sm) {

        String whereTo = sm.getQRValue(QuestRecordType.Ardentmill);
        int mapId = whereTo.isEmpty() ? 100000000 : Integer.parseInt(whereTo);
        Field prevField = sm.getUser().getConnectedServer().getFieldById(mapId).orElseThrow();

        Optional<PortalInfo> tgtPortal = prevField.getPortalByName("profession");
        sm.playPortalSE();
        sm.warp(mapId, tgtPortal.isPresent() ? "profession" : GameConstants.DEFAULT_PORTAL_NAME);

    }


    @Script("himmel")
    public static void himmel(ScriptManager sm) {

    }

    @Script("alchemy")
    public static void alchemy(ScriptManager sm) {

    }

    @Script("equip_product")
    public static void equip_product(ScriptManager sm) {

    }

    @Script("acc_product")
    public static void acc_product(ScriptManager sm) {
        User user = sm.getUser();

        boolean hasAcc = user.getSkillLevel(ACC_CRAFTING) > 0;

        int choice = sm.askMenu("The brilliant radiance! The crystalline purity! The prismatic beauty! Are you a Jeweler too, my friend? Shall we seek the mysteries of Accessory Crafting together?", Map.of(
                0, "Hear an explanation about #b#eAccessory Crafting#n.",
                1, "Learn #eAccessory Crafting#n.#k"
        ));

        if (choice == 1) {
            if(!hasAcc && sm.askYesNo("Oh, you're ready to learn #bAccessory Crafting#k from me?\r\nSince you're so daring, I'll give you a discount. #b5000 Mesos#k to become my student.\r\n#b(Number of Professions Learned: %d")) {
                sm.addSkill(92000000, 1, 10);
                sm.soundEffect("profession/levelup");
                sm.sayNext("Oh! Wonderful! And that's how you do Accessory Crafting. Practice, practice, practice, and when you've gained enough Mastery, I'll teach you some more.");
            }
        }
    }

    @Script("mining")
    public static void mining(ScriptManager sm) {
        int choice = sm.askMenu("Hello. What can I help you with?", Map.of(
                0, "Hear an explanation about #b#eMining#n.",
                1, "Learn #eMining#n.#k"
        ));
    }

    @Script("herbalism")
    public static void herbalism(ScriptManager sm) {

        int[] FEE = {5000, 15000, 25000, 40000, 60000, 85000, 115000, 150000, 190000, 235000};
        boolean hasHerbalism = sm.getUser().getSkillLevel(92000000) > 0;

        int choice = sm.askMenu("Hello. What can I help you with?", Map.of(
                0, "Hear an explanation about #b#eHerbalism#n.",
                1, "Learn #eHerbalism#n.#k"
        ));

        if (hasHerbalism) {

        }
        else {
            if (choice == 0) {
                sm.sayNext("Herbalism lets you gather herbs. You can buy Oil Bottles from #p9031007# to refine the herbs and use them as materials to craft equipment, accessories, alchemy tools, and the like.");
            }
            else if (choice == 1) {
                if(!sm.askYesNo("To learn #bHerbalism#k, you must pay #b5,000 Mesos#k. You sure you want to learn it?\r\n")) {
                    sm.sayNext("Ah, it's smart not to rush into anything. Come back after you've pondered it some more.");
                    return;
                }

                if(!sm.addMoney(-FEE[0])) {
                    sm.sayNext("Umm... I don't think you have enough money... I'm sorry, but please bring #b5000 Mesos#k.");
                    return;
                }
                sm.addSkill(92000000, 1, 10);
                sm.soundEffect("profession/levelup");
                sm.sayNext("Congratulations! You're an Herbalist. See me again when you've increased your Mastery and I'll level up your Herbalism skill.");
            }
        }

    }

    @Script("open_alchemy")
    public static void open_alchemy(ScriptManager sm) {
        sm.write(UserLocal.openUI(UIType.PROFESSION));
    }

    @Script("open_equipP")
    public static void open_equipP(ScriptManager sm) {
        sm.write(UserLocal.openUI(UIType.PROFESSION));
    }

    @Script("open_accP")
    public static void open_accP(ScriptManager sm) {
        sm.write(UserLocal.openUI(UIType.PROFESSION));
    }

    @Script("open_mining")
    public static void open_mining(ScriptManager sm) {
        sm.write(UserLocal.openUI(UIType.PROFESSION));
    }

    @Script("open_herb")
    public static void open_herb(ScriptManager sm) {
        sm.write(UserLocal.openUI(UIType.PROFESSION));
    }

    @Script("gatherTuto")
    public static void gatherTuto(ScriptManager sm) {
        sm.playPortalSE();
        //sm.warpInstance();
    }

}
