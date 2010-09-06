grammar twyncat;

options {
	//output = template;
	//rewrite = true;
	//output = AST;
	backtrack = true;
}

tokens {
	INDENT;
	DEDENT;
}

@parser::header {
package it.polito.lt.twyncat;
}

@lexer::header {
package it.polito.lt.twyncat;
import java.util.LinkedList;
}


@lexer::members {
int nSpaces = 0;
int implicitLineJoiningLevel = 0;
Stack<Integer> indentations = new Stack<Integer>();
LinkedList<Token> tokens = new LinkedList<Token>();

public void emit(Token token) {
  // Check if new token starts from 0
  if (token.getCharPositionInLine() == 0) {
  	// Check if token starting from 0 is not one of the allowed ones
  	if ((token.getType() != LEADINGWS)&&(token.getType() != INDENT)&&(token.getType() != DEDENT)/*&&(token.getType() != COMMENT)*/) {
  		// Pop all DEDENTS in the indentations stack before the matched token  		
  		while( indentations.empty() == false) {
  			indentations.pop();
			Token t = new ClassicToken(DEDENT, new String("")); t.setLine(token.getLine());
			emit(t);
			System.out.println("DED at line " + token.getLine());
		}
		
  	}
  }
  state.token = token;
  tokens.add(token);
}

public Token nextToken() {
  super.nextToken();
  // Check if it's EOF's time
  if ( tokens.size() == 0 ) {
    // Check if indentations stack is empty
    if ( !indentations.empty() ) {
      // Return DEDENT tokens until stack is empty
      indentations.pop(); 
      System.out.println("DED at EOF");
      return new ClassicToken(DEDENT);
    }
    return Token.EOF_TOKEN;
  }
  return (Token)tokens.remove();
}

protected void mismatch(IntStream input, int ttype, BitSet follow)
  throws RecognitionException
{
  throw new MismatchedTokenException(ttype, input);
}

}
// Alter code generation so catch-clauses get replace with
// this action.
@rulecatch {
	catch (RecognitionException e) {
		throw e;
	}
}

// === Boolean Literal ===
BOOLEANL
  : 'True' | 'False'
  ;

// === Standard Data Type ===
SDT options{ k = 4; }
  : 'bool'    // {True, False}
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
  
function:	
	'func' ID ':' codeBlock
	;

callFunc
	: ID trailer? '(' ( test ( ',' test)*)? ')'
	;
  
// TODO: check if exprStm is the right rule to match
alias	:
	'alias' ID '=' exprStm	
	;

pointer	:
	'pointer' '.' (SDT | ID)  ID (',' ID)*
	;

// TODO: init at value ID = 3, ID2 = 7...
enumeration	:
	'enum' '.' ID '=' LCURLY ID ('=' DECIMALL)? (',' ID ('=' DECIMALL)?)* RCURLY
	;
	
// TODO: not completed
/*
subrange:
	'subrange' '.' ( 'int' | 'sint' | 'usint') ID '='
	;
*/

structure
	: 'structure' ID COLON NEWLINE INDENT ((SDT | ID) varList NEWLINE)+ DEDENT	
	;

// TODO within : arrays, structures, strings (and respective initializations)
definition :
	(( 'in' | 'out' | 'inout' ) DOT )? (( 'persistent' | 'retain' | 'constant') DOT )? (SDT | ID) varList  { System.out.println("ASD " + $start); }
	;

globaldefinition 
	:
	(( 'config' | 'global' ) DOT )? (( 'persistent' | 'retain' | 'constant') DOT )? (SDT | ID) varList
	;

varList :
	varListElem (',' varListElem )*
	;
	
fragment
varListElem 
	: ID trailer? (arrayModifier)? ('=' (arrayConstantExpression | atom))?
	;

arrayModifier
	: ( LBRACK arrayRange RBRACK )
	| ( LBRACK first=arrayRange RBRACK ) ( LBRACK second=arrayRange RBRACK ) 
	| ( LBRACK first=arrayRange RBRACK ) ( LBRACK second=arrayRange RBRACK ) ( LBRACK third=arrayRange RBRACK )
	;

arrayRange
	: l=DECIMALL ':' h=DECIMALL // -> arrayRange(low={$l.text},high={$h.text}) // When more TOKENS appear in a Parser Rule, it is necessary to label them, removing ambiguities
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
	: atom ( ',' atom )*
	;

// "root" of TwinCAT grammar
// TODO: functions, imports, ...
file
	: globalStm* function* program EOF
	;

statement
	: simpleStm
	| compoundStm
	;

globalStm
	: smallGlobalStm (SEMI)? NEWLINE
	;

smallGlobalStm
	: alias
	| pointer
	| enumeration
	| globaldefinition
	| structure
	;

// TODO: choose if we let more small statements per line
simpleStm
  : smallStm (SEMI)? NEWLINE
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
  | callFunc
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
  : 'for' ID 'in' LCURLY test ':' test ':' test RCURLY COLON codeBlock
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
	
term
	: factor (('*'|'/'|'%'|'//') factor)*
	;
	
factor
	:  '(' expr ')' 
	| ('+'|'-'|'~') factor | power
	;
	
power
	: atom ('**' factor)?
	;
atom
	: literal
	| ID trailer?
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
  : BINARYL
  | HEXL
  | FLOATINGPOINTL
  | DECIMALL
  | OCTALL
  | timeL
  | todL
  | dateL
  | datetimeL
  | BOOLEANL
  | CHARACTERL
  | stringL
  ;

BINARYL
  : 'b!' ('0'..'1')+
  ;
  
HEXL
  : 'h!' HEXDIGIT+
  ;

FLOATINGPOINTL
  :    ('0'..'9')* '.' ('0'..'9')+ Exponent?
  |    ('0'..'9')+ Exponent
  ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ; 

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

fragment
EscapeSequence
  :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
  |   OctalEscape
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
OctalEscape
  :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
  |   '\\' ('0'..'7') ('0'..'7')
  |   '\\' ('0'..'7')
  ;

FF    : '\u000C';
//HASH    : '#';
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

/*
COMMENT
@init {
	$channel = HIDDEN;
}
	: { getCharPositionInLine() == 0 }?=> '#' ~('\n')+ NEWLINE
	| { getCharPositionInLine() > 0 }?=> '#' ~('\n')+ 
;
*/

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
				    			char[] spaces = new char[nSpaces];
							for(int i = 0; i < nSpaces; i++)
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