grammar twyncat;

options {
	backtrack=true; // automatically resolve similar rules (which begin the same way)
	//memoize=true; // use extra memory to speed up backtracking
	//output=AST; // generate an abstract syntax tree from matched rules
	//ASTLabelType=CommonTree; // class of tree node (must be cast from Object, otherwise)
}

tokens {
    INDENT;
    DEDENT;
}


@lexer::members {
/** Handles context-sensitive lexing of implicit line joining such as
 *  the case where newline is ignored in cases like this:
 *  a = [3,
 *       4]
 */
int implicitLineJoiningLevel = 0;
int startPosition = -1;
}

/*
=== ?!?!?!?!? ===
  * Identifiers can be a single word or a structure component such as mystructure.mycomponent
  * Structures, aliases, memory locations
*/

singleLogicLine
	: NEWLINE
	| simpleStm
	| compoundStm NEWLINE
	;

structureComponent
	: IDENTIFIER (DOT IDENTIFIER)*
	;
	
functionDefinition
	: 'def' IDENTIFIER parameters COLON suite
	;
	
parameters 
	: LPAREN (argumentList)? RPAREN
	;
	
argumentList
	:	
	;

statement
	: simpleStm
	| compoundStm
	;

simpleStm
	: smallStm (options {greedy=true;}:SEMI smallStm)* (SEMI)? NEWLINE
	;

smallStm
	: exprStm
        | flowStm
        | declaration
        ;
exprStm
	: testList ( augAssign testList | assigns )?
	;

assigns
	: ( assignTestList )+
	;

assignTestList
	: ASSIGN testList
	;

augAssign
	: PLUSEQUAL
	| MINUSEQUAL
	| STAREQUAL
	| SLASHEQUAL
	| PERCENTEQUAL
	| ANDEQUAL
	| OREQUAL
	| LEFTSHIFTEQUAL
	| RIGHTSHIFTEQUAL
	;

flowStm
	: returnStm
	| exitStm
	;

exitStm
	: 'exit'
	;


returnStm
	: 'return'
	;	

compoundStm
	: ifStm
	| caseStm
	| forStm
	| whileStm
	| repeatuntilStm
	;

ifStm
	: 'if' test COLON suite elifClause*  ('else' COLON suite)?
	;

elifClause
	: 'elif' test COLON suite
	;

caseStm
	: 'case' test COLON NEWLINE INDENT caseElementsStm DEDENT
	;
	
caseElementsStm
	: test COLON suite
	| 'default' COLON suite
	;

forStm
	: 'for' IDENTIFIER 'in' '{'  '}' COLON suite
	;
	
whileStm
	: 'while' test COLON suite
	;

repeatuntilStm
	: 'repeat' 'until' test COLON suite
	;
	
repeatuntilHeaderStm
	: 'repeat' COLON NEWLINE INDENT suite DEDENT 'until' test
	;
	
suite
	: simpleStm
	| NEWLINE INDENT (statement)+ DEDENT
	;

test
	: orTest
	( ('if' orTest 'else') => 'if' orTest 'else' test)?
	;

orTest
	: andTest (OR andTest)*
        ;

andTest
	: notTest (AND notTest)*
        ;

notTest
	: NOT notTest
	| comparison
	;
	
comparison
	: expr (comparisonOp expr)*
	;

comparisonOp 
	: LESS
        | GREATER
        | EQUAL
        | GREATEREQUAL
        | LESSEQUAL
        | ALT_NOTEQUAL
        | NOTEQUAL
        //| 'is'
        //| 'is' NOT
        ;

expr
	: xorExpr (VBAR xorExpr)*
	;

xorExpr
	: andExpr (CIRCUMFLEX andExpr)*
	;

andExpr
	: shiftExpr (AMPER shiftExpr)*
	;

shiftExpr
	: arithExpr ((LEFTSHIFT|RIGHTSHIFT) arithExpr)*
	;

arithExpr
	: term ((PLUS|MINUS) term)*
	;

term
	: factor ((STAR | SLASH | PERCENT | DOUBLESLASH ) factor)*
	;

factor
	: PLUS factor
	| MINUS factor
	| TILDE factor
	| power
	;

power	
	: atom (trailer)* (options {greedy=true;}:DOUBLESTAR factor)?
	;

atom
	: literal
	| IDENTIFIER
	;

trailer
	: LPAREN (arglist)? RPAREN
	| DOT IDENTIFIER
	;

testList
    : test (options {k=2;}: COMMA test)* (COMMA)?
    ;

arglist
	: argument (COMMA argument)*
        ;

argument
	: test ( ASSIGN test )?
        ;

// === File ===
file
	: imports functions program EOF
	;

// === Imports ===
// TODO: manage imports
imports
	: ( singleImport )*
	;

singleImport
	: 'import' IDENTIFIER ( '.' IDENTIFIER )* NEWLINE
	;

// === Functions ===
functions
	: ( functionDefinition )*
	;

// === Program ===
program
	: 'prog' IDENTIFIER ':' suite
	;

// === Declaration ===
/* EXAMPLES
in.retain.T_DCTIME BufferLatchPosEL1252ACh1, 
                diff1[1:250000],              
                diff2[1:250000], 
                diff3[1:250000], 
                diff4[1:250000], 
                diff5[1:16000]
bool myflag = True, yourflag = False, anyoneflag
out.constant.dint myConstant = 2147483640
*/
declaration
	: declarationHeader varDeclarationList
	;

// === Declaration Header ===
/* EXAMPLES
bool
mytype
out.bool
retain.bool
out.persistent.bool
inout.retain.mytype
*/
declarationHeader
	: ( VARDECLARATIONPURPOSE '.' )? ( VARDECLATTRIBUTE '.' )? ( SDT | UDT )
	;

// === Variable Declaration List ===
/* EXAMPLES
myidentifier, mysecondidentifier = 3, mythirdarray[1:40]
mynewidentifier
*/
varDeclarationList
	: varDeclaration ( ',' varDeclaration )*
	;

// === Variable Declaration ===
/* EXAMPLES
myidentifier
my2ndidentifier = True
*/
varDeclaration
	: varIdentifierDeclaration ( '=' varDeclarationConstantExpression )?
	;

// === Variable Constant Expression ===
/* EXAMPLES
3000
100e+2
True
t!1d2h3m4s567ms
*/
varDeclarationConstantExpression
	: IDENTIFIER				// Such as MYCONSTANT
	| literal				// Such as 1000 or True or t!1d2h3m4s567ms
	| arrayConstantExpression		// Such as [1,6,8] or [t!1d2h3m4s567ms, t!1d2h3m]
	| structureConstantExpression		// Such as ( myElem = 8, my2ndElem = 10 )
	;

// === Variable Identifier Declaration
/* EXAMPLE
myVar
myVar[1:40]
mySecond[1:10][1:100]
*/
varIdentifierDeclaration
	: IDENTIFIER ( identifierArrayMod )?
	;

// === Identifier Array Mod
/* EXAMPLE
[10:400]
[1:10][1:20]
*/
identifierArrayMod
	: ( LBRACK arrayRange RBRACK )
	| ( LBRACK arrayRange RBRACK ) ( LBRACK arrayRange RBRACK )
	| ( LBRACK arrayRange RBRACK ) ( LBRACK arrayRange RBRACK ) ( LBRACK arrayRange RBRACK )
	;

arrayRange
	: DECIMALL ':' DECIMALL
	;

// === Array Constant Expression ===
/* EXAMPLE
[1,2,3,4,5]
[1,2][3,4][5,6]
*/
arrayConstantExpression
	: ( LBRACK literalsList RBRACK )
	| ( LBRACK literalsList RBRACK ) ( LBRACK literalsList RBRACK )
	| ( LBRACK literalsList RBRACK ) ( LBRACK literalsList RBRACK ) ( LBRACK literalsList RBRACK )
	;

// === Literals List ===
/* EXAMPLE
o!66
h!AF,h!1024,b!0001010
*/	
literalsList
	: literal ( ',' literal )*
	;

// === Literals ===
// TODO: String initialization
literal
	: stringL
	| binaryL
	| HEXL
	| DECIMALL
	| octalL
	| timeL
	| todL
	| dateL
	| datetimeL
	| floatingpointL
	| BOOLEANL
	;

// === Structure Constant Expression ===
/* EXAMPLE
( member = 3 )
( member1 = h!FF, member2 = o!40 )
*/
structureConstantExpression
	: ( LPAREN ( IDENTIFIER '=' varDeclarationConstantExpression ) ( ',' IDENTIFIER '=' varDeclarationConstantExpression )* RPAREN )	// Shouldn't use varIdentifierDeclaration cause of cannot re-define arrays on the fly (Is that right?)
	;
	






// === Standard Data Type ===
SDT	:
	'bool'		// {True, False}
	| 'byte'	// {0 to 255}
	| 'word'	// {0 to 65535}
	| 'dword'	// {0 to 4294967295}
	| 'sint'	// {-128 to 127}
	| 'usint'	// {0 to 255}
	| 'int'		// {-32768 to 32767}
	| 'uint'	// {0 to 65535}
	| 'dint'	// {-2147483648 to 2147483647}
	| 'udint'	// {0 to 4294967295}
	| 'real'	// {~ -3.402823 x 10^38 to ~ 3.402823 x 1038}
	| 'lreal'	// {~ -1.79769313486231E308 to ~ 1.79769313486232E308}
	| 'string'	// {(dim) 'This is a String';}
	| 'time'	// {T#0ms to T#71582m47s295ms} - T#9d8h7m6s5ms
	| 'tod'		// {TOD#00:00 to TOD#1193:02:47.295} - TOD#00:00:00.001
	| 'date'	// {D#1970-01-01 to D#2106-02-06} - D#1972-03-29
	| 'dt'		// {DT#1970-01-01-00:00 to DT#2106-02-06-06:28:15}
	;

// === User Data Type ===
// TODO: All
UDT	:
	'udt'
	;

floatingpointL
	:   ('0'..'9')+ '.' ('0'..'9')* Exponent?
	|   '.' ('0'..'9')+ Exponent?
	|   ('0'..'9')+ Exponent
	|   ('0'..'9')+ Exponent?
	;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;	

BOOLEANL
	: 'True' | 'False';
	
binaryL
	: 'b!' ('0'..'1')+
	;
	
HEXL
	: 'h!' HEXDIGIT+
	;

fragment
HEXDIGIT
	: ('0'..'9'|'a'..'f'|'A'..'F')
	;
	
fragment
DECIMALL
	: ('0' | '1'..'9' '0'..'9'*)
	;

octalL
	: 'o!' ('0'..'7')+
	;

timeL
	: 't!' ( DECIMALL 'd' ) ( DECIMALL 'h' )? ( DECIMALL 'm' )? ( DECIMALL 's' )? ( DECIMALL 'ms' )? 
	| 't!' ( DECIMALL 'd' )? ( DECIMALL 'h' ) ( DECIMALL 'm' )? ( DECIMALL 's' )? ( DECIMALL 'ms' )? 
	| 't!' ( DECIMALL 'd' )? ( DECIMALL 'h' )? ( DECIMALL 'm' ) ( DECIMALL 's' )? ( DECIMALL 'ms' )? 
	| 't!' ( DECIMALL 'd' )? ( DECIMALL 'h' )? ( DECIMALL 'm' )? ( DECIMALL 's' ) ( DECIMALL 'ms' )? 
	| 't!' ( DECIMALL 'd' )? ( DECIMALL 'h' )? ( DECIMALL 'm' )? ( DECIMALL 's' )? ( DECIMALL 'ms' ) 
	;

todL
	: 'tod!' DECIMALL ':' DECIMALL ':' DECIMALL ( '.' DECIMALL )?
	;

dateL
	: 'd!' DECIMALL '-' DECIMALL '-' DECIMALL
	;

datetimeL
	: 'dt!' DECIMALL '-' DECIMALL '-' DECIMALL '-' DECIMALL ':' DECIMALL
	;
	
CHARACTERL
	:   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
	;

stringL
	:  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
	;

fragment
EscapeSequence
	:   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
	|   OctalEscape
	;
	
fragment
OctalEscape
	:   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
	|   '\\' ('0'..'7') ('0'..'7')
	|   '\\' ('0'..'7')
	;

/* TODO
//7.4                     # Decimal Number
//1.64e+009               # Decimal Number
\$                      # Dollar signs
\'                      # Single quotation mark
\l                      # Line feed
\n                      # New line
\p                      # Page feed
\r                      # Line break
\t                      # Tab
*/

/*
Match various string types.  Note that greedy=false implies '''
should make us exit loop not continue.
*/
STRING
    :   ('r'|'u'|'ur')?
        (   '\'\'\'' (options {greedy=false;}:TRIAPOS)* '\'\'\''
        |   '"""' (options {greedy=false;}:TRIQUOTE)* '"""'
        |   '"' (ESC|~('\\'|'\n'|'"'))* '"'
        |   '\'' (ESC|~('\\'|'\n'|'\''))* '\''
        )
    ;

/** the two '"'? cause a warning -- is there a way to avoid that? */
fragment
TRIQUOTE
    : '"'? '"'? (ESC|~('\\'|'"'))+
    ;

/** the two '\''? cause a warning -- is there a way to avoid that? */
fragment
TRIAPOS
    : '\''? '\''? (ESC|~('\\'|'\''))+
    ;

fragment
ESC
    :    '\\' .
    ;

VARDECLARATIONPURPOSE
	: ( 'in' | 'out' | 'inout')
	;

VARDECLATTRIBUTE
	: ('retain' | 'persistent' | 'constant')
	;

NEWLINE	:   (( FF )?( CR )? '\n' )+
        {if ( startPosition==0 || implicitLineJoiningLevel>0 )
            $channel=HIDDEN;
        }
    ;

WS  :    {startPosition>0}?=> (' '| TAB | FF )+ {$channel=HIDDEN;}
    ;

LEADING_WS
@init {
    int spaces = 0;
}
    :   {startPosition==0}?=>		// If it is starting from first column
        (   {implicitLineJoiningLevel>0}? ( ' ' | TAB )+ {$channel=HIDDEN;}	// It is within a no-indentation context (ignores them)
	|    ( ' ' { spaces++; } | TAB { spaces += 8; spaces -= (spaces \% 8); } )+ 	// Counts how many ' ' will be generated
        {
            // Make a string of n spaces where n is column number - 1
            char[] indentation = new char[spaces];
            for (int i=0; i<spaces; i++) {
                indentation[i] = ' ';
            }
            String s = new String(indentation);
            emit(new ClassicToken(LEADING_WS,new String(indentation)));
            }
            // Kill trailing newline if present and then ignore
            ( ('\r')? '\n' {if (token!=null) token.setChannel(HIDDEN); else $channel=HIDDEN;})*
        )
    ;

COMMENT
@init {
    $channel=HIDDEN;
}
    :    {startPosition==0}?=> ( WS | TAB )* HASH (~'\n')* '\n'+
    |    {startPosition>0}?=> HASH (~'\n')* // let NEWLINE handle \n unless char pos==0 for '#'
    ;

FF		: '\u000C';
HASH		: '#';
TAB		: '\t';
CR		: '\r';
LPAREN		: '(' {implicitLineJoiningLevel++;} ;
RPAREN		: ')' {implicitLineJoiningLevel--;} ;
LBRACK		: '[' {implicitLineJoiningLevel++;} ;
RBRACK		: ']' {implicitLineJoiningLevel--;} ;
COLON		: ':' ;
SEMI		: ';' ;
PLUS		: '+' ;
MINUS		: '-' ;
STAR		: '*' ;
SLASH		: '/' ;
VBAR		: '|' ;
AMPER		: '&' ;
LESS		: '<' ;
GREATER		: '>' ;
ASSIGN		: '=' ;
PERCENT		: '%' ;
BACKQUOTE	: '`' ;
LCURLY		: '{' {implicitLineJoiningLevel++;} ;
RCURLY		: '}' {implicitLineJoiningLevel--;} ;
CIRCUMFLEX	: '^' ;
TILDE		: '~' ;
EQUAL		: '==' ;
NOTEQUAL	: '!=' ;
ALT_NOTEQUAL	: '<>' ;
LESSEQUAL	: '<=' ;
LEFTSHIFT	: '<<' ;
GREATEREQUAL	: '>=' ;
RIGHTSHIFT	: '>>' ;
PLUSEQUAL	: '+=' ;
MINUSEQUAL	: '-=' ;
DOUBLESTAR	: '**' ;
STAREQUAL	: '*=' ;
DOUBLESLASH	: '//' ;
SLASHEQUAL	: '/=' ;
OREQUAL		: '|=' ;
PERCENTEQUAL	: '%=' ;
ANDEQUAL	: '&=' ;
CIRCUMFLEXEQUAL	: '^=' ;
LEFTSHIFTEQUAL	: '<<=' ;
RIGHTSHIFTEQUAL	: '>>=' ;
DOUBLESTAREQUAL	: '**=' ;
DOUBLESLASHEQUAL: '//=' ;
DOT		: '.' ;
COMMA		: ',';
AT		: '@' ;
AND		: 'and' ;
OR		: 'or' ;
NOT		: 'not' ;

// === Identifier ===
// TODO: need to allow myVarUDT.myMember
IDENTIFIER
	:
	( 'a' .. 'z' | 'A' .. 'Z' | '_') ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
	;