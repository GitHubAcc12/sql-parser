package main.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Token {
    String token;

    List<Token> children;
    List<Parameter> parameters;

    private Token() {
    }

    Token(final String token) {
        this.token = token;
        children = new ArrayList<>();
        parameters = new ArrayList<>();
    }

    public void addChild(final Token child) {
        children.add(child);
    }

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
}
