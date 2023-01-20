package de.exxcellent.challenge;

import de.exxcellent.challenge.analysers.FootballAnalyser;
import de.exxcellent.challenge.analysers.WeatherAnalyser;
import de.exxcellent.challenge.data.ParsedData;
import de.exxcellent.challenge.parsers.Parser;
import de.exxcellent.challenge.parsers.ParserFactory;
import de.exxcellent.challenge.readers.FileResourceReader;
import de.exxcellent.challenge.readers.ResourceReader;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        ResourceReader reader = new FileResourceReader();
        ParserFactory parserFactory = new ParserFactory();
        try {
            Parser parser = parserFactory.createParserByType("csv");
            ParsedData parsed;

            List<String> unparsed = reader.read("src/main/resources/de/exxcellent/challenge/weather.csv");
            parsed = parser.parse(unparsed);
            WeatherAnalyser weatherAnalyser = new WeatherAnalyser(parsed);
            String dayWithSmallestTempSpread = weatherAnalyser.getDaySmallestTemperatureSpread();
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

            unparsed = reader.read("src/main/resources/de/exxcellent/challenge/football.csv");
            parsed = parser.parse(unparsed);
            FootballAnalyser footballAnalyser = new FootballAnalyser(parsed);
            String teamWithSmallestGoalSpread = footballAnalyser.getTeamLowestGoalDifference();
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
