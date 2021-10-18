package ar.uba.fi.compiladores;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import ar.uba.fi.compiladores.Lang1.Wrainfuck;
import ar.uba.fi.compiladores.Lang1.WrainfuckLexer;

public class Lang1Test {
    @Test
    void testSimple() throws IOException{
        Queue<FakeLexer<Number>.Token> list = new LinkedList<>();
        WrainfuckLexer yylexer = new WrainfuckLexer(list);
        list.add(yylexer.new Token(WrainfuckLexer.COMMA));
        list.add(yylexer.new Token(WrainfuckLexer.COMMA));
        list.add(yylexer.new Token(WrainfuckLexer.COMMA));
        list.add(yylexer.new Token(WrainfuckLexer.L_BRACES));
        list.add(yylexer.new Token(WrainfuckLexer.NUMBER,1));
        list.add(yylexer.new Token(WrainfuckLexer.SLASH));
        list.add(yylexer.new Token(WrainfuckLexer.NUMBER,0.2));
        list.add(yylexer.new Token(WrainfuckLexer.R_BRACES));
        list.add(yylexer.new Token(WrainfuckLexer.EOF));
        Wrainfuck parser = new Wrainfuck(yylexer);
        parser.parse();
        // ,,, [1 / 0.2]
        assertEquals(5.0, parser.value.floatValue(),0.001);
    }    
}
