package de.exxcellent.challenge.parsers;

import java.util.List;

public interface Parser {
    public ParsedData parse(List<String> rawData) throws InvalidFormat;
}
