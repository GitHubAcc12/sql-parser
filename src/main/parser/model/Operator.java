package main.parser.model;

public class Operator implements Token {
    private final String operator;

    public Operator(final String operator) {
        this.operator = operator;
    }

    @Override
    public String getToken() {
        return operator;
    }

    @Override
    public String getAsString() {
        return "Operator: " + operator;
    }


}
