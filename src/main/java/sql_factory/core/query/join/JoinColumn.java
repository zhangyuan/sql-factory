package sql_factory.core.query.join;

import sql_factory.core.Column;
import sql_factory.core.query.QueryTable;

public class JoinColumn implements Column {
    private QueryTable table;
    private Column column;

    public JoinColumn(QueryTable table, Column column) {
        this.table = table;
        this.column = column;
    }

    @Override
    public String toString() {
        return String.format("%s.%s", this.table.getAlias(), this.column.getName());
    }

    @Override
    public String getName() {
        return this.column.getName();
    }
}
