package com.example.samples;

import com.example.db.Column;
import com.example.db.Query;
import com.example.db.Table;
import com.example.db.search_condition.And;
import com.example.db.search_condition.Brace;
import com.example.db.search_condition.Equal;
import com.example.db.search_condition.Expression;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Query query = new Query();

        Table leadTable = Definition.leadTable;
        Table dimLeadTypeTable = Definition.dimLeadTypeTable;
        Table dimLeadStatusTable = Definition.dimLeadStatusTable;

        query = query.from(leadTable).select(Arrays.asList(
                new Column("lead_id"),
                new Column("lead_status"),
                new Column("lead_type")
        ))
                .innerJoin(dimLeadTypeTable,
                        new And(
                                new Equal(
                                        leadTable.column("lead_type_id"),
                                        dimLeadTypeTable.column("lead_type_id")),
                                new Expression("currentTime BETWEEN %s AND %s",
                                        dimLeadTypeTable.column("from_time"),
                                        dimLeadTypeTable.column("to_time")),
                                new Expression("1 = 1")
                        )
                )
                .innerJoin(dimLeadStatusTable,
                        new Brace(
                                new Equal(
                                        leadTable.column("lead_status_id"),
                                        dimLeadStatusTable.column("lead_status_id"))
                        )
                );

        System.out.println(query.build());
    }
}
