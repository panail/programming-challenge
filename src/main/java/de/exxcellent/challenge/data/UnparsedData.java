package de.exxcellent.challenge.data;

import java.util.List;

public class UnparsedData {
    private List<String> data;
    private String type;

    public UnparsedData(List<String> data, String type) {
        this.data = data;
        this.type = type;
    }

    public List<String> getData() {
        return data;
    }

    public String getType() {
        return type;
    }
}
