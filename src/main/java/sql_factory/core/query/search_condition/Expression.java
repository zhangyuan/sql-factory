package sql_factory.core.query.search_condition;

public class Expression implements Condition {
    private final String expression;
    private Object[] args;

    public Expression(String expression) {
        this.expression = expression;
    }

    public Expression(String expression, Object... args) {
        this.expression = expression;
        this.args = args;
    }


    @Override
    public String toString() {
        return String.format(this.expression, this.args);
    }
}
