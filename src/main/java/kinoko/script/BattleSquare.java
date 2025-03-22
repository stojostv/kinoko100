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

import java.util.Optional;

public class BattleSquare extends ScriptHandler {

    @Script("battleSquareMove")
    public static void battleSquareMove(ScriptManager sm) {

        String whereTo = sm.getQRValue(QuestRecordType.BattleSquare);
        int mapId = whereTo.isEmpty() ? 100000000 : Integer.parseInt(whereTo);
        Field prevField = sm.getUser().getConnectedServer().getFieldById(mapId).orElseThrow();

        if(!sm.askYesNo("Would you like to leave the #b#m960000000##k?")) {
            return;
        }

        Optional<PortalInfo> tgtPortal = prevField.getPortalByName("battleSquare");
        sm.warp(mapId, tgtPortal.isPresent() ? "battleSquare" : GameConstants.DEFAULT_PORTAL_NAME);
    }

    @Script("battleSquareMove2")
    public static void battleSquareMove2(ScriptManager sm) {

        String curMap = String.valueOf(sm.getFieldId());
        if(!sm.askYesNo("Looking to test your strength in Battle Mode? Haha! I'll send you to #m960000000#, where you can prove yourself by fighting other Maplers.")) {
            return;
        }

        if(sm.getLevel() < 30) {
            sm.sayOk("Hmm... Your level is too low to participate in Battle Mode. Train more until Level #b30#k.");
            return;
        }
        sm.setQRValue(QuestRecordType.BattleSquare, curMap);
        sm.warp(960000000, "battleSquare");
    }

    @Script("pvpLaunch")
    public static void pvpLaunch(ScriptManager sm) {
        sm.write(UserLocal.openUI(UIType.PVP));
    }

    @Script("superFightGuide")
    public static void superFightGuide(ScriptManager sm) {

    }

    @Script("pvpExchangeBP")
    public static void pvpExchangeBP(ScriptManager sm) {

    }

}
