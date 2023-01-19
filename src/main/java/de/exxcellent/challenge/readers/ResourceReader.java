package de.exxcellent.challenge.readers;

import java.io.IOException;
import java.util.List;

public interface ResourceReader {
    public List<String> read(String resourceIdentifier) throws IOException;
}
