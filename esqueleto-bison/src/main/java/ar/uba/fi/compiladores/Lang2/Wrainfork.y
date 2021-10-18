%language "Java"
%define api.parser.class {Wrainfork}
%define api.parser.public
%define package {ar.uba.fi.compiladores.Lang2}
%define api.value.type {String}

/* Bison Declarations */
%token COMMA
%token ZERO
%token L_PAREN
%token R_PAREN
%token L_BRACES
%token SLASH
%token R_BRACES
%token ONE
%token NUMBER

%code {
  public String value;
}

/* Grammar follows */
%%

exp:
  COMMA exp                       { $$ = value = "-" +$2; }
| ZERO                            { $$ = value = "0"; }
| L_PAREN exp COMMA div R_PAREN   { $$ = value = "("+$2+" * "+$4+")"; }
| L_BRACES div SLASH div R_BRACES { $$ = value = "{"+$2+" / "+$4+"}"; }
;

div: 
  ONE SLASH exp                   { $$ = "1 / "+$3; }
| NUMBER                          { $$ = $1; }

%%