package main.parser;

import main.model.AbstractSyntaxTree;
import main.model.Parameter;
import main.model.Token;

import java.util.List;

public class Parser {

    public static AbstractSyntaxTree parseAbstractSyntaxTree(final List<Token> tokens) {
        final AbstractSyntaxTree abstractSyntaxTree = new AbstractSyntaxTree();

        abstractSyntaxTree.root = tokens.get(0);
        final Token lastProcessedToken = abstractSyntaxTree.root;

        for (int i = 1; i < tokens.size(); i++) {

            // handle parameters for lastProcessedToken
            for (; tokens.get(i) instanceof Parameter; i++) {
                lastProcessedToken.addParameter((Parameter) tokens.get(i));
            }


        }

        return abstractSyntaxTree;
    }


}
