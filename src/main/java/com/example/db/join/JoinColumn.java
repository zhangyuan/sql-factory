package com.example.db.join;

import com.example.db.Column;
import com.example.db.Table;

public class JoinColumn extends Column {
    public JoinColumn(Table table, String column_name) {
        super(table, column_name);
    }

    @Override
    public String toString() {
        return String.format("%s.%s", this.table.build(), this.name);
    }
}
