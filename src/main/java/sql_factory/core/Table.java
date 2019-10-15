package sql_factory.core;

import sql_factory.core.join.JoinColumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
    private String name;
    private List<Column> columns = new ArrayList<>();

    public Table(String name) {
        this.name = name;
    }


    public String build() {
        return this.name;
    }

    public Column column(String column_name) {
        if (this.columns.stream().anyMatch(x -> x.name.equals(column_name))) {
            return new JoinColumn(this, column_name);
        } else {
            String message = String.format("Column %s not exists on table %s", column_name, this.name);
            throw new RuntimeException(message);
        }
    }

    public Table withColumn(Column... columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }
}
