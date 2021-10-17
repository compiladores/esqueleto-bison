package ar.uba.fi.compiladores;

public abstract class JFlexLexerHelper {

    public String getLVal() {
        return yytext();
    }

    public abstract String yytext();

    public void yyerror(String msg) {
        throw new RuntimeException(msg);
    }
    
}
