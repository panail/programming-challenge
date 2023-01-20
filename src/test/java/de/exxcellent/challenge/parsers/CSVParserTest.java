package de.exxcellent.challenge.parsers;

import de.exxcellent.challenge.data.ParsedData;
import de.exxcellent.challenge.data.UnparsedData;
import de.exxcellent.challenge.exceptions.InvalidFormat;
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
        UnparsedData unparsedValidCSV = new UnparsedData(validCsv, "csv");
        ParsedData parsed = assertDoesNotThrow(() -> parser.parse(unparsedValidCSV));
        assertEquals("B", parsed.getColumnNames().get(1), "Columname should be B");
        assertEquals("y", parsed.getData().get(1).get(1), "Data should be y");
    }

    @Test
    void emptyFileThrows() {
        List<String> onlyHeaders = new ArrayList<String>();
        onlyHeaders.add("A,B,C");
        UnparsedData unparsedOnlyHeaders = new UnparsedData(onlyHeaders, "csv");
        Exception exception = assertThrows(InvalidFormat.class, () -> parser.parse(unparsedOnlyHeaders));
    }

    @Test
    void invalidCsvThrows() {
        List<String> invalidCsv = new ArrayList<String>();
        invalidCsv.add("text, not");
        invalidCsv.add("in csv format");
        invalidCsv.add("");
        UnparsedData unparsedInvalid = new UnparsedData(invalidCsv, "csv");
        Exception exception = assertThrows(InvalidFormat.class, () -> parser.parse(unparsedInvalid));
    }
}