grammar twyncat;

tokens {
	INDENT;
	DEDENT;
}

@lexer::header {
import java.util.LinkedList;
}

@lexer::members {
int nSpaces = 0;
int implicitLineJoiningLevel = 0;
Stack<Integer> indentations = new Stack<Integer>();
LinkedList<Token> tokens = new LinkedList<Token>();

public void emit(Token token) {
  state.token = token;
  tokens.add(token);
}
public Token nextToken() {
  super.nextToken();
  if ( tokens.size() == 0 ) {
    if ( !indentations.empty() ) {
      indentations.pop(); return new ClassicToken(DEDENT);
    }
    return Token.EOF_TOKEN;
  }
  return (Token)tokens.remove();
}
}

// === Boolean Literal ===
BOOLEANL
  : 'True' | 'False'
  ;

// === Standard Data Type ===
SDT :
  'bool'    // {True, False}
  | 'byte'  // {0 to 255}
  | 'word'  // {0 to 65535}
  | 'dword' // {0 to 4294967295}
  | 'sint'  // {-128 to 127}
  | 'usint' // {0 to 255}
  | 'int'   // {-32768 to 32767}
  | 'uint'  // {0 to 65535}
  | 'dint'  // {-2147483648 to 2147483647}
  | 'udint' // {0 to 4294967295}
  | 'real'  // {~ -3.402823 x 10^38 to ~ 3.402823 x 1038}
  | 'lreal' // {~ -1.79769313486231E308 to ~ 1.79769313486232E308}
  | 'string'  // {(dim) 'This is a String';}
  | 'time'  // {T#0ms to T#71582m47s295ms} - T#9d8h7m6s5ms
  | 'tod'   // {TOD#00:00 to TOD#1193:02:47.295} - TOD#00:00:00.001
  | 'date'  // {D#1970-01-01 to D#2106-02-06} - D#1972-03-29
  | 'dt'    // {DT#1970-01-01-00:00 to DT#2106-02-06-06:28:15}
  ;

// Only one per file
program	:
  'prog' ID ':' codeBlock
  ;
 
// TODO within : arrays, structures, strings (and respective initializations)
definition :
  (( 'in' | 'out' | 'inout' ) '.' )? (( 'persistent' | 'retain' | 'constant') '.')? SDT ID (',' ID)*
  ;

// "root" of TwinCAT grammar
// TODO: functions, imports, ...
file :
  program EOF ;

statement
  : simpleStm
  | compoundStm
  ;

// TODO: choose if we let more small statements per line
simpleStm
  : smallStm (SEMI smallStm)* (SEMI)? NEWLINE
  ;

// TODO: function calls
smallStm
  : exprStm
  | flowStm
  | repeatUntilStm
  | definition
  ;

// TODO: implement http://docs.python.org/release/2.6.4/reference/grammar.html
exprStm
  : test (augAssign (test)
  | ('=' (test))*)
  ;

augAssign
	: '+=' 
	| '-=' 
	| '*=' 
	| '/=' 
	| '%=' 
	| '&=' 
	| '|=' 
	| '^=' 
	| '<<='
	| '>>='
	| '**='
	| '//='
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
  //| repeatUntilStm
  ;

ifStm
  : 'if' test COLON codeBlock elifClause* ('else' COLON codeBlock)?
  ;

elifClause
  : 'elif' test COLON codeBlock
  ;

caseStm
  : 'case' test COLON NEWLINE INDENT caseElementsStm DEDENT
  ;
  
caseElementsStm
  : ( test COLON codeBlock )+ 'default' COLON codeBlock
  ;

forStm
  : 'for' ID 'in' '{' test ':' test ':' test '}' COLON codeBlock
  ;
  
whileStm
  : 'while' test COLON codeBlock
  ;

repeatUntilStm
  : 'repeat' COLON codeBlock 'until' test
  ;

codeBlock
  : simpleStm
  | NEWLINE INDENT ( statement )+ DEDENT
  ;

// TODO: implement http://docs.python.org/release/2.6.4/reference/grammar.html
test
  : orTest
  ;

orTest	:
	andTest ('or' andTest)*
	;

andTest	:
	notTest ('and' notTest)*
	;

notTest :
	 'not' notTest | comparison
	;
	
comparison
	: expr (compOperator expr)*
	;
	
compOperator
	: '<'
	| '>'
	| '=='
	| '>='
	| '<='
	| '<>'
	| '!='
	//| 'in'
	//| 'not' 'in'
	//| 'is'
	//| 'is' 'not'
	;
	
expr:
	xorExpr ('|' xorExpr)*
	;

xorExpr: 
	andExpr ('^' andExpr)*
	;
	
andExpr:
	shiftExpr ('&' shiftExpr)*
	;
	
shiftExpr:
	arithExpr (('<<'|'>>') arithExpr)*
	;
	
arithExpr:
	term (('+'|'-') term)*
	;
	
term:
	factor (('*'|'/'|'%'|'//') factor)*
	;
	
factor: 
	('+'|'-'|'~') factor | power
	;
	
power
	: atom trailer* ('**' factor)?
	;
atom
	: ID
/*	| FLOATINGPOINTL
	| DECIMALL
	| HEXL
	| BINARYL
	|  
	| stringL+
*/
	| literal
	;
	
trailer
	: ('.' ID)+
	;

ID  : 
  ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
  ;

singleFileInput
  : (NEWLINE | statement)* EOF
  ;

// === Literals ===
// TODO: String initialization
literal
  : 
  //stringL |
  BINARYL
  | HEXL
  | DECIMALL
  | OCTALL
  | timeL
  | todL
  | dateL
  | datetimeL
  | FLOATINGPOINTL
  | BOOLEANL
  ;

fragment
FLOATINGPOINTL
  :   ('0'..'9')* '.' ('0'..'9')+ Exponent?
  |   ('0'..'9')+ Exponent?
  ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ; 

BINARYL
  : 'b!' ('0'..'1')+
  ;
  
HEXL
  : 'h!' HEXDIGIT+
  ;

fragment
HEXDIGIT
  : ('0'..'9'|'a'..'f'|'A'..'F')
  ;
  
DECIMALL
  : ('0' | '1'..'9' '0'..'9'*)
  ;

OCTALL
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

FF    : '\u000C';
HASH    : '#';
TAB   : '\t';
CR    : '\r';
LPAREN    : '(' {implicitLineJoiningLevel++;} ;
RPAREN    : ')' {implicitLineJoiningLevel--;} ;
LBRACK    : '[' {implicitLineJoiningLevel++;} ;
RBRACK    : ']' {implicitLineJoiningLevel--;} ;
COLON   : ':' ;
SEMI    : ';' ;
PLUS    : '+' ;
MINUS   : '-' ;
STAR    : '*' ;
SLASH   : '/' ;
VBAR    : '|' ;
AMPER   : '&' ;
LESS    : '<' ;
GREATER   : '>' ;
ASSIGN    : '=' ;
PERCENT   : '%' ;
BACKQUOTE : '`' ;
LCURLY    : '{' {implicitLineJoiningLevel++;} ;
RCURLY    : '}' {implicitLineJoiningLevel--;} ;
CIRCUMFLEX  : '^' ;
TILDE   : '~' ;
EQUAL   : '==' ;
NOTEQUAL  : '!=' ;
ALT_NOTEQUAL  : '<>' ;
LESSEQUAL : '<=' ;
LEFTSHIFT : '<<' ;
GREATEREQUAL  : '>=' ;
RIGHTSHIFT  : '>>' ;
PLUSEQUAL : '+=' ;
MINUSEQUAL  : '-=' ;
DOUBLESTAR  : '**' ;
STAREQUAL : '*=' ;
DOUBLESLASH : '//' ;
SLASHEQUAL  : '/=' ;
OREQUAL   : '|=' ;
PERCENTEQUAL  : '%=' ;
ANDEQUAL  : '&=' ;
CIRCUMFLEXEQUAL : '^=' ;
LEFTSHIFTEQUAL  : '<<=' ;
RIGHTSHIFTEQUAL : '>>=' ;
DOUBLESTAREQUAL : '**=' ;
DOUBLESLASHEQUAL: '//=' ;
DOT   : '.' ;
COMMA   : ',';
AT    : '@' ;

NEWLINE :
    (( FF )?( CR )? '\n' )+
    { if ( $start == 0 || implicitLineJoiningLevel > 0 )
        $channel=HIDDEN;
    }
    ;

WS  :    
    { getCharPositionInLine() > 0 }?=>
    (' '| TAB | FF )+ { $channel = HIDDEN; }
    ;

// TODO: ignore this rule using a flag when implicitjoiningline > 0
LEADINGWS	
@init{
	int nSpaces = 0;
}	:
	{ getCharPositionInLine() == 0 }?=> 
		( ' ' { nSpaces++; }
		| '\t' { nSpaces += 8; nSpaces -= (nSpaces \% 8); }
		)+
		{
			int lastIndentation;
			if (indentations.empty())
				lastIndentation = 0;
			else
				lastIndentation = indentations.peek();
			if ( nSpaces > lastIndentation ) {
				indentations.push(nSpaces);
				char[] spaces = new char[nSpaces];
				for(int i = 0; i < nSpaces; i++)
					spaces[i] = ' ';
				Token t = new ClassicToken(INDENT, new String(spaces)); t.setLine($line);
				emit( t );
				System.out.println("IND Spaces: " + nSpaces + " at line " + $line);
			} else if ( nSpaces < lastIndentation ) {
				if ( indentations.search(nSpaces) != -1 ) {
				    boolean first = true;
				    while( indentations.empty() == false) {
				    	if( nSpaces < indentations.peek() ) { 
				    		if(first){
				    			first = false;
				    			int nSp = indentations.pop();
				    			char[] spaces = new char[nSp];
							for(int i = 0; i < nSp; i++)
								spaces[i] = ' ';
				    			Token t = new ClassicToken(DEDENT, new String(spaces)); t.setLine($line);
				    			emit(t);
							System.out.println("DED Spaces: " + nSp + " at line " + $line);
				    		} else {
		           				int nSp = indentations.pop();
							Token t = new ClassicToken(DEDENT, new String("")); t.setLine($line);
							emit(t);
							System.out.println("DED Spaces: " + nSp + " at line " + $line);
						}
					} else { break; }
				    }
				} else {
					System.out.println("ERROR");
				}
			}
			$channel = HIDDEN;
		}
	;