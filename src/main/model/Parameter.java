package main.model;

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
