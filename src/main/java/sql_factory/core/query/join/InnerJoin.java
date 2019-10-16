package sql_factory.core.query.join;

import sql_factory.core.query.FromTable;
import sql_factory.core.query.search_condition.Condition;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InnerJoin {
    private final JoinedTable rightTable;
    private List<Condition> conditions;
    private final FromTable leftTable;

    public InnerJoin(FromTable leftTable, JoinedTable rightTable, Condition... conditions) {
        this.leftTable = leftTable;
        this.rightTable = rightTable;
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public String toString() {
        String joins = this.conditions.stream().map(Condition::toString).collect(Collectors.joining(" AND "));
        return String.format("INNER JOIN %s ON %s", rightTable.toString(), joins);
    }
}
