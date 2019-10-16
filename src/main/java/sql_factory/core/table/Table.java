package sql_factory.core.table;

import sql_factory.core.Column;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Table {
    protected String name;
    protected List<Column> columns = new ArrayList<>();

    public Table(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public Column column(String columnName) {
        Optional<Column> column = this.columns.stream().filter(x -> x.getName().equals(columnName)).findFirst();
        if (column.isPresent()) {
            return column.get();
        }
        throw new RuntimeException(String.format("%s not found on table %s", columnName, this.name));
    }

    public Table withColumn(Column... columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }
}
