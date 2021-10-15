package ar.uba.fi.compiladores.Lang1;

import java.util.Queue;

import ar.uba.fi.compiladores.FakeLexer;
import lombok.NonNull;

public class WrainfuckLexer extends FakeLexer<Number> implements Wrainfuck.Lexer {

    public WrainfuckLexer(@NonNull Queue<FakeLexer<Number>.Token> tokens) {
        super(tokens);
    }
    
}
