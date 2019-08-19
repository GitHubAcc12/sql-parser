package main.model;

/**
 * Model class used to represent the sql-constraints used in the operations.sql file.
 */
public class Constraint extends Token {

    public Constraint(final String constraint) {
        super(constraint);
    }

    @Override
    public String getAsString() {
        return "Constraint: " + token;
    }
}
