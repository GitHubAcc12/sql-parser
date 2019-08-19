package main.parser;

import main.model.*;

import java.util.List;

/**
 * Class used to parse a List of tokens to an AbstractSyntaxTree.
 */
public class Parser {

    /**
     * Parses the list of tokens to an AbstractSyntaxTree. Assumes a clear hierarchy of keywords:
     * Statements > Clauses > Operators > Constraints + Parameters
     * Static method, could be changed to a more object-oriented approach as explained in Lexer.
     *
     * @param tokens The list of tokens to be parsed to an AST.
     * @return An instance of AbstractSyntaxTree.
     */
    public static AbstractSyntaxTree parseAbstractSyntaxTree(final List<Token> tokens) {
        final AbstractSyntaxTree abstractSyntaxTree = new AbstractSyntaxTree();

        abstractSyntaxTree.root = tokens.get(0); // Strictly assumes that the first item of the list is a statement!
        // Should not be a restriction for sql
        Token lastProcessedToken = abstractSyntaxTree.root;

        for (int i = 1; i < tokens.size(); i++) {

            if (tokens.get(i) instanceof Parameter) {
                lastProcessedToken.addChild(tokens.get(i));
            } else if (tokens.get(i) instanceof Clause) {
                abstractSyntaxTree.root.addChild(tokens.get(i));
                lastProcessedToken = tokens.get(i);
            } else if (tokens.get(i) instanceof Constraint) {
                lastProcessedToken.addChild(tokens.get(i));
            } else if (tokens.get(i) instanceof BinaryOperator) {
                lastProcessedToken.addChild(tokens.get(i));
                lastProcessedToken = tokens.get(i);
            }

        }

        return abstractSyntaxTree;
    }


}
