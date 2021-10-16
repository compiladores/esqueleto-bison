package ar.uba.fi.compiladores;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import ar.uba.fi.compiladores.Lang4.Rainfork;
import ar.uba.fi.compiladores.Lang4.RainforkLexer;
import ar.uba.fi.compiladores.Lang4.SemVal;

public class Lang4Test {
    @Test
    void testSimple() throws IOException{
        Queue<FakeLexer<SemVal>.Token> list = new LinkedList<>();
        RainforkLexer yylexer = new RainforkLexer(list);
        list.add(yylexer.new Token(RainforkLexer.COMMA));
        list.add(yylexer.new Token(RainforkLexer.COMMA));
        list.add(yylexer.new Token(RainforkLexer.COMMA));
        list.add(yylexer.new Token(RainforkLexer.L_BRACES));
        list.add(yylexer.new Token(RainforkLexer.NUMBER,new SemVal(null,null,1)));
        list.add(yylexer.new Token(RainforkLexer.SLASH));
        list.add(yylexer.new Token(RainforkLexer.NUMBER,new SemVal(null,null,0.2)));
        list.add(yylexer.new Token(RainforkLexer.R_BRACES));
        list.add(yylexer.new Token(RainforkLexer.EOF));
        Rainfork parser = new Rainfork(yylexer);
        parser.parse();
        assertEquals("5.0", parser.value.toString());
    }
    @Test
    void testTuple() throws IOException{
        Queue<FakeLexer<SemVal>.Token> list = new LinkedList<>();
        RainforkLexer yylexer = new RainforkLexer(list);
        list.add(yylexer.new Token(RainforkLexer.COMMA));
        list.add(yylexer.new Token(RainforkLexer.COMMA));
        list.add(yylexer.new Token(RainforkLexer.COMMA));
        list.add(yylexer.new Token(RainforkLexer.L_PAREN));
        list.add(yylexer.new Token(RainforkLexer.ZERO));
        list.add(yylexer.new Token(RainforkLexer.COMMA));
        list.add(yylexer.new Token(RainforkLexer.NUMBER,new SemVal(null,null,0.2)));
        list.add(yylexer.new Token(RainforkLexer.R_PAREN));
        list.add(yylexer.new Token(RainforkLexer.EOF));
        Rainfork parser = new Rainfork(yylexer);
        parser.parse();
        assertEquals("(0,0.2)", parser.value.toString());
    }  
}
