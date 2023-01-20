package de.exxcellent.challenge.readers;

import de.exxcellent.challenge.data.UnparsedData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * File reader
 */
public class FileResourceReader implements ResourceReader {

    /**
     * Reads Contents of a file and returns them as Strings
     *
     * @param resourceIdentifier Path to the file to be read
     * @return List of Strings with Contents of file,each String represents a line
     * @throws IOException
     */
    @Override
    public UnparsedData read(String resourceIdentifier) throws IOException {

        File file = new File(resourceIdentifier);
        List<String> data = new ArrayList<>();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            data.add(line);
        }
        String fileExtension = "";
        int i = resourceIdentifier.lastIndexOf('.');
        if (i > 0) {
            fileExtension = resourceIdentifier.substring(i + 1);
        }
        return new UnparsedData(data, fileExtension);
    }
}
