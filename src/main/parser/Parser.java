package main.parser;

import main.model.*;

import java.util.List;

public class Parser {

    public static AbstractSyntaxTree parseAbstractSyntaxTree(final List<Token> tokens) {
        final AbstractSyntaxTree abstractSyntaxTree = new AbstractSyntaxTree();

        abstractSyntaxTree.root = tokens.get(0);
        Token lastProcessedToken = abstractSyntaxTree.root;

        for (int i = 1; i < tokens.size(); i++) {

            if (tokens.get(i) instanceof Parameter) {
                lastProcessedToken.addParameter((Parameter) tokens.get(i));
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
