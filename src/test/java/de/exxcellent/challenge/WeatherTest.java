package de.exxcellent.challenge;

import de.exxcellent.challenge.parsers.CSVParser;
import de.exxcellent.challenge.parsers.ParsedData;
import de.exxcellent.challenge.parsers.Parser;
import de.exxcellent.challenge.readers.FileResourceReader;
import de.exxcellent.challenge.readers.ResourceReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    @Test
    void getDaySmallestTemperatureSpread() {
        ResourceReader reader = new FileResourceReader();
        Parser parser = new CSVParser();
        ParsedData parsed;
        String day = "";
        try {
            List<String> unparsed = reader.read("src/test/resources/weather.csv");
            parsed = parser.parse(unparsed);
            Weather weather = new Weather(parsed);
            day = weather.getDaySmallestTemperatureSpread();

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("14", day, "day with lowst temperature spread should be 14");
    }
}