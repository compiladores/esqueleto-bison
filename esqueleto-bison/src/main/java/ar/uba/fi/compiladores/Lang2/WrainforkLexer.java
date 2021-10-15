package ar.uba.fi.compiladores.Lang2;

import java.util.Queue;

import ar.uba.fi.compiladores.FakeLexer;
import lombok.NonNull;

public class WrainforkLexer extends FakeLexer<String> implements Wrainfork.Lexer {

    public WrainforkLexer(@NonNull Queue<FakeLexer<String>.Token> tokens) {
        super(tokens);
    }
    
}
