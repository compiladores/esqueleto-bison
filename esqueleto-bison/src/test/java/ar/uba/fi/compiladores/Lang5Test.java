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
    void testAssign() throws IOException{
        assertEquals(" SYMBOL: a 1 2 +  a set-global  SYMBOL: b 4 a get-global +  b set-global a get-global . b get-global . ", transpile("a = 1 + 2; b = 4 + a; print a; print b;"));
    }
    @Test
    void testComplex() throws IOException{
        assertEquals("1 2 + 2 3 * 3 5 + + + .", transpile("print (1+2)+2*3+(3+5)"));
    }
}
