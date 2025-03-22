package kinoko.database.cassandra.type;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;

public final class MapTransferInfoUDT {
    public static final String MAP_TRANSFER = "map_transfer";
    public static final String MAP_TRANSFER_EX = "map_transfer_ex";
    public static final String MAP_TRANSFER_PREMIUM = "map_transfer_premium";
    public static final String MAP_TRANSFER_HYPER = "map_transfer_hyper";

    private static final String typeName = "map_transfer_info_type";

    public static String getTypeName() {
        return typeName;
    }

    public static void createUserDefinedType(CqlSession session, String keyspace) {
        session.execute(
                SchemaBuilder.createType(keyspace, getTypeName())
                        .ifNotExists()
                        .withField(MAP_TRANSFER, DataTypes.frozenListOf(DataTypes.INT))
                        .withField(MAP_TRANSFER_EX, DataTypes.frozenListOf(DataTypes.INT))
                        .withField(MAP_TRANSFER_PREMIUM, DataTypes.frozenListOf(DataTypes.INT))
                        .withField(MAP_TRANSFER_HYPER, DataTypes.frozenListOf(DataTypes.INT))
                        .build()
        );
    }
}
