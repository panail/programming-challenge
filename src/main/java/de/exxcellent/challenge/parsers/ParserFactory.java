package de.exxcellent.challenge.parsers;

import de.exxcellent.challenge.data.UnparsedData;
import de.exxcellent.challenge.exceptions.NotSupported;

public class ParserFactory {

    /**
     * generates a parser for a data type
     *
     * @param type the type of data the parser shoulld be able to parse
     * @return the corresponding parser
     * @throws NotSupported
     */
    public Parser createParserByType(String type) throws NotSupported {
        switch (type.toLowerCase()) {
            case "csv":
                return new CSVParser();
            default:
                throw new NotSupported("Type not supported for parsing");
        }
    }

    /**
     * generates a parser for specific data
     *
     * @param data the data object the parser should be able to parse
     * @return the corresponding Parser
     * @throws NotSupported
     */
    public Parser createParserForData(UnparsedData data) throws NotSupported {
        switch (data.getType().toLowerCase()) {
            case "csv":
                return new CSVParser();
            default:
                throw new NotSupported("type could not be detected or is not supported");
        }
    }

}
