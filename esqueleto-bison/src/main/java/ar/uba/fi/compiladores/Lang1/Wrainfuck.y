%language "Java"
%define api.parser.class {Wrainfuck}
%define api.parser.public
%define package {ar.uba.fi.compiladores.Lang1}
%define api.value.type {Number}

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
  public Number value;
}

/* Grammar follows */
%%

exp:
  COMMA exp                       { $$ = value = $2.floatValue(); }
| ZERO                            { $$ = value = 0; }
| L_PAREN exp COMMA div R_PAREN   { $$ = value = $2.floatValue() * $4.floatValue(); }
| L_BRACES div SLASH div R_BRACES { $$ = value = $2.floatValue() / $4.floatValue(); }
;

div: 
  ONE SLASH exp                   { $$ = 1 / $3.floatValue(); }
| NUMBER                          { $$ = $1.floatValue(); }

%%