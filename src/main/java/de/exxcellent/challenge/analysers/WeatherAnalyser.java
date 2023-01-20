package de.exxcellent.challenge.analysers;

import de.exxcellent.challenge.exceptions.InvalidFormat;
import de.exxcellent.challenge.data.ParsedData;

import java.util.List;

public class WeatherAnalyser {
    private ParsedData data;

    public WeatherAnalyser(ParsedData data) throws InvalidFormat {
        this.data = data;

        //verify data is Weather data
        List expectedColumnNames = List.of("Day", "MxT", "MnT");
        if (!(data.getColumnNames().containsAll(expectedColumnNames))) {
            throw new InvalidFormat("parsed data does not contain weather data");
        }
    }

    /**
     * finds the day, where the difference between the highest and lowest temperature is minimal.
     *
     * @return The number of the day
     */
    public String getDaySmallestTemperatureSpread() {
        return data.getEntryWithMinimalDifference("MxT", "MnT", "Day");
    }


}
