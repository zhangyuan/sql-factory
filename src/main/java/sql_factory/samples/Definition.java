package sql_factory.samples;

import sql_factory.core.Column;
import sql_factory.core.Table;

public class Definition {
    public static final Table leadTable = new Table("lead").withColumn(
            new Column("lead_id"),
            new Column("lead_type_id"),
            new Column("lead_status_id")
    );

    public static final Table dimLeadTypeTable = new Table("dim_lead_type").withColumn(
            new Column("lead_type_id"),
            new Column("lead_type"),
            new Column("from_time"),
            new Column("to_time")
    );

    public static final Table dimLeadStatusTable = new Table("dim_lead_type").withColumn(
            new Column("lead_status_id"),
            new Column("lead_status")
    );
}
