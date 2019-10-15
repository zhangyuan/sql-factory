package sql_factory.core;

public class Column {
    protected String name;
    protected Table table;

    public Column(String name) {
        this.name = name;
    }

    public Column(Table table, String name) {
        this.table = table;
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
