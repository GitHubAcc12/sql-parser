package main.model;

/**
 * Model class used to represent parameters used in the operations.sql file.
 */
public class Parameter extends Token {
    public Parameter(final String parameter) {
        super(parameter);
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getAsString() {
        return "Parameter: " + token;
    }
}
