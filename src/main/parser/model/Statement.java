package main.parser.model;

public class Statement implements Token {
    private final String statement;

    public Statement(final String statement) {
        this.statement = statement;
    }

    @Override
    public String getToken() {
        return statement;
    }

    @Override
    public String getAsString() {
        return "Statement: " + statement;
    }

}
