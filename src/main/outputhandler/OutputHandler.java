package main.outputhandler;

import java.util.List;

public interface OutputHandler {
    public void write(List<String> lines, String outputFilePath);
}
