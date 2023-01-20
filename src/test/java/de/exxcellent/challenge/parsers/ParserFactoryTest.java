package de.exxcellent.challenge.parsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertTrue(parser instanceof CSVParser);
    }

    void unsuportedTypeThrows() {
        assertThrows(NotSupported.class, () -> parserFactory.createParserByType("JSON"));
    }
}