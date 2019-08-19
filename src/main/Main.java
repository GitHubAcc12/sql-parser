package main;

import main.inputhandler.InputHandler;
import main.inputhandler.LocalFileReader;
import main.lexer.Lexer;
import main.model.AbstractSyntaxTree;
import main.model.Token;
import main.outputhandler.LocalFileWriter;
import main.outputhandler.OutputHandler;
import main.parser.Parser;

import java.util.ArrayList;
import java.util.List;

// https://stackoverflow.com/questions/10379956/parsing-sql-like-syntax-design-pattern
// https://stackoverflow.com/questions/2842809/lexers-vs-parsers


public class Main {

    public static void main(final String[] args) {
        final InputHandler reader = new LocalFileReader();
        final List<String> readWords = reader.read("./task/operations.sql");
        final OutputHandler writer = new LocalFileWriter();
        final List<String> toWrite = new ArrayList<>();
        for (final String line : readWords) {
            final List<Token> tokens = Lexer.tokenizeLine(line);
            final AbstractSyntaxTree abstractSyntaxTree = Parser.parseAbstractSyntaxTree(tokens);
            toWrite.add(abstractSyntaxTree.getOutputFormat());
        }
        writer.write(toWrite, "./result/abstractsyntaxtree.txt");
    }
}
