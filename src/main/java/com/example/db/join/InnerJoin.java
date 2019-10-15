package com.example.db.join;

import com.example.db.Table;
import com.example.db.search_condition.Condition;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InnerJoin {
    private final Table rightTable;
    private List<Condition> conditions;
    private final Table leftTable;

    public InnerJoin(Table leftTable, Table rightTable, Condition... conditions) {
        this.leftTable = leftTable;
        this.rightTable = rightTable;
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public String toString() {
        String joins = this.conditions.stream().map(Condition::toString).collect(Collectors.joining(" AND "));
        return String.format("INNER JOIN %s ON %s", rightTable.build(), joins);
    }
}
