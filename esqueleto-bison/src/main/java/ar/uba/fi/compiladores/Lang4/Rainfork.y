%language "Java"
%define api.parser.class {Rainfork}
%define api.parser.public
%define package {ar.uba.fi.compiladores.Lang4}
%define api.value.type {SemVal}
%define api.parser.extends {RainforkHelper}

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
  public SemVal value;
}

/* Grammar follows */
%%

exp:
  COMMA exp                       { $$ = value = comma($2); }
| ZERO                            { $$ = value = zero(); }
| L_PAREN exp COMMA div R_PAREN   { $$ = value = tuple($2,$4); }
| L_BRACES div SLASH div R_BRACES { $$ = value = division($2,$4); }
;

div: 
  ONE SLASH exp                   { $$ = opposite($3); }
| NUMBER                          { $$ = $1; }

%%