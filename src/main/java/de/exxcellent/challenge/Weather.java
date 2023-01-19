package de.exxcellent.challenge;

import de.exxcellent.challenge.parsers.InvalidFormat;
import de.exxcellent.challenge.parsers.ParsedData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Weather {
    private ParsedData data;

    public Weather(ParsedData data) throws InvalidFormat {
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
