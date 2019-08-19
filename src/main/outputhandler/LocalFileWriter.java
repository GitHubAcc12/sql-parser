package main.outputhandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LocalFileWriter implements OutputHandler {

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
