grammar twyncat;

// TODO: Memory locations
// TODO: Structure
// TODO: Variables initialization
// TODO: Type checking
// TODO: Pointer dereference (^)
// TODO: Retain, Persistent, Constant

options {
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

@parser::members {

public class VariablesBundle {
	public List<String> inVar;
	public List<String> outVar;
	public List<String> inoutVar;
	public List<String> locVar;
	public List<String> inVarR;
	public List<String> outVarR;
	public List<String> inoutVarR;
	public List<String> locVarR;
	public List<String> inVarC;
	public List<String> outVarC;
	public List<String> inoutVarC;
	public List<String> locVarC;
	public List<String> inVarP;
	public List<String> outVarP;
	public List<String> inoutVarP;
	public List<String> locVarP;
	
	public VariablesBundle () {
		inVar = new LinkedList<String>();
		outVar = new LinkedList<String>();
		inoutVar = new LinkedList<String>();
		locVar = new LinkedList<String>();
		inVarR = new LinkedList<String>();
		outVarR = new LinkedList<String>();
		inoutVarR = new LinkedList<String>();
		locVarR = new LinkedList<String>();
		inVarC = new LinkedList<String>();
		outVarC = new LinkedList<String>();
		inoutVarC = new LinkedList<String>();
		locVarC = new LinkedList<String>();
		inVarP = new LinkedList<String>();
		outVarP = new LinkedList<String>();
		inoutVarP = new LinkedList<String>();
		locVarP = new LinkedList<String>();
	}
	
	public void addAll(VariablesBundle vb) {
		if(vb == null) return;
		if(vb.inVar != null) { inVar.addAll(vb.inVar); }
		if(vb.outVar != null) { outVar.addAll(vb.outVar); }
		if(vb.inoutVar != null) { inoutVar.addAll(vb.inoutVar); }
		if(vb.locVar != null) { locVar.addAll(vb.locVar); }
		if(vb.inVarR != null) { inVarR.addAll(vb.inVarR); }
		if(vb.outVarR != null) { outVarR.addAll(vb.outVarR); }
		if(vb.inoutVarR != null) { inoutVarR.addAll(vb.inoutVarR); }
		if(vb.locVarR != null) { locVarR.addAll(vb.locVarR); }
		if(vb.inVarC != null) { inVarC.addAll(vb.inVarC); }
		if(vb.outVarC != null) { outVarC.addAll(vb.outVarC); }
		if(vb.inoutVarC != null) { inoutVarC.addAll(vb.inoutVarC); }
		if(vb.locVarC != null) { locVarC.addAll(vb.locVarC); }
		if(vb.inVarP != null) { inVarP.addAll(vb.inVarP); }
		if(vb.outVarP != null) { outVarP.addAll(vb.outVarP); }
		if(vb.inoutVarP != null) { inoutVarP.addAll(vb.inoutVarP); }
		if(vb.locVarP != null) { locVarP.addAll(vb.locVarP); }
	}
}

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

sdt returns [ String txt ]
	: 'bool' { $txt = "BOOL"; }
	| 'byte' { $txt = "BYTE"; } 
	| 'word' { $txt = "WORD"; }
	| 'dword' { $txt = "DWORD"; }
	| 'lint' { $txt = "LINT"; }
	| 'ulint' { $txt = "ULINT"; }
	| 'lword' { $txt = "LWORD"; }
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

booleanL returns [ String txt ]
	: 'True' { $txt = "TRUE"; }
	| 'False' { $txt = "FALSE"; }
	;

program returns [ List<String> statements ]
@init	{ $statements = new LinkedList<String>(); }
@after	{
	$statements.add("(* ==== PROGRAM " + $pn.text + " ==== *)");
	$statements.add("PROGRAM " + $pn.text);
	if($cb.vbund.locVar.size() > 0) { $statements.add("VAR"); $statements.addAll($cb.vbund.locVar); $statements.add("END_VAR"); }
	if($cb.vbund.inVar.size() > 0) { $statements.add("VAR_INPUT");	$statements.addAll($cb.vbund.inVar); $statements.add("END_VAR"); }
	if($cb.vbund.outVar.size() > 0) { $statements.add("VAR_OUTPUT"); $statements.addAll($cb.vbund.outVar); $statements.add("END_VAR"); }
	if($cb.vbund.inoutVar.size() > 0) { $statements.add("VAR_IN_OUT"); $statements.addAll($cb.vbund.inoutVar); $statements.add("END_VAR"); }
	if($cb.vbund.locVarR.size() > 0) { $statements.add("VAR RETAIN"); $statements.addAll($cb.vbund.locVarR); $statements.add("END_VAR"); }
	if($cb.vbund.inVarR.size() > 0) { $statements.add("VAR_INPUT RETAIN");	$statements.addAll($cb.vbund.inVarR); $statements.add("END_VAR"); }
	if($cb.vbund.outVarR.size() > 0) { $statements.add("VAR_OUTPUT RETAIN"); $statements.addAll($cb.vbund.outVarR); $statements.add("END_VAR"); }
	if($cb.vbund.inoutVarR.size() > 0) { $statements.add("VAR_IN_OUT RETAIN"); $statements.addAll($cb.vbund.inoutVarR); $statements.add("END_VAR"); }
	if($cb.vbund.locVarC.size() > 0) { $statements.add("VAR CONSTANT"); $statements.addAll($cb.vbund.locVarC); $statements.add("END_VAR"); }
	if($cb.vbund.inVarC.size() > 0) { $statements.add("VAR_INPUT CONSTANT"); $statements.addAll($cb.vbund.inVarC); $statements.add("END_VAR"); }
	if($cb.vbund.outVarC.size() > 0) { $statements.add("VAR_OUTPUT CONSTANT"); $statements.addAll($cb.vbund.outVarC); $statements.add("END_VAR"); }
	if($cb.vbund.inoutVarC.size() > 0) { $statements.add("VAR_IN_OUT CONSTANT"); $statements.addAll($cb.vbund.inoutVarC); $statements.add("END_VAR"); }
	if($cb.vbund.locVarP.size() > 0) { $statements.add("VAR PERSISTENT"); $statements.addAll($cb.vbund.locVarP); $statements.add("END_VAR"); }
	if($cb.vbund.inVarP.size() > 0) { $statements.add("VAR_INPUT PERSISTENT"); $statements.addAll($cb.vbund.inVarP); $statements.add("END_VAR"); }
	if($cb.vbund.outVarP.size() > 0) { $statements.add("VAR_OUTPUT PERSISTENT"); $statements.addAll($cb.vbund.outVarP); $statements.add("END_VAR"); }
	if($cb.vbund.inoutVarP.size() > 0) { $statements.add("VAR_IN_OUT PERSISTENT"); $statements.addAll($cb.vbund.inoutVarP); $statements.add("END_VAR"); }
	$statements.addAll($cb.statements);
	}
	: 'prog' pn=ID ':' cb=codeBlock
	;

function returns [ List<String> statements ]
@init	{ $statements = new LinkedList<String>(); Boolean returnsV = false; }
@after	{
	if(returnsV){
		$statements.add("(* ==== FUNCTION " + $funcN.text + " ==== *)");
		$statements.add("FUNCTION " + $funcN.text + " : " + (rts == null?"":$rts.txt) + ($rtu == null?"":$rtu.text));
	} else {
		$statements.add("(* ==== FUNCTION_BLOCK " + $funcN.text + " ==== *)");
		$statements.add("FUNCTION_BLOCK " + $funcN.text);
	}
	if($cb.vbund.locVar.size() > 0) { $statements.add("VAR"); $statements.addAll($cb.vbund.locVar); $statements.add("END_VAR"); }
	if($cb.vbund.inVar.size() > 0) { $statements.add("VAR_INPUT");	$statements.addAll($cb.vbund.inVar); $statements.add("END_VAR"); }
	if($cb.vbund.outVar.size() > 0) { $statements.add("VAR_OUTPUT"); $statements.addAll($cb.vbund.outVar); $statements.add("END_VAR"); }
	if($cb.vbund.inoutVar.size() > 0) { $statements.add("VAR_IN_OUT"); $statements.addAll($cb.vbund.inoutVar); $statements.add("END_VAR"); }
	if($cb.vbund.locVarR.size() > 0) { $statements.add("VAR RETAIN"); $statements.addAll($cb.vbund.locVarR); $statements.add("END_VAR"); }
	if($cb.vbund.inVarR.size() > 0) { $statements.add("VAR_INPUT RETAIN");	$statements.addAll($cb.vbund.inVarR); $statements.add("END_VAR"); }
	if($cb.vbund.outVarR.size() > 0) { $statements.add("VAR_OUTPUT RETAIN"); $statements.addAll($cb.vbund.outVarR); $statements.add("END_VAR"); }
	if($cb.vbund.inoutVarR.size() > 0) { $statements.add("VAR_IN_OUT RETAIN"); $statements.addAll($cb.vbund.inoutVarR); $statements.add("END_VAR"); }
	if($cb.vbund.locVarC.size() > 0) { $statements.add("VAR CONSTANT"); $statements.addAll($cb.vbund.locVarC); $statements.add("END_VAR"); }
	if($cb.vbund.inVarC.size() > 0) { $statements.add("VAR_INPUT CONSTANT"); $statements.addAll($cb.vbund.inVarC); $statements.add("END_VAR"); }
	if($cb.vbund.outVarC.size() > 0) { $statements.add("VAR_OUTPUT CONSTANT"); $statements.addAll($cb.vbund.outVarC); $statements.add("END_VAR"); }
	if($cb.vbund.inoutVarC.size() > 0) { $statements.add("VAR_IN_OUT CONSTANT"); $statements.addAll($cb.vbund.inoutVarC); $statements.add("END_VAR"); }
	if($cb.vbund.locVarP.size() > 0) { $statements.add("VAR PERSISTENT"); $statements.addAll($cb.vbund.locVarP); $statements.add("END_VAR"); }
	if($cb.vbund.inVarP.size() > 0) { $statements.add("VAR_INPUT PERSISTENT"); $statements.addAll($cb.vbund.inVarP); $statements.add("END_VAR"); }
	if($cb.vbund.outVarP.size() > 0) { $statements.add("VAR_OUTPUT PERSISTENT"); $statements.addAll($cb.vbund.outVarP); $statements.add("END_VAR"); }
	if($cb.vbund.inoutVarP.size() > 0) { $statements.add("VAR_IN_OUT PERSISTENT"); $statements.addAll($cb.vbund.inoutVarP); $statements.add("END_VAR"); }
	$statements.addAll($cb.statements);
	}
	: 'func' funcN=ID ('returns' ( rts=sdt | rtu=ID ) { returnsV = true; })? ':' cb=codeBlock
	;

callFunc returns [ String txt ]
	: ID trail=trailer? '(' ( cfb=callFuncBlockArgs | cf=callFuncArgs )? ')'
	{ $txt = $ID.text + ($trail.txt == null?"":$trail.txt) + "(" + (cfb == null?"":$cfb.txt) + (cf == null?"":$cf.txt) + ")" + ";"; }
	;

// TODO: Check if passed arguments are of same type of declared and exists
callFuncBlockArgs returns [String txt]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString(); }
	: ( argN1=ID trail1=trailer? '=' argV1=test { sb.append($argN1.text + ($trail1.txt == null?"":$trail1.txt) + " := " + $argV1.txt); } ( ',' argNN=ID trailN=trailer? '=' argVN=test { sb.append(", " + $argNN.text + ($trailN.txt == null?"":$trailN.txt) + " := " + $argVN.txt); } )*)? 
	;
	
callFuncArgs returns [String txt]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString(); }
	: ( argV1=test { sb.append($argV1.txt); } ( ',' argVN=test { sb.append(", " + $argVN.txt); } )*)? 
	;

// TODO: Add alias to types
alias returns [ String txt ]
	: 'alias' ID '=' exprStm
	{ $txt = "TYPE " + $ID.text + ":" + $exprStm.txt + "; " + "END_TYPE"; }
	;

subrange returns [ String txt ]
	: 'subrange' '.' subrangeType ID '=' lb=literal ':' ub=literal
	{ $txt = "TYPE " + $ID.text + " : " + $subrangeType.txt + "( " + $lb.txt + ".." + $ub.txt + " ) END_TYPE;"; }
	;

// TODO: Add pointers to variables
// TODO: Function or Datatype must exist
pointer	returns [ List<String> statements ]
@init	{ $statements = new LinkedList<String>(); }
	: 'pointer' '.' ( pS=sdt | pU=ID) p1=ID { $statements.add($p1.text + " : POINTER TO " + (pS == null?"":$pS.txt) + ($pU == null?"":$pU.text) + ";"); }
	(',' pN=ID { $statements.add($pN.text + " : POINTER TO " + (pS == null?"":$pS.txt) + ($pU == null?"":$pU.text) + ";"); } )*
	;

// TODO: Add enumeration to types
// TODO: (maybe) Error checking will be not supported
enumeration returns [ String txt ]
	: 'enum' '.' en=ID '=' LCURLY enumerationElementList RCURLY
	{ $txt = "TYPE " + $en.text + ":(" + $enumerationElementList.txt + "); END_TYPE"; }
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

fragment subrangeType returns [ String txt ]
	: 'sint' { $txt = "SINT"; }
	| 'usint' { $txt = "USINT"; }
	| 'int' { $txt = "INT"; }
	| 'uint' { $txt = "UINT"; }
	| 'dint' { $txt = "DINT"; }
	| 'udint' { $txt = "UDINT"; }
	| 'byte' { $txt = "BYTE"; }
	| 'word' { $txt = "WORD"; }
	| 'dword' { $txt = "DWORD"; }
	| 'lint' { $txt = "LINT"; }
	| 'ulint' { $txt = "ULINT"; }
	| 'lword' { $txt = "LWORD"; }
	;

structure returns [ List<String> statements ]
@init	{ $statements = new LinkedList<String>(); }
	: 'structure' ID COLON NEWLINE INDENT se=structureElement DEDENT
	{
	$statements.add("TYPE " + $ID.text + " :");
	$statements.add("STRUCT");
   	$statements.addAll($se.statements);
	$statements.add("END_STRUCT");
	$statements.add("END_TYPE");
	}
	;
	
structureElement returns [ List<String> statements ]
@init	{ $statements = new LinkedList<String>(); }
	: ((sT=sdt | uT=ID) varList[ (sT == null?"":$sT.txt) + ($uT.text == null?"":$uT.text) + "" ] NEWLINE)+
	{
	$statements.addAll($varList.statements);
	}
	;

// OUT = 0; IN = 1; INOUT = 2; LOC= 3;
definition returns [ VariablesBundle vbund ]
@init	{ List<String> definitions; $vbund = new VariablesBundle(); }
@after	{
	definitions = $vlist.statements;
	int purpose = 3, modifier = 0;
	if(dp != null) { purpose = $dp.pID; }
	if(dm != null) { modifier = $dm.mID; }
	switch(purpose){
		case 0: // Output
			switch(modifier) {
				case 0: $vbund.outVar = definitions; break;
				case 1: $vbund.outVarR = definitions; break;
				case 2: $vbund.outVarP = definitions; break;
				case 3: $vbund.outVarC = definitions; break;
				default: break;
			}
			break;
		case 1: // Input
			switch(modifier) {
				case 0: $vbund.inVar = definitions; break;
				case 1: $vbund.inVarR = definitions; break;
				case 2: $vbund.inVarP = definitions; break;
				case 3: $vbund.inVarC = definitions; break;
				default: break;
			}
			break;
		case 2: // Input-Output
			switch(modifier) {
				case 0: $vbund.inoutVar = definitions; break;
				case 1: $vbund.inoutVarR = definitions; break;
				case 2: $vbund.inoutVarP = definitions; break;
				case 3: $vbund.inoutVarC = definitions; break;
				default: break;
			}
			break;
		case 3: // Local
			switch(modifier) {
				case 0: $vbund.locVar = definitions; break;
				case 1: $vbund.locVarR = definitions; break;
				case 2: $vbund.locVarP = definitions; break;
				case 3: $vbund.locVarC = definitions; break;
				default: break;
			}
			break;
		default: break;
	}
	}
	: dp=defPurpose? dm=defModifier? (sT=sdt | uT=ID) vlist=varList[ (sT == null?"":$sT.txt) + ($uT.text == null?"":$uT.text) + "" ]
	;

defPurpose returns [ int pID ]
	: ( 'in' { $pID = 1; } | 'out' { $pID = 0; } | 'inout' { $pID = 2; } ) DOT 
	;

defModifier returns [ int mID ]
	: ( 'persistent' { $mID = 2; } | 'retain' { $mID = 1; } | 'constant' { $mID = 3; } ) DOT 
	;
	
globaldefinition returns [ List<String> statements ]
@after	{ $statements = $vlist.statements; }
	: (( 'config' | 'global' ) DOT )? (( 'persistent' | 'retain' | 'constant') DOT )? (sT=sdt | uT=ID) vlist=varList[ (sT == null?"":$sT.txt) + ($uT.text == null?"":$uT.text) + "" ]
	;

varList [ String type ] returns [ List<String> statements ]
@init	{ $statements = new LinkedList<String>(); }
	: vle1=varListElem[ $type ] { if($vle1.txt != null) { $statements.add($vle1.txt); } } (',' vleN=varListElem[ $type ] { if($vleN.txt != null) { $statements.add($vleN.txt); } })*
	;

fragment varListElem [ String vType ] returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString() + ";"; }
	: ID { sb.append($ID.text); } (trailer { sb.append($trailer.txt); })?
	( { sb.append(" ARRAY"); } arrayModifier { sb.append($arrayModifier.txt); sb.append(" OF " + $vType); } ('=' ace=arrayConstantExpression { sb.append(" := " + $ace.txt); })?  
	| ( '[' strl=DECIMALL ']' )? ('=' t=test )? { sb.append(" : " + $vType + ($strl == null?"":"("+$strl.text+")") + (t == null?"":" := " + $t.txt)); })?
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
	: a1=atom { sb.append($a1.txt); } ( ',' aN=atom { sb.append(", " + $aN.txt); })*
	;

// "root" of TwinCAT grammar
file	returns [ List<String> statements ]
@init	{ $statements = new LinkedList<String>(); }
@after	{	
	for(String s : $statements){
		System.out.println(s);
	}
	}
	: (gs=globalStm { $statements.addAll($gs.statements); } )*
	(fs=function { $statements.addAll($fs.statements); } )* 
	ps=program { $statements.addAll($ps.statements); } EOF
	;

statement returns [ List<String> statements, VariablesBundle vbund ]
	: simpleStm { $statements = $simpleStm.statements; $vbund = $simpleStm.vbund; }
	| compoundStm { $statements = $compoundStm.statements; $vbund = $compoundStm.vbund; }
	;

globalStm returns [ List<String> statements ]
	: smallGlobalStm (SEMI)? NEWLINE { $statements = $smallGlobalStm.statements; }
	;

smallGlobalStm returns [ List<String> statements ]
@init	{ $statements = new LinkedList<String>(); }
	: alias { $statements.add($alias.txt); }
	| pointer { $statements.addAll($pointer.statements); }
	| enumeration { $statements.add($enumeration.txt); }
	| globaldefinition { $statements.addAll($globaldefinition.statements); }
	| structure //-> {$structure.st}
	;

simpleStm returns [ List<String> statements, VariablesBundle vbund ]
	: smallStm (SEMI)? NEWLINE { $statements = $smallStm.statements; $vbund = $smallStm.vbund; }
	;

// TODO: check if statements is null !
// TODO: pointer
smallStm returns [ List<String> statements, VariablesBundle vbund ]
@init	{ $statements = new LinkedList<String>(); }
	: exprStm { $statements.add($exprStm.txt); }
	| flowStm { $statements.add($flowStm.txt); }
	| repeatUntilStm { $statements.addAll($repeatUntilStm.statements); $vbund = $repeatUntilStm.vbund; }
	| pointer
	| d=definition { $vbund = $d.vbund; }
	;

exprStm returns [ String txt ]
	: t1=test augAssign t2=test { $txt = $t1.txt + " := " + $t1.txt + $augAssign.txt + $t2.txt + ";"; }
	| t3=test '=' t4=test { $txt = $t3.txt + " := " + $t4.txt + ";"; }
	;
	
augAssign returns [ String txt ]
	: '+=' { $txt = " + "; }
	| '-=' { $txt = " - "; }
	| '*=' { $txt = " * "; }
	| '/=' { $txt = " / "; }
	| '%=' { $txt = " MOD "; }
	| '&=' { $txt = " AND "; }
	| '|=' { $txt = " OR "; }
	;
	
flowStm returns [ String txt ]
	: 'return' { $txt = "RETURN" + ";"; }
	| 'exit' { $txt = "EXIT" + ";"; }
	| callFunc { $txt = $callFunc.txt; }
	;
	
compoundStm returns [ List<String> statements, VariablesBundle vbund ]
	: ifStm { $statements = $ifStm.statements; $vbund = $ifStm.vbund; }
	| caseStm { $statements = $caseStm.statements; $vbund = $caseStm.vbund; }
	| forStm { $statements = $forStm.statements; $vbund = $forStm.vbund; }
	| whileStm { $statements = $whileStm.statements; $vbund = $whileStm.vbund; }
	;

ifStm returns [ List<String> statements, VariablesBundle vbund ]
@init	{ $statements = new LinkedList<String>(); $vbund = new VariablesBundle(); }
	: 'if' test COLON cb=codeBlock { $statements.add("IF " + $test.txt + " THEN"); $statements.addAll($cb.statements); $vbund.addAll($cb.vbund); } (ec=elifClause { $statements.addAll($ec.statements); $vbund.addAll($cb.vbund); } )*
	('else' COLON cbE=codeBlock { $statements.add("ELSE"); $statements.addAll($cbE.statements); $vbund.addAll($cbE.vbund); $statements.add("END_IF;"); } )?
	;

elifClause returns [ List<String> statements, VariablesBundle vbund ]
@init	{ $statements = new LinkedList<String>(); }
	: 'elif' test COLON cb=codeBlock { $statements.add("ELSIF " + $test.txt + " THEN"); $statements.addAll($cb.statements); $vbund = $cb.vbund; }
	;

caseStm returns [ List<String> statements, VariablesBundle vbund ]
@init	{ $statements = new LinkedList<String>(); }
	: 'case' test COLON NEWLINE INDENT caseElementsStm DEDENT
	{
	$statements.add("CASE " + $test.txt + " OF");
	$statements.addAll($caseElementsStm.statements); $vbund = $caseElementsStm.vbund;
	$statements.add("END_CASE;");
	}
	;
  
caseElementsStm returns [ List<String> statements, VariablesBundle vbund ]
@init	{ $statements = new LinkedList<String>(); $vbund = new VariablesBundle(); }
	: ( test COLON cbN=codeBlock { $statements.add($test.txt + ":"); $statements.addAll($cbN.statements); $vbund.addAll($cbN.vbund); } )+
	'default' COLON cbd=codeBlock { $statements.add("ELSE"); $statements.addAll($cbd.statements); $vbund.addAll($cbd.vbund); }
	;

forStm returns [ List<String> statements, VariablesBundle vbund ]
@init	{ $statements = new LinkedList<String>(); }
	: 'for' ID (t=trailer)? (ame=arrayModifierEl)?'in' LCURLY start=test ':' step=test ':' stop=test RCURLY COLON codeBlock
	{
	$statements.add("FOR " + $ID.text + (t == null?"":$t.txt) + (ame == null?"":$ame.txt) + " := " + $start.txt + " TO " + $stop.txt + " BY " + $step.txt + " DO");  
	$statements.addAll($codeBlock.statements); $vbund = $codeBlock.vbund; 
	$statements.add("END_FOR;");
	}
	;
  
whileStm returns [ List<String> statements, VariablesBundle vbund ]
@init	{ $statements = new LinkedList<String>(); }
	: 'while' test COLON codeBlock
	{
	$statements.add("WHILE " + $test.txt + " DO");
	$statements.addAll($codeBlock.statements); $vbund = $codeBlock.vbund; 
	$statements.add("END_WHILE;");
	}
	;

repeatUntilStm returns [ List<String> statements, VariablesBundle vbund ]
@init	{ $statements = new LinkedList<String>(); }
	: 'repeat' COLON codeBlock 'until' test
	{
	$statements.add("REPEAT");
	$statements.addAll($codeBlock.statements); $vbund = $codeBlock.vbund; 
	$statements.add("UNTIL " + $test.txt);
	$statements.add("END_REPEAT;");
	}
	;

codeBlock returns [ List<String> statements, VariablesBundle vbund  ]
@init	{ $statements = new LinkedList<String>(); $vbund = new VariablesBundle(); }
	: stm=simpleStm { if($stm.statements != null) {	$statements.addAll($stm.statements); $vbund.addAll($stm.vbund); }  }
	| NEWLINE INDENT ( stms=statement { if($stms.statements != null) { $statements.addAll($stms.statements); $vbund.addAll($stms.vbund); } })+ DEDENT 
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
	| '!=' { $txt = new String("<>"); }
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
	: ('+' { sb.append("+"); } |'-' { sb.append("-"); })? power { sb.append($power.txt); }
	;
	

power returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ 
	if(fac == null){
		sb.append($atp.txt);
	} else {
		sb.append("EXPT(" + $atp.txt + ", " + $fac.txt + ")");
	}
	$txt = sb.toString();
	}
	: atp=atom ('**' fac=factor)?
	;
	
atom returns [ String txt ]
@init	{ StringBuilder sb = new StringBuilder(); }
@after	{ $txt = sb.toString();	}
	: ID { sb.append($ID.text); } (trailer { sb.append($trailer.txt); })? (arrayModifierEl { sb.append($arrayModifierEl.txt); })?
	| literal { sb.append($literal.txt); }
	| '(' test ')' { sb.append("( " + $test.txt + " )"); }
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
	: ('.' ID { sb.append("." + $ID.text); })+
	;

literal returns [ String txt ]
  : DECIMALL { $txt = $DECIMALL.text; }
  | HEXDIGITS { $txt = "16#" + $HEXDIGITS.text.substring(2); }
  | FLOATINGPOINTL { $txt = $FLOATINGPOINTL.text; }
  | BINDIGITS { $txt = "2#" + $BINDIGITS.text.substring(2); }
  | OCTDIGITS { $txt = "8#" + $OCTDIGITS.text.substring(2); }
  | timeL { $txt = $timeL.txt; }
  | todL { $txt = $todL.txt; }
  | dateL { $txt = $dateL.txt; }
  | datetimeL { $txt = $datetimeL.txt; }
  | booleanL { $txt = $booleanL.txt; }
  | CHARACTERL { $txt = $CHARACTERL.text; }
  | stringL { $txt = $stringL.txt; }
  ;

FLOATINGPOINTL
	: ('0'..'9')* '.' ('0'..'9')+ EXPONENT?
	| ('0'..'9')+ EXPONENT
	;

HEXDIGITS : 'h!' ('0'..'9'|'a'..'f'|'A'..'F')+ ;

DECIMALL : ('0' | '1'..'9' '0'..'9'*) ;

OCTDIGITS : 'o!' ('0'..'7')+ ;

BINDIGITS : 'b!' ('0'..'1')+ ;

fragment EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ; 

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