package main.model;

public class AbstractSyntaxTree {
    public Token root;

    public AbstractSyntaxTree() {
    }

    public AbstractSyntaxTree(final Token root) {
        this.root = root;
    }
}
