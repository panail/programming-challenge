package de.exxcellent.challenge.parsers;

import java.util.List;

public class ParsedData {
    public ParsedData(List<String> columnNames, List<List<String>> data) {
        this.columnNames = columnNames;
        this.data = data;
    }

    private final List<String> columnNames;

    private final List<List<String>> data;
    public List<String> getColumnNames() {
        return columnNames;
    }

    public List<List<String>> getData() {
        return data;
    }

}
