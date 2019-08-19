package main.outputhandler;

import java.util.List;

/**
 * Interface for all output-writing class, used for better extensibility, as explained in the javadoc of InputHandler.
 */
public interface OutputHandler {
    public void write(List<String> lines, String outputPath);
}
