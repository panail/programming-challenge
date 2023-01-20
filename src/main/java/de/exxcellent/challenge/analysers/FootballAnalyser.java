package de.exxcellent.challenge.analysers;

import de.exxcellent.challenge.exceptions.InvalidFormat;
import de.exxcellent.challenge.data.ParsedData;

import java.util.List;

public class FootballAnalyser {
    private ParsedData data;

    public FootballAnalyser(ParsedData data) throws InvalidFormat {
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
