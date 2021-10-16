package ar.uba.fi.compiladores.Lang3;

import java.util.Queue;

import ar.uba.fi.compiladores.FakeLexer;
import lombok.NonNull;

public class BrainforkLexer extends FakeLexer<String> implements Brainfork.Lexer {

    public BrainforkLexer(@NonNull Queue<FakeLexer<String>.Token> tokens) {
        super(tokens);
    }
    
}
