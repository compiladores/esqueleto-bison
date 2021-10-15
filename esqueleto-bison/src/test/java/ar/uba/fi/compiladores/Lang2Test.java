package ar.uba.fi.compiladores;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import ar.uba.fi.compiladores.Lang2.Wrainfork;
import ar.uba.fi.compiladores.Lang2.WrainforkLexer;

public class Lang2Test {
    @Test
    void testSimple() throws IOException{
        Queue<FakeLexer<String>.Token> list = new LinkedList<>();
        WrainforkLexer yylexer = new WrainforkLexer(list);
        list.add(yylexer.new Token(WrainforkLexer.COMMA));
        list.add(yylexer.new Token(WrainforkLexer.COMMA));
        list.add(yylexer.new Token(WrainforkLexer.COMMA));
        list.add(yylexer.new Token(WrainforkLexer.L_BRACES));
        list.add(yylexer.new Token(WrainforkLexer.NUMBER,"1"));
        list.add(yylexer.new Token(WrainforkLexer.SLASH));
        list.add(yylexer.new Token(WrainforkLexer.NUMBER,"0.2"));
        list.add(yylexer.new Token(WrainforkLexer.R_BRACES));
        list.add(yylexer.new Token(WrainforkLexer.EOF));
        Wrainfork parser = new Wrainfork(yylexer);
        parser.parse();
        assertEquals("[1 / 0.2]", parser.value);
    }    
}
