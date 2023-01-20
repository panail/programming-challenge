package de.exxcellent.challenge.parsers;

import de.exxcellent.challenge.data.UnparsedData;
import de.exxcellent.challenge.exceptions.NotSupported;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserFactoryTest {
    ParserFactory parserFactory;

    @BeforeEach
    void setUp() {
        parserFactory = new ParserFactory();
    }

    @Test
    void createCsVParser() {

        Parser parser = assertDoesNotThrow(() -> parserFactory.createParserByType("csv"));
        assertTrue(parser instanceof CSVParser,"Type should be csvParser");
    }

    @Test
    void createParserForFile(){
        List<String> data =new ArrayList<>();
        UnparsedData unparsed = new UnparsedData(data,"csv");
        Parser parser = assertDoesNotThrow(() -> parserFactory.createParserForData(unparsed));
        assertTrue(parser instanceof CSVParser,"Type should be csvParser");
    }
    @Test
    void unsuportedTypeThrows() {
        assertThrows(NotSupported.class, () -> parserFactory.createParserByType("JSON"));
    }
}