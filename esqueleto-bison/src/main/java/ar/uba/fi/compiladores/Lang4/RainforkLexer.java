package ar.uba.fi.compiladores.Lang4;

import java.util.Queue;

import ar.uba.fi.compiladores.FakeLexer;
import lombok.NonNull;

public class RainforkLexer extends FakeLexer<SemVal> implements Rainfork.Lexer {

    public RainforkLexer(@NonNull Queue<FakeLexer<SemVal>.Token> tokens) {
        super(tokens);
    }
    
}
