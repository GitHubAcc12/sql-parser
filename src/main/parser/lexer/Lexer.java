package main.parser.lexer;

import main.parser.Keywords;
import main.parser.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lexer {

    private static Token createTokenFromWord(final String word) {
        if (Arrays.asList(Keywords.STATEMENTS).contains(word)) {
            return new Statement(word);
        } else if (Arrays.asList(Keywords.CLAUSES).contains(word)) {
            return new Clause(word);
        } else if (Arrays.asList(Keywords.CONSTRAINTS).contains(word)) {
            return new Constraint(word);
        } else if (Arrays.asList(Keywords.OPERATORS).contains(word)) {
            return new Operator(word);
        } else {
            return new Parameter(word);
        }
    }

    public static List<Token> tokenizeLine(final String line) {
        final List<Token> tokenList = new ArrayList<>();

        for (final String word : line.split(" ")) {
            tokenList.add(createTokenFromWord(word));
        }

        return tokenList;
    }


}
