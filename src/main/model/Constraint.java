package main.model;

public class Constraint extends Token {

    public Constraint(final String constraint) {
        super(constraint);
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getAsString() {
        return "Constraint: " + token;
    }
}
