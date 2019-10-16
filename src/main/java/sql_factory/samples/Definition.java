package sql_factory.samples;

import sql_factory.core.table.Table;
import sql_factory.core.table.TableColumn;

public class Definition {
    public static final Table leadTable = new Table("fact_lead").withColumn(
            new TableColumn("lead_id"),
            new TableColumn("lead_type_id"),
            new TableColumn("lead_status_id")
    );

    public static final Table dimLeadTypeTable = new Table("dim_lead_type").withColumn(
            new TableColumn("lead_type_id"),
            new TableColumn("lead_type"),
            new TableColumn("from_time"),
            new TableColumn("to_time")
    );

    public static final Table dimLeadStatusTable = new Table("dim_lead_type").withColumn(
            new TableColumn("lead_status_id"),
            new TableColumn("lead_status")
    );
}
