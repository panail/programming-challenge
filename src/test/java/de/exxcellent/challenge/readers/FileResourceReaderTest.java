package de.exxcellent.challenge.readers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileResourceReaderTest {
    ResourceReader reader;

    @BeforeEach
    void setUp() {
        reader = new FileResourceReader();
    }


    @Test
    void readingFileSucceedes() {
        try {
            List<String> content = reader.read("src/test/resources/readerTest.csv");
            assertEquals(content.get(1), "1,2,3", "second line of readerTest.csv should be 1,2,3");
             content = reader.read("src/test/resources/readerTest.txt");
            assertEquals(content.get(1), "not", "second line of readerTest.txt should be \"not\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void readingNonexistingFileThrows() {
            Exception exception=assertThrows(IOException.class,()->reader.read("src/test/resources/nonexisting"));
    }

}