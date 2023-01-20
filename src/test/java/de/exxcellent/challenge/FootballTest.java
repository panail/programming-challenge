package de.exxcellent.challenge;

import de.exxcellent.challenge.parsers.CSVParser;
import de.exxcellent.challenge.parsers.ParsedData;
import de.exxcellent.challenge.parsers.Parser;
import de.exxcellent.challenge.readers.FileResourceReader;
import de.exxcellent.challenge.readers.ResourceReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballTest {

    @Test
    void getTeamLowestGoalDifference() {
        ResourceReader reader = new FileResourceReader();
        Parser parser = new CSVParser();
        ParsedData parsed;
        String team = "";
        List<String> unparsed = assertDoesNotThrow(() -> reader.read("src/test/resources/football.csv"));
        parsed = assertDoesNotThrow(() -> parser.parse(unparsed));
        Football football = assertDoesNotThrow(() -> new Football(parsed));
        team = football.getTeamLowestGoalDifference();

        assertEquals("Aston_Villa", team, "team with lowest goal difference should be Aston Villa");
    }
}