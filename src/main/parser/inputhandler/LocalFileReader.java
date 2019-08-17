package main.parser.inputhandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocalFileReader implements InputHandler {

    /**
     * Reads the file referenced with filepath line by line.
     *
     * @param filepath The path to the file which will be read.
     * @return An ArrayList containing every line of the file, an empty list if the file could not be read.
     */
    @Override
    public List<String> read(String filepath) {
        List<String> lines = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filepath))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Failed to read file");
        }
        return lines;
    }
}
