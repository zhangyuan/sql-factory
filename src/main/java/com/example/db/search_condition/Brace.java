package com.example.db.search_condition;

public class Brace implements Condition {
    private Condition condition;

    public Brace(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return String.format("( %s )", condition.toString());
    }
}
