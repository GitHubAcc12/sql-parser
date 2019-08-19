package main.model;

/**
 * Model class to represent the sql-clauses used in the operations.sql file.
 */
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
