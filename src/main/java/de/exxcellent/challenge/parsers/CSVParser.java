package de.exxcellent.challenge.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Parser for csv Files
 */
public class CSVParser implements Parser{

    /**
     * Parse csv formatted data
     * @param rawData List of Strings containing csv formatted data, including headers
     * @return A Parsed Data Object containing the values of the csv file
     * @throws InvalidFormat
     */
    @Override
    public ParsedData parse(List<String> rawData) throws InvalidFormat {
        if (rawData.size()<2){
            throw new InvalidFormat("no data in csv File");
        }
        List<String> columnNames= Arrays.asList(rawData.get(0).split(","));
        List<List<String>> data=new ArrayList<List<String>>();
        rawData.stream().skip(1).forEach(row->data.add(Arrays.asList(row.split(","))));

        for (List<String> row:data){
            if(row.size() !=columnNames.size()){
                throw new InvalidFormat("invalid csv File");
            }
        }

        return (new ParsedData(columnNames,data));
    }

}
