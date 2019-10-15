package com.example.db;

import com.example.db.join.InnerJoin;
import com.example.db.search_condition.Condition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Query {
    private Table fromTable;
    private List<Column> columns;
    private List<InnerJoin> innerJoins = new ArrayList<>();

    public Query from(Table table) {
        this.fromTable = table;
        return this;
    }

    public Query select(List<Column> columns) {
        this.columns = columns;
        return this;
    }

    public String build() {
        String columns = this.columns.stream().map(Column::toString).collect(Collectors.joining(", "));
        String sql = String.format("SELECT %s FROM %s\n", columns, this.fromTable.build());
        if (!this.innerJoins.isEmpty()) {
            sql += " ";
            String collect = this.innerJoins.stream().map(InnerJoin::toString).collect(Collectors.joining(" "));
            sql += collect;
        }

        return new org.hibernate.engine.jdbc.internal.BasicFormatterImpl().format(sql);
    }

    public Query innerJoin(Table rightTable, Condition... conditions) {
        this.innerJoins.add(new InnerJoin(this.fromTable, rightTable, conditions));
        return this;
    }
}
