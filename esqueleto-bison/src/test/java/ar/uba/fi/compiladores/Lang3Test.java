package ar.uba.fi.compiladores;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import ar.uba.fi.compiladores.Lang3.Brainfork;
import ar.uba.fi.compiladores.Lang3.BrainforkLexer;

public class Lang3Test {
    @Test
    void testSimple() throws IOException{
        Queue<FakeLexer<String>.Token> list = new LinkedList<>();
        BrainforkLexer yylexer = new BrainforkLexer(list);
        list.add(yylexer.new Token(BrainforkLexer.COMMA));
        list.add(yylexer.new Token(BrainforkLexer.COMMA));
        list.add(yylexer.new Token(BrainforkLexer.COMMA));
        list.add(yylexer.new Token(BrainforkLexer.L_BRACES));
        list.add(yylexer.new Token(BrainforkLexer.NUMBER,"1"));
        list.add(yylexer.new Token(BrainforkLexer.SLASH));
        list.add(yylexer.new Token(BrainforkLexer.NUMBER,"0.2"));
        list.add(yylexer.new Token(BrainforkLexer.R_BRACES));
        list.add(yylexer.new Token(BrainforkLexer.EOF));
        Brainfork parser = new Brainfork(yylexer);
        parser.parse();
        assertEquals("[1/0.2]", parser.value);
    }    
}
