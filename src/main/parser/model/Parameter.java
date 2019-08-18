package main.parser.model;

public class Parameter implements Token {

    private final String parameter;

    public Parameter(final String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String getToken() {
        return parameter;
    }

    @Override
    public String getAsString() {
        return "Parameter: " + parameter;
    }
}
