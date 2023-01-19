package de.exxcellent.challenge.parsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParsedDataTest {

    ParsedData parsedData;

    @BeforeEach
    void setUp() {
        List<String> columnNames = List.of("a", "b", "c");
        List<List<String>> data = new ArrayList<>();
        data.add(List.of("x", "2", "6"));
        data.add(List.of("y", "4", "12"));
        data.add(List.of("z", "6", "7"));
        parsedData = new ParsedData(columnNames, data);
    }

    @Test
    void getEntryWithMinimalDifference() {
        String entry = parsedData.getEntryWithMinimalDifference("b", "c", "a");
        assertEquals("z", entry, "for the minimal difference the value of column a should be z ");
    }

    @Test
    void getIndexWithMinimalDifference() {
        int index = parsedData.getIndexWithMinimalDifference("b", "c");
        assertEquals(2, index, "minimal difference should be at index 2 ");
    }

    @Test
    void getDataByColumnName() {
        String entry = parsedData.getDataByColumnName(1, "b");
        assertEquals("4", entry, "value for b at index 1 should be 4");
    }

    @Test
    void getDataInt() {
        int entry = parsedData.getDataInt(1, 1);
        assertEquals(4, entry, "value at 1,1 should be 4");
    }
}