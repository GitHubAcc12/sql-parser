package main;

import main.parser.inputhandler.InputHandler;
import main.parser.inputhandler.LocalFileReader;
import main.parser.lexer.Lexer;
import main.parser.model.Token;

import java.util.List;

// https://stackoverflow.com/questions/10379956/parsing-sql-like-syntax-design-pattern
// https://stackoverflow.com/questions/2842809/lexers-vs-parsers


public class Main {

    public static void main(final String[] args) {
        final InputHandler reader = new LocalFileReader();
        final List<String> readWords = reader.read("/Users/jankretschmann/IdeaProjects/sql-parser/task/operations.sql");
        for (final String line : readWords) {
            final List<Token> tokens = Lexer.tokenizeLine(line);
            System.out.println("New Line:");
            for (final Token token : tokens) {
                System.out.println(token.getAsString());
            }
            System.out.println();
            System.out.println();

        }
    }
}
