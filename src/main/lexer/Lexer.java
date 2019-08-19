package main.lexer;

import main.model.*;

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
        } else if (Arrays.asList(Keywords.BINARY_OPERATORS).contains(word)) {
            return new BinaryOperator(word);
        } else {
            return new Parameter(word);
        }
    }

    public static List<Token> tokenizeLine(final String line) {
        final List<Token> tokenList = new ArrayList<>();
        final String[] words = cutSemicolonFromLastWordIfExists(line.split(" "));
        for (int i = 0; i < words.length; i++) {
            String word = clearAdditionalCharacters(words[i]);
            if (isCompositeKeyword(word)) {
                // Assuming one SQL-Statement is not split into two lines
                // AND one line does not contain more than one statement
                word += " " + words[i + 1];
                i++;
            } else if (word.charAt(0) == '"') {
                // handle strings
                System.out.println(word);
                final StringBuilder completeWord = new StringBuilder(word);
                i++; // initialize completeWord with word and
                // increment i once here instead of checking the size of completeWord every iteration
                for (; completeWord.charAt(completeWord.length() - 1) != '"'; i++) {
                    System.out.println("Completeword: " + completeWord.toString());
                    completeWord.append(" ").append(clearAdditionalCharacters(words[i]));
                }
                word = completeWord.toString();
            }
            final Token generatedToken = createTokenFromWord(word);
            if (generatedToken instanceof BinaryOperator) {
                tokenList.add(tokenList.size() - 1, generatedToken);
            } else {
                tokenList.add(generatedToken);
            }
        }
        return tokenList;
    }

    private static boolean isCompositeKeyword(final String word) {
        return Arrays.asList(Keywords.COMPOSITE_KEYWORDS_FIRST_HALFS).contains(word);
    }

    private static String[] cutSemicolonFromLastWordIfExists(final String[] words) {
        final String lastWord = words[words.length - 1];
        if (lastWord.charAt(lastWord.length() - 1) == ';') {
            words[words.length - 1] = lastWord.substring(0, lastWord.length() - 1);
        }
        return words;
    }

    private static String clearAdditionalCharacters(final String word) {
        String cleared = word.trim();
        final char lastChar = cleared.charAt(cleared.length() - 1);
        if (lastChar == ',' || lastChar == ')') {
            cleared = cleared.substring(0, cleared.length() - 1);
        }
        if (cleared.charAt(0) == '(') {
            cleared = cleared.substring(1);
        }
        return cleared;
    }


}
