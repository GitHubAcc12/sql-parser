package main.model;

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
