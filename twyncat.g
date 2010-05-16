grammar twyncat;

tokens {
    INDENT;
    DEDENT;
}

options {
	//backtrack=true; // automatically resolve similar rules (which begin the same way)
	//memoize=true; // use extra memory to speed up backtracking
	//output=AST; // generate an abstract syntax tree from matched rules
	//ASTLabelType=CommonTree; // class of tree node (must be cast from Object, otherwise)
}

@lexer::members {
/** Handles context-sensitive lexing of implicit line joining such as
 *  the case where newline is ignored in cases like this:
 *  a = [3,
 *       4]
 */
int implicitLineJoiningLevel = 0;
int startPosition=-1;
}

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
	: declarationheader vardeclarationlist
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
declarationheader
	: ( VARDECLARATIONPURPOSE '.' )? ( VARDECLATTRIBUTE '.' )? ( SDT | UDT )
	;

// === Variable Declaration List ===
/* EXAMPLES
myidentifier, mysecondidentifier = 3, mythirdarray[1:40]
mynewidentifier
*/
vardeclarationlist
	: vardeclaration (',' vardeclaration)*
	;

// === Variable Declaration ===
/* EXAMPLES
myidentifier
my2ndidentifier = True
*/
vardeclaration
	: varidentifierdeclaration ( vardeclarationassignment )?
	;

vardeclarationassignment
	: '=' CONSTANT
	;

varidentifierdeclaration
	: IDENTIFIER
	| IDENTIFIER ('[' ARRAYRANGE ']') // TODO UP TO 3 ???
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
UDT	:
	'udt'		// TODO
	;

// === Identifier ===
IDENTIFIER
	:
	( 'a' .. 'z' | 'A' .. 'Z' | '_') ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
	;

CONSTANT
	: '3'	// TODO
	;

ARRAYRANGE
	: '1:200'	// TODO
	;

VARDECLARATIONPURPOSE
	: ( 'in' | 'out' | 'inout')
	;

VARDECLATTRIBUTE
	: ('retain' | 'persistent' | 'constant')
	;

NEWLINE	:   (( FF )?( CR )? LF )+
        {if ( startPos==0 || implicitLineJoiningLevel>0 )
            $channel=HIDDEN;
        }
    ;

WS  :    {startPos>0}?=> (' '| TAB | FF )+ {$channel=HIDDEN;}
    ;

LEADING_WS
@init {
    int spaces = 0;
}
    :   {startPos==0}?=>		// If it is starting from first column
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
    :    {startPos==0}?=> ( WS | TAB )* HASH (~LF)* LF+
    |    {startPos>0}?=> HASH (~LF)* // let NEWLINE handle \n unless char pos==0 for '#'
    ;

FF		: '\u000C';
HASH		: '#';
TAB		: '\t';
CR		: '\r';
LF		: '\n';
LPAREN		: '(' {implicitLineJoiningLevel++;} ;
RPAREN		: ')' {implicitLineJoiningLevel--;} ;
LBRACK		: '[' {implicitLineJoiningLevel++;} ;
RBRACK		: ']' {implicitLineJoiningLevel--;} ;
COLON		: ':' ;
COMMA		: ',' ;
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
VBAREQUAL	: '|=' ;
PERCENTEQUAL	: '%=' ;
AMPEREQUAL	: '&=' ;
CIRCUMFLEXEQUAL	: '^=' ;
LEFTSHIFTEQUAL	: '<<=' ;
RIGHTSHIFTEQUAL	: '>>=' ;
DOUBLESTAREQUAL	: '**=' ;
DOUBLESLASHEQUAL: '//=' ;
DOT		: '.' ;
AT		: '@' ;
AND		: 'and' ;
OR		: 'or' ;
NOT		: 'not' ;