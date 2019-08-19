package main.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class Token, superclass of every other model class besides AbstractSyntaxTree and Keywords.
 * Makes up the tree structure.
 */
public abstract class Token {
    String token;

    private List<Token> children;
    private List<Parameter> parameters;

    /**
     * Private default constructor to prevent it from being called.
     */
    private Token() {
    }

    /**
     * Package-private constructor, should only be used by subclasses.
     *
     * @param token The word in sql which was parsed as a token.
     */
    Token(final String token) {
        this.token = token;
        children = new ArrayList<>();
        parameters = new ArrayList<>();
    }

    /**
     * Adds a child node to the token.
     *
     * @param child The token to be added as child node.
     */
    public void addChild(final Token child) {
        children.add(child);
    }

    /**
     * Adds a parameter child node to the token.
     *
     * @param parameter
     */
    public void addParameter(final Parameter parameter) {
        parameters.add(parameter);
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public List<Token> getChildren() {
        return children;
    }

    public abstract String getToken();

    public abstract String getAsString();

    String getAsTree(final int level, final StringBuilder stringBuilder) {
        for (int i = 0; i < level; i++) {
            stringBuilder.append("\t");
        }
        stringBuilder.append(getAsString());
        stringBuilder.append(System.lineSeparator());
        final List<Token> allChildren = new ArrayList<>();
        allChildren.addAll(parameters);
        allChildren.addAll(children);
        for (final Token child : allChildren) {
            child.getAsTree(level + 1, stringBuilder);
        }
        return stringBuilder.toString();
    }
}
