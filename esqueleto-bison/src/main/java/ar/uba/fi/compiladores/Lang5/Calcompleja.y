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
%token SEMICOLON
%token ASSIGN
%token VARIABLE
%code {
  public String program;
}

/* Grammar follows */
%%

top: 
  stmt_list       { $$ = program = $1;}
;
stmt_list:        { $$ = "";}
| stmt stmt_list  { $$ = $1 + $2;}
;

stmt:
  PRINT term SEMICOLON     { $$ = $2 +". ";}
| VARIABLE ASSIGN term SEMICOLON     { $$ = " SYMBOL: " + $1+ " "+ $3+ " "+$1+" set-global " ;}
;

term:
  factor PLUS term   { $$ =  $1 + $3 + "+ "; }
| factor            { $$ = $1; }
;

factor:
  L_PAREN term R_PAREN    { $$ = $2; }
| NUMBER TIMES factor     { $$ = $1 +" "+ $3 + "* "; }
| NUMBER                  { $$ = $1 + " "; }
| VARIABLE                { $$ = $1 + " get-global "; }
;

%%