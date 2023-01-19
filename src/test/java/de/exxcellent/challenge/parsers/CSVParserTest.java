package de.exxcellent.challenge.parsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {
    Parser parser;

    @BeforeEach
    void setUp() {
        parser = new CSVParser();
    }

    @Test
    void validCsvSucceedes() {
        List<String> validCsv = new ArrayList<String>();
        validCsv.add("A,B,C");
        validCsv.add("1,2,3");
        validCsv.add("x,y,z");
        try {
            ParsedData parsed = parser.parse(validCsv);
            assertEquals("B", parsed.getColumnNames().get(1), "Columname should be B");
            assertEquals("y", parsed.getData().get(1).get(1), "Data should be y");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void emptyFileThrows() {
        List<String> onlyHeaders = new ArrayList<String>();
        onlyHeaders.add("A,B,C");
        Exception exception = assertThrows(InvalidFormat.class, () -> parser.parse(onlyHeaders));
    }

    @Test
    void invalidCsvThrows() {
        List<String> invalidCsv = new ArrayList<String>();
        invalidCsv.add("text, not");
        invalidCsv.add("in csv format");
        invalidCsv.add("");
        Exception exception = assertThrows(InvalidFormat.class, () -> parser.parse(invalidCsv));
    }
}