package sql_factory.core.query;

import sql_factory.core.Column;
import sql_factory.core.table.Table;
import sql_factory.core.query.join.JoinColumn;

public class FromTable implements QueryTable {
    private Table table;

    public FromTable(Table table, String alias) {
        this.table = table;
        this.alias = alias;
    }

    private String alias;

    @Override
    public String toString() {
        return this.alias;
    }

    public String from() {
        return String.format(this.table.toString() + " " + this.alias);
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
