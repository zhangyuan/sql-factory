package sql_factory.core.query.search_condition;

import java.util.Arrays;
import java.util.stream.Collectors;

public class And implements Condition {
    private Condition[] conditions;

    public And(Condition... conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        String text = Arrays.stream(conditions).map(x -> x.toString()).collect(Collectors.joining(" AND "));
        return String.format(" %s ", text);
    }
}
