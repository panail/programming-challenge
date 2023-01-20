package de.exxcellent.challenge;

import de.exxcellent.challenge.analysers.WeatherAnalyser;
import de.exxcellent.challenge.data.UnparsedData;
import de.exxcellent.challenge.parsers.CSVParser;
import de.exxcellent.challenge.data.ParsedData;
import de.exxcellent.challenge.parsers.Parser;
import de.exxcellent.challenge.readers.FileResourceReader;
import de.exxcellent.challenge.readers.ResourceReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherAnalyserTest {

    @Test
    void getDaySmallestTemperatureSpread() {
        ResourceReader reader = new FileResourceReader();
        Parser parser = new CSVParser();
        ParsedData parsed;
        String day = "";

        UnparsedData unparsed = assertDoesNotThrow(() -> reader.read("src/test/resources/weather.csv"));
        parsed = assertDoesNotThrow(() -> parser.parse(unparsed));
        WeatherAnalyser weatherAnalyser = assertDoesNotThrow(() -> new WeatherAnalyser(parsed));
        day = weatherAnalyser.getDaySmallestTemperatureSpread();

        assertEquals("14", day, "day with lowst temperature spread should be 14");
    }
}