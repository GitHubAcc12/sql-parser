package main.model;

/**
 * Model class to represent statements used in the operations.sql file.
 */
public class Statement extends Token {
    public Statement(final String statement) {
        super(statement);
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getAsString() {
        return "Statement: " + token;
    }

}
