package main.model;

public class BinaryOperator extends Token {
    public BinaryOperator(final String operator) {
        super(operator);
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getAsString() {
        return "Operator: " + token;
    }


}
