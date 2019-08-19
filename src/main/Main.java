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


public class Main {

    public static void main(final String[] args) {

        // read the input file
        final InputHandler reader = new LocalFileReader();
        final List<String> readWords = reader.read("./task/operations.sql");

        // iterate over each sql operation and save the resulting AbstractSyntaxTree as a String representation
        final List<String> toWrite = new ArrayList<>();
        for (final String line : readWords) {
            final List<Token> tokens = Lexer.tokenizeLine(line);
            final AbstractSyntaxTree abstractSyntaxTree = Parser.parseAbstractSyntaxTree(tokens);
            toWrite.add(abstractSyntaxTree.getOutputFormat());
        }

        // write the output file
        final OutputHandler writer = new LocalFileWriter();
        writer.write(toWrite, "./result/abstractsyntaxtree.txt");
    }
}
