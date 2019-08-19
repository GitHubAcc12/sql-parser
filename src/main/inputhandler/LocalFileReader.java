package main.inputhandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads the input from a locally saved file line by line and returns it as a list of strings.
 */
public class LocalFileReader implements InputHandler {
    /**
     * Reads the file referenced with filepath line by line.
     *
     * @param filepath The path to the file which will be read.
     * @return An ArrayList containing every line of the file, an empty list if the file could not be read.
     */
    @Override
    public List<String> read(final String filepath) {
        final List<String> lines = new ArrayList<>();
        try (final BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filepath))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }

        } catch (final IOException e) {
            System.out.println("Failed to read file: " + e.getLocalizedMessage());
        }
        return lines;
    }
}
