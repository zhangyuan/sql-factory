package sql_factory.core.table;

import sql_factory.core.Column;

public class TableColumn implements Column {
    protected String name;

    public TableColumn(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
