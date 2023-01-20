package de.exxcellent.challenge.parsers;

import de.exxcellent.challenge.exceptions.NotSupported;

public class ParserFactory {

    public Parser createParserByType(String type) throws NotSupported {
        switch (type.toLowerCase()) {
            case "csv":
                return new CSVParser();
            default:
                throw new NotSupported("Type not supported for parsing");
        }
    }

}
