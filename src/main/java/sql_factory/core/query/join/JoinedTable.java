package sql_factory.core.query.join;

import sql_factory.core.Column;
import sql_factory.core.query.QueryTable;
import sql_factory.core.table.Table;

public class JoinedTable implements QueryTable {
    private Table table;
    private String alias;

    public JoinedTable(Table table, String alias) {
        this.table = table;
        this.alias = alias;
    }

    public String toString() {
        return String.format("%s %s", this.table.toString(), this.alias);
    }

    public Column column(String columnName) {
        Column column = this.table.column(columnName);
        return new JoinColumn(this, column);
    }

    @Override
    public String getAlias() {
        return alias;
    }
}
