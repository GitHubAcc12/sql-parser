package main.inputhandler;

import java.util.List;

/**
 * Interface for every input-reading class, makes it easier to switch to different input sources.
 */
public interface InputHandler {

    public List<String> read(String filepath);
}
