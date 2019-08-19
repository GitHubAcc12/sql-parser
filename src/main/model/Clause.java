package main.model;

public class Clause extends Token {

    public Clause(final String clause) {
        super(clause);
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getAsString() {
        return "Clause: " + token;
    }

}
