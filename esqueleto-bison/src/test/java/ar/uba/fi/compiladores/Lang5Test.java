package ar.uba.fi.compiladores;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

import ar.uba.fi.compiladores.Lang5.Calcompleja;
import ar.uba.fi.compiladores.Lang5.CalcomplejaLexer;

public class Lang5Test {
    private String transpile(String source) throws IOException{
        CalcomplejaLexer lexer = new CalcomplejaLexer(new StringReader(source));
        Calcompleja calc = new Calcompleja(lexer);
        calc.parse();
        return calc.program;
    }
    @Test
    void testSimple() throws IOException{
        assertEquals("1 2 + .", transpile("print 1 + 2"));
    }
    @Test
    void testComplex() throws IOException{
        assertEquals("1 2 + 2 3 * 35 + + .", transpile("print (1+2)+2*3+(35)"));
    }
}
