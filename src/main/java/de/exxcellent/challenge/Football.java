package de.exxcellent.challenge;

import de.exxcellent.challenge.parsers.InvalidFormat;
import de.exxcellent.challenge.parsers.ParsedData;

import java.util.List;

public class Football {
    private ParsedData data;

    public Football(ParsedData data) throws InvalidFormat {
        this.data = data;

        //verify data is Football data
        List expectedColumnNames = List.of("Team", "Goals", "Goals Allowed");
        if (!(data.getColumnNames().containsAll(expectedColumnNames))) {
            throw new InvalidFormat("parsed data does not contain weather data");
        }
    }

    /**
     * finds the team with the smallest distance between goals scored and goals received (absolut value)
     *
     * @return The Name of the team
     */
    public String getTeamLowestGoalDifference() {
        return data.getEntryWithMinimalDifference("Goals", "Goals Allowed", "Team");
    }
}
