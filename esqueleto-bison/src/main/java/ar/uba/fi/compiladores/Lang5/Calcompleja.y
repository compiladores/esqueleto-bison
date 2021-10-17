%language "Java"
%define api.parser.class {Calcompleja}
%define api.parser.public
%define package {ar.uba.fi.compiladores.Lang5}
%define api.value.type {String}

/* Bison Declarations */
%token L_PAREN
%token R_PAREN
%token TIMES
%token PLUS
%token NUMBER
%token PRINT

%code {
  public String program;
}

/* Grammar follows */
%%

top: 
  PRINT term       { $$ = program = $2 + ".";}
;
term:
  factor PLUS term   { $$ =  $1 + $3 + "+ "; }
| factor            { $$ = $1; }
;

factor:
  L_PAREN term R_PAREN    { $$ = $2; }
| NUMBER TIMES factor     { $$ = $1 +" "+ $3 + "* "; }
| NUMBER                  { $$ = $1 + " "; }
;

%%