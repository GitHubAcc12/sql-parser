package main.parser.model;

public class Constraint implements Token {
    private final String constraint;

    public Constraint(final String constraint) {
        this.constraint = constraint;
    }

    @Override
    public String getToken() {
        return constraint;
    }

    @Override
    public String getAsString() {
        return "Constraint: " + constraint;
    }
}
