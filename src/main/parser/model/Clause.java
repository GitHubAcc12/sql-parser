package main.parser.model;

public class Clause implements Token {
    private final String clause;

    public Clause(final String clause) {
        this.clause = clause;
    }

    @Override
    public String getToken() {
        return clause;
    }

    @Override
    public String getAsString() {
        return "Clause: " + clause;
    }

}
