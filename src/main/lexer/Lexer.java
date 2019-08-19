package main.lexer;

import main.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Used to tokenize the lines from the input file, create one token out of every word and put
 * composite tokens together. Technically exceeds what a Lexer does, but I found no different
 * name to be more fitting. Consists of static methods because no attributes were used.
 * Could be changed to an interface + implementing class, to make it easier to extend it to
 * a Lexer+Parser for more languages than SQL.
 */
public class Lexer {

    /**
     * Uses the Keyword class to find out which class is best used to describe a token. Creates an instance of that
     * class and returns it.
     *
     * @param word The token to classify.
     * @return An instance of one of the five possible token classes, to be found in the model package.
     */
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

    /**
     * Publicly visible method used to tokenize a line. Uses several private methods internally.
     *
     * @param line The line to be tokenized.
     * @return A list of Token instances.
     */
    public static List<Token> tokenizeLine(final String line) {
        final List<Token> tokenList = new ArrayList<>();
        final String[] words = cutSemicolonFromLastWordIfExists(line.split(" "));
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isCompositeKeyword(word)) {
                // Assuming one SQL-Statement is not split into two lines
                // AND one line does not contain more than one statement
                word += " " + words[i + 1];
                i++;
            } else if (word.charAt(0) == '"') {
                // handle strings
                final StringBuilder completeWord = new StringBuilder(word);
                i++; // initialize completeWord with word and
                // increment i once here instead of checking the size of completeWord every iteration
                for (; completeWord.charAt(completeWord.length() - 1) != '"'; i++) {
                    completeWord.append(" ").append(clearAdditionalCharacters(words[i]));
                }
                word = completeWord.toString();
                i--; // decrement once to prevent double increment because of the two loops
            }
            final Token generatedToken = createTokenFromWord(clearAdditionalCharacters(word));

            // easiest way to handle the binary operators as a tree node later on
            // is to put them in order at this point
            if (generatedToken instanceof BinaryOperator) {
                tokenList.add(tokenList.size() - 1, generatedToken);
            } else {
                tokenList.add(generatedToken);
            }
        }
        return tokenList;
    }

    /**
     * Puts together Keywords which technically consist of more than one word/token.
     *
     * @param word The first half of the word.
     * @return True, if a second half is needed to complete the keyword; false, if not.
     */
    private static boolean isCompositeKeyword(final String word) {
        return Arrays.asList(Keywords.COMPOSITE_KEYWORDS_FIRST_HALFS).contains(word);
    }

    /**
     * Cuts the semicolon from the last word of the received line. Only cuts one semicolon, assumes there is not more
     * than one.
     *
     * @param words The line as an array of words.
     * @return A new array of strings, where the last entry is short one semicolon at the end.
     */
    private static String[] cutSemicolonFromLastWordIfExists(final String[] words) {
        final String lastWord = words[words.length - 1];
        if (lastWord.charAt(lastWord.length() - 1) == ';') {
            words[words.length - 1] = lastWord.substring(0, lastWord.length() - 1);
        }
        return words;
    }

    /**
     * Clears the other useless characters from the front and the back of a word. Only checks for the characters
     * which could be found in the operations.sql file, which are '(' for the front and ')' and ',' for the back.
     *
     * @param word The word to be checked.
     * @return The same word without the mentioned characters at the front or the back.
     */
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
