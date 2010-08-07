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

booleanL returns [ String txt ]
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
	: ID trail=trailer? '(' callFuncArgs ')'
	{ $txt = $ID.text + ($trail.txt == null?"":$trail.txt) + "(" + $callFuncArgs.txt + ")"; System.out.println($txt); }
	;
	
callFuncArgs returns [String txt]
@init	{StringBuilder sb = new StringBuilder();}
@after	{$txt = sb.toString();}
	: ( argN=ID '=' argV=test 
	{
	sb.append($argN.text + " := " + $argV.txt);
	}
	( ',' argN=ID '=' argV=test)*)? 
	{
	sb.append(", " + $argN.text + " := " + $argV.txt);
	}
	;
	
alias returns [ String txt ]
	: 'alias' ID '=' exprStm
	{ $txt = "TYPE " + $ID.text + ":" + $exprStm.txt + "; " + "END_TYPE"; System.out.println($txt);	}
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
	: 'enum' '.' en=ID '=' LCURLY enumerationElementList RCURLY
	{ $txt = "TYPE " + $en.text + ":(" + $enumerationElementList.txt + "); END_TYPE"; System.out.println($txt); }
	;

enumerationElementList returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString(); }
	:  ee1=enumerationElement { sb.append($ee1.txt); } (',' eeN=enumerationElement { sb.append(", " + $eeN.txt); } )*
	;

fragment enumerationElement returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString(); }
	: ID { sb.append($ID.text); } ('=' DECIMALL { sb.append(":=" + $DECIMALL.text); })?
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
varListElem returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();}
	: ID { sb.append($ID.text); } (trailer { sb.append($trailer.txt); })? (arrayModifier { sb.append($arrayModifier.txt); })? 
	('=' (ace=arrayConstantExpression { sb.append(" := " + $ace.txt); }| a=atom { sb.append(" := " + $a.txt); }))?
	;

arrayModifier returns [ String txt ]
	: ( LBRACK arrayRange RBRACK )
	{ $txt = "[ " + $arrayRange.txt + " ]"; }
	| ( LBRACK first=arrayRange RBRACK ) ( LBRACK second=arrayRange RBRACK )
	{ $txt = "[ " + $first.txt + ", " + $second.txt + " ]";	}
	| ( LBRACK first=arrayRange RBRACK ) ( LBRACK second=arrayRange RBRACK ) ( LBRACK third=arrayRange RBRACK )
	{ $txt = "[ " + $first.txt + ", " + $second.txt + ", " + $third.txt + " ]"; }
	;

arrayRange returns [ String txt ]
	: l=DECIMALL ':' h=DECIMALL
	{ $txt = $l.text + ".." + $h.text; }
	; 

arrayConstantExpression returns [ String txt ]
	: ( LBRACK literalsList RBRACK )
	{ $txt = $literalsList.txt; }
	| ( LBRACK first=literalsList RBRACK ) ( LBRACK second=literalsList RBRACK )
	{ $txt = $first.txt + ", " + $second.txt;	}
	| ( LBRACK first=literalsList RBRACK ) ( LBRACK second=literalsList RBRACK ) ( LBRACK third=literalsList RBRACK )
	{ $txt = $first.txt + ", " + $second.txt + ", " + $third.txt; }
	;

literalsList returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString(); }
	: a1=atom 
	{ sb.append($a1.txt); }
	( ',' aN=atom { sb.append(", " + $aN.txt); })*
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
@after	{ System.out.println($txt); }
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

test returns [ String txt]
	: orTest { $txt = $orTest.txt; }
	;

orTest returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: and1=andTest { sb.append($and1.txt); } ('or' andN=andTest { sb.append(" OR " + $andN.txt); })*
	;

andTest returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: not1=notTest { sb.append($not1.txt); } ('and' notN=notTest { sb.append(" AND " + $notN.txt); })*
	;

notTest returns [ String txt ]
	: 'not' nt=notTest { $txt = "NOT " + $nt.txt; }
	| comparison { $txt = $comparison.txt; }
	;
	
comparison returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: ex1=expr { sb.append($ex1.txt); } (compOperator exN=expr { sb.append(" " + $compOperator.txt + " " + $exN.txt + " "); })*
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
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: xor1=xorExpr { sb.append($xor1.txt); } ('|' xorN=xorExpr { sb.append(" OR " + $xorN.txt); } )*
	;

xorExpr returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: and1=andExpr { sb.append($and1.txt); } ('^' andN=andExpr { sb.append(" XOR " + $andN.txt); } )*
	;
	
andExpr returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: shi1=shiftExpr { sb.append($shi1.txt); } ('&' shiN=shiftExpr { sb.append(" AND " + $shiN.txt); } )*
	;
	
shiftExpr returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: aril=arithExpr '<<' ariL=arithExpr { sb.append("SHL(" + $aril.txt + ", " + $ariL.txt + ")"); }
	| arir=arithExpr '>>' ariR=arithExpr { sb.append("SHR(" + $arir.txt + ", " + $ariR.txt + ")"); }
	| ari=arithExpr { sb.append($ari.txt); }
	;
	
arithExpr returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: t1=term { sb.append($t1.txt); } (('+' { sb.append(" + "); } |'-' { sb.append(" - "); }) tN=term { sb.append($tN.txt); })*
	;
	
term returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: f1=factor { sb.append($f1.txt); } (('*' { sb.append(" * "); } | '/' { sb.append(" / "); } | '%' { sb.append(" MOD "); }) fN=factor { sb.append($fN.txt); })*
	;
	
factor returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: '(' expr ')' { sb.append("(" + $expr.txt + ")"); }
	| ('+' { sb.append("+"); } | '-' { sb.append("-"); } ) fact=factor { sb.append($fact.txt); }
	| power { sb.append($power.txt); }
	;
	
power returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: atp=atom '**' factor { sb.append("EXPT(" + $atp.txt + ", " + $factor.txt +")"); }
	| at=atom { sb.append($at.txt); }
	;
atom returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: ID { sb.append($ID.text); } (trailer { sb.append($trailer.txt); })? (arrayModifierEl { sb.append($arrayModifierEl.txt); })?
	| literal { sb.append($literal.txt); }
	;
	
arrayModifierEl returns [ String txt ]
	: ( LBRACK expr RBRACK )
	{ $txt = "[ " +$expr.txt + "]"; }
	| ( LBRACK first=expr RBRACK ) ( LBRACK second=expr RBRACK )
	{ $txt =  "[ " + $first.txt + ", " + $second.txt + "]"; }
	| ( LBRACK first=expr RBRACK ) ( LBRACK second=expr RBRACK ) ( LBRACK third=expr RBRACK )
	{ $txt =  "[ " + $first.txt + ", " + $second.txt + ", " + $third.txt + "]"; }
	;
	
trailer returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: ('.' ID { sb.append("." + $ID.text);})+
	;

singleFileInput
  : (NEWLINE | statement)* EOF
  ;

// === Literals ===
// TODO: String initialization
literal returns [ String txt ]
  : DECIMALL { $txt = $DECIMALL.text; }
  | hexL { $txt = $hexL.txt; }
  | FLOATINGPOINTL { $txt = $FLOATINGPOINTL.text; }
  | binaryL { $txt = $binaryL.txt; }
  | octalL { $txt = $octalL.txt; }
  | timeL { $txt = $timeL.txt; }
  | todL { $txt = $todL.txt; }
  | dateL { $txt = $dateL.txt; }
  | datetimeL { $txt = $datetimeL.txt; }
  | booleanL { $txt = $booleanL.txt; }
  | CHARACTERL { $txt = $CHARACTERL.text; }
  | stringL { $txt = $stringL.txt; }
  ;

binaryL returns [ String txt ]
	: 'b!' BINDIGITS { $txt = "2#" + $BINDIGITS.text; }
	;

fragment BINDIGITS : ('0'..'1')+ ;
  
hexL returns [ String txt ]
	: 'h!' HEXDIGITS { $txt = "16#" + $HEXDIGITS.text; }
 	;

FLOATINGPOINTL
	:    ('0'..'9')* '.' ('0'..'9')+ EXPONENT?
	|    ('0'..'9')+ EXPONENT
	;

fragment EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ; 

fragment HEXDIGITS : ('0'..'9'|'a'..'f'|'A'..'F')+ ;

fragment OCTDIGITS : ('0'..'7')+ ;
	
DECIMALL : ('0' | '1'..'9' '0'..'9'*) ;

octalL returns [ String txt ]
	: 'o!' OCTDIGITS { $txt = "8#" + $OCTDIGITS.text; }
	;

// TODO: Check & convert in twincat
fragment EscapeSequence : '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | OctalEscape ;

timeL returns [ String txt ]
  : 't!' ( d=DECIMALL 'd' ) ( h=DECIMALL 'h' )? ( m=DECIMALL 'm' )? ( s=DECIMALL 's' )? ( ms=DECIMALL 'ms' )? 
  { $txt = "T#" + $d.text + ($h == null?"":$h.text + "h") + ($m == null?"":$m.text + "m") + ($s == null?"":$s.text + "s") + ($ms == null?"":$ms.text + "ms"); }
  | 't!' ( d=DECIMALL 'd' )? ( h=DECIMALL 'h' ) ( m=DECIMALL 'm' )? ( s=DECIMALL 's' )? ( ms=DECIMALL 'ms' )? 
  { $txt = "T#" + ($d == null?"":$d.text + "d") + $h.text + ($m == null?"":$m.text + "m") + ($s == null?"":$s.text + "s") + ($ms == null?"":$ms.text + "ms"); }
  | 't!' ( d=DECIMALL 'd' )? ( h=DECIMALL 'h' )? ( m=DECIMALL 'm' ) ( s=DECIMALL 's' )? ( ms=DECIMALL 'ms' )?
  { $txt = "T#" + ($d == null?"":$d.text + "d") + ($h == null?"":$h.text + "h") + $m.text + ($s == null?"":$s.text + "s") + ($ms == null?"":$ms.text + "ms"); }
  | 't!' ( d=DECIMALL 'd' )? ( h=DECIMALL 'h' )? ( m=DECIMALL 'm' )? ( s=DECIMALL 's' ) ( ms=DECIMALL 'ms' )?
  { $txt = "T#" + ($d == null?"":$d.text + "d") + ($h == null?"":$h.text + "h") + ($m == null?"":$m.text + "m") + $s.text + ($ms == null?"":$ms.text + "ms"); }
  | 't!' ( d=DECIMALL 'd' )? ( h=DECIMALL 'h' )? ( m=DECIMALL 'm' )? ( s=DECIMALL 's' )? ( ms=DECIMALL 'ms' )
  { $txt = "T#" + ($d == null?"":$d.text + "d") + ($h == null?"":$h.text + "h") + ($m == null?"":$m.text + "m") + ($s == null?"":$s.text + "s") + $ms.text; }
  ;

todL returns [ String txt ]
  : 'tod!' TODLDIGITS { $txt = "TOD#" + $TODLDIGITS.text; }
  ;
  
fragment TODLDIGITS : DECIMALL ':' DECIMALL ':' DECIMALL ( '.' DECIMALL )? ;

dateL returns [ String txt ]
  : 'd!' DATEDIGITS { $txt = "D#" + $DATEDIGITS.text; }
  ;
  
fragment DATEDIGITS : DECIMALL '-' DECIMALL '-' DECIMALL;

datetimeL returns [ String txt ]
  : 'dt!' DATETIMEDIGITS { $txt = "DT#" + $DATETIMEDIGITS.text; }
  ;
  
fragment DATETIMEDIGITS : DECIMALL '-' DECIMALL '-' DECIMALL '-' DECIMALL ':' DECIMALL;
  
CHARACTERL
  :   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
  ;

stringL returns [ String txt ]
  :  '"' stringLContent '"' { $txt = "'" + $stringLContent.text + "'"; }
  ;
  
fragment stringLContent : ( EscapeSequence | ~('\\'|'"') )*;
  
fragment
OctalEscape
  :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
  |   '\\' ('0'..'7') ('0'..'7')
  |   '\\' ('0'..'7')
  ;

ID	: 
	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
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
GREATEREQUAL  : '>=' ;
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
LEFTSHIFT	: '<<'; 
RIGHTSHIFTEQUAL : '>>=' ;
RIGHTSHIFT	: '>>'; 
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