package sql_factory.core.search_condition;

import sql_factory.core.Column;

public class Equal implements Condition {
    private final Column leftColumn;
    private final Column rightColumn;

    public Equal(Column leftColumn, Column rightColumn) {
        this.leftColumn = leftColumn;
        this.rightColumn = rightColumn;
    }

    @Override
    public String toString() {
        return String.format("%s = %s", this.leftColumn.toString(), this.rightColumn.toString());
    }
}
