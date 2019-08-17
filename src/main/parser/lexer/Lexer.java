package main.parser.lexer;

import main.parser.lexer.model.Token;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public List<Token> tokenize(List<String> linesToTokenize) {
        List<Token> tokenList = new ArrayList<>();

        for(String line : linesToTokenize) {

        }

        return tokenList;
    }

    private List<Token> tokenizeLine(String line) {
        List<Token> tokenList = new ArrayList<>();

        for(String word : line.split(" ")) {

        }

        return tokenList;
    }


}
