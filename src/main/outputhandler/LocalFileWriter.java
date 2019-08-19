package main.outputhandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Used to write the output to a local file.
 */
public class LocalFileWriter implements OutputHandler {

    /**
     * Writes the given list of strings line by line to an outputfile.
     *
     * @param lines          The lines to be written.
     * @param outputFilePath The path of the file to write the lines to.
     */
    @Override
    public void write(final List<String> lines, final String outputFilePath) {
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (final String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());
            }
        } catch (final IOException e) {
            System.out.println("Failed to write outputfile: " + e.getLocalizedMessage());
        }
    }
}
