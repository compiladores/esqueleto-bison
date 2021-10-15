package ar.uba.fi.compiladores;

import java.io.IOException;
import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FakeLexer<T> {
    @AllArgsConstructor
    @RequiredArgsConstructor
    public class Token{
        @Getter
        @NonNull
        private int type;
        @Getter
        private T value;
    }

    @Getter
    @NonNull
    private Queue<Token> tokens;

    public T getLVal() {
        return last.value; 
    }

    Token last=null;

    public int yylex() throws IOException {
        last=tokens.remove();
        return last.type;
    }

    public void yyerror(String msg) {
        throw new RuntimeException(msg);
    }
    
}
