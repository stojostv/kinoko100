package kinoko.database.cassandra.type;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;

public final class CharacterStatUDT {
    public static final String GENDER = "gender";
    public static final String SKIN = "skin";
    public static final String FACE = "face";
    public static final String HAIR = "hair";
    public static final String LEVEL = "level";
    public static final String JOB = "job";
    public static final String SUB_JOB = "sub_job";
    public static final String BASE_STR = "base_str";
    public static final String BASE_DEX = "base_dex";
    public static final String BASE_INT = "base_int";
    public static final String BASE_LUK = "base_luk";
    public static final String HP = "hp";
    public static final String MAX_HP = "max_hp";
    public static final String MP = "mp";
    public static final String MAX_MP = "max_mp";
    public static final String AP = "ap";
    public static final String SP = "sp";
    public static final String EXP = "exp";
    public static final String POP = "pop";
    public static final String POS_MAP = "pos_map";
    public static final String PORTAL = "portal";
    public static final String PET_1 = "pet_1";
    public static final String PET_2 = "pet_2";
    public static final String PET_3 = "pet_3";
    public static final String FATIGUE = "fatigue";
    public static final String CHARISMA = "charisma";
    public static final String INSIGHT = "insight";
    public static final String WILLPOWER = "willpower";
    public static final String CRAFT = "craft";
    public static final String SENSE = "sense";
    public static final String CHARM = "charm";
    public static final String PVP_EXP = "pvp_exp";
    public static final String PVP_GRADE = "pvp_grade";
    public static final String PVP_POINT = "pvp_point";
    public static final String PVP_LEVEL = "pvp_level";

    private static final String typeName = "character_stat_type";

    public static String getTypeName() {
        return typeName;
    }

    public static void createUserDefinedType(CqlSession session, String keyspace) {
        session.execute(
                SchemaBuilder.createType(keyspace, getTypeName())
                        .ifNotExists()
                        .withField(GENDER, DataTypes.TINYINT)
                        .withField(SKIN, DataTypes.TINYINT)
                        .withField(FACE, DataTypes.INT)
                        .withField(HAIR, DataTypes.INT)
                        .withField(LEVEL, DataTypes.SMALLINT)
                        .withField(JOB, DataTypes.SMALLINT)
                        .withField(SUB_JOB, DataTypes.SMALLINT)
                        .withField(BASE_STR, DataTypes.SMALLINT)
                        .withField(BASE_DEX, DataTypes.SMALLINT)
                        .withField(BASE_INT, DataTypes.SMALLINT)
                        .withField(BASE_LUK, DataTypes.SMALLINT)
                        .withField(HP, DataTypes.INT)
                        .withField(MAX_HP, DataTypes.INT)
                        .withField(MP, DataTypes.INT)
                        .withField(MAX_MP, DataTypes.INT)
                        .withField(AP, DataTypes.SMALLINT)
                        .withField(SP, DataTypes.frozenMapOf(DataTypes.INT, DataTypes.INT))
                        .withField(EXP, DataTypes.INT)
                        .withField(POP, DataTypes.INT)
                        .withField(POS_MAP, DataTypes.INT)
                        .withField(PORTAL, DataTypes.TINYINT)
                        .withField(PET_1, DataTypes.BIGINT)
                        .withField(PET_2, DataTypes.BIGINT)
                        .withField(PET_3, DataTypes.BIGINT)
                        .withField(FATIGUE, DataTypes.TINYINT)
                        .withField(CHARISMA, DataTypes.INT)
                        .withField(INSIGHT, DataTypes.INT)
                        .withField(WILLPOWER, DataTypes.INT)
                        .withField(CRAFT, DataTypes.INT)
                        .withField(SENSE, DataTypes.INT)
                        .withField(CHARM, DataTypes.INT)
                        .withField(PVP_EXP, DataTypes.INT)
                        .withField(PVP_GRADE, DataTypes.TINYINT)
                        .withField(PVP_POINT, DataTypes.INT)
                        .withField(PVP_LEVEL, DataTypes.TINYINT)
                        .build()
        );
    }
}
