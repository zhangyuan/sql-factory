package sql_factory.core.join;

import sql_factory.core.Column;
import sql_factory.core.Table;

public class JoinColumn extends Column {
    public JoinColumn(Table table, String column_name) {
        super(table, column_name);
    }

    @Override
    public String toString() {
        return String.format("%s.%s", this.table.build(), this.name);
    }
}
