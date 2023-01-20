package de.exxcellent.challenge.readers;

import de.exxcellent.challenge.data.UnparsedData;

import java.io.IOException;
import java.util.List;

public interface ResourceReader {
    public UnparsedData read(String resourceIdentifier) throws IOException;
}
