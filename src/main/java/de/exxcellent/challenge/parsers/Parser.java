package de.exxcellent.challenge.parsers;

import de.exxcellent.challenge.data.ParsedData;
import de.exxcellent.challenge.exceptions.InvalidFormat;

import java.util.List;

public interface Parser {
    public ParsedData parse(List<String> rawData) throws InvalidFormat;
}
