grammar twyncat;

options {
	//output = template;
	//rewrite = true;
	output = AST;
	backtrack = true;
}

tokens {
	INDENT;
	DEDENT;
}

@parser::header {
import java.util.ListIterator;
import java.util.LinkedList;
}

@lexer::header {
import java.util.ListIterator;
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
				// System.out.println("DED at line " + token.getLine());
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
			// System.out.println("DED at EOF");
			return new ClassicToken(DEDENT);
		}
		return Token.EOF_TOKEN;
	}
	return (Token)tokens.remove();
}

protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException {
	throw new MismatchedTokenException(ttype, input);
}

}

// Alter code generation so catch-clauses get replace with this action.
@rulecatch {
	catch (RecognitionException re) {
		throw re;
	}
}

BOOLEANL returns [ String txt ]
	: 'True' { $txt = "TRUE"; }
	| 'False' { $txt = "FALSE"; }
	;

SDT returns [ String txt ]
	: 'bool' { $txt = "BOOL"; }
	| 'byte' { $txt = "BYTE"; } 
	| 'word' { $txt = "WORD"; }
	| 'dword' { $txt = "DWORD"; }
	| 'sint' { $txt = "SINT"; } 
	| 'usint' { $txt = "USINT"; }
	| 'int' { $txt = "INT"; }	
	| 'uint' { $txt = "UINT"; }
	| 'dint' { $txt = "DINT"; }
	| 'udint' { $txt = "UDINT"; }
	| 'real' { $txt = "REAL"; }
	| 'lreal' { $txt = "LREAL"; }
	| 'string' { $txt = "STRING"; }
	| 'time' { $txt = "TIME"; }
	| 'tod' { $txt = "TIME_OF_DAY"; }
	| 'date' { $txt = "DATE"; }
	| 'dt' { $txt = "DATE_AND_TIME"; }
	;


program
	: 'prog' ID ':' codeBlock
	;

function
	: 'func' ID ':' codeBlock
	;

callFunc returns [ String txt ]
	: ID trailer? '(' callFuncArgs ')'
	{
		$txt = $ID.text + ($trailer.text == null?"":$trailer.text) + "(" + $callFuncArgs.txt + ")";
		System.out.println($txt);
	}
	;
	
callFuncArgs returns [String txt]
	:  ( argsN+=ID '=' argsV+=test ( ',' argsN+=ID '=' argsV+=test)*)? 
	{
		StringBuilder sb = new StringBuilder();
		ListIterator<CommonTree> vI = $argsV.listIterator();
		ListIterator<CommonToken> nI = $argsN.listIterator();
		while(vI.hasNext()){
			sb.append(nI.next().getText() + " := " + vI.next().getText());
			if(vI.hasNext()){
				sb.append(", ");
			}
		}
		$txt = sb.toString();
	}
	;
	
alias returns [ String txt ]
	: 'alias' ID '=' exprStm
	{
		$txt = "TYPE " + $ID.text + ":" + $exprStm.txt + "; " + "END_TYPE";
		System.out.println($txt);
	}	
	;

pointer	returns [ List<String> statements ]
	: 'pointer' '.' (ts=SDT | ti=ID) n+=ID (',' n+=ID)*
	{
		$statements = new LinkedList<String>();
		ListIterator<Token> nI = $n.listIterator();
		
		while(nI.hasNext()){
			$statements.add(new String(nI.next().getText() + " :POINTER TO " + $ts.text + $ti.text));
			
		}
	}	
	;
// for each ID, declare a variable named scope.ID giving type pointer to t
// for each ID, print out twincat syntax for pointer
enumeration returns [ String txt ]
	:	'enum' '.' en=ID '=' LCURLY enumerationElementList RCURLY
	{
		$txt = "TYPE " + $en.text + ":(" + $enumerationElementList.txt + "); END_TYPE";
	}
	;

enumerationElementList returns [ String txt ]
	:  eE+=enumerationElement? (',' eE+=enumerationElement)*
	{
		StringBuilder sb = new StringBuilder();
		ListIterator<CommonTree> i = $eE.listIterator();
		while(i.hasNext()) {
			sb.append(i.next().getText()); // FIX TXT!!!!!
			if(i.hasNext()){
				sb.append(", ");
			}
		}
		$txt = sb.toString();
	} 
	;

fragment	
enumerationElement returns [ String txt ]
	:
	ID ('=' DECIMALL)?
	{
		$txt = $ID.text + ":=" + $DECIMALL.text;
	}
	;

// TODO: not completed
/*
subrange:
	'subrange' '.' ( 'int' | 'sint' | 'usint') ID '='
	;
*/

structure
	: 'structure' ID COLON NEWLINE INDENT structureElement+ DEDENT
	;
	
structureElement
	: ((SDT | ID) varList NEWLINE)+
	;

// TODO within : arrays, structures, strings (and respective initializations)
definition
	: (( 'in' | 'out' | 'inout' ) DOT )? (( 'persistent' | 'retain' | 'constant') DOT )? (SDT | ID) varList
	;

globaldefinition 
	: (( 'config' | 'global' ) DOT )? (( 'persistent' | 'retain' | 'constant') DOT )? (SDT | ID) varList
	;

varList
	: varListElem (',' varListElem )*
	;
	
fragment
varListElem 
	: ID trailer? (arrayModifier)? ('=' (arrayConstantExpression | atom))?
	;

arrayModifier returns [ String txt ]
	: ( LBRACK arrayRange RBRACK )
	{
	$txt = "[ " + $arrayRange.txt + " ]";
	}
	| ( LBRACK first=arrayRange RBRACK ) ( LBRACK second=arrayRange RBRACK )
	{
	$txt = "[ " + $first.txt + ", " + $second.txt + " ]";
	}
	| ( LBRACK first=arrayRange RBRACK ) ( LBRACK second=arrayRange RBRACK ) ( LBRACK third=arrayRange RBRACK )
	{
	$txt = "[ " + $first.txt + ", " + $second.txt + ", " + $third.txt + " ]";
	}
	;

arrayRange returns [ String txt ]
	: l=DECIMALL ':' h=DECIMALL
	{
	$txt = $l.text + ".." + $h.text;
	}
	; 

arrayConstantExpression
	: ( LBRACK literalsList RBRACK )
	| ( LBRACK literalsList RBRACK ) ( LBRACK literalsList RBRACK )
	| ( LBRACK literalsList RBRACK ) ( LBRACK literalsList RBRACK ) ( LBRACK literalsList RBRACK )
	;

literalsList
	: atom ( ',' atom )*
	;

// "root" of TwinCAT grammar
file	: gs+=globalStm* fs+=function* program EOF
	;

statement returns [ List<String> statements ]
	: simpleStm
	| compoundStm
	;

globalStm returns [ List<String> statements ]
	: smallGlobalStm (SEMI)? NEWLINE
	{
	$statements = new LinkedList<String>();
	//$statements.addAll($smallGlobalStm.statements);
	}
	;

smallGlobalStm returns [ List<String> statements ]
	: alias //-> {$alias.st}
	| pointer //-> {$pointer.st}
	| enumeration //-> {$enumeration.st}
	| globaldefinition //-> {$globaldefinition.st}
	| structure //-> {$structure.st}
	;

// TODO: choose if we let more small statements per line
simpleStm returns [ List<String> statements ]
	: smallStm (SEMI)? NEWLINE
	;

// TODO: function calls
smallStm returns [ List<String> statements ]
	: exprStm
	| flowStm
	| repeatUntilStm
	| definition
	;

// TODO: implement http://docs.python.org/release/2.6.4/reference/grammar.html
exprStm returns [ String txt ]
@after	{
	System.out.println("exprStm: " + $txt);
	}
	: t1=test
	(
	augAssign[$t1.text] t2=test { $txt = $t1.text + " " + $augAssign.txt + $t2.text; }
	| ('=' t3=test) { $txt = $t1.text + " := " + $t3.txt; }
	)
	;

augAssign [ String pre ] returns [ String txt ]
	: '+=' { $txt = ":= " + $pre + " + "; }
	| '-=' { $txt = ":= " + $pre + " - "; }
	| '*=' { $txt = ":= " + $pre + " * "; }
	| '/=' { $txt = ":= " + $pre + " / "; }
	| '%=' { $txt = ":= " + $pre + " MOD "; }
	| '&=' { $txt = ":= " + $pre + " AND "; }
	| '|=' { $txt = ":= " + $pre + " OR "; }
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

codeBlock returns [ List<String> statements ]
	: stms+=simpleStm | NEWLINE INDENT ( stms+=statement )+ DEDENT
	{
  	$statements = new LinkedList<String>();
  	}
	;

test returns [ String txt, String asdrubale]
	: orTest
	{
	$txt = $orTest.txt;
	System.out.println($txt);
	}
	;

orTest returns [ String txt ]
	: at+=andTest ('or' at+=andTest)*
	{
	StringBuilder sb = new StringBuilder();
	ListIterator<CommonTree> i = $at.listIterator();
	while(i.hasNext()){
		sb.append(i.next().getText());
		if(i.hasNext()){
			sb.append(" OR ");
		}
	}
	$txt = sb.toString();
	}
	;

andTest returns [ String txt ]
	: nt+=notTest ('and' nt+=notTest)*
	{
	StringBuilder sb = new StringBuilder();
	ListIterator<CommonTree> i = $nt.listIterator();
	while(i.hasNext()){
		sb.append(i.next().getText());
		if(i.hasNext()){
			sb.append(" AND ");
		}
	}
	$txt = sb.toString();
	}
	;

notTest returns [ String txt ]
	: 'not' nt=notTest { $txt = "NOT " + $nt.txt; }
	| comparison { $txt = $comparison.txt; }
	;
	
comparison returns [ String txt ]
@init	{
	StringBuilder sb = new StringBuilder();
	}
@after	{
	$txt = sb.toString();
	}
	: ex1=expr
	{
	
	sb.append($ex1.txt);
	}
	(compOperator exN=expr
	{
	sb.append(" " + $compOperator.txt + " ");
	sb.append(" " + $exN.txt + " ");
	}
	)*

	;
	
compOperator returns [ String txt ]
	: '<' { $txt = "<"; }
	| '>' { $txt = ">"; }
	| '==' { $txt = "="; }
	| '>=' { $txt = ">="; }
	| '<=' { $txt = "<="; }
	| '<>' { $txt = "<>"; }
	| '!=' { $txt = "<>"; }
	;
	
expr returns [ String txt ]
:	xorExpr ('|' xorExpr)* // To be turned in twincat OR
	{
	$txt = new String("PIPPO");
	}
	;

xorExpr: 
	andExpr ('^' andExpr)* // To be turned in twincat XOR
	;
	
andExpr:
	shiftExpr ('&' shiftExpr)* // To be turned in twincat AND
	;
	
shiftExpr:
	arithExpr (('<<'|'>>') arithExpr)* // To be turned in twincat SHL($aE1,$aE2), SHR($aE1,$aE2) respectively
	;
	
arithExpr:
	term (('+'|'-') term)*
	;
	
term	: factor (('*'|'/'|'%') factor)* // % To be turned in twincat $f1 MOD $f2
	;
	
factor	:  '(' expr ')' 
	| ('+'|'-') factor | power
	;
	
power	: atom ('**' factor)? // To be turned into EXPT($atom,$factor)
	;
atom	: literal
	| ID trailer? arrayModifierEl?
	;
	
arrayModifierEl
	: ( LBRACK expr RBRACK )
	| ( LBRACK expr RBRACK ) ( LBRACK expr RBRACK ) 
	| ( LBRACK expr RBRACK ) ( LBRACK expr RBRACK ) ( LBRACK expr RBRACK )
	;
	
trailer returns [ String txt ]
	: ('.' iL+=ID)+
	{
	StringBuilder sb = new StringBuilder();
	ListIterator<Token> i = $iL.listIterator();
	while(i.hasNext()){
		sb.append(i.next().getText());
		if(i.hasNext()){
			sb.append(".");
		}
	}	
	}
	;

ID	: 
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

// FIX: Will be not turned into twincat code
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
				//System.out.println("IND Spaces: " + nSpaces + " at line " + $line);
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
							//System.out.println("DED Spaces: " + nSp + " at line " + $line);
				    		} else {
		           				int nSp = indentations.pop();
							Token t = new ClassicToken(DEDENT, new String("")); t.setLine($line);
							emit(t);
							//System.out.println("DED Spaces: " + nSp + " at line " + $line);
						}
					} else { break; }
				    }
				} else {
					// Should raise IndentationException
					System.out.println("ERROR in indentation");
				}
			}
			$channel = HIDDEN;
		}
	;