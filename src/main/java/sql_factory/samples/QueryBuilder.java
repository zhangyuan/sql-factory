package sql_factory.samples;

import sql_factory.core.query.join.JoinedTable;
import sql_factory.core.query.FromTable;
import sql_factory.core.query.Query;
import sql_factory.core.query.search_condition.And;
import sql_factory.core.query.search_condition.Brace;
import sql_factory.core.query.search_condition.Equal;
import sql_factory.core.query.search_condition.Expression;
import sql_factory.core.table.Table;
import sql_factory.core.table.TableColumn;

import java.util.Arrays;

public class QueryBuilder {
    public static void main(String[] args) {
        Query query = new Query();

        Table leadTable = Definition.leadTable;
        Table dimLeadTypeTable = Definition.dimLeadTypeTable;
        Table dimLeadStatusTable = Definition.dimLeadStatusTable;

        JoinedTable leadType = new JoinedTable(dimLeadTypeTable, "lead_type");
        JoinedTable leadStatus = new JoinedTable(dimLeadStatusTable, "lead_status");

        FromTable fromLead = new FromTable(leadTable, "lead");

        query = query.from(fromLead).select(Arrays.asList(
                new TableColumn("lead_id"),
                new TableColumn("lead_status"),
                new TableColumn("lead_type")
        ))
                .innerJoin(leadType,
                        new And(
                                new Equal(
                                        fromLead.column("lead_type_id"),
                                        leadType.column("lead_type_id")),
                                new Expression("currentTime BETWEEN %s AND %s",
                                        leadType.column("from_time"),
                                        leadType.column("to_time")),
                                new Expression("1 = 1")
                        )
                )
                .innerJoin(leadStatus,
                        new Brace(
                                new Equal(
                                        fromLead.column("lead_status_id"),
                                        leadStatus.column("lead_status_id"))
                        )
                );

        System.out.println(query.build());
    }
}
