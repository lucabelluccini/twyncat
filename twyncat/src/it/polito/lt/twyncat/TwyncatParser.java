package it.polito.lt.twyncat;
// $ANTLR 3.2 Sep 23, 2009 12:02:23 H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g 2010-09-02 21:03:30

import java.util.ListIterator;
import java.util.LinkedList;
import it.polito.lt.twyncat.*;
import it.polito.lt.twyncat.exceptions.FieldExistsException;
import it.polito.lt.twyncat.exceptions.SymbolExistsException;
import it.polito.lt.twyncat.exceptions.TypeUnknownException;
import it.polito.lt.twyncat.exceptions.VariableNotAccessible;
import it.polito.lt.twyncat.exceptions.VariableNotDeclaredException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class TwyncatParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "INDENT", "DEDENT", "ID", "LCURLY", "RCURLY", "DECIMALL", "COLON", "NEWLINE", "DOT", "LBRACK", "RBRACK", "SEMI", "HEXDIGITS", "FLOATINGPOINTL", "BINDIGITS", "OCTDIGITS", "CHARACTERL", "EXPONENT", "OctalEscape", "EscapeSequence", "TODLDIGITS", "DATEDIGITS", "DATETIMEDIGITS", "FF", "TAB", "CR", "LPAREN", "RPAREN", "PLUS", "MINUS", "STAR", "SLASH", "VBAR", "AMPER", "LESS", "GREATER", "ASSIGN", "PERCENT", "BACKQUOTE", "CIRCUMFLEX", "TILDE", "EQUAL", "NOTEQUAL", "ALT_NOTEQUAL", "LESSEQUAL", "GREATEREQUAL", "PLUSEQUAL", "MINUSEQUAL", "DOUBLESTAR", "STAREQUAL", "DOUBLESLASH", "SLASHEQUAL", "OREQUAL", "PERCENTEQUAL", "ANDEQUAL", "CIRCUMFLEXEQUAL", "LEFTSHIFTEQUAL", "LEFTSHIFT", "RIGHTSHIFTEQUAL", "RIGHTSHIFT", "COMMA", "AT", "WS", "LEADINGWS", "'bool'", "'byte'", "'word'", "'dword'", "'lint'", "'ulint'", "'lword'", "'sint'", "'usint'", "'int'", "'uint'", "'dint'", "'udint'", "'real'", "'lreal'", "'string'", "'time'", "'tod'", "'date'", "'dt'", "'True'", "'False'", "'prog'", "'func'", "'returns'", "'alias'", "'subrange'", "'pointer'", "'enum'", "'structure'", "'in'", "'out'", "'inout'", "'persistent'", "'retain'", "'constant'", "'return'", "'exit'", "'if'", "'else'", "'elif'", "'case'", "'default'", "'for'", "'while'", "'repeat'", "'until'", "'or'", "'and'", "'not'", "'t!'", "'d'", "'h'", "'m'", "'s'", "'ms'", "'tod!'", "'d!'", "'dt!'", "'\"'", "'\\\\'"
    };
    public static final int SLASHEQUAL=55;
    public static final int BACKQUOTE=42;
    public static final int EXPONENT=21;
    public static final int STAR=34;
    public static final int CIRCUMFLEXEQUAL=59;
    public static final int GREATEREQUAL=49;
    public static final int EOF=-1;
    public static final int NOTEQUAL=46;
    public static final int T__93=93;
    public static final int MINUSEQUAL=51;
    public static final int VBAR=36;
    public static final int T__94=94;
    public static final int DATEDIGITS=25;
    public static final int RPAREN=31;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int GREATER=39;
    public static final int T__90=90;
    public static final int LESS=38;
    public static final int OREQUAL=56;
    public static final int T__99=99;
    public static final int ANDEQUAL=58;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int RBRACK=14;
    public static final int FLOATINGPOINTL=17;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LCURLY=7;
    public static final int RIGHTSHIFT=63;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int FF=27;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=66;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int BINDIGITS=18;
    public static final int DATETIMEDIGITS=26;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int HEXDIGITS=16;
    public static final int PERCENTEQUAL=57;
    public static final int LESSEQUAL=48;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int EscapeSequence=23;
    public static final int T__79=79;
    public static final int DECIMALL=9;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int DOUBLESLASH=54;
    public static final int T__69=69;
    public static final int LBRACK=13;
    public static final int DOUBLESTAR=52;
    public static final int TODLDIGITS=24;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int DEDENT=5;
    public static final int RIGHTSHIFTEQUAL=62;
    public static final int ID=6;
    public static final int OCTDIGITS=19;
    public static final int INDENT=4;
    public static final int LPAREN=30;
    public static final int PLUSEQUAL=50;
    public static final int AT=65;
    public static final int SLASH=35;
    public static final int T__107=107;
    public static final int CHARACTERL=20;
    public static final int COMMA=64;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int AMPER=37;
    public static final int T__103=103;
    public static final int EQUAL=45;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int TILDE=44;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int LEFTSHIFTEQUAL=60;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int LEFTSHIFT=61;
    public static final int PLUS=32;
    public static final int T__112=112;
    public static final int DOT=12;
    public static final int LEADINGWS=67;
    public static final int PERCENT=41;
    public static final int TAB=28;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int MINUS=33;
    public static final int SEMI=15;
    public static final int COLON=10;
    public static final int NEWLINE=11;
    public static final int RCURLY=8;
    public static final int ASSIGN=40;
    public static final int CR=29;
    public static final int OctalEscape=22;
    public static final int STAREQUAL=53;
    public static final int CIRCUMFLEX=43;
    public static final int ALT_NOTEQUAL=47;

    // delegates
    // delegators


        public TwyncatParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TwyncatParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return TwyncatParser.tokenNames; }
    public String getGrammarFileName() { return "H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g"; }

    Twyncat t = Twyncat.getInstance();

    String currentBlock = null;
    boolean inStructure = false;

    public String checkFunction(String functionName, String... args) {
    	System.err.println("Checking function '" + functionName + "' passing " + args.length + " parameters.");
    	return "FOO";
    }

    public boolean checkType(String t1, String t2) {
    	if(t1 == null || t2 == null)
    		return false;
    	if(!t1.equalsIgnoreCase(t2)){
    		System.err.println("Types " + t1 + " vs " + t2);
    	}
    	return t1.equalsIgnoreCase(t2);
    }

    public String getType(String symbol) {
    	String type = null;
    	try {
			type = t.checkVariable(symbol);
		} catch (VariableNotDeclaredException e) {
			System.err.println(e.getMessage());
		} catch (VariableNotAccessible e) {
			System.err.println(e.getMessage());
		}
    	return type;
    }

    public void declare(String var, String type) {
    	try {
			t.declare(var, type);
		} catch (SymbolExistsException e) {
			System.err.println(e.getMessage());
		} catch (TypeUnknownException e) {
			System.err.println(e.getMessage());
		}
    }

    public void declareLocal(String scope, String var, String type) {
    	try {
			t.declareLocal(scope, var, type);
		} catch (SymbolExistsException e) {
			System.err.println(e.getMessage());
		} catch (TypeUnknownException e) {
			System.err.println(e.getMessage());
		}
    }
/*
    public class Structure {
    	String name;
    	
    	public Structure(String st) {
    		
    	}
    	
    	public void addField(String n, String t) {
    		System.err.println("Structure '" + name + "', field: '" + n + "' of type '" + t + "'");
    	}
    }
*/

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



    public static class sdt_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sdt"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:188:1: sdt returns [ String txt ] : ( 'bool' | 'byte' | 'word' | 'dword' | 'lint' | 'ulint' | 'lword' | 'sint' | 'usint' | 'int' | 'uint' | 'dint' | 'udint' | 'real' | 'lreal' | 'string' | 'time' | 'tod' | 'date' | 'dt' );
    public final TwyncatParser.sdt_return sdt() throws RecognitionException {
        TwyncatParser.sdt_return retval = new TwyncatParser.sdt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal1=null;
        Token string_literal2=null;
        Token string_literal3=null;
        Token string_literal4=null;
        Token string_literal5=null;
        Token string_literal6=null;
        Token string_literal7=null;
        Token string_literal8=null;
        Token string_literal9=null;
        Token string_literal10=null;
        Token string_literal11=null;
        Token string_literal12=null;
        Token string_literal13=null;
        Token string_literal14=null;
        Token string_literal15=null;
        Token string_literal16=null;
        Token string_literal17=null;
        Token string_literal18=null;
        Token string_literal19=null;
        Token string_literal20=null;

        Object string_literal1_tree=null;
        Object string_literal2_tree=null;
        Object string_literal3_tree=null;
        Object string_literal4_tree=null;
        Object string_literal5_tree=null;
        Object string_literal6_tree=null;
        Object string_literal7_tree=null;
        Object string_literal8_tree=null;
        Object string_literal9_tree=null;
        Object string_literal10_tree=null;
        Object string_literal11_tree=null;
        Object string_literal12_tree=null;
        Object string_literal13_tree=null;
        Object string_literal14_tree=null;
        Object string_literal15_tree=null;
        Object string_literal16_tree=null;
        Object string_literal17_tree=null;
        Object string_literal18_tree=null;
        Object string_literal19_tree=null;
        Object string_literal20_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:189:2: ( 'bool' | 'byte' | 'word' | 'dword' | 'lint' | 'ulint' | 'lword' | 'sint' | 'usint' | 'int' | 'uint' | 'dint' | 'udint' | 'real' | 'lreal' | 'string' | 'time' | 'tod' | 'date' | 'dt' )
            int alt1=20;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt1=1;
                }
                break;
            case 69:
                {
                alt1=2;
                }
                break;
            case 70:
                {
                alt1=3;
                }
                break;
            case 71:
                {
                alt1=4;
                }
                break;
            case 72:
                {
                alt1=5;
                }
                break;
            case 73:
                {
                alt1=6;
                }
                break;
            case 74:
                {
                alt1=7;
                }
                break;
            case 75:
                {
                alt1=8;
                }
                break;
            case 76:
                {
                alt1=9;
                }
                break;
            case 77:
                {
                alt1=10;
                }
                break;
            case 78:
                {
                alt1=11;
                }
                break;
            case 79:
                {
                alt1=12;
                }
                break;
            case 80:
                {
                alt1=13;
                }
                break;
            case 81:
                {
                alt1=14;
                }
                break;
            case 82:
                {
                alt1=15;
                }
                break;
            case 83:
                {
                alt1=16;
                }
                break;
            case 84:
                {
                alt1=17;
                }
                break;
            case 85:
                {
                alt1=18;
                }
                break;
            case 86:
                {
                alt1=19;
                }
                break;
            case 87:
                {
                alt1=20;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:189:4: 'bool'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal1=(Token)match(input,68,FOLLOW_68_in_sdt98); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal1_tree = (Object)adaptor.create(string_literal1);
                    adaptor.addChild(root_0, string_literal1_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "BOOL"; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:190:4: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal2=(Token)match(input,69,FOLLOW_69_in_sdt105); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal2_tree = (Object)adaptor.create(string_literal2);
                    adaptor.addChild(root_0, string_literal2_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "BYTE"; 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:191:4: 'word'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal3=(Token)match(input,70,FOLLOW_70_in_sdt113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal3_tree = (Object)adaptor.create(string_literal3);
                    adaptor.addChild(root_0, string_literal3_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "WORD"; 
                    }

                    }
                    break;
                case 4 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:192:4: 'dword'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal4=(Token)match(input,71,FOLLOW_71_in_sdt120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal4_tree = (Object)adaptor.create(string_literal4);
                    adaptor.addChild(root_0, string_literal4_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "DWORD"; 
                    }

                    }
                    break;
                case 5 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:193:4: 'lint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal5=(Token)match(input,72,FOLLOW_72_in_sdt127); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal5_tree = (Object)adaptor.create(string_literal5);
                    adaptor.addChild(root_0, string_literal5_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "LINT"; 
                    }

                    }
                    break;
                case 6 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:194:4: 'ulint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal6=(Token)match(input,73,FOLLOW_73_in_sdt134); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal6_tree = (Object)adaptor.create(string_literal6);
                    adaptor.addChild(root_0, string_literal6_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "ULINT"; 
                    }

                    }
                    break;
                case 7 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:195:4: 'lword'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal7=(Token)match(input,74,FOLLOW_74_in_sdt141); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal7_tree = (Object)adaptor.create(string_literal7);
                    adaptor.addChild(root_0, string_literal7_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "LWORD"; 
                    }

                    }
                    break;
                case 8 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:196:4: 'sint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal8=(Token)match(input,75,FOLLOW_75_in_sdt148); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal8_tree = (Object)adaptor.create(string_literal8);
                    adaptor.addChild(root_0, string_literal8_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "SINT"; 
                    }

                    }
                    break;
                case 9 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:197:4: 'usint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal9=(Token)match(input,76,FOLLOW_76_in_sdt156); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal9_tree = (Object)adaptor.create(string_literal9);
                    adaptor.addChild(root_0, string_literal9_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "USINT"; 
                    }

                    }
                    break;
                case 10 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:198:4: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal10=(Token)match(input,77,FOLLOW_77_in_sdt163); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal10_tree = (Object)adaptor.create(string_literal10);
                    adaptor.addChild(root_0, string_literal10_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "INT"; 
                    }

                    }
                    break;
                case 11 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:199:4: 'uint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal11=(Token)match(input,78,FOLLOW_78_in_sdt171); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal11_tree = (Object)adaptor.create(string_literal11);
                    adaptor.addChild(root_0, string_literal11_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "UINT"; 
                    }

                    }
                    break;
                case 12 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:200:4: 'dint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal12=(Token)match(input,79,FOLLOW_79_in_sdt178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal12_tree = (Object)adaptor.create(string_literal12);
                    adaptor.addChild(root_0, string_literal12_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "DINT"; 
                    }

                    }
                    break;
                case 13 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:201:4: 'udint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal13=(Token)match(input,80,FOLLOW_80_in_sdt185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal13_tree = (Object)adaptor.create(string_literal13);
                    adaptor.addChild(root_0, string_literal13_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "UDINT"; 
                    }

                    }
                    break;
                case 14 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:202:4: 'real'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal14=(Token)match(input,81,FOLLOW_81_in_sdt192); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal14_tree = (Object)adaptor.create(string_literal14);
                    adaptor.addChild(root_0, string_literal14_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "REAL"; 
                    }

                    }
                    break;
                case 15 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:203:4: 'lreal'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal15=(Token)match(input,82,FOLLOW_82_in_sdt199); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal15_tree = (Object)adaptor.create(string_literal15);
                    adaptor.addChild(root_0, string_literal15_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "LREAL"; 
                    }

                    }
                    break;
                case 16 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:204:4: 'string'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal16=(Token)match(input,83,FOLLOW_83_in_sdt206); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal16_tree = (Object)adaptor.create(string_literal16);
                    adaptor.addChild(root_0, string_literal16_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "STRING"; 
                    }

                    }
                    break;
                case 17 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:205:4: 'time'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal17=(Token)match(input,84,FOLLOW_84_in_sdt213); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal17_tree = (Object)adaptor.create(string_literal17);
                    adaptor.addChild(root_0, string_literal17_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "TIME"; 
                    }

                    }
                    break;
                case 18 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:206:4: 'tod'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal18=(Token)match(input,85,FOLLOW_85_in_sdt220); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal18_tree = (Object)adaptor.create(string_literal18);
                    adaptor.addChild(root_0, string_literal18_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "TIME_OF_DAY"; 
                    }

                    }
                    break;
                case 19 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:207:4: 'date'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal19=(Token)match(input,86,FOLLOW_86_in_sdt227); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal19_tree = (Object)adaptor.create(string_literal19);
                    adaptor.addChild(root_0, string_literal19_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "DATE"; 
                    }

                    }
                    break;
                case 20 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:208:4: 'dt'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal20=(Token)match(input,87,FOLLOW_87_in_sdt234); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal20_tree = (Object)adaptor.create(string_literal20);
                    adaptor.addChild(root_0, string_literal20_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "DATE_AND_TIME"; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "sdt"

    public static class booleanL_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "booleanL"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:211:1: booleanL returns [ String txt ] : ( 'True' | 'False' );
    public final TwyncatParser.booleanL_return booleanL() throws RecognitionException {
        TwyncatParser.booleanL_return retval = new TwyncatParser.booleanL_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal21=null;
        Token string_literal22=null;

        Object string_literal21_tree=null;
        Object string_literal22_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:212:2: ( 'True' | 'False' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==88) ) {
                alt2=1;
            }
            else if ( (LA2_0==89) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:212:4: 'True'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal21=(Token)match(input,88,FOLLOW_88_in_booleanL251); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal21_tree = (Object)adaptor.create(string_literal21);
                    adaptor.addChild(root_0, string_literal21_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "TRUE"; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:213:4: 'False'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal22=(Token)match(input,89,FOLLOW_89_in_booleanL258); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal22_tree = (Object)adaptor.create(string_literal22);
                    adaptor.addChild(root_0, string_literal22_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "FALSE"; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "booleanL"

    public static class program_return extends ParserRuleReturnScope {
        public List<String> statements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:216:1: program returns [ List<String> statements ] : 'prog' pn= ID ':' cb= codeBlock ;
    public final TwyncatParser.program_return program() throws RecognitionException {
        TwyncatParser.program_return retval = new TwyncatParser.program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pn=null;
        Token string_literal23=null;
        Token char_literal24=null;
        TwyncatParser.codeBlock_return cb = null;


        Object pn_tree=null;
        Object string_literal23_tree=null;
        Object char_literal24_tree=null;

         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:239:2: ( 'prog' pn= ID ':' cb= codeBlock )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:239:4: 'prog' pn= ID ':' cb= codeBlock
            {
            root_0 = (Object)adaptor.nil();

            string_literal23=(Token)match(input,90,FOLLOW_90_in_program285); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal23_tree = (Object)adaptor.create(string_literal23);
            adaptor.addChild(root_0, string_literal23_tree);
            }
            pn=(Token)match(input,ID,FOLLOW_ID_in_program289); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            pn_tree = (Object)adaptor.create(pn);
            adaptor.addChild(root_0, pn_tree);
            }
            if ( state.backtracking==0 ) {
               currentBlock = (pn!=null?pn.getText():null); 
            }
            char_literal24=(Token)match(input,COLON,FOLLOW_COLON_in_program293); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal24_tree = (Object)adaptor.create(char_literal24);
            adaptor.addChild(root_0, char_literal24_tree);
            }
            pushFollow(FOLLOW_codeBlock_in_program297);
            cb=codeBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, cb.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

              	retval.statements.add("(* ==== PROGRAM " + (pn!=null?pn.getText():null) + " ==== *)");
              	retval.statements.add("PROGRAM " + (pn!=null?pn.getText():null));
              	if((cb!=null?cb.vbund:null).locVar.size() > 0) { retval.statements.add("VAR"); retval.statements.addAll((cb!=null?cb.vbund:null).locVar); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inVar.size() > 0) { retval.statements.add("VAR_INPUT");	retval.statements.addAll((cb!=null?cb.vbund:null).inVar); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).outVar.size() > 0) { retval.statements.add("VAR_OUTPUT"); retval.statements.addAll((cb!=null?cb.vbund:null).outVar); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inoutVar.size() > 0) { retval.statements.add("VAR_IN_OUT"); retval.statements.addAll((cb!=null?cb.vbund:null).inoutVar); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).locVarR.size() > 0) { retval.statements.add("VAR RETAIN"); retval.statements.addAll((cb!=null?cb.vbund:null).locVarR); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inVarR.size() > 0) { retval.statements.add("VAR_INPUT RETAIN");	retval.statements.addAll((cb!=null?cb.vbund:null).inVarR); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).outVarR.size() > 0) { retval.statements.add("VAR_OUTPUT RETAIN"); retval.statements.addAll((cb!=null?cb.vbund:null).outVarR); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inoutVarR.size() > 0) { retval.statements.add("VAR_IN_OUT RETAIN"); retval.statements.addAll((cb!=null?cb.vbund:null).inoutVarR); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).locVarC.size() > 0) { retval.statements.add("VAR CONSTANT"); retval.statements.addAll((cb!=null?cb.vbund:null).locVarC); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inVarC.size() > 0) { retval.statements.add("VAR_INPUT CONSTANT"); retval.statements.addAll((cb!=null?cb.vbund:null).inVarC); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).outVarC.size() > 0) { retval.statements.add("VAR_OUTPUT CONSTANT"); retval.statements.addAll((cb!=null?cb.vbund:null).outVarC); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inoutVarC.size() > 0) { retval.statements.add("VAR_IN_OUT CONSTANT"); retval.statements.addAll((cb!=null?cb.vbund:null).inoutVarC); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).locVarP.size() > 0) { retval.statements.add("VAR PERSISTENT"); retval.statements.addAll((cb!=null?cb.vbund:null).locVarP); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inVarP.size() > 0) { retval.statements.add("VAR_INPUT PERSISTENT"); retval.statements.addAll((cb!=null?cb.vbund:null).inVarP); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).outVarP.size() > 0) { retval.statements.add("VAR_OUTPUT PERSISTENT"); retval.statements.addAll((cb!=null?cb.vbund:null).outVarP); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inoutVarP.size() > 0) { retval.statements.add("VAR_IN_OUT PERSISTENT"); retval.statements.addAll((cb!=null?cb.vbund:null).inoutVarP); retval.statements.add("END_VAR"); }
              	retval.statements.addAll((cb!=null?cb.statements:null));
              	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class function_return extends ParserRuleReturnScope {
        public List<String> statements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:244:1: function returns [ List<String> statements ] : 'func' funcN= ID ( 'returns' (rts= sdt | rtu= ID ) )? ':' cb= codeBlock ;
    public final TwyncatParser.function_return function() throws RecognitionException {
        TwyncatParser.function_return retval = new TwyncatParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token funcN=null;
        Token rtu=null;
        Token string_literal25=null;
        Token string_literal26=null;
        Token char_literal27=null;
        TwyncatParser.sdt_return rts = null;

        TwyncatParser.codeBlock_return cb = null;


        Object funcN_tree=null;
        Object rtu_tree=null;
        Object string_literal25_tree=null;
        Object string_literal26_tree=null;
        Object char_literal27_tree=null;

         retval.statements = new LinkedList<String>(); Boolean returnsV = false; 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:272:2: ( 'func' funcN= ID ( 'returns' (rts= sdt | rtu= ID ) )? ':' cb= codeBlock )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:272:4: 'func' funcN= ID ( 'returns' (rts= sdt | rtu= ID ) )? ':' cb= codeBlock
            {
            root_0 = (Object)adaptor.nil();

            string_literal25=(Token)match(input,91,FOLLOW_91_in_function325); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal25_tree = (Object)adaptor.create(string_literal25);
            adaptor.addChild(root_0, string_literal25_tree);
            }
            funcN=(Token)match(input,ID,FOLLOW_ID_in_function329); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            funcN_tree = (Object)adaptor.create(funcN);
            adaptor.addChild(root_0, funcN_tree);
            }
            if ( state.backtracking==0 ) {
               currentBlock = (funcN!=null?funcN.getText():null); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:272:52: ( 'returns' (rts= sdt | rtu= ID ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==92) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:272:53: 'returns' (rts= sdt | rtu= ID )
                    {
                    string_literal26=(Token)match(input,92,FOLLOW_92_in_function334); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal26_tree = (Object)adaptor.create(string_literal26);
                    adaptor.addChild(root_0, string_literal26_tree);
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:272:63: (rts= sdt | rtu= ID )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=68 && LA3_0<=87)) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==ID) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:272:65: rts= sdt
                            {
                            pushFollow(FOLLOW_sdt_in_function340);
                            rts=sdt();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, rts.getTree());

                            }
                            break;
                        case 2 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:272:75: rtu= ID
                            {
                            rtu=(Token)match(input,ID,FOLLOW_ID_in_function346); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            rtu_tree = (Object)adaptor.create(rtu);
                            adaptor.addChild(root_0, rtu_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       returnsV = true; 
                    }

                    }
                    break;

            }

            char_literal27=(Token)match(input,COLON,FOLLOW_COLON_in_function354); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal27_tree = (Object)adaptor.create(char_literal27);
            adaptor.addChild(root_0, char_literal27_tree);
            }
            pushFollow(FOLLOW_codeBlock_in_function358);
            cb=codeBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, cb.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

              	if(returnsV){
              		retval.statements.add("(* ==== FUNCTION " + (funcN!=null?funcN.getText():null) + " ==== *)");
              		retval.statements.add("FUNCTION " + (funcN!=null?funcN.getText():null) + " : " + (rts == null?"":(rts!=null?rts.txt:null)) + (rtu == null?"":(rtu!=null?rtu.getText():null)));
              	} else {
              		retval.statements.add("(* ==== FUNCTION_BLOCK " + (funcN!=null?funcN.getText():null) + " ==== *)");
              		retval.statements.add("FUNCTION_BLOCK " + (funcN!=null?funcN.getText():null));
              	}
              	if((cb!=null?cb.vbund:null).locVar.size() > 0) { retval.statements.add("VAR"); retval.statements.addAll((cb!=null?cb.vbund:null).locVar); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inVar.size() > 0) { retval.statements.add("VAR_INPUT");	retval.statements.addAll((cb!=null?cb.vbund:null).inVar); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).outVar.size() > 0) { retval.statements.add("VAR_OUTPUT"); retval.statements.addAll((cb!=null?cb.vbund:null).outVar); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inoutVar.size() > 0) { retval.statements.add("VAR_IN_OUT"); retval.statements.addAll((cb!=null?cb.vbund:null).inoutVar); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).locVarR.size() > 0) { retval.statements.add("VAR RETAIN"); retval.statements.addAll((cb!=null?cb.vbund:null).locVarR); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inVarR.size() > 0) { retval.statements.add("VAR_INPUT RETAIN");	retval.statements.addAll((cb!=null?cb.vbund:null).inVarR); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).outVarR.size() > 0) { retval.statements.add("VAR_OUTPUT RETAIN"); retval.statements.addAll((cb!=null?cb.vbund:null).outVarR); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inoutVarR.size() > 0) { retval.statements.add("VAR_IN_OUT RETAIN"); retval.statements.addAll((cb!=null?cb.vbund:null).inoutVarR); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).locVarC.size() > 0) { retval.statements.add("VAR CONSTANT"); retval.statements.addAll((cb!=null?cb.vbund:null).locVarC); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inVarC.size() > 0) { retval.statements.add("VAR_INPUT CONSTANT"); retval.statements.addAll((cb!=null?cb.vbund:null).inVarC); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).outVarC.size() > 0) { retval.statements.add("VAR_OUTPUT CONSTANT"); retval.statements.addAll((cb!=null?cb.vbund:null).outVarC); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inoutVarC.size() > 0) { retval.statements.add("VAR_IN_OUT CONSTANT"); retval.statements.addAll((cb!=null?cb.vbund:null).inoutVarC); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).locVarP.size() > 0) { retval.statements.add("VAR PERSISTENT"); retval.statements.addAll((cb!=null?cb.vbund:null).locVarP); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inVarP.size() > 0) { retval.statements.add("VAR_INPUT PERSISTENT"); retval.statements.addAll((cb!=null?cb.vbund:null).inVarP); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).outVarP.size() > 0) { retval.statements.add("VAR_OUTPUT PERSISTENT"); retval.statements.addAll((cb!=null?cb.vbund:null).outVarP); retval.statements.add("END_VAR"); }
              	if((cb!=null?cb.vbund:null).inoutVarP.size() > 0) { retval.statements.add("VAR_IN_OUT PERSISTENT"); retval.statements.addAll((cb!=null?cb.vbund:null).inoutVarP); retval.statements.add("END_VAR"); }
              	retval.statements.addAll((cb!=null?cb.statements:null));
              	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class callFunc_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "callFunc"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:275:1: callFunc returns [ String txt, String dType ] : ID ( trailer )? '(' (cfa= callFuncArgs )? ')' ;
    public final TwyncatParser.callFunc_return callFunc() throws RecognitionException {
        TwyncatParser.callFunc_return retval = new TwyncatParser.callFunc_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID28=null;
        Token char_literal30=null;
        Token char_literal31=null;
        TwyncatParser.callFuncArgs_return cfa = null;

        TwyncatParser.trailer_return trailer29 = null;


        Object ID28_tree=null;
        Object char_literal30_tree=null;
        Object char_literal31_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:277:2: ( ID ( trailer )? '(' (cfa= callFuncArgs )? ')' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:277:4: ID ( trailer )? '(' (cfa= callFuncArgs )? ')'
            {
            root_0 = (Object)adaptor.nil();

            ID28=(Token)match(input,ID,FOLLOW_ID_in_callFunc378); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID28_tree = (Object)adaptor.create(ID28);
            adaptor.addChild(root_0, ID28_tree);
            }
            if ( state.backtracking==0 ) {
               sb.append((ID28!=null?ID28.getText():null)); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:277:32: ( trailer )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==DOT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:277:33: trailer
                    {
                    pushFollow(FOLLOW_trailer_in_callFunc383);
                    trailer29=trailer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, trailer29.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append((trailer29!=null?input.toString(trailer29.start,trailer29.stop):null)); 
                    }

                    }
                    break;

            }

            char_literal30=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_callFunc390); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal30_tree = (Object)adaptor.create(char_literal30);
            adaptor.addChild(root_0, char_literal30_tree);
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:277:78: (cfa= callFuncArgs )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ID||LA6_0==DECIMALL||(LA6_0>=HEXDIGITS && LA6_0<=CHARACTERL)||LA6_0==LPAREN||(LA6_0>=PLUS && LA6_0<=MINUS)||(LA6_0>=88 && LA6_0<=89)||(LA6_0>=117 && LA6_0<=118)||(LA6_0>=124 && LA6_0<=127)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RPAREN) ) {
                int LA6_2 = input.LA(2);

                if ( (synpred24_twyncat()) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:277:80: cfa= callFuncArgs
                    {
                    pushFollow(FOLLOW_callFuncArgs_in_callFunc396);
                    cfa=callFuncArgs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cfa.getTree());

                    }
                    break;

            }

            char_literal31=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_callFunc401); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal31_tree = (Object)adaptor.create(char_literal31);
            adaptor.addChild(root_0, char_literal31_tree);
            }
            if ( state.backtracking==0 ) {

              	retval.txt = sb.toString() + "(" + (cfa == null?"":(cfa!=null?cfa.txt:null)) + ")" + ";";
              	if(cfa != null) {
              		String[] a = new String[(cfa!=null?cfa.argTypesList:null).size()];
              		retval.dType = checkFunction(sb.toString(),(cfa!=null?cfa.argTypesList:null).toArray(a));
              	} else {
              		retval.dType = checkFunction(sb.toString());
              	}
              	
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "callFunc"

    public static class callFuncBlock_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "callFuncBlock"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:290:1: callFuncBlock returns [ String txt ] : ID (trail= trailer )? '(' (cfb= callFuncBlockArgs )? ')' ;
    public final TwyncatParser.callFuncBlock_return callFuncBlock() throws RecognitionException {
        TwyncatParser.callFuncBlock_return retval = new TwyncatParser.callFuncBlock_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID32=null;
        Token char_literal33=null;
        Token char_literal34=null;
        TwyncatParser.trailer_return trail = null;

        TwyncatParser.callFuncBlockArgs_return cfb = null;


        Object ID32_tree=null;
        Object char_literal33_tree=null;
        Object char_literal34_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:291:2: ( ID (trail= trailer )? '(' (cfb= callFuncBlockArgs )? ')' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:291:4: ID (trail= trailer )? '(' (cfb= callFuncBlockArgs )? ')'
            {
            root_0 = (Object)adaptor.nil();

            ID32=(Token)match(input,ID,FOLLOW_ID_in_callFuncBlock420); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID32_tree = (Object)adaptor.create(ID32);
            adaptor.addChild(root_0, ID32_tree);
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:291:12: (trail= trailer )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==DOT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:0:0: trail= trailer
                    {
                    pushFollow(FOLLOW_trailer_in_callFuncBlock424);
                    trail=trailer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, trail.getTree());

                    }
                    break;

            }

            char_literal33=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_callFuncBlock427); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal33_tree = (Object)adaptor.create(char_literal33);
            adaptor.addChild(root_0, char_literal33_tree);
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:291:26: (cfb= callFuncBlockArgs )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==RPAREN) ) {
                int LA8_2 = input.LA(2);

                if ( (synpred26_twyncat()) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:291:28: cfb= callFuncBlockArgs
                    {
                    pushFollow(FOLLOW_callFuncBlockArgs_in_callFuncBlock433);
                    cfb=callFuncBlockArgs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cfb.getTree());

                    }
                    break;

            }

            char_literal34=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_callFuncBlock438); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal34_tree = (Object)adaptor.create(char_literal34);
            adaptor.addChild(root_0, char_literal34_tree);
            }
            if ( state.backtracking==0 ) {
               retval.txt = (ID32!=null?ID32.getText():null) + ((trail!=null?trail.txt:null) == null?"":(trail!=null?trail.txt:null)) + "(" + (cfb == null?"":(cfb!=null?cfb.txt:null)) + ")" + ";"; 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "callFuncBlock"

    public static class callFuncBlockArgs_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "callFuncBlockArgs"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:295:1: callFuncBlockArgs returns [ String txt ] : (argN1= ID (trail1= trailer )? '=' argV1= test ( ',' argNN= ID (trailN= trailer )? '=' argVN= test )* )? ;
    public final TwyncatParser.callFuncBlockArgs_return callFuncBlockArgs() throws RecognitionException {
        TwyncatParser.callFuncBlockArgs_return retval = new TwyncatParser.callFuncBlockArgs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token argN1=null;
        Token argNN=null;
        Token char_literal35=null;
        Token char_literal36=null;
        Token char_literal37=null;
        TwyncatParser.trailer_return trail1 = null;

        TwyncatParser.test_return argV1 = null;

        TwyncatParser.trailer_return trailN = null;

        TwyncatParser.test_return argVN = null;


        Object argN1_tree=null;
        Object argNN_tree=null;
        Object char_literal35_tree=null;
        Object char_literal36_tree=null;
        Object char_literal37_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:298:2: ( (argN1= ID (trail1= trailer )? '=' argV1= test ( ',' argNN= ID (trailN= trailer )? '=' argVN= test )* )? )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:298:4: (argN1= ID (trail1= trailer )? '=' argV1= test ( ',' argNN= ID (trailN= trailer )? '=' argVN= test )* )?
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:298:4: (argN1= ID (trail1= trailer )? '=' argV1= test ( ',' argNN= ID (trailN= trailer )? '=' argVN= test )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:298:6: argN1= ID (trail1= trailer )? '=' argV1= test ( ',' argNN= ID (trailN= trailer )? '=' argVN= test )*
                    {
                    argN1=(Token)match(input,ID,FOLLOW_ID_in_callFuncBlockArgs470); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    argN1_tree = (Object)adaptor.create(argN1);
                    adaptor.addChild(root_0, argN1_tree);
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:298:21: (trail1= trailer )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==DOT) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:0:0: trail1= trailer
                            {
                            pushFollow(FOLLOW_trailer_in_callFuncBlockArgs474);
                            trail1=trailer();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, trail1.getTree());

                            }
                            break;

                    }

                    char_literal35=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_callFuncBlockArgs477); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (Object)adaptor.create(char_literal35);
                    adaptor.addChild(root_0, char_literal35_tree);
                    }
                    pushFollow(FOLLOW_test_in_callFuncBlockArgs481);
                    argV1=test();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argV1.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append((argN1!=null?argN1.getText():null) + ((trail1!=null?trail1.txt:null) == null?"":(trail1!=null?trail1.txt:null)) + " := " + (argV1!=null?argV1.txt:null)); 
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:298:135: ( ',' argNN= ID (trailN= trailer )? '=' argVN= test )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==COMMA) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:298:137: ',' argNN= ID (trailN= trailer )? '=' argVN= test
                    	    {
                    	    char_literal36=(Token)match(input,COMMA,FOLLOW_COMMA_in_callFuncBlockArgs487); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal36_tree = (Object)adaptor.create(char_literal36);
                    	    adaptor.addChild(root_0, char_literal36_tree);
                    	    }
                    	    argNN=(Token)match(input,ID,FOLLOW_ID_in_callFuncBlockArgs491); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    argNN_tree = (Object)adaptor.create(argNN);
                    	    adaptor.addChild(root_0, argNN_tree);
                    	    }
                    	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:298:156: (trailN= trailer )?
                    	    int alt10=2;
                    	    int LA10_0 = input.LA(1);

                    	    if ( (LA10_0==DOT) ) {
                    	        alt10=1;
                    	    }
                    	    switch (alt10) {
                    	        case 1 :
                    	            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:0:0: trailN= trailer
                    	            {
                    	            pushFollow(FOLLOW_trailer_in_callFuncBlockArgs495);
                    	            trailN=trailer();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, trailN.getTree());

                    	            }
                    	            break;

                    	    }

                    	    char_literal37=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_callFuncBlockArgs498); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal37_tree = (Object)adaptor.create(char_literal37);
                    	    adaptor.addChild(root_0, char_literal37_tree);
                    	    }
                    	    pushFollow(FOLLOW_test_in_callFuncBlockArgs502);
                    	    argVN=test();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argVN.getTree());
                    	    if ( state.backtracking==0 ) {
                    	       sb.append(", " + (argNN!=null?argNN.getText():null) + ((trailN!=null?trailN.txt:null) == null?"":(trailN!=null?trailN.txt:null)) + " := " + (argVN!=null?argVN.txt:null)); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString(); 
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "callFuncBlockArgs"

    public static class callFuncArgs_return extends ParserRuleReturnScope {
        public String txt;
        public List<String> argTypesList;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "callFuncArgs"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:301:1: callFuncArgs returns [ String txt, List<String> argTypesList ] : (argV1= test ( ',' argVN= test )* )? ;
    public final TwyncatParser.callFuncArgs_return callFuncArgs() throws RecognitionException {
        TwyncatParser.callFuncArgs_return retval = new TwyncatParser.callFuncArgs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal38=null;
        TwyncatParser.test_return argV1 = null;

        TwyncatParser.test_return argVN = null;


        Object char_literal38_tree=null;

         StringBuilder sb = new StringBuilder(); retval.argTypesList = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:304:2: ( (argV1= test ( ',' argVN= test )* )? )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:304:4: (argV1= test ( ',' argVN= test )* )?
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:304:4: (argV1= test ( ',' argVN= test )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ID||LA14_0==DECIMALL||(LA14_0>=HEXDIGITS && LA14_0<=CHARACTERL)||LA14_0==LPAREN||(LA14_0>=PLUS && LA14_0<=MINUS)||(LA14_0>=88 && LA14_0<=89)||(LA14_0>=117 && LA14_0<=118)||(LA14_0>=124 && LA14_0<=127)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:304:6: argV1= test ( ',' argVN= test )*
                    {
                    pushFollow(FOLLOW_test_in_callFuncArgs540);
                    argV1=test();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argV1.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append((argV1!=null?argV1.txt:null)); retval.argTypesList.add((argV1!=null?argV1.dType:null)); 
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:304:77: ( ',' argVN= test )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:304:79: ',' argVN= test
                    	    {
                    	    char_literal38=(Token)match(input,COMMA,FOLLOW_COMMA_in_callFuncArgs546); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal38_tree = (Object)adaptor.create(char_literal38);
                    	    adaptor.addChild(root_0, char_literal38_tree);
                    	    }
                    	    pushFollow(FOLLOW_test_in_callFuncArgs550);
                    	    argVN=test();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argVN.getTree());
                    	    if ( state.backtracking==0 ) {
                    	       sb.append(", " + (argVN!=null?argVN.txt:null)); retval.argTypesList.add((argVN!=null?argVN.dType:null)); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString(); 
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "callFuncArgs"

    public static class alias_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alias"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:308:1: alias returns [ String txt ] : 'alias' ID '=' exprStm ;
    public final TwyncatParser.alias_return alias() throws RecognitionException {
        TwyncatParser.alias_return retval = new TwyncatParser.alias_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal39=null;
        Token ID40=null;
        Token char_literal41=null;
        TwyncatParser.exprStm_return exprStm42 = null;


        Object string_literal39_tree=null;
        Object ID40_tree=null;
        Object char_literal41_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:309:2: ( 'alias' ID '=' exprStm )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:309:4: 'alias' ID '=' exprStm
            {
            root_0 = (Object)adaptor.nil();

            string_literal39=(Token)match(input,93,FOLLOW_93_in_alias574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal39_tree = (Object)adaptor.create(string_literal39);
            adaptor.addChild(root_0, string_literal39_tree);
            }
            ID40=(Token)match(input,ID,FOLLOW_ID_in_alias576); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID40_tree = (Object)adaptor.create(ID40);
            adaptor.addChild(root_0, ID40_tree);
            }
            char_literal41=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_alias578); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (Object)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);
            }
            pushFollow(FOLLOW_exprStm_in_alias580);
            exprStm42=exprStm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exprStm42.getTree());
            if ( state.backtracking==0 ) {
               retval.txt = "TYPE " + (ID40!=null?ID40.getText():null) + ":" + (exprStm42!=null?exprStm42.txt:null) + "; " + "END_TYPE"; 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "alias"

    public static class subrange_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subrange"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:313:1: subrange returns [ String txt ] : 'subrange' '.' subrangeType ID '=' lb= literal ':' ub= literal ;
    public final TwyncatParser.subrange_return subrange() throws RecognitionException {
        TwyncatParser.subrange_return retval = new TwyncatParser.subrange_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal43=null;
        Token char_literal44=null;
        Token ID46=null;
        Token char_literal47=null;
        Token char_literal48=null;
        TwyncatParser.literal_return lb = null;

        TwyncatParser.literal_return ub = null;

        TwyncatParser.subrangeType_return subrangeType45 = null;


        Object string_literal43_tree=null;
        Object char_literal44_tree=null;
        Object ID46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal48_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:314:2: ( 'subrange' '.' subrangeType ID '=' lb= literal ':' ub= literal )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:314:4: 'subrange' '.' subrangeType ID '=' lb= literal ':' ub= literal
            {
            root_0 = (Object)adaptor.nil();

            string_literal43=(Token)match(input,94,FOLLOW_94_in_subrange598); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal43_tree = (Object)adaptor.create(string_literal43);
            adaptor.addChild(root_0, string_literal43_tree);
            }
            char_literal44=(Token)match(input,DOT,FOLLOW_DOT_in_subrange600); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal44_tree = (Object)adaptor.create(char_literal44);
            adaptor.addChild(root_0, char_literal44_tree);
            }
            pushFollow(FOLLOW_subrangeType_in_subrange602);
            subrangeType45=subrangeType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, subrangeType45.getTree());
            ID46=(Token)match(input,ID,FOLLOW_ID_in_subrange604); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID46_tree = (Object)adaptor.create(ID46);
            adaptor.addChild(root_0, ID46_tree);
            }
            char_literal47=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_subrange606); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal47_tree = (Object)adaptor.create(char_literal47);
            adaptor.addChild(root_0, char_literal47_tree);
            }
            pushFollow(FOLLOW_literal_in_subrange610);
            lb=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, lb.getTree());
            char_literal48=(Token)match(input,COLON,FOLLOW_COLON_in_subrange612); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal48_tree = (Object)adaptor.create(char_literal48);
            adaptor.addChild(root_0, char_literal48_tree);
            }
            pushFollow(FOLLOW_literal_in_subrange616);
            ub=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ub.getTree());
            if ( state.backtracking==0 ) {
               retval.txt = "TYPE " + (ID46!=null?ID46.getText():null) + " : " + (subrangeType45!=null?subrangeType45.txt:null) + "( " + (lb!=null?lb.txt:null) + ".." + (ub!=null?ub.txt:null) + " ) END_TYPE;"; 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "subrange"

    public static class pointer_return extends ParserRuleReturnScope {
        public List<String> statements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointer"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:320:1: pointer returns [ List<String> statements ] : 'pointer' '.' (pS= sdt | pU= ID ) p1= ID ( ',' pN= ID )* ;
    public final TwyncatParser.pointer_return pointer() throws RecognitionException {
        TwyncatParser.pointer_return retval = new TwyncatParser.pointer_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pU=null;
        Token p1=null;
        Token pN=null;
        Token string_literal49=null;
        Token char_literal50=null;
        Token char_literal51=null;
        TwyncatParser.sdt_return pS = null;


        Object pU_tree=null;
        Object p1_tree=null;
        Object pN_tree=null;
        Object string_literal49_tree=null;
        Object char_literal50_tree=null;
        Object char_literal51_tree=null;

         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:322:2: ( 'pointer' '.' (pS= sdt | pU= ID ) p1= ID ( ',' pN= ID )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:322:4: 'pointer' '.' (pS= sdt | pU= ID ) p1= ID ( ',' pN= ID )*
            {
            root_0 = (Object)adaptor.nil();

            string_literal49=(Token)match(input,95,FOLLOW_95_in_pointer641); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal49_tree = (Object)adaptor.create(string_literal49);
            adaptor.addChild(root_0, string_literal49_tree);
            }
            char_literal50=(Token)match(input,DOT,FOLLOW_DOT_in_pointer643); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal50_tree = (Object)adaptor.create(char_literal50);
            adaptor.addChild(root_0, char_literal50_tree);
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:322:18: (pS= sdt | pU= ID )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=68 && LA15_0<=87)) ) {
                alt15=1;
            }
            else if ( (LA15_0==ID) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:322:20: pS= sdt
                    {
                    pushFollow(FOLLOW_sdt_in_pointer649);
                    pS=sdt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pS.getTree());

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:322:29: pU= ID
                    {
                    pU=(Token)match(input,ID,FOLLOW_ID_in_pointer655); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    pU_tree = (Object)adaptor.create(pU);
                    adaptor.addChild(root_0, pU_tree);
                    }

                    }
                    break;

            }

            p1=(Token)match(input,ID,FOLLOW_ID_in_pointer660); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            p1_tree = (Object)adaptor.create(p1);
            adaptor.addChild(root_0, p1_tree);
            }
            if ( state.backtracking==0 ) {
               retval.statements.add((p1!=null?p1.getText():null) + " : POINTER TO " + (pS == null?"":(pS!=null?pS.txt:null)) + (pU == null?"":(pU!=null?pU.getText():null)) + ";"); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:323:2: ( ',' pN= ID )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==COMMA) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:323:3: ',' pN= ID
            	    {
            	    char_literal51=(Token)match(input,COMMA,FOLLOW_COMMA_in_pointer666); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal51_tree = (Object)adaptor.create(char_literal51);
            	    adaptor.addChild(root_0, char_literal51_tree);
            	    }
            	    pN=(Token)match(input,ID,FOLLOW_ID_in_pointer670); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    pN_tree = (Object)adaptor.create(pN);
            	    adaptor.addChild(root_0, pN_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       retval.statements.add((pN!=null?pN.getText():null) + " : POINTER TO " + (pS == null?"":(pS!=null?pS.txt:null)) + (pU == null?"":(pU!=null?pU.getText():null)) + ";"); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "pointer"

    public static class enumeration_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumeration"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:328:1: enumeration returns [ String txt ] : 'enum' '.' en= ID '=' LCURLY enumerationElementList RCURLY ;
    public final TwyncatParser.enumeration_return enumeration() throws RecognitionException {
        TwyncatParser.enumeration_return retval = new TwyncatParser.enumeration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token en=null;
        Token string_literal52=null;
        Token char_literal53=null;
        Token char_literal54=null;
        Token LCURLY55=null;
        Token RCURLY57=null;
        TwyncatParser.enumerationElementList_return enumerationElementList56 = null;


        Object en_tree=null;
        Object string_literal52_tree=null;
        Object char_literal53_tree=null;
        Object char_literal54_tree=null;
        Object LCURLY55_tree=null;
        Object RCURLY57_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:329:2: ( 'enum' '.' en= ID '=' LCURLY enumerationElementList RCURLY )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:329:4: 'enum' '.' en= ID '=' LCURLY enumerationElementList RCURLY
            {
            root_0 = (Object)adaptor.nil();

            string_literal52=(Token)match(input,96,FOLLOW_96_in_enumeration692); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal52_tree = (Object)adaptor.create(string_literal52);
            adaptor.addChild(root_0, string_literal52_tree);
            }
            char_literal53=(Token)match(input,DOT,FOLLOW_DOT_in_enumeration694); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal53_tree = (Object)adaptor.create(char_literal53);
            adaptor.addChild(root_0, char_literal53_tree);
            }
            en=(Token)match(input,ID,FOLLOW_ID_in_enumeration698); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            en_tree = (Object)adaptor.create(en);
            adaptor.addChild(root_0, en_tree);
            }
            char_literal54=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_enumeration700); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal54_tree = (Object)adaptor.create(char_literal54);
            adaptor.addChild(root_0, char_literal54_tree);
            }
            LCURLY55=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_enumeration702); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LCURLY55_tree = (Object)adaptor.create(LCURLY55);
            adaptor.addChild(root_0, LCURLY55_tree);
            }
            pushFollow(FOLLOW_enumerationElementList_in_enumeration704);
            enumerationElementList56=enumerationElementList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, enumerationElementList56.getTree());
            RCURLY57=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_enumeration706); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RCURLY57_tree = (Object)adaptor.create(RCURLY57);
            adaptor.addChild(root_0, RCURLY57_tree);
            }
            if ( state.backtracking==0 ) {
               retval.txt = "TYPE " + (en!=null?en.getText():null) + ":(" + (enumerationElementList56!=null?enumerationElementList56.txt:null) + "); END_TYPE"; 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumeration"

    public static class enumerationElementList_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumerationElementList"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:333:1: enumerationElementList returns [ String txt ] : ee1= enumerationElement ( ',' eeN= enumerationElement )* ;
    public final TwyncatParser.enumerationElementList_return enumerationElementList() throws RecognitionException {
        TwyncatParser.enumerationElementList_return retval = new TwyncatParser.enumerationElementList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal58=null;
        TwyncatParser.enumerationElement_return ee1 = null;

        TwyncatParser.enumerationElement_return eeN = null;


        Object char_literal58_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:336:2: (ee1= enumerationElement ( ',' eeN= enumerationElement )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:336:5: ee1= enumerationElement ( ',' eeN= enumerationElement )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_enumerationElement_in_enumerationElementList737);
            ee1=enumerationElement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ee1.getTree());
            if ( state.backtracking==0 ) {
               sb.append((ee1!=null?ee1.txt:null)); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:336:53: ( ',' eeN= enumerationElement )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==COMMA) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:336:54: ',' eeN= enumerationElement
            	    {
            	    char_literal58=(Token)match(input,COMMA,FOLLOW_COMMA_in_enumerationElementList742); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal58_tree = (Object)adaptor.create(char_literal58);
            	    adaptor.addChild(root_0, char_literal58_tree);
            	    }
            	    pushFollow(FOLLOW_enumerationElement_in_enumerationElementList746);
            	    eeN=enumerationElement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, eeN.getTree());
            	    if ( state.backtracking==0 ) {
            	       sb.append(", " + (eeN!=null?eeN.txt:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString(); 
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumerationElementList"

    public static class enumerationElement_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumerationElement"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:339:10: fragment enumerationElement returns [ String txt ] : ID ( '=' DECIMALL )? ;
    public final TwyncatParser.enumerationElement_return enumerationElement() throws RecognitionException {
        TwyncatParser.enumerationElement_return retval = new TwyncatParser.enumerationElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID59=null;
        Token char_literal60=null;
        Token DECIMALL61=null;

        Object ID59_tree=null;
        Object char_literal60_tree=null;
        Object DECIMALL61_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:342:2: ( ID ( '=' DECIMALL )? )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:342:4: ID ( '=' DECIMALL )?
            {
            root_0 = (Object)adaptor.nil();

            ID59=(Token)match(input,ID,FOLLOW_ID_in_enumerationElement778); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID59_tree = (Object)adaptor.create(ID59);
            adaptor.addChild(root_0, ID59_tree);
            }
            if ( state.backtracking==0 ) {
               sb.append((ID59!=null?ID59.getText():null)); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:342:32: ( '=' DECIMALL )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ASSIGN) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:342:33: '=' DECIMALL
                    {
                    char_literal60=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_enumerationElement783); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal60_tree = (Object)adaptor.create(char_literal60);
                    adaptor.addChild(root_0, char_literal60_tree);
                    }
                    DECIMALL61=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_enumerationElement785); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMALL61_tree = (Object)adaptor.create(DECIMALL61);
                    adaptor.addChild(root_0, DECIMALL61_tree);
                    }
                    if ( state.backtracking==0 ) {
                       sb.append(":=" + (DECIMALL61!=null?DECIMALL61.getText():null)); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString(); 
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumerationElement"

    public static class subrangeType_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subrangeType"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:345:10: fragment subrangeType returns [ String txt ] : ( 'sint' | 'usint' | 'int' | 'uint' | 'dint' | 'udint' | 'byte' | 'word' | 'dword' | 'lint' | 'ulint' | 'lword' );
    public final TwyncatParser.subrangeType_return subrangeType() throws RecognitionException {
        TwyncatParser.subrangeType_return retval = new TwyncatParser.subrangeType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal62=null;
        Token string_literal63=null;
        Token string_literal64=null;
        Token string_literal65=null;
        Token string_literal66=null;
        Token string_literal67=null;
        Token string_literal68=null;
        Token string_literal69=null;
        Token string_literal70=null;
        Token string_literal71=null;
        Token string_literal72=null;
        Token string_literal73=null;

        Object string_literal62_tree=null;
        Object string_literal63_tree=null;
        Object string_literal64_tree=null;
        Object string_literal65_tree=null;
        Object string_literal66_tree=null;
        Object string_literal67_tree=null;
        Object string_literal68_tree=null;
        Object string_literal69_tree=null;
        Object string_literal70_tree=null;
        Object string_literal71_tree=null;
        Object string_literal72_tree=null;
        Object string_literal73_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:346:2: ( 'sint' | 'usint' | 'int' | 'uint' | 'dint' | 'udint' | 'byte' | 'word' | 'dword' | 'lint' | 'ulint' | 'lword' )
            int alt19=12;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt19=1;
                }
                break;
            case 76:
                {
                alt19=2;
                }
                break;
            case 77:
                {
                alt19=3;
                }
                break;
            case 78:
                {
                alt19=4;
                }
                break;
            case 79:
                {
                alt19=5;
                }
                break;
            case 80:
                {
                alt19=6;
                }
                break;
            case 69:
                {
                alt19=7;
                }
                break;
            case 70:
                {
                alt19=8;
                }
                break;
            case 71:
                {
                alt19=9;
                }
                break;
            case 72:
                {
                alt19=10;
                }
                break;
            case 73:
                {
                alt19=11;
                }
                break;
            case 74:
                {
                alt19=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:346:4: 'sint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal62=(Token)match(input,75,FOLLOW_75_in_subrangeType806); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal62_tree = (Object)adaptor.create(string_literal62);
                    adaptor.addChild(root_0, string_literal62_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "SINT"; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:347:4: 'usint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal63=(Token)match(input,76,FOLLOW_76_in_subrangeType813); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal63_tree = (Object)adaptor.create(string_literal63);
                    adaptor.addChild(root_0, string_literal63_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "USINT"; 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:348:4: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal64=(Token)match(input,77,FOLLOW_77_in_subrangeType820); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal64_tree = (Object)adaptor.create(string_literal64);
                    adaptor.addChild(root_0, string_literal64_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "INT"; 
                    }

                    }
                    break;
                case 4 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:349:4: 'uint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal65=(Token)match(input,78,FOLLOW_78_in_subrangeType827); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal65_tree = (Object)adaptor.create(string_literal65);
                    adaptor.addChild(root_0, string_literal65_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "UINT"; 
                    }

                    }
                    break;
                case 5 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:350:4: 'dint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal66=(Token)match(input,79,FOLLOW_79_in_subrangeType834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal66_tree = (Object)adaptor.create(string_literal66);
                    adaptor.addChild(root_0, string_literal66_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "DINT"; 
                    }

                    }
                    break;
                case 6 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:351:4: 'udint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal67=(Token)match(input,80,FOLLOW_80_in_subrangeType841); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal67_tree = (Object)adaptor.create(string_literal67);
                    adaptor.addChild(root_0, string_literal67_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "UDINT"; 
                    }

                    }
                    break;
                case 7 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:352:4: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal68=(Token)match(input,69,FOLLOW_69_in_subrangeType848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal68_tree = (Object)adaptor.create(string_literal68);
                    adaptor.addChild(root_0, string_literal68_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "BYTE"; 
                    }

                    }
                    break;
                case 8 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:353:4: 'word'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal69=(Token)match(input,70,FOLLOW_70_in_subrangeType855); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal69_tree = (Object)adaptor.create(string_literal69);
                    adaptor.addChild(root_0, string_literal69_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "WORD"; 
                    }

                    }
                    break;
                case 9 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:354:4: 'dword'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal70=(Token)match(input,71,FOLLOW_71_in_subrangeType862); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal70_tree = (Object)adaptor.create(string_literal70);
                    adaptor.addChild(root_0, string_literal70_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "DWORD"; 
                    }

                    }
                    break;
                case 10 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:355:4: 'lint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal71=(Token)match(input,72,FOLLOW_72_in_subrangeType869); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal71_tree = (Object)adaptor.create(string_literal71);
                    adaptor.addChild(root_0, string_literal71_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "LINT"; 
                    }

                    }
                    break;
                case 11 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:356:4: 'ulint'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal72=(Token)match(input,73,FOLLOW_73_in_subrangeType876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal72_tree = (Object)adaptor.create(string_literal72);
                    adaptor.addChild(root_0, string_literal72_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "ULINT"; 
                    }

                    }
                    break;
                case 12 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:357:4: 'lword'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal73=(Token)match(input,74,FOLLOW_74_in_subrangeType883); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal73_tree = (Object)adaptor.create(string_literal73);
                    adaptor.addChild(root_0, string_literal73_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "LWORD"; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "subrangeType"

    public static class structure_return extends ParserRuleReturnScope {
        public List<String> statements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structure"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:360:1: structure returns [ List<String> statements ] : 'structure' ID COLON NEWLINE INDENT se= structureElement[ s ] DEDENT ;
    public final TwyncatParser.structure_return structure() throws RecognitionException {
        TwyncatParser.structure_return retval = new TwyncatParser.structure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal74=null;
        Token ID75=null;
        Token COLON76=null;
        Token NEWLINE77=null;
        Token INDENT78=null;
        Token DEDENT79=null;
        TwyncatParser.structureElement_return se = null;


        Object string_literal74_tree=null;
        Object ID75_tree=null;
        Object COLON76_tree=null;
        Object NEWLINE77_tree=null;
        Object INDENT78_tree=null;
        Object DEDENT79_tree=null;

         retval.statements = new LinkedList<String>(); Structure s = null; 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:362:2: ( 'structure' ID COLON NEWLINE INDENT se= structureElement[ s ] DEDENT )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:362:4: 'structure' ID COLON NEWLINE INDENT se= structureElement[ s ] DEDENT
            {
            root_0 = (Object)adaptor.nil();

            string_literal74=(Token)match(input,97,FOLLOW_97_in_structure905); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal74_tree = (Object)adaptor.create(string_literal74);
            adaptor.addChild(root_0, string_literal74_tree);
            }
            ID75=(Token)match(input,ID,FOLLOW_ID_in_structure907); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID75_tree = (Object)adaptor.create(ID75);
            adaptor.addChild(root_0, ID75_tree);
            }
            COLON76=(Token)match(input,COLON,FOLLOW_COLON_in_structure909); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON76_tree = (Object)adaptor.create(COLON76);
            adaptor.addChild(root_0, COLON76_tree);
            }
            if ( state.backtracking==0 ) {
               s = new Structure((ID75!=null?ID75.getText():null)); 
            }
            NEWLINE77=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_structure913); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NEWLINE77_tree = (Object)adaptor.create(NEWLINE77);
            adaptor.addChild(root_0, NEWLINE77_tree);
            }
            INDENT78=(Token)match(input,INDENT,FOLLOW_INDENT_in_structure915); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INDENT78_tree = (Object)adaptor.create(INDENT78);
            adaptor.addChild(root_0, INDENT78_tree);
            }
            pushFollow(FOLLOW_structureElement_in_structure919);
            se=structureElement(s);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, se.getTree());
            DEDENT79=(Token)match(input,DEDENT,FOLLOW_DEDENT_in_structure922); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEDENT79_tree = (Object)adaptor.create(DEDENT79);
            adaptor.addChild(root_0, DEDENT79_tree);
            }
            if ( state.backtracking==0 ) {

              	retval.statements.add("TYPE " + (ID75!=null?ID75.getText():null) + " :");
              	retval.statements.add("STRUCT");
                 	retval.statements.addAll((se!=null?se.statements:null));
              	retval.statements.add("END_STRUCT");
              	retval.statements.add("END_TYPE");
              	
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "structure"

    public static class structureElement_return extends ParserRuleReturnScope {
        public List<String> statements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structureElement"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:372:1: structureElement[ Structure struct ] returns [ List<String> statements ] : ( (sT= sdt | uT= ID ) structureElementList[ ($sT.txt == null?\"\":$sT.txt) + ($uT.text == null?\"\":$uT.text) + \"\", $struct ] NEWLINE )+ ;
    public final TwyncatParser.structureElement_return structureElement(Structure struct) throws RecognitionException {
        TwyncatParser.structureElement_return retval = new TwyncatParser.structureElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token uT=null;
        Token NEWLINE81=null;
        TwyncatParser.sdt_return sT = null;

        TwyncatParser.structureElementList_return structureElementList80 = null;


        Object uT_tree=null;
        Object NEWLINE81_tree=null;

         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:374:2: ( ( (sT= sdt | uT= ID ) structureElementList[ ($sT.txt == null?\"\":$sT.txt) + ($uT.text == null?\"\":$uT.text) + \"\", $struct ] NEWLINE )+ )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:374:4: ( (sT= sdt | uT= ID ) structureElementList[ ($sT.txt == null?\"\":$sT.txt) + ($uT.text == null?\"\":$uT.text) + \"\", $struct ] NEWLINE )+
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:374:4: ( (sT= sdt | uT= ID ) structureElementList[ ($sT.txt == null?\"\":$sT.txt) + ($uT.text == null?\"\":$uT.text) + \"\", $struct ] NEWLINE )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==ID||(LA21_0>=68 && LA21_0<=87)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:374:5: (sT= sdt | uT= ID ) structureElementList[ ($sT.txt == null?\"\":$sT.txt) + ($uT.text == null?\"\":$uT.text) + \"\", $struct ] NEWLINE
            	    {
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:374:5: (sT= sdt | uT= ID )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( ((LA20_0>=68 && LA20_0<=87)) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==ID) ) {
            	        alt20=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:374:6: sT= sdt
            	            {
            	            pushFollow(FOLLOW_sdt_in_structureElement952);
            	            sT=sdt();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, sT.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:374:15: uT= ID
            	            {
            	            uT=(Token)match(input,ID,FOLLOW_ID_in_structureElement958); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            uT_tree = (Object)adaptor.create(uT);
            	            adaptor.addChild(root_0, uT_tree);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_structureElementList_in_structureElement961);
            	    structureElementList80=structureElementList(((sT!=null?sT.txt:null) == null?"":(sT!=null?sT.txt:null)) + ((uT!=null?uT.getText():null) == null?"":(uT!=null?uT.getText():null)) + "", struct);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, structureElementList80.getTree());
            	    NEWLINE81=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_structureElement964); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NEWLINE81_tree = (Object)adaptor.create(NEWLINE81);
            	    adaptor.addChild(root_0, NEWLINE81_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       retval.statements.addAll((structureElementList80!=null?structureElementList80.statements:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "structureElement"

    public static class structureElementList_return extends ParserRuleReturnScope {
        public List<String> statements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structureElementList"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:377:1: structureElementList[ String type, Structure struct ] returns [ List<String> statements ] : vle1= structureField[ $type, $struct ] ( ',' vleN= structureField[ $type, $struct ] )* ;
    public final TwyncatParser.structureElementList_return structureElementList(String type, Structure struct) throws RecognitionException {
        TwyncatParser.structureElementList_return retval = new TwyncatParser.structureElementList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal82=null;
        TwyncatParser.structureField_return vle1 = null;

        TwyncatParser.structureField_return vleN = null;


        Object char_literal82_tree=null;

         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:379:2: (vle1= structureField[ $type, $struct ] ( ',' vleN= structureField[ $type, $struct ] )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:379:4: vle1= structureField[ $type, $struct ] ( ',' vleN= structureField[ $type, $struct ] )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_structureField_in_structureElementList992);
            vle1=structureField(type, struct);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, vle1.getTree());
            if ( state.backtracking==0 ) {
               if((vle1!=null?vle1.txt:null) != null) { retval.statements.add((vle1!=null?vle1.txt:null)); } 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:379:100: ( ',' vleN= structureField[ $type, $struct ] )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==COMMA) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:379:101: ',' vleN= structureField[ $type, $struct ]
            	    {
            	    char_literal82=(Token)match(input,COMMA,FOLLOW_COMMA_in_structureElementList998); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal82_tree = (Object)adaptor.create(char_literal82);
            	    adaptor.addChild(root_0, char_literal82_tree);
            	    }
            	    pushFollow(FOLLOW_structureField_in_structureElementList1002);
            	    vleN=structureField(type, struct);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, vleN.getTree());
            	    if ( state.backtracking==0 ) {
            	       if((vleN!=null?vleN.txt:null) != null) { retval.statements.add((vleN!=null?vleN.txt:null)); } 
            	    }

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "structureElementList"

    public static class structureField_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structureField"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:383:10: fragment structureField[ String vType, Structure struct ] returns [ String txt ] : ID ( trailer )? ( arrayModifier ( '=' ace= arrayConstantExpression )? | ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )? ;
    public final TwyncatParser.structureField_return structureField(String vType, Structure struct) throws RecognitionException {
        TwyncatParser.structureField_return retval = new TwyncatParser.structureField_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token strl=null;
        Token ID83=null;
        Token char_literal86=null;
        Token char_literal87=null;
        Token char_literal88=null;
        Token char_literal89=null;
        TwyncatParser.arrayConstantExpression_return ace = null;

        TwyncatParser.test_return t = null;

        TwyncatParser.trailer_return trailer84 = null;

        TwyncatParser.arrayModifier_return arrayModifier85 = null;


        Object strl_tree=null;
        Object ID83_tree=null;
        Object char_literal86_tree=null;
        Object char_literal87_tree=null;
        Object char_literal88_tree=null;
        Object char_literal89_tree=null;

         StringBuilder sb = new StringBuilder(); StringBuilder sbVar = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:386:2: ( ID ( trailer )? ( arrayModifier ( '=' ace= arrayConstantExpression )? | ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )? )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:386:4: ID ( trailer )? ( arrayModifier ( '=' ace= arrayConstantExpression )? | ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )?
            {
            root_0 = (Object)adaptor.nil();

            ID83=(Token)match(input,ID,FOLLOW_ID_in_structureField1037); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID83_tree = (Object)adaptor.create(ID83);
            adaptor.addChild(root_0, ID83_tree);
            }
            if ( state.backtracking==0 ) {
               sb.append((ID83!=null?ID83.getText():null)); sbVar.append((ID83!=null?ID83.getText():null)); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:386:56: ( trailer )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==DOT) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:386:57: trailer
                    {
                    pushFollow(FOLLOW_trailer_in_structureField1042);
                    trailer84=trailer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, trailer84.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append((trailer84!=null?trailer84.txt:null)); sbVar.append((trailer84!=null?trailer84.txt:null)); 
                    }

                    }
                    break;

            }

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:387:2: ( arrayModifier ( '=' ace= arrayConstantExpression )? | ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )?
            int alt27=3;
            switch ( input.LA(1) ) {
                case LBRACK:
                    {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==DECIMALL) ) {
                        int LA27_6 = input.LA(3);

                        if ( (LA27_6==RBRACK) ) {
                            alt27=2;
                        }
                        else if ( (LA27_6==COLON) ) {
                            alt27=1;
                        }
                    }
                    }
                    break;
                case ASSIGN:
                    {
                    alt27=2;
                    }
                    break;
                case COMMA:
                    {
                    int LA27_3 = input.LA(2);

                    if ( (synpred56_twyncat()) ) {
                        alt27=2;
                    }
                    }
                    break;
                case NEWLINE:
                    {
                    int LA27_4 = input.LA(2);

                    if ( (synpred56_twyncat()) ) {
                        alt27=2;
                    }
                    }
                    break;
                case EOF:
                    {
                    int LA27_5 = input.LA(2);

                    if ( (synpred56_twyncat()) ) {
                        alt27=2;
                    }
                    }
                    break;
            }

            switch (alt27) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:387:4: arrayModifier ( '=' ace= arrayConstantExpression )?
                    {
                    if ( state.backtracking==0 ) {
                       sb.append(" ARRAY"); 
                    }
                    pushFollow(FOLLOW_arrayModifier_in_structureField1053);
                    arrayModifier85=arrayModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayModifier85.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append((arrayModifier85!=null?arrayModifier85.txt:null)); sb.append(" OF " + vType); sbVar.append("[]"); 
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:387:126: ( '=' ace= arrayConstantExpression )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==ASSIGN) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:387:127: '=' ace= arrayConstantExpression
                            {
                            char_literal86=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_structureField1058); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal86_tree = (Object)adaptor.create(char_literal86);
                            adaptor.addChild(root_0, char_literal86_tree);
                            }
                            pushFollow(FOLLOW_arrayConstantExpression_in_structureField1062);
                            ace=arrayConstantExpression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, ace.getTree());
                            if ( state.backtracking==0 ) {
                               sb.append(" := " + (ace!=null?ace.txt:null)); 
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:4: ( '[' strl= DECIMALL ']' )? ( '=' t= test )?
                    {
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:4: ( '[' strl= DECIMALL ']' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==LBRACK) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:6: '[' strl= DECIMALL ']'
                            {
                            char_literal87=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_structureField1075); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal87_tree = (Object)adaptor.create(char_literal87);
                            adaptor.addChild(root_0, char_literal87_tree);
                            }
                            strl=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_structureField1079); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            strl_tree = (Object)adaptor.create(strl);
                            adaptor.addChild(root_0, strl_tree);
                            }
                            char_literal88=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_structureField1081); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal88_tree = (Object)adaptor.create(char_literal88);
                            adaptor.addChild(root_0, char_literal88_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:31: ( '=' t= test )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==ASSIGN) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:32: '=' t= test
                            {
                            char_literal89=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_structureField1087); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal89_tree = (Object)adaptor.create(char_literal89);
                            adaptor.addChild(root_0, char_literal89_tree);
                            }
                            pushFollow(FOLLOW_test_in_structureField1091);
                            t=test();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       sb.append(" : " + vType + (strl == null?"":"("+(strl!=null?strl.getText():null)+")") + (t == null?"":" := " + (t!=null?t.txt:null))); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString() + ";";
               try {
				struct.addField(sbVar.toString(), vType);
				} catch (FieldExistsException e) {
					System.err.println(e.getMessage());
				} catch (TypeUnknownException e) {
					System.err.println(e.getMessage());
				} 
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "structureField"

    public static class definition_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "definition"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:392:1: definition returns [ List<String> statements, VariablesBundle vbund ] : (dp= defPurpose )? (dm= defModifier )? (sT= sdt | uT= ID ) vlist= varList[ (sT == null?\"\":$sT.txt) + ($uT == null?\"\":$uT.text) , (dp == null) ] ;
    public final TwyncatParser.definition_return definition() throws RecognitionException {
        TwyncatParser.definition_return retval = new TwyncatParser.definition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token uT=null;
        TwyncatParser.defPurpose_return dp = null;

        TwyncatParser.defModifier_return dm = null;

        TwyncatParser.sdt_return sT = null;

        TwyncatParser.varList_return vlist = null;


        Object uT_tree=null;

         List<String> definitions; retval.vbund = new VariablesBundle(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:440:2: ( (dp= defPurpose )? (dm= defModifier )? (sT= sdt | uT= ID ) vlist= varList[ (sT == null?\"\":$sT.txt) + ($uT == null?\"\":$uT.text) , (dp == null) ] )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:440:4: (dp= defPurpose )? (dm= defModifier )? (sT= sdt | uT= ID ) vlist= varList[ (sT == null?\"\":$sT.txt) + ($uT == null?\"\":$uT.text) , (dp == null) ]
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:440:6: (dp= defPurpose )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=98 && LA28_0<=100)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:0:0: dp= defPurpose
                    {
                    pushFollow(FOLLOW_defPurpose_in_definition1126);
                    dp=defPurpose();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dp.getTree());

                    }
                    break;

            }

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:440:21: (dm= defModifier )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=101 && LA29_0<=103)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:0:0: dm= defModifier
                    {
                    pushFollow(FOLLOW_defModifier_in_definition1131);
                    dm=defModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dm.getTree());

                    }
                    break;

            }

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:440:35: (sT= sdt | uT= ID )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=68 && LA30_0<=87)) ) {
                alt30=1;
            }
            else if ( (LA30_0==ID) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:440:36: sT= sdt
                    {
                    pushFollow(FOLLOW_sdt_in_definition1137);
                    sT=sdt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sT.getTree());

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:440:45: uT= ID
                    {
                    uT=(Token)match(input,ID,FOLLOW_ID_in_definition1143); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    uT_tree = (Object)adaptor.create(uT);
                    adaptor.addChild(root_0, uT_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_varList_in_definition1148);
            vlist=varList((sT == null?"":(sT!=null?sT.txt:null)) + (uT == null?"":(uT!=null?uT.getText():null)), (dp == null));

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, vlist.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

              	retval.statements = (vlist!=null?vlist.initializations:null);
              	definitions = (vlist!=null?vlist.statements:null);
              	int purpose = 3, modifier = 0;
              	if(dp != null) { purpose = (dp!=null?dp.pID:0); }
              	if(dm != null) { modifier = (dm!=null?dm.mID:0); }	
              	switch(purpose){
              		case 0: // Output
              			switch(modifier) {
              				case 0: retval.vbund.outVar = definitions; break;
              				case 1: retval.vbund.outVarR = definitions; break;
              				case 2: retval.vbund.outVarP = definitions; break;
              				case 3: retval.vbund.outVarC = definitions; break;
              				default: break;
              			}
              			break;
              		case 1: // Input
              			switch(modifier) {
              				case 0: retval.vbund.inVar = definitions; break;
              				case 1: retval.vbund.inVarR = definitions; break;
              				case 2: retval.vbund.inVarP = definitions; break;
              				case 3: retval.vbund.inVarC = definitions; break;
              				default: break;
              			}
              			break;
              		case 2: // Input-Output
              			switch(modifier) {
              				case 0: retval.vbund.inoutVar = definitions; break;
              				case 1: retval.vbund.inoutVarR = definitions; break;
              				case 2: retval.vbund.inoutVarP = definitions; break;
              				case 3: retval.vbund.inoutVarC = definitions; break;
              				default: break;
              			}
              			break;
              		case 3: // Local
              			switch(modifier) {
              				case 0: retval.vbund.locVar = definitions; break;
              				case 1: retval.vbund.locVarR = definitions; break;
              				case 2: retval.vbund.locVarP = definitions; break;
              				case 3: retval.vbund.locVarC = definitions; break;
              				default: break;
              			}
              			break;
              		default: break;
              	}
              	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "definition"

    public static class defPurpose_return extends ParserRuleReturnScope {
        public int pID;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defPurpose"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:443:1: defPurpose returns [ int pID ] : ( 'in' | 'out' | 'inout' ) DOT ;
    public final TwyncatParser.defPurpose_return defPurpose() throws RecognitionException {
        TwyncatParser.defPurpose_return retval = new TwyncatParser.defPurpose_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal90=null;
        Token string_literal91=null;
        Token string_literal92=null;
        Token DOT93=null;

        Object string_literal90_tree=null;
        Object string_literal91_tree=null;
        Object string_literal92_tree=null;
        Object DOT93_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:444:2: ( ( 'in' | 'out' | 'inout' ) DOT )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:444:4: ( 'in' | 'out' | 'inout' ) DOT
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:444:4: ( 'in' | 'out' | 'inout' )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt31=1;
                }
                break;
            case 99:
                {
                alt31=2;
                }
                break;
            case 100:
                {
                alt31=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:444:6: 'in'
                    {
                    string_literal90=(Token)match(input,98,FOLLOW_98_in_defPurpose1166); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (Object)adaptor.create(string_literal90);
                    adaptor.addChild(root_0, string_literal90_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.pID = 1; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:444:27: 'out'
                    {
                    string_literal91=(Token)match(input,99,FOLLOW_99_in_defPurpose1172); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal91_tree = (Object)adaptor.create(string_literal91);
                    adaptor.addChild(root_0, string_literal91_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.pID = 0; 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:444:49: 'inout'
                    {
                    string_literal92=(Token)match(input,100,FOLLOW_100_in_defPurpose1178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    adaptor.addChild(root_0, string_literal92_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.pID = 2; 
                    }

                    }
                    break;

            }

            DOT93=(Token)match(input,DOT,FOLLOW_DOT_in_defPurpose1184); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOT93_tree = (Object)adaptor.create(DOT93);
            adaptor.addChild(root_0, DOT93_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "defPurpose"

    public static class defModifier_return extends ParserRuleReturnScope {
        public int mID;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defModifier"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:447:1: defModifier returns [ int mID ] : ( 'persistent' | 'retain' | 'constant' ) DOT ;
    public final TwyncatParser.defModifier_return defModifier() throws RecognitionException {
        TwyncatParser.defModifier_return retval = new TwyncatParser.defModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal94=null;
        Token string_literal95=null;
        Token string_literal96=null;
        Token DOT97=null;

        Object string_literal94_tree=null;
        Object string_literal95_tree=null;
        Object string_literal96_tree=null;
        Object DOT97_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:448:2: ( ( 'persistent' | 'retain' | 'constant' ) DOT )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:448:4: ( 'persistent' | 'retain' | 'constant' ) DOT
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:448:4: ( 'persistent' | 'retain' | 'constant' )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt32=1;
                }
                break;
            case 102:
                {
                alt32=2;
                }
                break;
            case 103:
                {
                alt32=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:448:6: 'persistent'
                    {
                    string_literal94=(Token)match(input,101,FOLLOW_101_in_defModifier1202); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal94_tree = (Object)adaptor.create(string_literal94);
                    adaptor.addChild(root_0, string_literal94_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mID = 2; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:448:35: 'retain'
                    {
                    string_literal95=(Token)match(input,102,FOLLOW_102_in_defModifier1208); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal95_tree = (Object)adaptor.create(string_literal95);
                    adaptor.addChild(root_0, string_literal95_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mID = 1; 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:448:60: 'constant'
                    {
                    string_literal96=(Token)match(input,103,FOLLOW_103_in_defModifier1214); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = (Object)adaptor.create(string_literal96);
                    adaptor.addChild(root_0, string_literal96_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mID = 3; 
                    }

                    }
                    break;

            }

            DOT97=(Token)match(input,DOT,FOLLOW_DOT_in_defModifier1220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOT97_tree = (Object)adaptor.create(DOT97);
            adaptor.addChild(root_0, DOT97_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "defModifier"

    public static class varList_return extends ParserRuleReturnScope {
        public List<String> statements;
        public List<String> initializations;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varList"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:458:1: varList[ String type, boolean isLocal ] returns [ List<String> statements, List<String> initializations ] : vle1= varListElem[ $type, $isLocal ] ( ',' vleN= varListElem[ $type, $isLocal ] )* ;
    public final TwyncatParser.varList_return varList(String type, boolean isLocal) throws RecognitionException {
        TwyncatParser.varList_return retval = new TwyncatParser.varList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal98=null;
        TwyncatParser.varListElem_return vle1 = null;

        TwyncatParser.varListElem_return vleN = null;


        Object char_literal98_tree=null;

         retval.statements = new LinkedList<String>(); retval.initializations = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:460:2: (vle1= varListElem[ $type, $isLocal ] ( ',' vleN= varListElem[ $type, $isLocal ] )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:460:4: vle1= varListElem[ $type, $isLocal ] ( ',' vleN= varListElem[ $type, $isLocal ] )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_varListElem_in_varList1248);
            vle1=varListElem(type, isLocal);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, vle1.getTree());
            if ( state.backtracking==0 ) {
               if((vle1!=null?vle1.txt:null) != null) { retval.statements.add((vle1!=null?vle1.txt:null)); } if((vle1!=null?vle1.initialization:null) != null) { retval.initializations.add((vle1!=null?vle1.initialization:null)); } 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:460:179: ( ',' vleN= varListElem[ $type, $isLocal ] )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==COMMA) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:460:180: ',' vleN= varListElem[ $type, $isLocal ]
            	    {
            	    char_literal98=(Token)match(input,COMMA,FOLLOW_COMMA_in_varList1254); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal98_tree = (Object)adaptor.create(char_literal98);
            	    adaptor.addChild(root_0, char_literal98_tree);
            	    }
            	    pushFollow(FOLLOW_varListElem_in_varList1258);
            	    vleN=varListElem(type, isLocal);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, vleN.getTree());
            	    if ( state.backtracking==0 ) {
            	       if((vleN!=null?vleN.txt:null) != null) { retval.statements.add((vleN!=null?vleN.txt:null)); } if((vleN!=null?vleN.initialization:null) != null) { retval.initializations.add((vleN!=null?vleN.initialization:null)); } 
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "varList"

    public static class varListElem_return extends ParserRuleReturnScope {
        public String txt;
        public String initialization;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varListElem"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:463:10: fragment varListElem[ String vType, boolean isLocal ] returns [ String txt, String initialization ] : ID ( trailer )? ( arrayModifier ( '=' ace= arrayConstantExpression )? | ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )? ;
    public final TwyncatParser.varListElem_return varListElem(String vType, boolean isLocal) throws RecognitionException {
        TwyncatParser.varListElem_return retval = new TwyncatParser.varListElem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token strl=null;
        Token ID99=null;
        Token char_literal102=null;
        Token char_literal103=null;
        Token char_literal104=null;
        Token char_literal105=null;
        TwyncatParser.arrayConstantExpression_return ace = null;

        TwyncatParser.test_return t = null;

        TwyncatParser.trailer_return trailer100 = null;

        TwyncatParser.arrayModifier_return arrayModifier101 = null;


        Object strl_tree=null;
        Object ID99_tree=null;
        Object char_literal102_tree=null;
        Object char_literal103_tree=null;
        Object char_literal104_tree=null;
        Object char_literal105_tree=null;

         StringBuilder sb = new StringBuilder(); StringBuilder sbVar = new StringBuilder(); StringBuilder sbInit = new StringBuilder(); boolean init = false; 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:466:2: ( ID ( trailer )? ( arrayModifier ( '=' ace= arrayConstantExpression )? | ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )? )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:466:4: ID ( trailer )? ( arrayModifier ( '=' ace= arrayConstantExpression )? | ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )?
            {
            root_0 = (Object)adaptor.nil();

            ID99=(Token)match(input,ID,FOLLOW_ID_in_varListElem1293); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID99_tree = (Object)adaptor.create(ID99);
            adaptor.addChild(root_0, ID99_tree);
            }
            if ( state.backtracking==0 ) {
               sb.append((ID99!=null?ID99.getText():null)); sbVar.append((ID99!=null?ID99.getText():null)); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:466:56: ( trailer )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==DOT) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:466:57: trailer
                    {
                    pushFollow(FOLLOW_trailer_in_varListElem1298);
                    trailer100=trailer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, trailer100.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append((trailer100!=null?trailer100.txt:null)); sbVar.append((trailer100!=null?trailer100.txt:null)); 
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               sbInit.append(sbVar.toString()); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:467:2: ( arrayModifier ( '=' ace= arrayConstantExpression )? | ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )?
            int alt38=3;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:467:4: arrayModifier ( '=' ace= arrayConstantExpression )?
                    {
                    if ( state.backtracking==0 ) {
                       sb.append(" ARRAY"); 
                    }
                    pushFollow(FOLLOW_arrayModifier_in_varListElem1311);
                    arrayModifier101=arrayModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayModifier101.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append((arrayModifier101!=null?arrayModifier101.txt:null)); sb.append(" OF " + vType); sbVar.append("[]"); 
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:467:126: ( '=' ace= arrayConstantExpression )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==ASSIGN) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:467:127: '=' ace= arrayConstantExpression
                            {
                            char_literal102=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_varListElem1316); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal102_tree = (Object)adaptor.create(char_literal102);
                            adaptor.addChild(root_0, char_literal102_tree);
                            }
                            pushFollow(FOLLOW_arrayConstantExpression_in_varListElem1320);
                            ace=arrayConstantExpression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, ace.getTree());
                            if ( state.backtracking==0 ) {
                               sb.append(" := " + (ace!=null?ace.txt:null)); 
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:4: ( '[' strl= DECIMALL ']' )? ( '=' t= test )?
                    {
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:4: ( '[' strl= DECIMALL ']' )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==LBRACK) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:6: '[' strl= DECIMALL ']'
                            {
                            char_literal103=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_varListElem1333); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal103_tree = (Object)adaptor.create(char_literal103);
                            adaptor.addChild(root_0, char_literal103_tree);
                            }
                            strl=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_varListElem1337); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            strl_tree = (Object)adaptor.create(strl);
                            adaptor.addChild(root_0, strl_tree);
                            }
                            char_literal104=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_varListElem1339); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal104_tree = (Object)adaptor.create(char_literal104);
                            adaptor.addChild(root_0, char_literal104_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:31: ( '=' t= test )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==ASSIGN) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:32: '=' t= test
                            {
                            char_literal105=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_varListElem1345); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal105_tree = (Object)adaptor.create(char_literal105);
                            adaptor.addChild(root_0, char_literal105_tree);
                            }
                            pushFollow(FOLLOW_test_in_varListElem1349);
                            t=test();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                            if ( state.backtracking==0 ) {
                               init = true; 
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       sb.append(" : " + vType + (strl == null?"":"("+(strl!=null?strl.getText():null)+")")); sbInit.append((t == null?"":" := " + (t!=null?t.txt:null))); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString() + ";"; retval.initialization = (init?sbInit.toString():null); if(isLocal){ declareLocal(currentBlock,sbVar.toString(),vType); } else { declare(currentBlock + "." + sbVar.toString(),vType); } 
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "varListElem"

    public static class arrayModifier_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayModifier"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:471:1: arrayModifier returns [ String txt ] : ( ( LBRACK arrayRange RBRACK ) | ( LBRACK first= arrayRange RBRACK ) ( LBRACK second= arrayRange RBRACK ) | ( LBRACK first= arrayRange RBRACK ) ( LBRACK second= arrayRange RBRACK ) ( LBRACK third= arrayRange RBRACK ) );
    public final TwyncatParser.arrayModifier_return arrayModifier() throws RecognitionException {
        TwyncatParser.arrayModifier_return retval = new TwyncatParser.arrayModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBRACK106=null;
        Token RBRACK108=null;
        Token LBRACK109=null;
        Token RBRACK110=null;
        Token LBRACK111=null;
        Token RBRACK112=null;
        Token LBRACK113=null;
        Token RBRACK114=null;
        Token LBRACK115=null;
        Token RBRACK116=null;
        Token LBRACK117=null;
        Token RBRACK118=null;
        TwyncatParser.arrayRange_return first = null;

        TwyncatParser.arrayRange_return second = null;

        TwyncatParser.arrayRange_return third = null;

        TwyncatParser.arrayRange_return arrayRange107 = null;


        Object LBRACK106_tree=null;
        Object RBRACK108_tree=null;
        Object LBRACK109_tree=null;
        Object RBRACK110_tree=null;
        Object LBRACK111_tree=null;
        Object RBRACK112_tree=null;
        Object LBRACK113_tree=null;
        Object RBRACK114_tree=null;
        Object LBRACK115_tree=null;
        Object RBRACK116_tree=null;
        Object LBRACK117_tree=null;
        Object RBRACK118_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:472:2: ( ( LBRACK arrayRange RBRACK ) | ( LBRACK first= arrayRange RBRACK ) ( LBRACK second= arrayRange RBRACK ) | ( LBRACK first= arrayRange RBRACK ) ( LBRACK second= arrayRange RBRACK ) ( LBRACK third= arrayRange RBRACK ) )
            int alt39=3;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:472:4: ( LBRACK arrayRange RBRACK )
                    {
                    root_0 = (Object)adaptor.nil();

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:472:4: ( LBRACK arrayRange RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:472:6: LBRACK arrayRange RBRACK
                    {
                    LBRACK106=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifier1375); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK106_tree = (Object)adaptor.create(LBRACK106);
                    adaptor.addChild(root_0, LBRACK106_tree);
                    }
                    pushFollow(FOLLOW_arrayRange_in_arrayModifier1377);
                    arrayRange107=arrayRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayRange107.getTree());
                    RBRACK108=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifier1379); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK108_tree = (Object)adaptor.create(RBRACK108);
                    adaptor.addChild(root_0, RBRACK108_tree);
                    }

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = "[ " + (arrayRange107!=null?arrayRange107.txt:null) + " ]"; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:474:4: ( LBRACK first= arrayRange RBRACK ) ( LBRACK second= arrayRange RBRACK )
                    {
                    root_0 = (Object)adaptor.nil();

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:474:4: ( LBRACK first= arrayRange RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:474:6: LBRACK first= arrayRange RBRACK
                    {
                    LBRACK109=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifier1391); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK109_tree = (Object)adaptor.create(LBRACK109);
                    adaptor.addChild(root_0, LBRACK109_tree);
                    }
                    pushFollow(FOLLOW_arrayRange_in_arrayModifier1395);
                    first=arrayRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, first.getTree());
                    RBRACK110=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifier1397); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK110_tree = (Object)adaptor.create(RBRACK110);
                    adaptor.addChild(root_0, RBRACK110_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:474:39: ( LBRACK second= arrayRange RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:474:41: LBRACK second= arrayRange RBRACK
                    {
                    LBRACK111=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifier1403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK111_tree = (Object)adaptor.create(LBRACK111);
                    adaptor.addChild(root_0, LBRACK111_tree);
                    }
                    pushFollow(FOLLOW_arrayRange_in_arrayModifier1407);
                    second=arrayRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, second.getTree());
                    RBRACK112=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifier1409); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK112_tree = (Object)adaptor.create(RBRACK112);
                    adaptor.addChild(root_0, RBRACK112_tree);
                    }

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = "[ " + (first!=null?first.txt:null) + ", " + (second!=null?second.txt:null) + " ]";	
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:476:4: ( LBRACK first= arrayRange RBRACK ) ( LBRACK second= arrayRange RBRACK ) ( LBRACK third= arrayRange RBRACK )
                    {
                    root_0 = (Object)adaptor.nil();

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:476:4: ( LBRACK first= arrayRange RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:476:6: LBRACK first= arrayRange RBRACK
                    {
                    LBRACK113=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifier1421); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK113_tree = (Object)adaptor.create(LBRACK113);
                    adaptor.addChild(root_0, LBRACK113_tree);
                    }
                    pushFollow(FOLLOW_arrayRange_in_arrayModifier1425);
                    first=arrayRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, first.getTree());
                    RBRACK114=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifier1427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK114_tree = (Object)adaptor.create(RBRACK114);
                    adaptor.addChild(root_0, RBRACK114_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:476:39: ( LBRACK second= arrayRange RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:476:41: LBRACK second= arrayRange RBRACK
                    {
                    LBRACK115=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifier1433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK115_tree = (Object)adaptor.create(LBRACK115);
                    adaptor.addChild(root_0, LBRACK115_tree);
                    }
                    pushFollow(FOLLOW_arrayRange_in_arrayModifier1437);
                    second=arrayRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, second.getTree());
                    RBRACK116=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifier1439); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK116_tree = (Object)adaptor.create(RBRACK116);
                    adaptor.addChild(root_0, RBRACK116_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:476:75: ( LBRACK third= arrayRange RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:476:77: LBRACK third= arrayRange RBRACK
                    {
                    LBRACK117=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifier1445); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK117_tree = (Object)adaptor.create(LBRACK117);
                    adaptor.addChild(root_0, LBRACK117_tree);
                    }
                    pushFollow(FOLLOW_arrayRange_in_arrayModifier1449);
                    third=arrayRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, third.getTree());
                    RBRACK118=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifier1451); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK118_tree = (Object)adaptor.create(RBRACK118);
                    adaptor.addChild(root_0, RBRACK118_tree);
                    }

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = "[ " + (first!=null?first.txt:null) + ", " + (second!=null?second.txt:null) + ", " + (third!=null?third.txt:null) + " ]"; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayModifier"

    public static class arrayRange_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayRange"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:480:1: arrayRange returns [ String txt ] : l= DECIMALL ':' h= DECIMALL ;
    public final TwyncatParser.arrayRange_return arrayRange() throws RecognitionException {
        TwyncatParser.arrayRange_return retval = new TwyncatParser.arrayRange_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token l=null;
        Token h=null;
        Token char_literal119=null;

        Object l_tree=null;
        Object h_tree=null;
        Object char_literal119_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:481:2: (l= DECIMALL ':' h= DECIMALL )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:481:4: l= DECIMALL ':' h= DECIMALL
            {
            root_0 = (Object)adaptor.nil();

            l=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_arrayRange1473); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            l_tree = (Object)adaptor.create(l);
            adaptor.addChild(root_0, l_tree);
            }
            char_literal119=(Token)match(input,COLON,FOLLOW_COLON_in_arrayRange1475); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal119_tree = (Object)adaptor.create(char_literal119);
            adaptor.addChild(root_0, char_literal119_tree);
            }
            h=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_arrayRange1479); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            h_tree = (Object)adaptor.create(h);
            adaptor.addChild(root_0, h_tree);
            }
            if ( state.backtracking==0 ) {
               retval.txt = (l!=null?l.getText():null) + ".." + (h!=null?h.getText():null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayRange"

    public static class arrayConstantExpression_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayConstantExpression"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:485:1: arrayConstantExpression returns [ String txt ] : ( ( LBRACK literalsList RBRACK ) | ( LBRACK first= literalsList RBRACK ) ( LBRACK second= literalsList RBRACK ) | ( LBRACK first= literalsList RBRACK ) ( LBRACK second= literalsList RBRACK ) ( LBRACK third= literalsList RBRACK ) );
    public final TwyncatParser.arrayConstantExpression_return arrayConstantExpression() throws RecognitionException {
        TwyncatParser.arrayConstantExpression_return retval = new TwyncatParser.arrayConstantExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBRACK120=null;
        Token RBRACK122=null;
        Token LBRACK123=null;
        Token RBRACK124=null;
        Token LBRACK125=null;
        Token RBRACK126=null;
        Token LBRACK127=null;
        Token RBRACK128=null;
        Token LBRACK129=null;
        Token RBRACK130=null;
        Token LBRACK131=null;
        Token RBRACK132=null;
        TwyncatParser.literalsList_return first = null;

        TwyncatParser.literalsList_return second = null;

        TwyncatParser.literalsList_return third = null;

        TwyncatParser.literalsList_return literalsList121 = null;


        Object LBRACK120_tree=null;
        Object RBRACK122_tree=null;
        Object LBRACK123_tree=null;
        Object RBRACK124_tree=null;
        Object LBRACK125_tree=null;
        Object RBRACK126_tree=null;
        Object LBRACK127_tree=null;
        Object RBRACK128_tree=null;
        Object LBRACK129_tree=null;
        Object RBRACK130_tree=null;
        Object LBRACK131_tree=null;
        Object RBRACK132_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:486:2: ( ( LBRACK literalsList RBRACK ) | ( LBRACK first= literalsList RBRACK ) ( LBRACK second= literalsList RBRACK ) | ( LBRACK first= literalsList RBRACK ) ( LBRACK second= literalsList RBRACK ) ( LBRACK third= literalsList RBRACK ) )
            int alt40=3;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==LBRACK) ) {
                int LA40_1 = input.LA(2);

                if ( (synpred73_twyncat()) ) {
                    alt40=1;
                }
                else if ( (synpred74_twyncat()) ) {
                    alt40=2;
                }
                else if ( (true) ) {
                    alt40=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:486:4: ( LBRACK literalsList RBRACK )
                    {
                    root_0 = (Object)adaptor.nil();

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:486:4: ( LBRACK literalsList RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:486:6: LBRACK literalsList RBRACK
                    {
                    LBRACK120=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayConstantExpression1500); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK120_tree = (Object)adaptor.create(LBRACK120);
                    adaptor.addChild(root_0, LBRACK120_tree);
                    }
                    pushFollow(FOLLOW_literalsList_in_arrayConstantExpression1502);
                    literalsList121=literalsList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalsList121.getTree());
                    RBRACK122=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayConstantExpression1504); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK122_tree = (Object)adaptor.create(RBRACK122);
                    adaptor.addChild(root_0, RBRACK122_tree);
                    }

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = (literalsList121!=null?literalsList121.txt:null); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:4: ( LBRACK first= literalsList RBRACK ) ( LBRACK second= literalsList RBRACK )
                    {
                    root_0 = (Object)adaptor.nil();

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:4: ( LBRACK first= literalsList RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:6: LBRACK first= literalsList RBRACK
                    {
                    LBRACK123=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayConstantExpression1516); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK123_tree = (Object)adaptor.create(LBRACK123);
                    adaptor.addChild(root_0, LBRACK123_tree);
                    }
                    pushFollow(FOLLOW_literalsList_in_arrayConstantExpression1520);
                    first=literalsList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, first.getTree());
                    RBRACK124=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayConstantExpression1522); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK124_tree = (Object)adaptor.create(RBRACK124);
                    adaptor.addChild(root_0, RBRACK124_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:41: ( LBRACK second= literalsList RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:43: LBRACK second= literalsList RBRACK
                    {
                    LBRACK125=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayConstantExpression1528); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK125_tree = (Object)adaptor.create(LBRACK125);
                    adaptor.addChild(root_0, LBRACK125_tree);
                    }
                    pushFollow(FOLLOW_literalsList_in_arrayConstantExpression1532);
                    second=literalsList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, second.getTree());
                    RBRACK126=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayConstantExpression1534); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK126_tree = (Object)adaptor.create(RBRACK126);
                    adaptor.addChild(root_0, RBRACK126_tree);
                    }

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = (first!=null?first.txt:null) + ", " + (second!=null?second.txt:null);	
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:490:4: ( LBRACK first= literalsList RBRACK ) ( LBRACK second= literalsList RBRACK ) ( LBRACK third= literalsList RBRACK )
                    {
                    root_0 = (Object)adaptor.nil();

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:490:4: ( LBRACK first= literalsList RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:490:6: LBRACK first= literalsList RBRACK
                    {
                    LBRACK127=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayConstantExpression1546); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK127_tree = (Object)adaptor.create(LBRACK127);
                    adaptor.addChild(root_0, LBRACK127_tree);
                    }
                    pushFollow(FOLLOW_literalsList_in_arrayConstantExpression1550);
                    first=literalsList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, first.getTree());
                    RBRACK128=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayConstantExpression1552); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK128_tree = (Object)adaptor.create(RBRACK128);
                    adaptor.addChild(root_0, RBRACK128_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:490:41: ( LBRACK second= literalsList RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:490:43: LBRACK second= literalsList RBRACK
                    {
                    LBRACK129=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayConstantExpression1558); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK129_tree = (Object)adaptor.create(LBRACK129);
                    adaptor.addChild(root_0, LBRACK129_tree);
                    }
                    pushFollow(FOLLOW_literalsList_in_arrayConstantExpression1562);
                    second=literalsList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, second.getTree());
                    RBRACK130=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayConstantExpression1564); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK130_tree = (Object)adaptor.create(RBRACK130);
                    adaptor.addChild(root_0, RBRACK130_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:490:79: ( LBRACK third= literalsList RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:490:81: LBRACK third= literalsList RBRACK
                    {
                    LBRACK131=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayConstantExpression1570); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK131_tree = (Object)adaptor.create(LBRACK131);
                    adaptor.addChild(root_0, LBRACK131_tree);
                    }
                    pushFollow(FOLLOW_literalsList_in_arrayConstantExpression1574);
                    third=literalsList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, third.getTree());
                    RBRACK132=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayConstantExpression1576); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK132_tree = (Object)adaptor.create(RBRACK132);
                    adaptor.addChild(root_0, RBRACK132_tree);
                    }

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = (first!=null?first.txt:null) + ", " + (second!=null?second.txt:null) + ", " + (third!=null?third.txt:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayConstantExpression"

    public static class literalsList_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literalsList"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:494:1: literalsList returns [ String txt ] : a1= atom ( ',' aN= atom )* ;
    public final TwyncatParser.literalsList_return literalsList() throws RecognitionException {
        TwyncatParser.literalsList_return retval = new TwyncatParser.literalsList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal133=null;
        TwyncatParser.atom_return a1 = null;

        TwyncatParser.atom_return aN = null;


        Object char_literal133_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:497:2: (a1= atom ( ',' aN= atom )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:497:4: a1= atom ( ',' aN= atom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_atom_in_literalsList1608);
            a1=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
            if ( state.backtracking==0 ) {
               sb.append((a1!=null?a1.txt:null)); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:497:36: ( ',' aN= atom )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==COMMA) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:497:38: ',' aN= atom
            	    {
            	    char_literal133=(Token)match(input,COMMA,FOLLOW_COMMA_in_literalsList1614); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal133_tree = (Object)adaptor.create(char_literal133);
            	    adaptor.addChild(root_0, char_literal133_tree);
            	    }
            	    pushFollow(FOLLOW_atom_in_literalsList1618);
            	    aN=atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aN.getTree());
            	    if ( state.backtracking==0 ) {
            	       sb.append(", " + (aN!=null?aN.txt:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString(); 
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "literalsList"

    public static class file_return extends ParserRuleReturnScope {
        public List<String> statements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "file"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:501:1: file returns [ List<String> statements ] : (gs= globalStm )* (fs= function )* ps= program EOF ;
    public final TwyncatParser.file_return file() throws RecognitionException {
        TwyncatParser.file_return retval = new TwyncatParser.file_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF134=null;
        TwyncatParser.globalStm_return gs = null;

        TwyncatParser.function_return fs = null;

        TwyncatParser.program_return ps = null;


        Object EOF134_tree=null;

         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:508:2: ( (gs= globalStm )* (fs= function )* ps= program EOF )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:508:4: (gs= globalStm )* (fs= function )* ps= program EOF
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:508:4: (gs= globalStm )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==93||(LA42_0>=96 && LA42_0<=97)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:508:5: gs= globalStm
            	    {
            	    pushFollow(FOLLOW_globalStm_in_file1651);
            	    gs=globalStm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, gs.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.statements.addAll((gs!=null?gs.statements:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:509:2: (fs= function )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==91) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:509:3: fs= function
            	    {
            	    pushFollow(FOLLOW_function_in_file1662);
            	    fs=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fs.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.statements.addAll((fs!=null?fs.statements:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            pushFollow(FOLLOW_program_in_file1673);
            ps=program();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ps.getTree());
            if ( state.backtracking==0 ) {
               retval.statements.addAll((ps!=null?ps.statements:null)); 
            }
            EOF134=(Token)match(input,EOF,FOLLOW_EOF_in_file1677); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF134_tree = (Object)adaptor.create(EOF134);
            adaptor.addChild(root_0, EOF134_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              	
              	for(String s : retval.statements){
              		System.out.println(s);
              	}
              	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "file"

    public static class statement_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:513:1: statement returns [ List<String> statements, VariablesBundle vbund ] : ( simpleStm | compoundStm );
    public final TwyncatParser.statement_return statement() throws RecognitionException {
        TwyncatParser.statement_return retval = new TwyncatParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TwyncatParser.simpleStm_return simpleStm135 = null;

        TwyncatParser.compoundStm_return compoundStm136 = null;



        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:514:2: ( simpleStm | compoundStm )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==ID||LA44_0==DECIMALL||(LA44_0>=HEXDIGITS && LA44_0<=CHARACTERL)||LA44_0==LPAREN||(LA44_0>=PLUS && LA44_0<=MINUS)||(LA44_0>=68 && LA44_0<=89)||(LA44_0>=98 && LA44_0<=105)||LA44_0==113||(LA44_0>=117 && LA44_0<=118)||(LA44_0>=124 && LA44_0<=127)) ) {
                alt44=1;
            }
            else if ( (LA44_0==106||LA44_0==109||(LA44_0>=111 && LA44_0<=112)) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:514:4: simpleStm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simpleStm_in_statement1692);
                    simpleStm135=simpleStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleStm135.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements = (simpleStm135!=null?simpleStm135.statements:null); retval.vbund = (simpleStm135!=null?simpleStm135.vbund:null); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:515:4: compoundStm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_compoundStm_in_statement1699);
                    compoundStm136=compoundStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, compoundStm136.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements = (compoundStm136!=null?compoundStm136.statements:null); retval.vbund = (compoundStm136!=null?compoundStm136.vbund:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class globalStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "globalStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:518:1: globalStm returns [ List<String> statements ] : smallGlobalStm ( SEMI )? NEWLINE ;
    public final TwyncatParser.globalStm_return globalStm() throws RecognitionException {
        TwyncatParser.globalStm_return retval = new TwyncatParser.globalStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMI138=null;
        Token NEWLINE139=null;
        TwyncatParser.smallGlobalStm_return smallGlobalStm137 = null;


        Object SEMI138_tree=null;
        Object NEWLINE139_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:519:2: ( smallGlobalStm ( SEMI )? NEWLINE )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:519:4: smallGlobalStm ( SEMI )? NEWLINE
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_smallGlobalStm_in_globalStm1716);
            smallGlobalStm137=smallGlobalStm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, smallGlobalStm137.getTree());
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:519:19: ( SEMI )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==SEMI) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:519:20: SEMI
                    {
                    SEMI138=(Token)match(input,SEMI,FOLLOW_SEMI_in_globalStm1719); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMI138_tree = (Object)adaptor.create(SEMI138);
                    adaptor.addChild(root_0, SEMI138_tree);
                    }

                    }
                    break;

            }

            NEWLINE139=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_globalStm1723); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NEWLINE139_tree = (Object)adaptor.create(NEWLINE139);
            adaptor.addChild(root_0, NEWLINE139_tree);
            }
            if ( state.backtracking==0 ) {
               retval.statements = (smallGlobalStm137!=null?smallGlobalStm137.statements:null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "globalStm"

    public static class smallGlobalStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "smallGlobalStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:523:1: smallGlobalStm returns [ List<String> statements ] : ( alias | enumeration | structure );
    public final TwyncatParser.smallGlobalStm_return smallGlobalStm() throws RecognitionException {
        TwyncatParser.smallGlobalStm_return retval = new TwyncatParser.smallGlobalStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TwyncatParser.alias_return alias140 = null;

        TwyncatParser.enumeration_return enumeration141 = null;

        TwyncatParser.structure_return structure142 = null;



         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:525:2: ( alias | enumeration | structure )
            int alt46=3;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt46=1;
                }
                break;
            case 96:
                {
                alt46=2;
                }
                break;
            case 97:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:525:4: alias
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_alias_in_smallGlobalStm1746);
                    alias140=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, alias140.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements.add((alias140!=null?alias140.txt:null)); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:527:4: enumeration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumeration_in_smallGlobalStm1755);
                    enumeration141=enumeration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumeration141.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements.add((enumeration141!=null?enumeration141.txt:null)); 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:529:4: structure
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structure_in_smallGlobalStm1764);
                    structure142=structure();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structure142.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements.addAll((structure142!=null?structure142.statements:null)); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "smallGlobalStm"

    public static class simpleStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simpleStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:532:1: simpleStm returns [ List<String> statements, VariablesBundle vbund ] : smallStm ( SEMI )? NEWLINE ;
    public final TwyncatParser.simpleStm_return simpleStm() throws RecognitionException {
        TwyncatParser.simpleStm_return retval = new TwyncatParser.simpleStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMI144=null;
        Token NEWLINE145=null;
        TwyncatParser.smallStm_return smallStm143 = null;


        Object SEMI144_tree=null;
        Object NEWLINE145_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:533:2: ( smallStm ( SEMI )? NEWLINE )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:533:4: smallStm ( SEMI )? NEWLINE
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_smallStm_in_simpleStm1781);
            smallStm143=smallStm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, smallStm143.getTree());
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:533:13: ( SEMI )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==SEMI) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:533:14: SEMI
                    {
                    SEMI144=(Token)match(input,SEMI,FOLLOW_SEMI_in_simpleStm1784); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMI144_tree = (Object)adaptor.create(SEMI144);
                    adaptor.addChild(root_0, SEMI144_tree);
                    }

                    }
                    break;

            }

            NEWLINE145=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_simpleStm1788); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NEWLINE145_tree = (Object)adaptor.create(NEWLINE145);
            adaptor.addChild(root_0, NEWLINE145_tree);
            }
            if ( state.backtracking==0 ) {
               retval.statements = (smallStm143!=null?smallStm143.statements:null); retval.vbund = (smallStm143!=null?smallStm143.vbund:null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "simpleStm"

    public static class smallStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "smallStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:537:1: smallStm returns [ List<String> statements, VariablesBundle vbund ] : ( exprStm | flowStm | repeatUntilStm | d= definition );
    public final TwyncatParser.smallStm_return smallStm() throws RecognitionException {
        TwyncatParser.smallStm_return retval = new TwyncatParser.smallStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TwyncatParser.definition_return d = null;

        TwyncatParser.exprStm_return exprStm146 = null;

        TwyncatParser.flowStm_return flowStm147 = null;

        TwyncatParser.repeatUntilStm_return repeatUntilStm148 = null;



         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:539:2: ( exprStm | flowStm | repeatUntilStm | d= definition )
            int alt48=4;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:539:4: exprStm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exprStm_in_smallStm1811);
                    exprStm146=exprStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exprStm146.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements.add((exprStm146!=null?exprStm146.txt:null)); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:540:4: flowStm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_flowStm_in_smallStm1818);
                    flowStm147=flowStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, flowStm147.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements.add((flowStm147!=null?flowStm147.txt:null)); 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:541:4: repeatUntilStm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_repeatUntilStm_in_smallStm1825);
                    repeatUntilStm148=repeatUntilStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeatUntilStm148.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements.addAll((repeatUntilStm148!=null?repeatUntilStm148.statements:null)); retval.vbund = (repeatUntilStm148!=null?repeatUntilStm148.vbund:null); 
                    }

                    }
                    break;
                case 4 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:543:4: d= definition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_definition_in_smallStm1836);
                    d=definition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements.addAll((d!=null?d.statements:null)); retval.vbund = (d!=null?d.vbund:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "smallStm"

    public static class exprStm_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exprStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:546:1: exprStm returns [ String txt ] : (t1= test augAssign t2= test | t3= test '=' t4= test );
    public final TwyncatParser.exprStm_return exprStm() throws RecognitionException {
        TwyncatParser.exprStm_return retval = new TwyncatParser.exprStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal150=null;
        TwyncatParser.test_return t1 = null;

        TwyncatParser.test_return t2 = null;

        TwyncatParser.test_return t3 = null;

        TwyncatParser.test_return t4 = null;

        TwyncatParser.augAssign_return augAssign149 = null;


        Object char_literal150_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:547:2: (t1= test augAssign t2= test | t3= test '=' t4= test )
            int alt49=2;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:547:4: t1= test augAssign t2= test
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_test_in_exprStm1855);
                    t1=test();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
                    pushFollow(FOLLOW_augAssign_in_exprStm1857);
                    augAssign149=augAssign();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, augAssign149.getTree());
                    pushFollow(FOLLOW_test_in_exprStm1861);
                    t2=test();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t2.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (t1!=null?t1.txt:null) + " := " + (t1!=null?t1.txt:null) + (augAssign149!=null?augAssign149.txt:null) + (t2!=null?t2.txt:null) + ";"; checkType((t1!=null?t1.dType:null),(t2!=null?t2.dType:null)); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:548:4: t3= test '=' t4= test
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_test_in_exprStm1870);
                    t3=test();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t3.getTree());
                    char_literal150=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_exprStm1872); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal150_tree = (Object)adaptor.create(char_literal150);
                    adaptor.addChild(root_0, char_literal150_tree);
                    }
                    pushFollow(FOLLOW_test_in_exprStm1876);
                    t4=test();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t4.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (t3!=null?t3.txt:null) + " := " + (t4!=null?t4.txt:null) + ";"; checkType((t3!=null?t3.dType:null),(t4!=null?t4.dType:null)); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "exprStm"

    public static class augAssign_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "augAssign"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:551:1: augAssign returns [ String txt ] : ( '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=' );
    public final TwyncatParser.augAssign_return augAssign() throws RecognitionException {
        TwyncatParser.augAssign_return retval = new TwyncatParser.augAssign_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal151=null;
        Token string_literal152=null;
        Token string_literal153=null;
        Token string_literal154=null;
        Token string_literal155=null;
        Token string_literal156=null;
        Token string_literal157=null;

        Object string_literal151_tree=null;
        Object string_literal152_tree=null;
        Object string_literal153_tree=null;
        Object string_literal154_tree=null;
        Object string_literal155_tree=null;
        Object string_literal156_tree=null;
        Object string_literal157_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:552:2: ( '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=' )
            int alt50=7;
            switch ( input.LA(1) ) {
            case PLUSEQUAL:
                {
                alt50=1;
                }
                break;
            case MINUSEQUAL:
                {
                alt50=2;
                }
                break;
            case STAREQUAL:
                {
                alt50=3;
                }
                break;
            case SLASHEQUAL:
                {
                alt50=4;
                }
                break;
            case PERCENTEQUAL:
                {
                alt50=5;
                }
                break;
            case ANDEQUAL:
                {
                alt50=6;
                }
                break;
            case OREQUAL:
                {
                alt50=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:552:4: '+='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal151=(Token)match(input,PLUSEQUAL,FOLLOW_PLUSEQUAL_in_augAssign1894); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal151_tree = (Object)adaptor.create(string_literal151);
                    adaptor.addChild(root_0, string_literal151_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = " + "; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:553:4: '-='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal152=(Token)match(input,MINUSEQUAL,FOLLOW_MINUSEQUAL_in_augAssign1901); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal152_tree = (Object)adaptor.create(string_literal152);
                    adaptor.addChild(root_0, string_literal152_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = " - "; 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:554:4: '*='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal153=(Token)match(input,STAREQUAL,FOLLOW_STAREQUAL_in_augAssign1908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal153_tree = (Object)adaptor.create(string_literal153);
                    adaptor.addChild(root_0, string_literal153_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = " * "; 
                    }

                    }
                    break;
                case 4 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:555:4: '/='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal154=(Token)match(input,SLASHEQUAL,FOLLOW_SLASHEQUAL_in_augAssign1915); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal154_tree = (Object)adaptor.create(string_literal154);
                    adaptor.addChild(root_0, string_literal154_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = " / "; 
                    }

                    }
                    break;
                case 5 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:556:4: '%='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal155=(Token)match(input,PERCENTEQUAL,FOLLOW_PERCENTEQUAL_in_augAssign1922); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal155_tree = (Object)adaptor.create(string_literal155);
                    adaptor.addChild(root_0, string_literal155_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = " MOD "; 
                    }

                    }
                    break;
                case 6 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:557:4: '&='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal156=(Token)match(input,ANDEQUAL,FOLLOW_ANDEQUAL_in_augAssign1929); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal156_tree = (Object)adaptor.create(string_literal156);
                    adaptor.addChild(root_0, string_literal156_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = " AND "; 
                    }

                    }
                    break;
                case 7 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:558:4: '|='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal157=(Token)match(input,OREQUAL,FOLLOW_OREQUAL_in_augAssign1936); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal157_tree = (Object)adaptor.create(string_literal157);
                    adaptor.addChild(root_0, string_literal157_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = " OR "; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "augAssign"

    public static class flowStm_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "flowStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:561:1: flowStm returns [ String txt ] : ( 'return' | 'exit' | callFunc | callFuncBlock );
    public final TwyncatParser.flowStm_return flowStm() throws RecognitionException {
        TwyncatParser.flowStm_return retval = new TwyncatParser.flowStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal158=null;
        Token string_literal159=null;
        TwyncatParser.callFunc_return callFunc160 = null;

        TwyncatParser.callFuncBlock_return callFuncBlock161 = null;


        Object string_literal158_tree=null;
        Object string_literal159_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:562:2: ( 'return' | 'exit' | callFunc | callFuncBlock )
            int alt51=4;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:562:4: 'return'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal158=(Token)match(input,104,FOLLOW_104_in_flowStm1954); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal158_tree = (Object)adaptor.create(string_literal158);
                    adaptor.addChild(root_0, string_literal158_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "RETURN" + ";"; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:563:4: 'exit'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal159=(Token)match(input,105,FOLLOW_105_in_flowStm1961); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal159_tree = (Object)adaptor.create(string_literal159);
                    adaptor.addChild(root_0, string_literal159_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "EXIT" + ";"; 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:564:4: callFunc
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_callFunc_in_flowStm1968);
                    callFunc160=callFunc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, callFunc160.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (callFunc160!=null?callFunc160.txt:null); 
                    }

                    }
                    break;
                case 4 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:565:4: callFuncBlock
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_callFuncBlock_in_flowStm1975);
                    callFuncBlock161=callFuncBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, callFuncBlock161.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (callFuncBlock161!=null?callFuncBlock161.txt:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "flowStm"

    public static class compoundStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compoundStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:568:1: compoundStm returns [ List<String> statements, VariablesBundle vbund ] : ( ifStm | caseStm | forStm | whileStm );
    public final TwyncatParser.compoundStm_return compoundStm() throws RecognitionException {
        TwyncatParser.compoundStm_return retval = new TwyncatParser.compoundStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TwyncatParser.ifStm_return ifStm162 = null;

        TwyncatParser.caseStm_return caseStm163 = null;

        TwyncatParser.forStm_return forStm164 = null;

        TwyncatParser.whileStm_return whileStm165 = null;



        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:569:2: ( ifStm | caseStm | forStm | whileStm )
            int alt52=4;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt52=1;
                }
                break;
            case 109:
                {
                alt52=2;
                }
                break;
            case 111:
                {
                alt52=3;
                }
                break;
            case 112:
                {
                alt52=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:569:4: ifStm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ifStm_in_compoundStm1993);
                    ifStm162=ifStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStm162.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements = (ifStm162!=null?ifStm162.statements:null); retval.vbund = (ifStm162!=null?ifStm162.vbund:null); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:570:4: caseStm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_caseStm_in_compoundStm2000);
                    caseStm163=caseStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, caseStm163.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements = (caseStm163!=null?caseStm163.statements:null); retval.vbund = (caseStm163!=null?caseStm163.vbund:null); 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:571:4: forStm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forStm_in_compoundStm2007);
                    forStm164=forStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStm164.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements = (forStm164!=null?forStm164.statements:null); retval.vbund = (forStm164!=null?forStm164.vbund:null); 
                    }

                    }
                    break;
                case 4 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:572:4: whileStm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_whileStm_in_compoundStm2014);
                    whileStm165=whileStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStm165.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements = (whileStm165!=null?whileStm165.statements:null); retval.vbund = (whileStm165!=null?whileStm165.vbund:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "compoundStm"

    public static class ifStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:575:1: ifStm returns [ List<String> statements, VariablesBundle vbund ] : 'if' test COLON cb= codeBlock (ec= elifClause )* ( 'else' COLON cbE= codeBlock )? ;
    public final TwyncatParser.ifStm_return ifStm() throws RecognitionException {
        TwyncatParser.ifStm_return retval = new TwyncatParser.ifStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal166=null;
        Token COLON168=null;
        Token string_literal169=null;
        Token COLON170=null;
        TwyncatParser.codeBlock_return cb = null;

        TwyncatParser.elifClause_return ec = null;

        TwyncatParser.codeBlock_return cbE = null;

        TwyncatParser.test_return test167 = null;


        Object string_literal166_tree=null;
        Object COLON168_tree=null;
        Object string_literal169_tree=null;
        Object COLON170_tree=null;

         retval.statements = new LinkedList<String>(); retval.vbund = new VariablesBundle(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:577:2: ( 'if' test COLON cb= codeBlock (ec= elifClause )* ( 'else' COLON cbE= codeBlock )? )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:577:4: 'if' test COLON cb= codeBlock (ec= elifClause )* ( 'else' COLON cbE= codeBlock )?
            {
            root_0 = (Object)adaptor.nil();

            string_literal166=(Token)match(input,106,FOLLOW_106_in_ifStm2036); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal166_tree = (Object)adaptor.create(string_literal166);
            adaptor.addChild(root_0, string_literal166_tree);
            }
            pushFollow(FOLLOW_test_in_ifStm2038);
            test167=test();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, test167.getTree());
            COLON168=(Token)match(input,COLON,FOLLOW_COLON_in_ifStm2040); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON168_tree = (Object)adaptor.create(COLON168);
            adaptor.addChild(root_0, COLON168_tree);
            }
            pushFollow(FOLLOW_codeBlock_in_ifStm2044);
            cb=codeBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, cb.getTree());
            if ( state.backtracking==0 ) {
               retval.statements.add("IF " + (test167!=null?test167.txt:null) + " THEN"); retval.statements.addAll((cb!=null?cb.statements:null)); retval.vbund.addAll((cb!=null?cb.vbund:null)); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:577:145: (ec= elifClause )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==108) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:577:146: ec= elifClause
            	    {
            	    pushFollow(FOLLOW_elifClause_in_ifStm2051);
            	    ec=elifClause();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ec.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.statements.addAll((ec!=null?ec.statements:null)); retval.vbund.addAll((cb!=null?cb.vbund:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:578:2: ( 'else' COLON cbE= codeBlock )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==107) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:578:3: 'else' COLON cbE= codeBlock
                    {
                    string_literal169=(Token)match(input,107,FOLLOW_107_in_ifStm2060); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal169_tree = (Object)adaptor.create(string_literal169);
                    adaptor.addChild(root_0, string_literal169_tree);
                    }
                    COLON170=(Token)match(input,COLON,FOLLOW_COLON_in_ifStm2062); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLON170_tree = (Object)adaptor.create(COLON170);
                    adaptor.addChild(root_0, COLON170_tree);
                    }
                    pushFollow(FOLLOW_codeBlock_in_ifStm2066);
                    cbE=codeBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cbE.getTree());
                    if ( state.backtracking==0 ) {
                       retval.statements.add("ELSE"); retval.statements.addAll((cbE!=null?cbE.statements:null)); retval.vbund.addAll((cbE!=null?cbE.vbund:null)); retval.statements.add("END_IF;"); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifStm"

    public static class elifClause_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elifClause"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:581:1: elifClause returns [ List<String> statements, VariablesBundle vbund ] : 'elif' test COLON cb= codeBlock ;
    public final TwyncatParser.elifClause_return elifClause() throws RecognitionException {
        TwyncatParser.elifClause_return retval = new TwyncatParser.elifClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal171=null;
        Token COLON173=null;
        TwyncatParser.codeBlock_return cb = null;

        TwyncatParser.test_return test172 = null;


        Object string_literal171_tree=null;
        Object COLON173_tree=null;

         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:583:2: ( 'elif' test COLON cb= codeBlock )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:583:4: 'elif' test COLON cb= codeBlock
            {
            root_0 = (Object)adaptor.nil();

            string_literal171=(Token)match(input,108,FOLLOW_108_in_elifClause2091); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal171_tree = (Object)adaptor.create(string_literal171);
            adaptor.addChild(root_0, string_literal171_tree);
            }
            pushFollow(FOLLOW_test_in_elifClause2093);
            test172=test();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, test172.getTree());
            COLON173=(Token)match(input,COLON,FOLLOW_COLON_in_elifClause2095); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON173_tree = (Object)adaptor.create(COLON173);
            adaptor.addChild(root_0, COLON173_tree);
            }
            pushFollow(FOLLOW_codeBlock_in_elifClause2099);
            cb=codeBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, cb.getTree());
            if ( state.backtracking==0 ) {
               retval.statements.add("ELSIF " + (test172!=null?test172.txt:null) + " THEN"); retval.statements.addAll((cb!=null?cb.statements:null)); retval.vbund = (cb!=null?cb.vbund:null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "elifClause"

    public static class caseStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "caseStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:586:1: caseStm returns [ List<String> statements, VariablesBundle vbund ] : 'case' test COLON NEWLINE INDENT caseElementsStm DEDENT ;
    public final TwyncatParser.caseStm_return caseStm() throws RecognitionException {
        TwyncatParser.caseStm_return retval = new TwyncatParser.caseStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal174=null;
        Token COLON176=null;
        Token NEWLINE177=null;
        Token INDENT178=null;
        Token DEDENT180=null;
        TwyncatParser.test_return test175 = null;

        TwyncatParser.caseElementsStm_return caseElementsStm179 = null;


        Object string_literal174_tree=null;
        Object COLON176_tree=null;
        Object NEWLINE177_tree=null;
        Object INDENT178_tree=null;
        Object DEDENT180_tree=null;

         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:588:2: ( 'case' test COLON NEWLINE INDENT caseElementsStm DEDENT )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:588:4: 'case' test COLON NEWLINE INDENT caseElementsStm DEDENT
            {
            root_0 = (Object)adaptor.nil();

            string_literal174=(Token)match(input,109,FOLLOW_109_in_caseStm2121); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal174_tree = (Object)adaptor.create(string_literal174);
            adaptor.addChild(root_0, string_literal174_tree);
            }
            pushFollow(FOLLOW_test_in_caseStm2123);
            test175=test();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, test175.getTree());
            COLON176=(Token)match(input,COLON,FOLLOW_COLON_in_caseStm2125); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON176_tree = (Object)adaptor.create(COLON176);
            adaptor.addChild(root_0, COLON176_tree);
            }
            NEWLINE177=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_caseStm2127); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NEWLINE177_tree = (Object)adaptor.create(NEWLINE177);
            adaptor.addChild(root_0, NEWLINE177_tree);
            }
            INDENT178=(Token)match(input,INDENT,FOLLOW_INDENT_in_caseStm2129); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INDENT178_tree = (Object)adaptor.create(INDENT178);
            adaptor.addChild(root_0, INDENT178_tree);
            }
            pushFollow(FOLLOW_caseElementsStm_in_caseStm2131);
            caseElementsStm179=caseElementsStm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, caseElementsStm179.getTree());
            DEDENT180=(Token)match(input,DEDENT,FOLLOW_DEDENT_in_caseStm2133); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEDENT180_tree = (Object)adaptor.create(DEDENT180);
            adaptor.addChild(root_0, DEDENT180_tree);
            }
            if ( state.backtracking==0 ) {

              	retval.statements.add("CASE " + (test175!=null?test175.txt:null) + " OF");
              	retval.statements.addAll((caseElementsStm179!=null?caseElementsStm179.statements:null)); retval.vbund = (caseElementsStm179!=null?caseElementsStm179.vbund:null);
              	retval.statements.add("END_CASE;");
              	
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseStm"

    public static class caseElementsStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "caseElementsStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:596:1: caseElementsStm returns [ List<String> statements, VariablesBundle vbund ] : ( test COLON cbN= codeBlock )+ 'default' COLON cbd= codeBlock ;
    public final TwyncatParser.caseElementsStm_return caseElementsStm() throws RecognitionException {
        TwyncatParser.caseElementsStm_return retval = new TwyncatParser.caseElementsStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON182=null;
        Token string_literal183=null;
        Token COLON184=null;
        TwyncatParser.codeBlock_return cbN = null;

        TwyncatParser.codeBlock_return cbd = null;

        TwyncatParser.test_return test181 = null;


        Object COLON182_tree=null;
        Object string_literal183_tree=null;
        Object COLON184_tree=null;

         retval.statements = new LinkedList<String>(); retval.vbund = new VariablesBundle(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:598:2: ( ( test COLON cbN= codeBlock )+ 'default' COLON cbd= codeBlock )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:598:4: ( test COLON cbN= codeBlock )+ 'default' COLON cbd= codeBlock
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:598:4: ( test COLON cbN= codeBlock )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==ID||LA55_0==DECIMALL||(LA55_0>=HEXDIGITS && LA55_0<=CHARACTERL)||LA55_0==LPAREN||(LA55_0>=PLUS && LA55_0<=MINUS)||(LA55_0>=88 && LA55_0<=89)||(LA55_0>=117 && LA55_0<=118)||(LA55_0>=124 && LA55_0<=127)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:598:6: test COLON cbN= codeBlock
            	    {
            	    pushFollow(FOLLOW_test_in_caseElementsStm2160);
            	    test181=test();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, test181.getTree());
            	    COLON182=(Token)match(input,COLON,FOLLOW_COLON_in_caseElementsStm2162); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COLON182_tree = (Object)adaptor.create(COLON182);
            	    adaptor.addChild(root_0, COLON182_tree);
            	    }
            	    pushFollow(FOLLOW_codeBlock_in_caseElementsStm2166);
            	    cbN=codeBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cbN.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.statements.add((test181!=null?test181.txt:null) + ":"); retval.statements.addAll((cbN!=null?cbN.statements:null)); retval.vbund.addAll((cbN!=null?cbN.vbund:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);

            string_literal183=(Token)match(input,110,FOLLOW_110_in_caseElementsStm2174); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal183_tree = (Object)adaptor.create(string_literal183);
            adaptor.addChild(root_0, string_literal183_tree);
            }
            COLON184=(Token)match(input,COLON,FOLLOW_COLON_in_caseElementsStm2176); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON184_tree = (Object)adaptor.create(COLON184);
            adaptor.addChild(root_0, COLON184_tree);
            }
            pushFollow(FOLLOW_codeBlock_in_caseElementsStm2180);
            cbd=codeBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, cbd.getTree());
            if ( state.backtracking==0 ) {
               retval.statements.add("ELSE"); retval.statements.addAll((cbd!=null?cbd.statements:null)); retval.vbund.addAll((cbd!=null?cbd.vbund:null)); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseElementsStm"

    public static class forStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:602:1: forStm returns [ List<String> statements, VariablesBundle vbund ] : 'for' ID (t= trailer )? (ame= arrayModifierEl )? 'in' LCURLY start= test ':' step= test ':' stop= test RCURLY COLON codeBlock ;
    public final TwyncatParser.forStm_return forStm() throws RecognitionException {
        TwyncatParser.forStm_return retval = new TwyncatParser.forStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal185=null;
        Token ID186=null;
        Token string_literal187=null;
        Token LCURLY188=null;
        Token char_literal189=null;
        Token char_literal190=null;
        Token RCURLY191=null;
        Token COLON192=null;
        TwyncatParser.trailer_return t = null;

        TwyncatParser.arrayModifierEl_return ame = null;

        TwyncatParser.test_return start = null;

        TwyncatParser.test_return step = null;

        TwyncatParser.test_return stop = null;

        TwyncatParser.codeBlock_return codeBlock193 = null;


        Object string_literal185_tree=null;
        Object ID186_tree=null;
        Object string_literal187_tree=null;
        Object LCURLY188_tree=null;
        Object char_literal189_tree=null;
        Object char_literal190_tree=null;
        Object RCURLY191_tree=null;
        Object COLON192_tree=null;

         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:604:2: ( 'for' ID (t= trailer )? (ame= arrayModifierEl )? 'in' LCURLY start= test ':' step= test ':' stop= test RCURLY COLON codeBlock )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:604:4: 'for' ID (t= trailer )? (ame= arrayModifierEl )? 'in' LCURLY start= test ':' step= test ':' stop= test RCURLY COLON codeBlock
            {
            root_0 = (Object)adaptor.nil();

            string_literal185=(Token)match(input,111,FOLLOW_111_in_forStm2202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal185_tree = (Object)adaptor.create(string_literal185);
            adaptor.addChild(root_0, string_literal185_tree);
            }
            ID186=(Token)match(input,ID,FOLLOW_ID_in_forStm2204); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID186_tree = (Object)adaptor.create(ID186);
            adaptor.addChild(root_0, ID186_tree);
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:604:13: (t= trailer )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==DOT) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:604:14: t= trailer
                    {
                    pushFollow(FOLLOW_trailer_in_forStm2209);
                    t=trailer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;

            }

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:604:26: (ame= arrayModifierEl )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==LBRACK) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:604:27: ame= arrayModifierEl
                    {
                    pushFollow(FOLLOW_arrayModifierEl_in_forStm2216);
                    ame=arrayModifierEl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ame.getTree());

                    }
                    break;

            }

            string_literal187=(Token)match(input,98,FOLLOW_98_in_forStm2219); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal187_tree = (Object)adaptor.create(string_literal187);
            adaptor.addChild(root_0, string_literal187_tree);
            }
            LCURLY188=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_forStm2221); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LCURLY188_tree = (Object)adaptor.create(LCURLY188);
            adaptor.addChild(root_0, LCURLY188_tree);
            }
            pushFollow(FOLLOW_test_in_forStm2225);
            start=test();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, start.getTree());
            char_literal189=(Token)match(input,COLON,FOLLOW_COLON_in_forStm2227); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal189_tree = (Object)adaptor.create(char_literal189);
            adaptor.addChild(root_0, char_literal189_tree);
            }
            pushFollow(FOLLOW_test_in_forStm2231);
            step=test();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, step.getTree());
            char_literal190=(Token)match(input,COLON,FOLLOW_COLON_in_forStm2233); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal190_tree = (Object)adaptor.create(char_literal190);
            adaptor.addChild(root_0, char_literal190_tree);
            }
            pushFollow(FOLLOW_test_in_forStm2237);
            stop=test();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, stop.getTree());
            RCURLY191=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_forStm2239); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RCURLY191_tree = (Object)adaptor.create(RCURLY191);
            adaptor.addChild(root_0, RCURLY191_tree);
            }
            COLON192=(Token)match(input,COLON,FOLLOW_COLON_in_forStm2241); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON192_tree = (Object)adaptor.create(COLON192);
            adaptor.addChild(root_0, COLON192_tree);
            }
            pushFollow(FOLLOW_codeBlock_in_forStm2243);
            codeBlock193=codeBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, codeBlock193.getTree());
            if ( state.backtracking==0 ) {

              	retval.statements.add("FOR " + (ID186!=null?ID186.getText():null) + (t == null?"":(t!=null?t.txt:null)) + (ame == null?"":(ame!=null?ame.txt:null)) + " := " + (start!=null?start.txt:null) + " TO " + (stop!=null?stop.txt:null) + " BY " + (step!=null?step.txt:null) + " DO");  
              	retval.statements.addAll((codeBlock193!=null?codeBlock193.statements:null)); retval.vbund = (codeBlock193!=null?codeBlock193.vbund:null); 
              	retval.statements.add("END_FOR;");
              	
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "forStm"

    public static class whileStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whileStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:612:1: whileStm returns [ List<String> statements, VariablesBundle vbund ] : 'while' test COLON codeBlock ;
    public final TwyncatParser.whileStm_return whileStm() throws RecognitionException {
        TwyncatParser.whileStm_return retval = new TwyncatParser.whileStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal194=null;
        Token COLON196=null;
        TwyncatParser.test_return test195 = null;

        TwyncatParser.codeBlock_return codeBlock197 = null;


        Object string_literal194_tree=null;
        Object COLON196_tree=null;

         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:614:2: ( 'while' test COLON codeBlock )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:614:4: 'while' test COLON codeBlock
            {
            root_0 = (Object)adaptor.nil();

            string_literal194=(Token)match(input,112,FOLLOW_112_in_whileStm2268); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal194_tree = (Object)adaptor.create(string_literal194);
            adaptor.addChild(root_0, string_literal194_tree);
            }
            pushFollow(FOLLOW_test_in_whileStm2270);
            test195=test();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, test195.getTree());
            COLON196=(Token)match(input,COLON,FOLLOW_COLON_in_whileStm2272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON196_tree = (Object)adaptor.create(COLON196);
            adaptor.addChild(root_0, COLON196_tree);
            }
            pushFollow(FOLLOW_codeBlock_in_whileStm2274);
            codeBlock197=codeBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, codeBlock197.getTree());
            if ( state.backtracking==0 ) {

              	retval.statements.add("WHILE " + (test195!=null?test195.txt:null) + " DO");
              	retval.statements.addAll((codeBlock197!=null?codeBlock197.statements:null)); retval.vbund = (codeBlock197!=null?codeBlock197.vbund:null); 
              	retval.statements.add("END_WHILE;");
              	
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "whileStm"

    public static class repeatUntilStm_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repeatUntilStm"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:622:1: repeatUntilStm returns [ List<String> statements, VariablesBundle vbund ] : 'repeat' COLON codeBlock 'until' test ;
    public final TwyncatParser.repeatUntilStm_return repeatUntilStm() throws RecognitionException {
        TwyncatParser.repeatUntilStm_return retval = new TwyncatParser.repeatUntilStm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal198=null;
        Token COLON199=null;
        Token string_literal201=null;
        TwyncatParser.codeBlock_return codeBlock200 = null;

        TwyncatParser.test_return test202 = null;


        Object string_literal198_tree=null;
        Object COLON199_tree=null;
        Object string_literal201_tree=null;

         retval.statements = new LinkedList<String>(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:624:2: ( 'repeat' COLON codeBlock 'until' test )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:624:4: 'repeat' COLON codeBlock 'until' test
            {
            root_0 = (Object)adaptor.nil();

            string_literal198=(Token)match(input,113,FOLLOW_113_in_repeatUntilStm2297); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal198_tree = (Object)adaptor.create(string_literal198);
            adaptor.addChild(root_0, string_literal198_tree);
            }
            COLON199=(Token)match(input,COLON,FOLLOW_COLON_in_repeatUntilStm2299); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON199_tree = (Object)adaptor.create(COLON199);
            adaptor.addChild(root_0, COLON199_tree);
            }
            pushFollow(FOLLOW_codeBlock_in_repeatUntilStm2301);
            codeBlock200=codeBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, codeBlock200.getTree());
            string_literal201=(Token)match(input,114,FOLLOW_114_in_repeatUntilStm2303); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal201_tree = (Object)adaptor.create(string_literal201);
            adaptor.addChild(root_0, string_literal201_tree);
            }
            pushFollow(FOLLOW_test_in_repeatUntilStm2305);
            test202=test();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, test202.getTree());
            if ( state.backtracking==0 ) {

              	retval.statements.add("REPEAT");
              	retval.statements.addAll((codeBlock200!=null?codeBlock200.statements:null)); retval.vbund = (codeBlock200!=null?codeBlock200.vbund:null); 
              	retval.statements.add("UNTIL " + (test202!=null?test202.txt:null));
              	retval.statements.add("END_REPEAT;");
              	
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "repeatUntilStm"

    public static class codeBlock_return extends ParserRuleReturnScope {
        public List<String> statements;
        public VariablesBundle vbund;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "codeBlock"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:633:1: codeBlock returns [ List<String> statements, VariablesBundle vbund ] : (stm= simpleStm | NEWLINE INDENT (stms= statement )+ DEDENT );
    public final TwyncatParser.codeBlock_return codeBlock() throws RecognitionException {
        TwyncatParser.codeBlock_return retval = new TwyncatParser.codeBlock_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NEWLINE203=null;
        Token INDENT204=null;
        Token DEDENT205=null;
        TwyncatParser.simpleStm_return stm = null;

        TwyncatParser.statement_return stms = null;


        Object NEWLINE203_tree=null;
        Object INDENT204_tree=null;
        Object DEDENT205_tree=null;

         retval.statements = new LinkedList<String>(); retval.vbund = new VariablesBundle(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:635:2: (stm= simpleStm | NEWLINE INDENT (stms= statement )+ DEDENT )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==ID||LA59_0==DECIMALL||(LA59_0>=HEXDIGITS && LA59_0<=CHARACTERL)||LA59_0==LPAREN||(LA59_0>=PLUS && LA59_0<=MINUS)||(LA59_0>=68 && LA59_0<=89)||(LA59_0>=98 && LA59_0<=105)||LA59_0==113||(LA59_0>=117 && LA59_0<=118)||(LA59_0>=124 && LA59_0<=127)) ) {
                alt59=1;
            }
            else if ( (LA59_0==NEWLINE) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:635:4: stm= simpleStm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simpleStm_in_codeBlock2330);
                    stm=simpleStm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, stm.getTree());
                    if ( state.backtracking==0 ) {
                       if((stm!=null?stm.statements:null) != null) {	retval.statements.addAll((stm!=null?stm.statements:null)); retval.vbund.addAll((stm!=null?stm.vbund:null)); }  
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:636:4: NEWLINE INDENT (stms= statement )+ DEDENT
                    {
                    root_0 = (Object)adaptor.nil();

                    NEWLINE203=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_codeBlock2337); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEWLINE203_tree = (Object)adaptor.create(NEWLINE203);
                    adaptor.addChild(root_0, NEWLINE203_tree);
                    }
                    INDENT204=(Token)match(input,INDENT,FOLLOW_INDENT_in_codeBlock2339); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INDENT204_tree = (Object)adaptor.create(INDENT204);
                    adaptor.addChild(root_0, INDENT204_tree);
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:636:19: (stms= statement )+
                    int cnt58=0;
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==ID||LA58_0==DECIMALL||(LA58_0>=HEXDIGITS && LA58_0<=CHARACTERL)||LA58_0==LPAREN||(LA58_0>=PLUS && LA58_0<=MINUS)||(LA58_0>=68 && LA58_0<=89)||(LA58_0>=98 && LA58_0<=106)||LA58_0==109||(LA58_0>=111 && LA58_0<=113)||(LA58_0>=117 && LA58_0<=118)||(LA58_0>=124 && LA58_0<=127)) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:636:21: stms= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_codeBlock2345);
                    	    stms=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stms.getTree());
                    	    if ( state.backtracking==0 ) {
                    	       if((stms!=null?stms.statements:null) != null) { retval.statements.addAll((stms!=null?stms.statements:null)); retval.vbund.addAll((stms!=null?stms.vbund:null)); } 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt58 >= 1 ) break loop58;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(58, input);
                                throw eee;
                        }
                        cnt58++;
                    } while (true);

                    DEDENT205=(Token)match(input,DEDENT,FOLLOW_DEDENT_in_codeBlock2351); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEDENT205_tree = (Object)adaptor.create(DEDENT205);
                    adaptor.addChild(root_0, DEDENT205_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "codeBlock"

    public static class test_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "test"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:639:1: test returns [ String txt, String dType ] : orTest ;
    public final TwyncatParser.test_return test() throws RecognitionException {
        TwyncatParser.test_return retval = new TwyncatParser.test_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TwyncatParser.orTest_return orTest206 = null;



        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:640:2: ( orTest )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:640:4: orTest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_orTest_in_test2367);
            orTest206=orTest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, orTest206.getTree());
            if ( state.backtracking==0 ) {
               retval.txt = (orTest206!=null?orTest206.txt:null); retval.dType = (orTest206!=null?orTest206.dType:null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "test"

    public static class orTest_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orTest"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:643:1: orTest returns [ String txt, String dType ] : and1= andTest ( 'or' andN= andTest )* ;
    public final TwyncatParser.orTest_return orTest() throws RecognitionException {
        TwyncatParser.orTest_return retval = new TwyncatParser.orTest_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal207=null;
        TwyncatParser.andTest_return and1 = null;

        TwyncatParser.andTest_return andN = null;


        Object string_literal207_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:646:2: (and1= andTest ( 'or' andN= andTest )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:646:4: and1= andTest ( 'or' andN= andTest )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_andTest_in_orTest2396);
            and1=andTest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, and1.getTree());
            if ( state.backtracking==0 ) {
               sb.append((and1!=null?and1.txt:null)); retval.dType = (and1!=null?and1.dType:null); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:647:2: ( 'or' andN= andTest )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==115) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:647:3: 'or' andN= andTest
            	    {
            	    string_literal207=(Token)match(input,115,FOLLOW_115_in_orTest2402); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal207_tree = (Object)adaptor.create(string_literal207);
            	    adaptor.addChild(root_0, string_literal207_tree);
            	    }
            	    pushFollow(FOLLOW_andTest_in_orTest2406);
            	    andN=andTest();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andN.getTree());
            	    if ( state.backtracking==0 ) {
            	       sb.append(" OR " + (andN!=null?andN.txt:null)); retval.dType = checkFunction("OR",(and1!=null?and1.dType:null),(andN!=null?andN.dType:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "orTest"

    public static class andTest_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andTest"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:650:1: andTest returns [ String txt, String dType ] : not1= notTest ( 'and' notN= notTest )* ;
    public final TwyncatParser.andTest_return andTest() throws RecognitionException {
        TwyncatParser.andTest_return retval = new TwyncatParser.andTest_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal208=null;
        TwyncatParser.notTest_return not1 = null;

        TwyncatParser.notTest_return notN = null;


        Object string_literal208_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:653:2: (not1= notTest ( 'and' notN= notTest )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:653:4: not1= notTest ( 'and' notN= notTest )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_notTest_in_andTest2437);
            not1=notTest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, not1.getTree());
            if ( state.backtracking==0 ) {
               sb.append((not1!=null?not1.txt:null)); retval.dType = (not1!=null?not1.dType:null); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:654:2: ( 'and' notN= notTest )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==116) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:654:3: 'and' notN= notTest
            	    {
            	    string_literal208=(Token)match(input,116,FOLLOW_116_in_andTest2443); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal208_tree = (Object)adaptor.create(string_literal208);
            	    adaptor.addChild(root_0, string_literal208_tree);
            	    }
            	    pushFollow(FOLLOW_notTest_in_andTest2447);
            	    notN=notTest();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, notN.getTree());
            	    if ( state.backtracking==0 ) {
            	       sb.append(" AND " + (notN!=null?notN.txt:null)); retval.dType = checkFunction("AND",(not1!=null?not1.dType:null),(notN!=null?notN.dType:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "andTest"

    public static class notTest_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "notTest"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:657:1: notTest returns [ String txt, String dType ] : ( 'not' nt= notTest | comparison );
    public final TwyncatParser.notTest_return notTest() throws RecognitionException {
        TwyncatParser.notTest_return retval = new TwyncatParser.notTest_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal209=null;
        TwyncatParser.notTest_return nt = null;

        TwyncatParser.comparison_return comparison210 = null;


        Object string_literal209_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:658:2: ( 'not' nt= notTest | comparison )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==117) ) {
                alt62=1;
            }
            else if ( (LA62_0==ID||LA62_0==DECIMALL||(LA62_0>=HEXDIGITS && LA62_0<=CHARACTERL)||LA62_0==LPAREN||(LA62_0>=PLUS && LA62_0<=MINUS)||(LA62_0>=88 && LA62_0<=89)||LA62_0==118||(LA62_0>=124 && LA62_0<=127)) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:658:4: 'not' nt= notTest
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal209=(Token)match(input,117,FOLLOW_117_in_notTest2466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal209_tree = (Object)adaptor.create(string_literal209);
                    adaptor.addChild(root_0, string_literal209_tree);
                    }
                    pushFollow(FOLLOW_notTest_in_notTest2470);
                    nt=notTest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nt.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = "NOT " + (nt!=null?nt.txt:null); retval.dType = checkFunction("NOT",(nt!=null?nt.dType:null)); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:659:4: comparison
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_comparison_in_notTest2477);
                    comparison210=comparison();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, comparison210.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (comparison210!=null?comparison210.txt:null); retval.dType = (comparison210!=null?comparison210.dType:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "notTest"

    public static class comparison_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparison"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:662:1: comparison returns [ String txt, String dType ] : ex1= expr ( compOperator exN= expr )* ;
    public final TwyncatParser.comparison_return comparison() throws RecognitionException {
        TwyncatParser.comparison_return retval = new TwyncatParser.comparison_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TwyncatParser.expr_return ex1 = null;

        TwyncatParser.expr_return exN = null;

        TwyncatParser.compOperator_return compOperator211 = null;



         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:665:2: (ex1= expr ( compOperator exN= expr )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:665:4: ex1= expr ( compOperator exN= expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expr_in_comparison2506);
            ex1=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ex1.getTree());
            if ( state.backtracking==0 ) {
               sb.append((ex1!=null?ex1.txt:null)); retval.dType = (ex1!=null?ex1.dType:null); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:665:59: ( compOperator exN= expr )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( ((LA63_0>=LESS && LA63_0<=GREATER)||(LA63_0>=EQUAL && LA63_0<=GREATEREQUAL)) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:665:60: compOperator exN= expr
            	    {
            	    pushFollow(FOLLOW_compOperator_in_comparison2511);
            	    compOperator211=compOperator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compOperator211.getTree());
            	    pushFollow(FOLLOW_expr_in_comparison2515);
            	    exN=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exN.getTree());
            	    if ( state.backtracking==0 ) {
            	       sb.append(" " + (compOperator211!=null?compOperator211.txt:null) + " " + (exN!=null?exN.txt:null) + " "); checkType((ex1!=null?ex1.dType:null),(exN!=null?exN.dType:null)); retval.dType = "BOOL"; 
            	    }

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparison"

    public static class compOperator_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compOperator"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:668:1: compOperator returns [ String txt ] : ( '<' | '>' | '==' | '>=' | '<=' | '<>' | '!=' );
    public final TwyncatParser.compOperator_return compOperator() throws RecognitionException {
        TwyncatParser.compOperator_return retval = new TwyncatParser.compOperator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal212=null;
        Token char_literal213=null;
        Token string_literal214=null;
        Token string_literal215=null;
        Token string_literal216=null;
        Token string_literal217=null;
        Token string_literal218=null;

        Object char_literal212_tree=null;
        Object char_literal213_tree=null;
        Object string_literal214_tree=null;
        Object string_literal215_tree=null;
        Object string_literal216_tree=null;
        Object string_literal217_tree=null;
        Object string_literal218_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:669:2: ( '<' | '>' | '==' | '>=' | '<=' | '<>' | '!=' )
            int alt64=7;
            switch ( input.LA(1) ) {
            case LESS:
                {
                alt64=1;
                }
                break;
            case GREATER:
                {
                alt64=2;
                }
                break;
            case EQUAL:
                {
                alt64=3;
                }
                break;
            case GREATEREQUAL:
                {
                alt64=4;
                }
                break;
            case LESSEQUAL:
                {
                alt64=5;
                }
                break;
            case ALT_NOTEQUAL:
                {
                alt64=6;
                }
                break;
            case NOTEQUAL:
                {
                alt64=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:669:4: '<'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal212=(Token)match(input,LESS,FOLLOW_LESS_in_compOperator2535); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal212_tree = (Object)adaptor.create(char_literal212);
                    adaptor.addChild(root_0, char_literal212_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "<"; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:670:4: '>'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal213=(Token)match(input,GREATER,FOLLOW_GREATER_in_compOperator2542); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal213_tree = (Object)adaptor.create(char_literal213);
                    adaptor.addChild(root_0, char_literal213_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = ">"; 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:671:4: '=='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal214=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_compOperator2549); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal214_tree = (Object)adaptor.create(string_literal214);
                    adaptor.addChild(root_0, string_literal214_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "="; 
                    }

                    }
                    break;
                case 4 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:672:4: '>='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal215=(Token)match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_compOperator2556); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal215_tree = (Object)adaptor.create(string_literal215);
                    adaptor.addChild(root_0, string_literal215_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = ">="; 
                    }

                    }
                    break;
                case 5 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:673:4: '<='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal216=(Token)match(input,LESSEQUAL,FOLLOW_LESSEQUAL_in_compOperator2563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal216_tree = (Object)adaptor.create(string_literal216);
                    adaptor.addChild(root_0, string_literal216_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "<="; 
                    }

                    }
                    break;
                case 6 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:674:4: '<>'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal217=(Token)match(input,ALT_NOTEQUAL,FOLLOW_ALT_NOTEQUAL_in_compOperator2570); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal217_tree = (Object)adaptor.create(string_literal217);
                    adaptor.addChild(root_0, string_literal217_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "<>"; 
                    }

                    }
                    break;
                case 7 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:675:4: '!='
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal218=(Token)match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compOperator2577); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal218_tree = (Object)adaptor.create(string_literal218);
                    adaptor.addChild(root_0, string_literal218_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = new String("<>"); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "compOperator"

    public static class expr_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:678:1: expr returns [ String txt, String dType ] : xor1= xorExpr ( '|' xorN= xorExpr )* ;
    public final TwyncatParser.expr_return expr() throws RecognitionException {
        TwyncatParser.expr_return retval = new TwyncatParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal219=null;
        TwyncatParser.xorExpr_return xor1 = null;

        TwyncatParser.xorExpr_return xorN = null;


        Object char_literal219_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:681:2: (xor1= xorExpr ( '|' xorN= xorExpr )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:681:4: xor1= xorExpr ( '|' xorN= xorExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_xorExpr_in_expr2606);
            xor1=xorExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, xor1.getTree());
            if ( state.backtracking==0 ) {
               sb.append((xor1!=null?xor1.txt:null)); retval.dType = (xor1!=null?xor1.dType:null); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:681:65: ( '|' xorN= xorExpr )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==VBAR) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:681:66: '|' xorN= xorExpr
            	    {
            	    char_literal219=(Token)match(input,VBAR,FOLLOW_VBAR_in_expr2611); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal219_tree = (Object)adaptor.create(char_literal219);
            	    adaptor.addChild(root_0, char_literal219_tree);
            	    }
            	    pushFollow(FOLLOW_xorExpr_in_expr2615);
            	    xorN=xorExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, xorN.getTree());
            	    if ( state.backtracking==0 ) {
            	       sb.append(" OR " + (xorN!=null?xorN.txt:null)); retval.dType = checkFunction("OR",(xor1!=null?xor1.dType:null),(xorN!=null?xorN.dType:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class xorExpr_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xorExpr"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:684:1: xorExpr returns [ String txt, String dType ] : and1= andExpr ( '^' andN= andExpr )* ;
    public final TwyncatParser.xorExpr_return xorExpr() throws RecognitionException {
        TwyncatParser.xorExpr_return retval = new TwyncatParser.xorExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal220=null;
        TwyncatParser.andExpr_return and1 = null;

        TwyncatParser.andExpr_return andN = null;


        Object char_literal220_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:687:2: (and1= andExpr ( '^' andN= andExpr )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:687:4: and1= andExpr ( '^' andN= andExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_xorExpr2647);
            and1=andExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, and1.getTree());
            if ( state.backtracking==0 ) {
               sb.append((and1!=null?and1.txt:null)); retval.dType = (and1!=null?and1.dType:null); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:687:65: ( '^' andN= andExpr )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==CIRCUMFLEX) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:687:66: '^' andN= andExpr
            	    {
            	    char_literal220=(Token)match(input,CIRCUMFLEX,FOLLOW_CIRCUMFLEX_in_xorExpr2652); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal220_tree = (Object)adaptor.create(char_literal220);
            	    adaptor.addChild(root_0, char_literal220_tree);
            	    }
            	    pushFollow(FOLLOW_andExpr_in_xorExpr2656);
            	    andN=andExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andN.getTree());
            	    if ( state.backtracking==0 ) {
            	       sb.append(" XOR " + (andN!=null?andN.txt:null)); retval.dType = checkFunction("XOR",(and1!=null?and1.dType:null),(andN!=null?andN.dType:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "xorExpr"

    public static class andExpr_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpr"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:690:1: andExpr returns [ String txt, String dType ] : shi1= shiftExpr ( '&' shiN= shiftExpr )* ;
    public final TwyncatParser.andExpr_return andExpr() throws RecognitionException {
        TwyncatParser.andExpr_return retval = new TwyncatParser.andExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal221=null;
        TwyncatParser.shiftExpr_return shi1 = null;

        TwyncatParser.shiftExpr_return shiN = null;


        Object char_literal221_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:693:2: (shi1= shiftExpr ( '&' shiN= shiftExpr )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:693:4: shi1= shiftExpr ( '&' shiN= shiftExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_shiftExpr_in_andExpr2689);
            shi1=shiftExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, shi1.getTree());
            if ( state.backtracking==0 ) {
               sb.append((shi1!=null?shi1.txt:null)); retval.dType = (shi1!=null?shi1.dType:null); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:693:67: ( '&' shiN= shiftExpr )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==AMPER) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:693:68: '&' shiN= shiftExpr
            	    {
            	    char_literal221=(Token)match(input,AMPER,FOLLOW_AMPER_in_andExpr2694); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal221_tree = (Object)adaptor.create(char_literal221);
            	    adaptor.addChild(root_0, char_literal221_tree);
            	    }
            	    pushFollow(FOLLOW_shiftExpr_in_andExpr2698);
            	    shiN=shiftExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, shiN.getTree());
            	    if ( state.backtracking==0 ) {
            	       sb.append(" AND " + (shiN!=null?shiN.txt:null)); retval.dType = checkFunction("AND",(shi1!=null?shi1.dType:null),(shiN!=null?shiN.dType:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "andExpr"

    public static class shiftExpr_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shiftExpr"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:696:1: shiftExpr returns [ String txt, String dType ] : (aril= arithExpr '<<' ariL= arithExpr | arir= arithExpr '>>' ariR= arithExpr | ari= arithExpr );
    public final TwyncatParser.shiftExpr_return shiftExpr() throws RecognitionException {
        TwyncatParser.shiftExpr_return retval = new TwyncatParser.shiftExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal222=null;
        Token string_literal223=null;
        TwyncatParser.arithExpr_return aril = null;

        TwyncatParser.arithExpr_return ariL = null;

        TwyncatParser.arithExpr_return arir = null;

        TwyncatParser.arithExpr_return ariR = null;

        TwyncatParser.arithExpr_return ari = null;


        Object string_literal222_tree=null;
        Object string_literal223_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:699:2: (aril= arithExpr '<<' ariL= arithExpr | arir= arithExpr '>>' ariR= arithExpr | ari= arithExpr )
            int alt68=3;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:699:4: aril= arithExpr '<<' ariL= arithExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_arithExpr_in_shiftExpr2731);
                    aril=arithExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aril.getTree());
                    string_literal222=(Token)match(input,LEFTSHIFT,FOLLOW_LEFTSHIFT_in_shiftExpr2733); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal222_tree = (Object)adaptor.create(string_literal222);
                    adaptor.addChild(root_0, string_literal222_tree);
                    }
                    pushFollow(FOLLOW_arithExpr_in_shiftExpr2737);
                    ariL=arithExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ariL.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append("SHL(" + (aril!=null?aril.txt:null) + ", " + (ariL!=null?ariL.txt:null) + ")"); retval.dType = checkFunction("SHL",(aril!=null?aril.dType:null),(ariL!=null?ariL.dType:null)); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:700:4: arir= arithExpr '>>' ariR= arithExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_arithExpr_in_shiftExpr2746);
                    arir=arithExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arir.getTree());
                    string_literal223=(Token)match(input,RIGHTSHIFT,FOLLOW_RIGHTSHIFT_in_shiftExpr2748); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal223_tree = (Object)adaptor.create(string_literal223);
                    adaptor.addChild(root_0, string_literal223_tree);
                    }
                    pushFollow(FOLLOW_arithExpr_in_shiftExpr2752);
                    ariR=arithExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ariR.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append("SHR(" + (arir!=null?arir.txt:null) + ", " + (ariR!=null?ariR.txt:null) + ")"); retval.dType = checkFunction("SHR",(arir!=null?arir.dType:null),(ariR!=null?ariR.dType:null)); 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:701:4: ari= arithExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_arithExpr_in_shiftExpr2761);
                    ari=arithExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ari.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append((ari!=null?ari.txt:null)); retval.dType = (ari!=null?ari.dType:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "shiftExpr"

    public static class arithExpr_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arithExpr"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:704:1: arithExpr returns [ String txt, String dType ] : t1= term ( ( '+' | '-' ) tN= term )* ;
    public final TwyncatParser.arithExpr_return arithExpr() throws RecognitionException {
        TwyncatParser.arithExpr_return retval = new TwyncatParser.arithExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal224=null;
        Token char_literal225=null;
        TwyncatParser.term_return t1 = null;

        TwyncatParser.term_return tN = null;


        Object char_literal224_tree=null;
        Object char_literal225_tree=null;

         StringBuilder sb = new StringBuilder(); String funN = null; 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:707:2: (t1= term ( ( '+' | '-' ) tN= term )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:707:4: t1= term ( ( '+' | '-' ) tN= term )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_term_in_arithExpr2790);
            t1=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
            if ( state.backtracking==0 ) {
               sb.append((t1!=null?t1.txt:null)); retval.dType = (t1!=null?t1.dType:null); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:707:56: ( ( '+' | '-' ) tN= term )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( ((LA70_0>=PLUS && LA70_0<=MINUS)) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:707:57: ( '+' | '-' ) tN= term
            	    {
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:707:57: ( '+' | '-' )
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( (LA69_0==PLUS) ) {
            	        alt69=1;
            	    }
            	    else if ( (LA69_0==MINUS) ) {
            	        alt69=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 69, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:707:58: '+'
            	            {
            	            char_literal224=(Token)match(input,PLUS,FOLLOW_PLUS_in_arithExpr2796); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal224_tree = (Object)adaptor.create(char_literal224);
            	            adaptor.addChild(root_0, char_literal224_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               sb.append(" + "); funN = "ADD"; 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:707:99: '-'
            	            {
            	            char_literal225=(Token)match(input,MINUS,FOLLOW_MINUS_in_arithExpr2801); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal225_tree = (Object)adaptor.create(char_literal225);
            	            adaptor.addChild(root_0, char_literal225_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               sb.append(" - "); funN = "SUB"; 
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_term_in_arithExpr2808);
            	    tN=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, tN.getTree());
            	    if ( state.backtracking==0 ) {
            	       sb.append((tN!=null?tN.txt:null)); retval.dType = checkFunction(funN,(t1!=null?t1.dType:null),(tN!=null?tN.dType:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "arithExpr"

    public static class term_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "term"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:710:1: term returns [ String txt, String dType ] : f1= factor ( ( '*' | '/' | '%' ) fN= factor )* ;
    public final TwyncatParser.term_return term() throws RecognitionException {
        TwyncatParser.term_return retval = new TwyncatParser.term_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal226=null;
        Token char_literal227=null;
        Token char_literal228=null;
        TwyncatParser.factor_return f1 = null;

        TwyncatParser.factor_return fN = null;


        Object char_literal226_tree=null;
        Object char_literal227_tree=null;
        Object char_literal228_tree=null;

         StringBuilder sb = new StringBuilder(); String funN = null; 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:713:2: (f1= factor ( ( '*' | '/' | '%' ) fN= factor )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:713:4: f1= factor ( ( '*' | '/' | '%' ) fN= factor )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_factor_in_term2840);
            f1=factor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, f1.getTree());
            if ( state.backtracking==0 ) {
               sb.append((f1!=null?f1.txt:null)); retval.dType = (f1!=null?f1.dType:null); 
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:713:58: ( ( '*' | '/' | '%' ) fN= factor )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( ((LA72_0>=STAR && LA72_0<=SLASH)||LA72_0==PERCENT) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:713:59: ( '*' | '/' | '%' ) fN= factor
            	    {
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:713:59: ( '*' | '/' | '%' )
            	    int alt71=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt71=1;
            	        }
            	        break;
            	    case SLASH:
            	        {
            	        alt71=2;
            	        }
            	        break;
            	    case PERCENT:
            	        {
            	        alt71=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 71, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt71) {
            	        case 1 :
            	            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:713:60: '*'
            	            {
            	            char_literal226=(Token)match(input,STAR,FOLLOW_STAR_in_term2846); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal226_tree = (Object)adaptor.create(char_literal226);
            	            adaptor.addChild(root_0, char_literal226_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               sb.append(" * "); funN = "MUL"; 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:713:102: '/'
            	            {
            	            char_literal227=(Token)match(input,SLASH,FOLLOW_SLASH_in_term2852); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal227_tree = (Object)adaptor.create(char_literal227);
            	            adaptor.addChild(root_0, char_literal227_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               sb.append(" / ");  funN = "DIV"; 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:713:145: '%'
            	            {
            	            char_literal228=(Token)match(input,PERCENT,FOLLOW_PERCENT_in_term2858); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal228_tree = (Object)adaptor.create(char_literal228);
            	            adaptor.addChild(root_0, char_literal228_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               sb.append(" MOD ");  funN = "MOD"; 
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_factor_in_term2865);
            	    fN=factor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fN.getTree());
            	    if ( state.backtracking==0 ) {
            	       sb.append((fN!=null?fN.txt:null)); retval.dType = checkFunction(funN,(f1!=null?f1.dType:null),(fN!=null?fN.dType:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "term"

    public static class factor_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:716:1: factor returns [ String txt, String dType ] : ( '+' | '-' )? power ;
    public final TwyncatParser.factor_return factor() throws RecognitionException {
        TwyncatParser.factor_return retval = new TwyncatParser.factor_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal229=null;
        Token char_literal230=null;
        TwyncatParser.power_return power231 = null;


        Object char_literal229_tree=null;
        Object char_literal230_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:719:2: ( ( '+' | '-' )? power )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:719:4: ( '+' | '-' )? power
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:719:4: ( '+' | '-' )?
            int alt73=3;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==PLUS) ) {
                alt73=1;
            }
            else if ( (LA73_0==MINUS) ) {
                alt73=2;
            }
            switch (alt73) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:719:5: '+'
                    {
                    char_literal229=(Token)match(input,PLUS,FOLLOW_PLUS_in_factor2897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal229_tree = (Object)adaptor.create(char_literal229);
                    adaptor.addChild(root_0, char_literal229_tree);
                    }
                    if ( state.backtracking==0 ) {
                       sb.append("+"); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:719:30: '-'
                    {
                    char_literal230=(Token)match(input,MINUS,FOLLOW_MINUS_in_factor2902); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal230_tree = (Object)adaptor.create(char_literal230);
                    adaptor.addChild(root_0, char_literal230_tree);
                    }
                    if ( state.backtracking==0 ) {
                       sb.append("-"); 
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_power_in_factor2908);
            power231=power();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, power231.getTree());
            if ( state.backtracking==0 ) {
               sb.append((power231!=null?power231.txt:null)); retval.dType = (power231!=null?power231.dType:null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "factor"

    public static class power_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "power"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:723:1: power returns [ String txt, String dType ] : atp= atom ( '**' fac= factor )? ;
    public final TwyncatParser.power_return power() throws RecognitionException {
        TwyncatParser.power_return retval = new TwyncatParser.power_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal232=null;
        TwyncatParser.atom_return atp = null;

        TwyncatParser.factor_return fac = null;


        Object string_literal232_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:733:2: (atp= atom ( '**' fac= factor )? )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:733:4: atp= atom ( '**' fac= factor )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_atom_in_power2939);
            atp=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atp.getTree());
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:733:13: ( '**' fac= factor )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==DOUBLESTAR) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:733:14: '**' fac= factor
                    {
                    string_literal232=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_power2942); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal232_tree = (Object)adaptor.create(string_literal232);
                    adaptor.addChild(root_0, string_literal232_tree);
                    }
                    pushFollow(FOLLOW_factor_in_power2946);
                    fac=factor();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fac.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               
              	if(fac == null){
              		sb.append((atp!=null?atp.txt:null)); retval.dType = (atp!=null?atp.dType:null);
              	} else {
              		sb.append("EXPT(" + (atp!=null?atp.txt:null) + ", " + (fac!=null?fac.txt:null) + ")"); retval.dType = checkFunction("EXPT",(atp!=null?atp.dType:null),(fac!=null?fac.dType:null));
              	}
              	retval.txt = sb.toString();
              	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "power"

    public static class atom_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:736:1: atom returns [ String txt, String dType ] : ( ID ( trailer )? ( arrayModifierEl )? | literal | '(' test ')' | callFunc );
    public final TwyncatParser.atom_return atom() throws RecognitionException {
        TwyncatParser.atom_return retval = new TwyncatParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID233=null;
        Token char_literal237=null;
        Token char_literal239=null;
        TwyncatParser.trailer_return trailer234 = null;

        TwyncatParser.arrayModifierEl_return arrayModifierEl235 = null;

        TwyncatParser.literal_return literal236 = null;

        TwyncatParser.test_return test238 = null;

        TwyncatParser.callFunc_return callFunc240 = null;


        Object ID233_tree=null;
        Object char_literal237_tree=null;
        Object char_literal239_tree=null;

         StringBuilder sb = new StringBuilder(); StringBuilder atomS = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:739:2: ( ID ( trailer )? ( arrayModifierEl )? | literal | '(' test ')' | callFunc )
            int alt77=4;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:739:4: ID ( trailer )? ( arrayModifierEl )?
                    {
                    root_0 = (Object)adaptor.nil();

                    ID233=(Token)match(input,ID,FOLLOW_ID_in_atom2974); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID233_tree = (Object)adaptor.create(ID233);
                    adaptor.addChild(root_0, ID233_tree);
                    }
                    if ( state.backtracking==0 ) {
                       sb.append((ID233!=null?ID233.getText():null)); atomS.append((ID233!=null?ID233.getText():null)); 
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:739:56: ( trailer )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==DOT) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:739:57: trailer
                            {
                            pushFollow(FOLLOW_trailer_in_atom2979);
                            trailer234=trailer();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, trailer234.getTree());
                            if ( state.backtracking==0 ) {
                               sb.append((trailer234!=null?trailer234.txt:null)); atomS.append((trailer234!=null?trailer234.txt:null));  
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:740:2: ( arrayModifierEl )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==LBRACK) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:740:3: arrayModifierEl
                            {
                            pushFollow(FOLLOW_arrayModifierEl_in_atom2987);
                            arrayModifierEl235=arrayModifierEl();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayModifierEl235.getTree());
                            if ( state.backtracking==0 ) {
                               sb.append((arrayModifierEl235!=null?arrayModifierEl235.txt:null)); atomS.append("[]"); 
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       retval.dType = getType(currentBlock + "." + atomS.toString()); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:741:4: literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_atom2998);
                    literal236=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal236.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append((literal236!=null?literal236.txt:null)); retval.dType = (literal236!=null?literal236.dType:null); 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:742:4: '(' test ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal237=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom3006); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal237_tree = (Object)adaptor.create(char_literal237);
                    adaptor.addChild(root_0, char_literal237_tree);
                    }
                    pushFollow(FOLLOW_test_in_atom3008);
                    test238=test();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, test238.getTree());
                    char_literal239=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom3010); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal239_tree = (Object)adaptor.create(char_literal239);
                    adaptor.addChild(root_0, char_literal239_tree);
                    }
                    if ( state.backtracking==0 ) {
                       sb.append("( " + (test238!=null?test238.txt:null) + " )"); retval.dType = (test238!=null?test238.dType:null); 
                    }

                    }
                    break;
                case 4 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:743:4: callFunc
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_callFunc_in_atom3017);
                    callFunc240=callFunc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, callFunc240.getTree());
                    if ( state.backtracking==0 ) {
                       sb.append((callFunc240!=null?callFunc240.txt:null)); retval.dType = (callFunc240!=null?callFunc240.dType:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class arrayModifierEl_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayModifierEl"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:746:1: arrayModifierEl returns [ String txt ] : ( ( LBRACK expr RBRACK ) | ( LBRACK first= expr RBRACK ) ( LBRACK second= expr RBRACK ) | ( LBRACK first= expr RBRACK ) ( LBRACK second= expr RBRACK ) ( LBRACK third= expr RBRACK ) );
    public final TwyncatParser.arrayModifierEl_return arrayModifierEl() throws RecognitionException {
        TwyncatParser.arrayModifierEl_return retval = new TwyncatParser.arrayModifierEl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBRACK241=null;
        Token RBRACK243=null;
        Token LBRACK244=null;
        Token RBRACK245=null;
        Token LBRACK246=null;
        Token RBRACK247=null;
        Token LBRACK248=null;
        Token RBRACK249=null;
        Token LBRACK250=null;
        Token RBRACK251=null;
        Token LBRACK252=null;
        Token RBRACK253=null;
        TwyncatParser.expr_return first = null;

        TwyncatParser.expr_return second = null;

        TwyncatParser.expr_return third = null;

        TwyncatParser.expr_return expr242 = null;


        Object LBRACK241_tree=null;
        Object RBRACK243_tree=null;
        Object LBRACK244_tree=null;
        Object RBRACK245_tree=null;
        Object LBRACK246_tree=null;
        Object RBRACK247_tree=null;
        Object LBRACK248_tree=null;
        Object RBRACK249_tree=null;
        Object LBRACK250_tree=null;
        Object RBRACK251_tree=null;
        Object LBRACK252_tree=null;
        Object RBRACK253_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:747:2: ( ( LBRACK expr RBRACK ) | ( LBRACK first= expr RBRACK ) ( LBRACK second= expr RBRACK ) | ( LBRACK first= expr RBRACK ) ( LBRACK second= expr RBRACK ) ( LBRACK third= expr RBRACK ) )
            int alt78=3;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==LBRACK) ) {
                int LA78_1 = input.LA(2);

                if ( (synpred134_twyncat()) ) {
                    alt78=1;
                }
                else if ( (synpred135_twyncat()) ) {
                    alt78=2;
                }
                else if ( (true) ) {
                    alt78=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:747:4: ( LBRACK expr RBRACK )
                    {
                    root_0 = (Object)adaptor.nil();

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:747:4: ( LBRACK expr RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:747:6: LBRACK expr RBRACK
                    {
                    LBRACK241=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifierEl3037); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK241_tree = (Object)adaptor.create(LBRACK241);
                    adaptor.addChild(root_0, LBRACK241_tree);
                    }
                    pushFollow(FOLLOW_expr_in_arrayModifierEl3039);
                    expr242=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr242.getTree());
                    RBRACK243=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifierEl3041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK243_tree = (Object)adaptor.create(RBRACK243);
                    adaptor.addChild(root_0, RBRACK243_tree);
                    }

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = "[ " +(expr242!=null?expr242.txt:null) + "]"; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:4: ( LBRACK first= expr RBRACK ) ( LBRACK second= expr RBRACK )
                    {
                    root_0 = (Object)adaptor.nil();

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:4: ( LBRACK first= expr RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:6: LBRACK first= expr RBRACK
                    {
                    LBRACK244=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifierEl3053); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK244_tree = (Object)adaptor.create(LBRACK244);
                    adaptor.addChild(root_0, LBRACK244_tree);
                    }
                    pushFollow(FOLLOW_expr_in_arrayModifierEl3057);
                    first=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, first.getTree());
                    RBRACK245=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifierEl3059); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK245_tree = (Object)adaptor.create(RBRACK245);
                    adaptor.addChild(root_0, RBRACK245_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:33: ( LBRACK second= expr RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:35: LBRACK second= expr RBRACK
                    {
                    LBRACK246=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifierEl3065); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK246_tree = (Object)adaptor.create(LBRACK246);
                    adaptor.addChild(root_0, LBRACK246_tree);
                    }
                    pushFollow(FOLLOW_expr_in_arrayModifierEl3069);
                    second=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, second.getTree());
                    RBRACK247=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifierEl3071); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK247_tree = (Object)adaptor.create(RBRACK247);
                    adaptor.addChild(root_0, RBRACK247_tree);
                    }

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt =  "[ " + (first!=null?first.txt:null) + ", " + (second!=null?second.txt:null) + "]"; 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:751:4: ( LBRACK first= expr RBRACK ) ( LBRACK second= expr RBRACK ) ( LBRACK third= expr RBRACK )
                    {
                    root_0 = (Object)adaptor.nil();

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:751:4: ( LBRACK first= expr RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:751:6: LBRACK first= expr RBRACK
                    {
                    LBRACK248=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifierEl3083); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK248_tree = (Object)adaptor.create(LBRACK248);
                    adaptor.addChild(root_0, LBRACK248_tree);
                    }
                    pushFollow(FOLLOW_expr_in_arrayModifierEl3087);
                    first=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, first.getTree());
                    RBRACK249=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifierEl3089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK249_tree = (Object)adaptor.create(RBRACK249);
                    adaptor.addChild(root_0, RBRACK249_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:751:33: ( LBRACK second= expr RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:751:35: LBRACK second= expr RBRACK
                    {
                    LBRACK250=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifierEl3095); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK250_tree = (Object)adaptor.create(LBRACK250);
                    adaptor.addChild(root_0, LBRACK250_tree);
                    }
                    pushFollow(FOLLOW_expr_in_arrayModifierEl3099);
                    second=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, second.getTree());
                    RBRACK251=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifierEl3101); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK251_tree = (Object)adaptor.create(RBRACK251);
                    adaptor.addChild(root_0, RBRACK251_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:751:63: ( LBRACK third= expr RBRACK )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:751:65: LBRACK third= expr RBRACK
                    {
                    LBRACK252=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayModifierEl3107); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACK252_tree = (Object)adaptor.create(LBRACK252);
                    adaptor.addChild(root_0, LBRACK252_tree);
                    }
                    pushFollow(FOLLOW_expr_in_arrayModifierEl3111);
                    third=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, third.getTree());
                    RBRACK253=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayModifierEl3113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACK253_tree = (Object)adaptor.create(RBRACK253);
                    adaptor.addChild(root_0, RBRACK253_tree);
                    }

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt =  "[ " + (first!=null?first.txt:null) + ", " + (second!=null?second.txt:null) + ", " + (third!=null?third.txt:null) + "]"; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayModifierEl"

    public static class trailer_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trailer"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:755:1: trailer returns [ String txt ] : ( '.' ID )+ ;
    public final TwyncatParser.trailer_return trailer() throws RecognitionException {
        TwyncatParser.trailer_return retval = new TwyncatParser.trailer_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal254=null;
        Token ID255=null;

        Object char_literal254_tree=null;
        Object ID255_tree=null;

         StringBuilder sb = new StringBuilder(); 
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:758:2: ( ( '.' ID )+ )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:758:4: ( '.' ID )+
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:758:4: ( '.' ID )+
            int cnt79=0;
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==DOT) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:758:5: '.' ID
            	    {
            	    char_literal254=(Token)match(input,DOT,FOLLOW_DOT_in_trailer3144); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal254_tree = (Object)adaptor.create(char_literal254);
            	    adaptor.addChild(root_0, char_literal254_tree);
            	    }
            	    ID255=(Token)match(input,ID,FOLLOW_ID_in_trailer3146); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    ID255_tree = (Object)adaptor.create(ID255);
            	    adaptor.addChild(root_0, ID255_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       sb.append("." + (ID255!=null?ID255.getText():null)); 
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt79 >= 1 ) break loop79;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(79, input);
                        throw eee;
                }
                cnt79++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.txt = sb.toString();	
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "trailer"

    public static class literal_return extends ParserRuleReturnScope {
        public String txt;
        public String dType;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:761:1: literal returns [ String txt, String dType ] : ( DECIMALL | HEXDIGITS | FLOATINGPOINTL | BINDIGITS | OCTDIGITS | timeL | todL | dateL | datetimeL | booleanL | CHARACTERL | stringL );
    public final TwyncatParser.literal_return literal() throws RecognitionException {
        TwyncatParser.literal_return retval = new TwyncatParser.literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DECIMALL256=null;
        Token HEXDIGITS257=null;
        Token FLOATINGPOINTL258=null;
        Token BINDIGITS259=null;
        Token OCTDIGITS260=null;
        Token CHARACTERL266=null;
        TwyncatParser.timeL_return timeL261 = null;

        TwyncatParser.todL_return todL262 = null;

        TwyncatParser.dateL_return dateL263 = null;

        TwyncatParser.datetimeL_return datetimeL264 = null;

        TwyncatParser.booleanL_return booleanL265 = null;

        TwyncatParser.stringL_return stringL267 = null;


        Object DECIMALL256_tree=null;
        Object HEXDIGITS257_tree=null;
        Object FLOATINGPOINTL258_tree=null;
        Object BINDIGITS259_tree=null;
        Object OCTDIGITS260_tree=null;
        Object CHARACTERL266_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:762:3: ( DECIMALL | HEXDIGITS | FLOATINGPOINTL | BINDIGITS | OCTDIGITS | timeL | todL | dateL | datetimeL | booleanL | CHARACTERL | stringL )
            int alt80=12;
            switch ( input.LA(1) ) {
            case DECIMALL:
                {
                alt80=1;
                }
                break;
            case HEXDIGITS:
                {
                alt80=2;
                }
                break;
            case FLOATINGPOINTL:
                {
                alt80=3;
                }
                break;
            case BINDIGITS:
                {
                alt80=4;
                }
                break;
            case OCTDIGITS:
                {
                alt80=5;
                }
                break;
            case 118:
                {
                alt80=6;
                }
                break;
            case 124:
                {
                alt80=7;
                }
                break;
            case 125:
                {
                alt80=8;
                }
                break;
            case 126:
                {
                alt80=9;
                }
                break;
            case 88:
            case 89:
                {
                alt80=10;
                }
                break;
            case CHARACTERL:
                {
                alt80=11;
                }
                break;
            case 127:
                {
                alt80=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:762:5: DECIMALL
                    {
                    root_0 = (Object)adaptor.nil();

                    DECIMALL256=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_literal3166); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMALL256_tree = (Object)adaptor.create(DECIMALL256);
                    adaptor.addChild(root_0, DECIMALL256_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = (DECIMALL256!=null?DECIMALL256.getText():null); retval.dType = "DINT"; 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:763:5: HEXDIGITS
                    {
                    root_0 = (Object)adaptor.nil();

                    HEXDIGITS257=(Token)match(input,HEXDIGITS,FOLLOW_HEXDIGITS_in_literal3175); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HEXDIGITS257_tree = (Object)adaptor.create(HEXDIGITS257);
                    adaptor.addChild(root_0, HEXDIGITS257_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "16#" + (HEXDIGITS257!=null?HEXDIGITS257.getText():null).substring(2); retval.dType = "DWORD"; 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:764:5: FLOATINGPOINTL
                    {
                    root_0 = (Object)adaptor.nil();

                    FLOATINGPOINTL258=(Token)match(input,FLOATINGPOINTL,FOLLOW_FLOATINGPOINTL_in_literal3184); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATINGPOINTL258_tree = (Object)adaptor.create(FLOATINGPOINTL258);
                    adaptor.addChild(root_0, FLOATINGPOINTL258_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = (FLOATINGPOINTL258!=null?FLOATINGPOINTL258.getText():null); retval.dType = "REAL"; 
                    }

                    }
                    break;
                case 4 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:765:5: BINDIGITS
                    {
                    root_0 = (Object)adaptor.nil();

                    BINDIGITS259=(Token)match(input,BINDIGITS,FOLLOW_BINDIGITS_in_literal3193); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BINDIGITS259_tree = (Object)adaptor.create(BINDIGITS259);
                    adaptor.addChild(root_0, BINDIGITS259_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "2#" + (BINDIGITS259!=null?BINDIGITS259.getText():null).substring(2); retval.dType = "BYTE"; 
                    }

                    }
                    break;
                case 5 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:766:5: OCTDIGITS
                    {
                    root_0 = (Object)adaptor.nil();

                    OCTDIGITS260=(Token)match(input,OCTDIGITS,FOLLOW_OCTDIGITS_in_literal3202); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OCTDIGITS260_tree = (Object)adaptor.create(OCTDIGITS260);
                    adaptor.addChild(root_0, OCTDIGITS260_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = "8#" + (OCTDIGITS260!=null?OCTDIGITS260.getText():null).substring(2); retval.dType = "BYTE"; 
                    }

                    }
                    break;
                case 6 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:767:5: timeL
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_timeL_in_literal3210);
                    timeL261=timeL();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timeL261.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (timeL261!=null?timeL261.txt:null); retval.dType = "TIME"; 
                    }

                    }
                    break;
                case 7 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:768:5: todL
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_todL_in_literal3218);
                    todL262=todL();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, todL262.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (todL262!=null?todL262.txt:null); retval.dType = "TOD"; 
                    }

                    }
                    break;
                case 8 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:769:5: dateL
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_dateL_in_literal3226);
                    dateL263=dateL();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dateL263.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (dateL263!=null?dateL263.txt:null); retval.dType = "DATE"; 
                    }

                    }
                    break;
                case 9 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:770:5: datetimeL
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_datetimeL_in_literal3234);
                    datetimeL264=datetimeL();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, datetimeL264.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (datetimeL264!=null?datetimeL264.txt:null); retval.dType = "DT"; 
                    }

                    }
                    break;
                case 10 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:771:5: booleanL
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_booleanL_in_literal3242);
                    booleanL265=booleanL();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, booleanL265.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (booleanL265!=null?booleanL265.txt:null); retval.dType = "BOOL"; 
                    }

                    }
                    break;
                case 11 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:772:5: CHARACTERL
                    {
                    root_0 = (Object)adaptor.nil();

                    CHARACTERL266=(Token)match(input,CHARACTERL,FOLLOW_CHARACTERL_in_literal3250); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTERL266_tree = (Object)adaptor.create(CHARACTERL266);
                    adaptor.addChild(root_0, CHARACTERL266_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.txt = (CHARACTERL266!=null?CHARACTERL266.getText():null); retval.dType = "BYTE"; 
                    }

                    }
                    break;
                case 12 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:773:5: stringL
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_stringL_in_literal3258);
                    stringL267=stringL();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, stringL267.getTree());
                    if ( state.backtracking==0 ) {
                       retval.txt = (stringL267!=null?stringL267.txt:null); retval.dType = "STRING"; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "literal"

    public static class timeL_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "timeL"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:794:1: timeL returns [ String txt ] : ( 't!' (d= DECIMALL 'd' ) (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' ) (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' ) (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' ) (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' ) );
    public final TwyncatParser.timeL_return timeL() throws RecognitionException {
        TwyncatParser.timeL_return retval = new TwyncatParser.timeL_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token d=null;
        Token h=null;
        Token m=null;
        Token s=null;
        Token ms=null;
        Token string_literal268=null;
        Token char_literal269=null;
        Token char_literal270=null;
        Token char_literal271=null;
        Token char_literal272=null;
        Token string_literal273=null;
        Token string_literal274=null;
        Token char_literal275=null;
        Token char_literal276=null;
        Token char_literal277=null;
        Token char_literal278=null;
        Token string_literal279=null;
        Token string_literal280=null;
        Token char_literal281=null;
        Token char_literal282=null;
        Token char_literal283=null;
        Token char_literal284=null;
        Token string_literal285=null;
        Token string_literal286=null;
        Token char_literal287=null;
        Token char_literal288=null;
        Token char_literal289=null;
        Token char_literal290=null;
        Token string_literal291=null;
        Token string_literal292=null;
        Token char_literal293=null;
        Token char_literal294=null;
        Token char_literal295=null;
        Token char_literal296=null;
        Token string_literal297=null;

        Object d_tree=null;
        Object h_tree=null;
        Object m_tree=null;
        Object s_tree=null;
        Object ms_tree=null;
        Object string_literal268_tree=null;
        Object char_literal269_tree=null;
        Object char_literal270_tree=null;
        Object char_literal271_tree=null;
        Object char_literal272_tree=null;
        Object string_literal273_tree=null;
        Object string_literal274_tree=null;
        Object char_literal275_tree=null;
        Object char_literal276_tree=null;
        Object char_literal277_tree=null;
        Object char_literal278_tree=null;
        Object string_literal279_tree=null;
        Object string_literal280_tree=null;
        Object char_literal281_tree=null;
        Object char_literal282_tree=null;
        Object char_literal283_tree=null;
        Object char_literal284_tree=null;
        Object string_literal285_tree=null;
        Object string_literal286_tree=null;
        Object char_literal287_tree=null;
        Object char_literal288_tree=null;
        Object char_literal289_tree=null;
        Object char_literal290_tree=null;
        Object string_literal291_tree=null;
        Object string_literal292_tree=null;
        Object char_literal293_tree=null;
        Object char_literal294_tree=null;
        Object char_literal295_tree=null;
        Object char_literal296_tree=null;
        Object string_literal297_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:3: ( 't!' (d= DECIMALL 'd' ) (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' ) (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' ) (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' ) (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' ) )
            int alt101=5;
            alt101 = dfa101.predict(input);
            switch (alt101) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:5: 't!' (d= DECIMALL 'd' ) (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal268=(Token)match(input,118,FOLLOW_118_in_timeL3459); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal268_tree = (Object)adaptor.create(string_literal268);
                    adaptor.addChild(root_0, string_literal268_tree);
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:10: (d= DECIMALL 'd' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:12: d= DECIMALL 'd'
                    {
                    d=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3465); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    d_tree = (Object)adaptor.create(d);
                    adaptor.addChild(root_0, d_tree);
                    }
                    char_literal269=(Token)match(input,119,FOLLOW_119_in_timeL3467); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal269_tree = (Object)adaptor.create(char_literal269);
                    adaptor.addChild(root_0, char_literal269_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:29: (h= DECIMALL 'h' )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==DECIMALL) ) {
                        int LA81_1 = input.LA(2);

                        if ( (LA81_1==120) ) {
                            alt81=1;
                        }
                    }
                    switch (alt81) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:31: h= DECIMALL 'h'
                            {
                            h=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3475); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            h_tree = (Object)adaptor.create(h);
                            adaptor.addChild(root_0, h_tree);
                            }
                            char_literal270=(Token)match(input,120,FOLLOW_120_in_timeL3477); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal270_tree = (Object)adaptor.create(char_literal270);
                            adaptor.addChild(root_0, char_literal270_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:49: (m= DECIMALL 'm' )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==DECIMALL) ) {
                        int LA82_1 = input.LA(2);

                        if ( (LA82_1==121) ) {
                            alt82=1;
                        }
                    }
                    switch (alt82) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:51: m= DECIMALL 'm'
                            {
                            m=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3486); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            m_tree = (Object)adaptor.create(m);
                            adaptor.addChild(root_0, m_tree);
                            }
                            char_literal271=(Token)match(input,121,FOLLOW_121_in_timeL3488); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal271_tree = (Object)adaptor.create(char_literal271);
                            adaptor.addChild(root_0, char_literal271_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:69: (s= DECIMALL 's' )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==DECIMALL) ) {
                        int LA83_1 = input.LA(2);

                        if ( (LA83_1==122) ) {
                            alt83=1;
                        }
                    }
                    switch (alt83) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:71: s= DECIMALL 's'
                            {
                            s=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3497); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            s_tree = (Object)adaptor.create(s);
                            adaptor.addChild(root_0, s_tree);
                            }
                            char_literal272=(Token)match(input,122,FOLLOW_122_in_timeL3499); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal272_tree = (Object)adaptor.create(char_literal272);
                            adaptor.addChild(root_0, char_literal272_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:89: (ms= DECIMALL 'ms' )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==DECIMALL) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:91: ms= DECIMALL 'ms'
                            {
                            ms=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3508); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ms_tree = (Object)adaptor.create(ms);
                            adaptor.addChild(root_0, ms_tree);
                            }
                            string_literal273=(Token)match(input,123,FOLLOW_123_in_timeL3510); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal273_tree = (Object)adaptor.create(string_literal273);
                            adaptor.addChild(root_0, string_literal273_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = "T#" + (d!=null?d.getText():null) + (h == null?"":(h!=null?h.getText():null) + "h") + (m == null?"":(m!=null?m.getText():null) + "m") + (s == null?"":(s!=null?s.getText():null) + "s") + (ms == null?"":(ms!=null?ms.getText():null) + "ms"); 
                    }

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:5: 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' ) (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal274=(Token)match(input,118,FOLLOW_118_in_timeL3524); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal274_tree = (Object)adaptor.create(string_literal274);
                    adaptor.addChild(root_0, string_literal274_tree);
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:10: (d= DECIMALL 'd' )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==DECIMALL) ) {
                        int LA85_1 = input.LA(2);

                        if ( (LA85_1==119) ) {
                            alt85=1;
                        }
                    }
                    switch (alt85) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:12: d= DECIMALL 'd'
                            {
                            d=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3530); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            d_tree = (Object)adaptor.create(d);
                            adaptor.addChild(root_0, d_tree);
                            }
                            char_literal275=(Token)match(input,119,FOLLOW_119_in_timeL3532); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal275_tree = (Object)adaptor.create(char_literal275);
                            adaptor.addChild(root_0, char_literal275_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:30: (h= DECIMALL 'h' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:32: h= DECIMALL 'h'
                    {
                    h=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3541); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    h_tree = (Object)adaptor.create(h);
                    adaptor.addChild(root_0, h_tree);
                    }
                    char_literal276=(Token)match(input,120,FOLLOW_120_in_timeL3543); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal276_tree = (Object)adaptor.create(char_literal276);
                    adaptor.addChild(root_0, char_literal276_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:49: (m= DECIMALL 'm' )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==DECIMALL) ) {
                        int LA86_1 = input.LA(2);

                        if ( (LA86_1==121) ) {
                            alt86=1;
                        }
                    }
                    switch (alt86) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:51: m= DECIMALL 'm'
                            {
                            m=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3551); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            m_tree = (Object)adaptor.create(m);
                            adaptor.addChild(root_0, m_tree);
                            }
                            char_literal277=(Token)match(input,121,FOLLOW_121_in_timeL3553); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal277_tree = (Object)adaptor.create(char_literal277);
                            adaptor.addChild(root_0, char_literal277_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:69: (s= DECIMALL 's' )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==DECIMALL) ) {
                        int LA87_1 = input.LA(2);

                        if ( (LA87_1==122) ) {
                            alt87=1;
                        }
                    }
                    switch (alt87) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:71: s= DECIMALL 's'
                            {
                            s=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3562); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            s_tree = (Object)adaptor.create(s);
                            adaptor.addChild(root_0, s_tree);
                            }
                            char_literal278=(Token)match(input,122,FOLLOW_122_in_timeL3564); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal278_tree = (Object)adaptor.create(char_literal278);
                            adaptor.addChild(root_0, char_literal278_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:89: (ms= DECIMALL 'ms' )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==DECIMALL) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:91: ms= DECIMALL 'ms'
                            {
                            ms=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3573); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ms_tree = (Object)adaptor.create(ms);
                            adaptor.addChild(root_0, ms_tree);
                            }
                            string_literal279=(Token)match(input,123,FOLLOW_123_in_timeL3575); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal279_tree = (Object)adaptor.create(string_literal279);
                            adaptor.addChild(root_0, string_literal279_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = "T#" + (d == null?"":(d!=null?d.getText():null) + "d") + (h!=null?h.getText():null) + (m == null?"":(m!=null?m.getText():null) + "m") + (s == null?"":(s!=null?s.getText():null) + "s") + (ms == null?"":(ms!=null?ms.getText():null) + "ms"); 
                    }

                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:5: 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' ) (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal280=(Token)match(input,118,FOLLOW_118_in_timeL3589); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal280_tree = (Object)adaptor.create(string_literal280);
                    adaptor.addChild(root_0, string_literal280_tree);
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:10: (d= DECIMALL 'd' )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==DECIMALL) ) {
                        int LA89_1 = input.LA(2);

                        if ( (LA89_1==119) ) {
                            alt89=1;
                        }
                    }
                    switch (alt89) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:12: d= DECIMALL 'd'
                            {
                            d=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3595); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            d_tree = (Object)adaptor.create(d);
                            adaptor.addChild(root_0, d_tree);
                            }
                            char_literal281=(Token)match(input,119,FOLLOW_119_in_timeL3597); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal281_tree = (Object)adaptor.create(char_literal281);
                            adaptor.addChild(root_0, char_literal281_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:30: (h= DECIMALL 'h' )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==DECIMALL) ) {
                        int LA90_1 = input.LA(2);

                        if ( (LA90_1==120) ) {
                            alt90=1;
                        }
                    }
                    switch (alt90) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:32: h= DECIMALL 'h'
                            {
                            h=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3606); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            h_tree = (Object)adaptor.create(h);
                            adaptor.addChild(root_0, h_tree);
                            }
                            char_literal282=(Token)match(input,120,FOLLOW_120_in_timeL3608); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal282_tree = (Object)adaptor.create(char_literal282);
                            adaptor.addChild(root_0, char_literal282_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:50: (m= DECIMALL 'm' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:52: m= DECIMALL 'm'
                    {
                    m=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    m_tree = (Object)adaptor.create(m);
                    adaptor.addChild(root_0, m_tree);
                    }
                    char_literal283=(Token)match(input,121,FOLLOW_121_in_timeL3619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal283_tree = (Object)adaptor.create(char_literal283);
                    adaptor.addChild(root_0, char_literal283_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:69: (s= DECIMALL 's' )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==DECIMALL) ) {
                        int LA91_1 = input.LA(2);

                        if ( (LA91_1==122) ) {
                            alt91=1;
                        }
                    }
                    switch (alt91) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:71: s= DECIMALL 's'
                            {
                            s=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3627); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            s_tree = (Object)adaptor.create(s);
                            adaptor.addChild(root_0, s_tree);
                            }
                            char_literal284=(Token)match(input,122,FOLLOW_122_in_timeL3629); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal284_tree = (Object)adaptor.create(char_literal284);
                            adaptor.addChild(root_0, char_literal284_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:89: (ms= DECIMALL 'ms' )?
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==DECIMALL) ) {
                        alt92=1;
                    }
                    switch (alt92) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:91: ms= DECIMALL 'ms'
                            {
                            ms=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3638); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ms_tree = (Object)adaptor.create(ms);
                            adaptor.addChild(root_0, ms_tree);
                            }
                            string_literal285=(Token)match(input,123,FOLLOW_123_in_timeL3640); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal285_tree = (Object)adaptor.create(string_literal285);
                            adaptor.addChild(root_0, string_literal285_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = "T#" + (d == null?"":(d!=null?d.getText():null) + "d") + (h == null?"":(h!=null?h.getText():null) + "h") + (m!=null?m.getText():null) + (s == null?"":(s!=null?s.getText():null) + "s") + (ms == null?"":(ms!=null?ms.getText():null) + "ms"); 
                    }

                    }
                    break;
                case 4 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:5: 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' ) (ms= DECIMALL 'ms' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal286=(Token)match(input,118,FOLLOW_118_in_timeL3653); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal286_tree = (Object)adaptor.create(string_literal286);
                    adaptor.addChild(root_0, string_literal286_tree);
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:10: (d= DECIMALL 'd' )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==DECIMALL) ) {
                        int LA93_1 = input.LA(2);

                        if ( (LA93_1==119) ) {
                            alt93=1;
                        }
                    }
                    switch (alt93) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:12: d= DECIMALL 'd'
                            {
                            d=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3659); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            d_tree = (Object)adaptor.create(d);
                            adaptor.addChild(root_0, d_tree);
                            }
                            char_literal287=(Token)match(input,119,FOLLOW_119_in_timeL3661); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal287_tree = (Object)adaptor.create(char_literal287);
                            adaptor.addChild(root_0, char_literal287_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:30: (h= DECIMALL 'h' )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==DECIMALL) ) {
                        int LA94_1 = input.LA(2);

                        if ( (LA94_1==120) ) {
                            alt94=1;
                        }
                    }
                    switch (alt94) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:32: h= DECIMALL 'h'
                            {
                            h=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3670); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            h_tree = (Object)adaptor.create(h);
                            adaptor.addChild(root_0, h_tree);
                            }
                            char_literal288=(Token)match(input,120,FOLLOW_120_in_timeL3672); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal288_tree = (Object)adaptor.create(char_literal288);
                            adaptor.addChild(root_0, char_literal288_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:50: (m= DECIMALL 'm' )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==DECIMALL) ) {
                        int LA95_1 = input.LA(2);

                        if ( (LA95_1==121) ) {
                            alt95=1;
                        }
                    }
                    switch (alt95) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:52: m= DECIMALL 'm'
                            {
                            m=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3681); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            m_tree = (Object)adaptor.create(m);
                            adaptor.addChild(root_0, m_tree);
                            }
                            char_literal289=(Token)match(input,121,FOLLOW_121_in_timeL3683); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal289_tree = (Object)adaptor.create(char_literal289);
                            adaptor.addChild(root_0, char_literal289_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:70: (s= DECIMALL 's' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:72: s= DECIMALL 's'
                    {
                    s=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3692); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    s_tree = (Object)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);
                    }
                    char_literal290=(Token)match(input,122,FOLLOW_122_in_timeL3694); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal290_tree = (Object)adaptor.create(char_literal290);
                    adaptor.addChild(root_0, char_literal290_tree);
                    }

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:89: (ms= DECIMALL 'ms' )?
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==DECIMALL) ) {
                        alt96=1;
                    }
                    switch (alt96) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:91: ms= DECIMALL 'ms'
                            {
                            ms=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3702); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ms_tree = (Object)adaptor.create(ms);
                            adaptor.addChild(root_0, ms_tree);
                            }
                            string_literal291=(Token)match(input,123,FOLLOW_123_in_timeL3704); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal291_tree = (Object)adaptor.create(string_literal291);
                            adaptor.addChild(root_0, string_literal291_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = "T#" + (d == null?"":(d!=null?d.getText():null) + "d") + (h == null?"":(h!=null?h.getText():null) + "h") + (m == null?"":(m!=null?m.getText():null) + "m") + (s!=null?s.getText():null) + (ms == null?"":(ms!=null?ms.getText():null) + "ms"); 
                    }

                    }
                    break;
                case 5 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:5: 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal292=(Token)match(input,118,FOLLOW_118_in_timeL3717); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal292_tree = (Object)adaptor.create(string_literal292);
                    adaptor.addChild(root_0, string_literal292_tree);
                    }
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:10: (d= DECIMALL 'd' )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==DECIMALL) ) {
                        int LA97_1 = input.LA(2);

                        if ( (LA97_1==119) ) {
                            alt97=1;
                        }
                    }
                    switch (alt97) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:12: d= DECIMALL 'd'
                            {
                            d=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3723); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            d_tree = (Object)adaptor.create(d);
                            adaptor.addChild(root_0, d_tree);
                            }
                            char_literal293=(Token)match(input,119,FOLLOW_119_in_timeL3725); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal293_tree = (Object)adaptor.create(char_literal293);
                            adaptor.addChild(root_0, char_literal293_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:30: (h= DECIMALL 'h' )?
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( (LA98_0==DECIMALL) ) {
                        int LA98_1 = input.LA(2);

                        if ( (LA98_1==120) ) {
                            alt98=1;
                        }
                    }
                    switch (alt98) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:32: h= DECIMALL 'h'
                            {
                            h=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3734); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            h_tree = (Object)adaptor.create(h);
                            adaptor.addChild(root_0, h_tree);
                            }
                            char_literal294=(Token)match(input,120,FOLLOW_120_in_timeL3736); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal294_tree = (Object)adaptor.create(char_literal294);
                            adaptor.addChild(root_0, char_literal294_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:50: (m= DECIMALL 'm' )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==DECIMALL) ) {
                        int LA99_1 = input.LA(2);

                        if ( (LA99_1==121) ) {
                            alt99=1;
                        }
                    }
                    switch (alt99) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:52: m= DECIMALL 'm'
                            {
                            m=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3745); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            m_tree = (Object)adaptor.create(m);
                            adaptor.addChild(root_0, m_tree);
                            }
                            char_literal295=(Token)match(input,121,FOLLOW_121_in_timeL3747); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal295_tree = (Object)adaptor.create(char_literal295);
                            adaptor.addChild(root_0, char_literal295_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:70: (s= DECIMALL 's' )?
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==DECIMALL) ) {
                        int LA100_1 = input.LA(2);

                        if ( (LA100_1==122) ) {
                            alt100=1;
                        }
                    }
                    switch (alt100) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:72: s= DECIMALL 's'
                            {
                            s=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3756); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            s_tree = (Object)adaptor.create(s);
                            adaptor.addChild(root_0, s_tree);
                            }
                            char_literal296=(Token)match(input,122,FOLLOW_122_in_timeL3758); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal296_tree = (Object)adaptor.create(char_literal296);
                            adaptor.addChild(root_0, char_literal296_tree);
                            }

                            }
                            break;

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:90: (ms= DECIMALL 'ms' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:803:92: ms= DECIMALL 'ms'
                    {
                    ms=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_timeL3767); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ms_tree = (Object)adaptor.create(ms);
                    adaptor.addChild(root_0, ms_tree);
                    }
                    string_literal297=(Token)match(input,123,FOLLOW_123_in_timeL3769); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal297_tree = (Object)adaptor.create(string_literal297);
                    adaptor.addChild(root_0, string_literal297_tree);
                    }

                    }

                    if ( state.backtracking==0 ) {
                       retval.txt = "T#" + (d == null?"":(d!=null?d.getText():null) + "d") + (h == null?"":(h!=null?h.getText():null) + "h") + (m == null?"":(m!=null?m.getText():null) + "m") + (s == null?"":(s!=null?s.getText():null) + "s") + (ms!=null?ms.getText():null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "timeL"

    public static class todL_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "todL"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:807:1: todL returns [ String txt ] : 'tod!' TODLDIGITS ;
    public final TwyncatParser.todL_return todL() throws RecognitionException {
        TwyncatParser.todL_return retval = new TwyncatParser.todL_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal298=null;
        Token TODLDIGITS299=null;

        Object string_literal298_tree=null;
        Object TODLDIGITS299_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:808:3: ( 'tod!' TODLDIGITS )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:808:5: 'tod!' TODLDIGITS
            {
            root_0 = (Object)adaptor.nil();

            string_literal298=(Token)match(input,124,FOLLOW_124_in_todL3792); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal298_tree = (Object)adaptor.create(string_literal298);
            adaptor.addChild(root_0, string_literal298_tree);
            }
            TODLDIGITS299=(Token)match(input,TODLDIGITS,FOLLOW_TODLDIGITS_in_todL3794); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TODLDIGITS299_tree = (Object)adaptor.create(TODLDIGITS299);
            adaptor.addChild(root_0, TODLDIGITS299_tree);
            }
            if ( state.backtracking==0 ) {
               retval.txt = "TOD#" + (TODLDIGITS299!=null?TODLDIGITS299.getText():null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "todL"

    public static class dateL_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dateL"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:813:1: dateL returns [ String txt ] : 'd!' DATEDIGITS ;
    public final TwyncatParser.dateL_return dateL() throws RecognitionException {
        TwyncatParser.dateL_return retval = new TwyncatParser.dateL_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal300=null;
        Token DATEDIGITS301=null;

        Object string_literal300_tree=null;
        Object DATEDIGITS301_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:814:3: ( 'd!' DATEDIGITS )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:814:5: 'd!' DATEDIGITS
            {
            root_0 = (Object)adaptor.nil();

            string_literal300=(Token)match(input,125,FOLLOW_125_in_dateL3843); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal300_tree = (Object)adaptor.create(string_literal300);
            adaptor.addChild(root_0, string_literal300_tree);
            }
            DATEDIGITS301=(Token)match(input,DATEDIGITS,FOLLOW_DATEDIGITS_in_dateL3845); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DATEDIGITS301_tree = (Object)adaptor.create(DATEDIGITS301);
            adaptor.addChild(root_0, DATEDIGITS301_tree);
            }
            if ( state.backtracking==0 ) {
               retval.txt = "D#" + (DATEDIGITS301!=null?DATEDIGITS301.getText():null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "dateL"

    public static class datetimeL_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "datetimeL"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:819:1: datetimeL returns [ String txt ] : 'dt!' DATETIMEDIGITS ;
    public final TwyncatParser.datetimeL_return datetimeL() throws RecognitionException {
        TwyncatParser.datetimeL_return retval = new TwyncatParser.datetimeL_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal302=null;
        Token DATETIMEDIGITS303=null;

        Object string_literal302_tree=null;
        Object DATETIMEDIGITS303_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:820:3: ( 'dt!' DATETIMEDIGITS )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:820:5: 'dt!' DATETIMEDIGITS
            {
            root_0 = (Object)adaptor.nil();

            string_literal302=(Token)match(input,126,FOLLOW_126_in_datetimeL3884); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal302_tree = (Object)adaptor.create(string_literal302);
            adaptor.addChild(root_0, string_literal302_tree);
            }
            DATETIMEDIGITS303=(Token)match(input,DATETIMEDIGITS,FOLLOW_DATETIMEDIGITS_in_datetimeL3886); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DATETIMEDIGITS303_tree = (Object)adaptor.create(DATETIMEDIGITS303);
            adaptor.addChild(root_0, DATETIMEDIGITS303_tree);
            }
            if ( state.backtracking==0 ) {
               retval.txt = "DT#" + (DATETIMEDIGITS303!=null?DATETIMEDIGITS303.getText():null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "datetimeL"

    public static class stringL_return extends ParserRuleReturnScope {
        public String txt;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stringL"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:829:1: stringL returns [ String txt ] : '\"' stringLContent '\"' ;
    public final TwyncatParser.stringL_return stringL() throws RecognitionException {
        TwyncatParser.stringL_return retval = new TwyncatParser.stringL_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal304=null;
        Token char_literal306=null;
        TwyncatParser.stringLContent_return stringLContent305 = null;


        Object char_literal304_tree=null;
        Object char_literal306_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:830:3: ( '\"' stringLContent '\"' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:830:6: '\"' stringLContent '\"'
            {
            root_0 = (Object)adaptor.nil();

            char_literal304=(Token)match(input,127,FOLLOW_127_in_stringL3968); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal304_tree = (Object)adaptor.create(char_literal304);
            adaptor.addChild(root_0, char_literal304_tree);
            }
            pushFollow(FOLLOW_stringLContent_in_stringL3970);
            stringLContent305=stringLContent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, stringLContent305.getTree());
            char_literal306=(Token)match(input,127,FOLLOW_127_in_stringL3972); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal306_tree = (Object)adaptor.create(char_literal306);
            adaptor.addChild(root_0, char_literal306_tree);
            }
            if ( state.backtracking==0 ) {
               retval.txt = "'" + (stringLContent305!=null?input.toString(stringLContent305.start,stringLContent305.stop):null) + "'"; 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "stringL"

    public static class stringLContent_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stringLContent"
    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:833:10: fragment stringLContent : ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* ;
    public final TwyncatParser.stringLContent_return stringLContent() throws RecognitionException {
        TwyncatParser.stringLContent_return retval = new TwyncatParser.stringLContent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set307=null;

        Object set307_tree=null;

        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:833:25: ( ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:833:27: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
            {
            root_0 = (Object)adaptor.nil();

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:833:27: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( ((LA102_0>=INDENT && LA102_0<=126)) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:
            	    {
            	    set307=(Token)input.LT(1);
            	    if ( (input.LA(1)>=INDENT && input.LA(1)<=126) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set307));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop102;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        	catch (RecognitionException re) {
        		throw re;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "stringLContent"

    // $ANTLR start synpred24_twyncat
    public final void synpred24_twyncat_fragment() throws RecognitionException {   
        TwyncatParser.callFuncArgs_return cfa = null;


        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:277:80: (cfa= callFuncArgs )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:277:80: cfa= callFuncArgs
        {
        pushFollow(FOLLOW_callFuncArgs_in_synpred24_twyncat396);
        cfa=callFuncArgs();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_twyncat

    // $ANTLR start synpred26_twyncat
    public final void synpred26_twyncat_fragment() throws RecognitionException {   
        TwyncatParser.callFuncBlockArgs_return cfb = null;


        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:291:28: (cfb= callFuncBlockArgs )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:291:28: cfb= callFuncBlockArgs
        {
        pushFollow(FOLLOW_callFuncBlockArgs_in_synpred26_twyncat433);
        cfb=callFuncBlockArgs();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_twyncat

    // $ANTLR start synpred56_twyncat
    public final void synpred56_twyncat_fragment() throws RecognitionException {   
        Token strl=null;
        TwyncatParser.test_return t = null;


        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:4: ( ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:4: ( '[' strl= DECIMALL ']' )? ( '=' t= test )?
        {
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:4: ( '[' strl= DECIMALL ']' )?
        int alt111=2;
        int LA111_0 = input.LA(1);

        if ( (LA111_0==LBRACK) ) {
            alt111=1;
        }
        switch (alt111) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:6: '[' strl= DECIMALL ']'
                {
                match(input,LBRACK,FOLLOW_LBRACK_in_synpred56_twyncat1075); if (state.failed) return ;
                strl=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred56_twyncat1079); if (state.failed) return ;
                match(input,RBRACK,FOLLOW_RBRACK_in_synpred56_twyncat1081); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:31: ( '=' t= test )?
        int alt112=2;
        int LA112_0 = input.LA(1);

        if ( (LA112_0==ASSIGN) ) {
            alt112=1;
        }
        switch (alt112) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:388:32: '=' t= test
                {
                match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred56_twyncat1087); if (state.failed) return ;
                pushFollow(FOLLOW_test_in_synpred56_twyncat1091);
                t=test();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred56_twyncat

    // $ANTLR start synpred70_twyncat
    public final void synpred70_twyncat_fragment() throws RecognitionException {   
        Token strl=null;
        TwyncatParser.test_return t = null;


        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:4: ( ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:4: ( '[' strl= DECIMALL ']' )? ( '=' t= test )?
        {
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:4: ( '[' strl= DECIMALL ']' )?
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==LBRACK) ) {
            alt114=1;
        }
        switch (alt114) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:6: '[' strl= DECIMALL ']'
                {
                match(input,LBRACK,FOLLOW_LBRACK_in_synpred70_twyncat1333); if (state.failed) return ;
                strl=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred70_twyncat1337); if (state.failed) return ;
                match(input,RBRACK,FOLLOW_RBRACK_in_synpred70_twyncat1339); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:31: ( '=' t= test )?
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==ASSIGN) ) {
            alt115=1;
        }
        switch (alt115) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:468:32: '=' t= test
                {
                match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred70_twyncat1345); if (state.failed) return ;
                pushFollow(FOLLOW_test_in_synpred70_twyncat1349);
                t=test();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred70_twyncat

    // $ANTLR start synpred73_twyncat
    public final void synpred73_twyncat_fragment() throws RecognitionException {   
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:486:4: ( ( LBRACK literalsList RBRACK ) )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:486:4: ( LBRACK literalsList RBRACK )
        {
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:486:4: ( LBRACK literalsList RBRACK )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:486:6: LBRACK literalsList RBRACK
        {
        match(input,LBRACK,FOLLOW_LBRACK_in_synpred73_twyncat1500); if (state.failed) return ;
        pushFollow(FOLLOW_literalsList_in_synpred73_twyncat1502);
        literalsList();

        state._fsp--;
        if (state.failed) return ;
        match(input,RBRACK,FOLLOW_RBRACK_in_synpred73_twyncat1504); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred73_twyncat

    // $ANTLR start synpred74_twyncat
    public final void synpred74_twyncat_fragment() throws RecognitionException {   
        TwyncatParser.literalsList_return first = null;

        TwyncatParser.literalsList_return second = null;


        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:4: ( ( LBRACK first= literalsList RBRACK ) ( LBRACK second= literalsList RBRACK ) )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:4: ( LBRACK first= literalsList RBRACK ) ( LBRACK second= literalsList RBRACK )
        {
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:4: ( LBRACK first= literalsList RBRACK )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:6: LBRACK first= literalsList RBRACK
        {
        match(input,LBRACK,FOLLOW_LBRACK_in_synpred74_twyncat1516); if (state.failed) return ;
        pushFollow(FOLLOW_literalsList_in_synpred74_twyncat1520);
        first=literalsList();

        state._fsp--;
        if (state.failed) return ;
        match(input,RBRACK,FOLLOW_RBRACK_in_synpred74_twyncat1522); if (state.failed) return ;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:41: ( LBRACK second= literalsList RBRACK )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:488:43: LBRACK second= literalsList RBRACK
        {
        match(input,LBRACK,FOLLOW_LBRACK_in_synpred74_twyncat1528); if (state.failed) return ;
        pushFollow(FOLLOW_literalsList_in_synpred74_twyncat1532);
        second=literalsList();

        state._fsp--;
        if (state.failed) return ;
        match(input,RBRACK,FOLLOW_RBRACK_in_synpred74_twyncat1534); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred74_twyncat

    // $ANTLR start synpred83_twyncat
    public final void synpred83_twyncat_fragment() throws RecognitionException {   
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:539:4: ( exprStm )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:539:4: exprStm
        {
        pushFollow(FOLLOW_exprStm_in_synpred83_twyncat1811);
        exprStm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred83_twyncat

    // $ANTLR start synpred84_twyncat
    public final void synpred84_twyncat_fragment() throws RecognitionException {   
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:540:4: ( flowStm )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:540:4: flowStm
        {
        pushFollow(FOLLOW_flowStm_in_synpred84_twyncat1818);
        flowStm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred84_twyncat

    // $ANTLR start synpred86_twyncat
    public final void synpred86_twyncat_fragment() throws RecognitionException {   
        TwyncatParser.test_return t1 = null;

        TwyncatParser.test_return t2 = null;


        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:547:4: (t1= test augAssign t2= test )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:547:4: t1= test augAssign t2= test
        {
        pushFollow(FOLLOW_test_in_synpred86_twyncat1855);
        t1=test();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_augAssign_in_synpred86_twyncat1857);
        augAssign();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_test_in_synpred86_twyncat1861);
        t2=test();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_twyncat

    // $ANTLR start synpred95_twyncat
    public final void synpred95_twyncat_fragment() throws RecognitionException {   
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:564:4: ( callFunc )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:564:4: callFunc
        {
        pushFollow(FOLLOW_callFunc_in_synpred95_twyncat1968);
        callFunc();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred95_twyncat

    // $ANTLR start synpred119_twyncat
    public final void synpred119_twyncat_fragment() throws RecognitionException {   
        TwyncatParser.arithExpr_return aril = null;

        TwyncatParser.arithExpr_return ariL = null;


        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:699:4: (aril= arithExpr '<<' ariL= arithExpr )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:699:4: aril= arithExpr '<<' ariL= arithExpr
        {
        pushFollow(FOLLOW_arithExpr_in_synpred119_twyncat2731);
        aril=arithExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,LEFTSHIFT,FOLLOW_LEFTSHIFT_in_synpred119_twyncat2733); if (state.failed) return ;
        pushFollow(FOLLOW_arithExpr_in_synpred119_twyncat2737);
        ariL=arithExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred119_twyncat

    // $ANTLR start synpred120_twyncat
    public final void synpred120_twyncat_fragment() throws RecognitionException {   
        TwyncatParser.arithExpr_return arir = null;

        TwyncatParser.arithExpr_return ariR = null;


        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:700:4: (arir= arithExpr '>>' ariR= arithExpr )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:700:4: arir= arithExpr '>>' ariR= arithExpr
        {
        pushFollow(FOLLOW_arithExpr_in_synpred120_twyncat2746);
        arir=arithExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,RIGHTSHIFT,FOLLOW_RIGHTSHIFT_in_synpred120_twyncat2748); if (state.failed) return ;
        pushFollow(FOLLOW_arithExpr_in_synpred120_twyncat2752);
        ariR=arithExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred120_twyncat

    // $ANTLR start synpred134_twyncat
    public final void synpred134_twyncat_fragment() throws RecognitionException {   
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:747:4: ( ( LBRACK expr RBRACK ) )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:747:4: ( LBRACK expr RBRACK )
        {
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:747:4: ( LBRACK expr RBRACK )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:747:6: LBRACK expr RBRACK
        {
        match(input,LBRACK,FOLLOW_LBRACK_in_synpred134_twyncat3037); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred134_twyncat3039);
        expr();

        state._fsp--;
        if (state.failed) return ;
        match(input,RBRACK,FOLLOW_RBRACK_in_synpred134_twyncat3041); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred134_twyncat

    // $ANTLR start synpred135_twyncat
    public final void synpred135_twyncat_fragment() throws RecognitionException {   
        TwyncatParser.expr_return first = null;

        TwyncatParser.expr_return second = null;


        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:4: ( ( LBRACK first= expr RBRACK ) ( LBRACK second= expr RBRACK ) )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:4: ( LBRACK first= expr RBRACK ) ( LBRACK second= expr RBRACK )
        {
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:4: ( LBRACK first= expr RBRACK )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:6: LBRACK first= expr RBRACK
        {
        match(input,LBRACK,FOLLOW_LBRACK_in_synpred135_twyncat3053); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred135_twyncat3057);
        first=expr();

        state._fsp--;
        if (state.failed) return ;
        match(input,RBRACK,FOLLOW_RBRACK_in_synpred135_twyncat3059); if (state.failed) return ;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:33: ( LBRACK second= expr RBRACK )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:749:35: LBRACK second= expr RBRACK
        {
        match(input,LBRACK,FOLLOW_LBRACK_in_synpred135_twyncat3065); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred135_twyncat3069);
        second=expr();

        state._fsp--;
        if (state.failed) return ;
        match(input,RBRACK,FOLLOW_RBRACK_in_synpred135_twyncat3071); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred135_twyncat

    // $ANTLR start synpred152_twyncat
    public final void synpred152_twyncat_fragment() throws RecognitionException {   
        Token d=null;
        Token h=null;
        Token m=null;
        Token s=null;
        Token ms=null;

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:5: ( 't!' (d= DECIMALL 'd' ) (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:5: 't!' (d= DECIMALL 'd' ) (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )?
        {
        match(input,118,FOLLOW_118_in_synpred152_twyncat3459); if (state.failed) return ;
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:10: (d= DECIMALL 'd' )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:12: d= DECIMALL 'd'
        {
        d=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred152_twyncat3465); if (state.failed) return ;
        match(input,119,FOLLOW_119_in_synpred152_twyncat3467); if (state.failed) return ;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:29: (h= DECIMALL 'h' )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==DECIMALL) ) {
            int LA118_1 = input.LA(2);

            if ( (LA118_1==120) ) {
                alt118=1;
            }
        }
        switch (alt118) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:31: h= DECIMALL 'h'
                {
                h=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred152_twyncat3475); if (state.failed) return ;
                match(input,120,FOLLOW_120_in_synpred152_twyncat3477); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:49: (m= DECIMALL 'm' )?
        int alt119=2;
        int LA119_0 = input.LA(1);

        if ( (LA119_0==DECIMALL) ) {
            int LA119_1 = input.LA(2);

            if ( (LA119_1==121) ) {
                alt119=1;
            }
        }
        switch (alt119) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:51: m= DECIMALL 'm'
                {
                m=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred152_twyncat3486); if (state.failed) return ;
                match(input,121,FOLLOW_121_in_synpred152_twyncat3488); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:69: (s= DECIMALL 's' )?
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==DECIMALL) ) {
            int LA120_1 = input.LA(2);

            if ( (LA120_1==122) ) {
                alt120=1;
            }
        }
        switch (alt120) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:71: s= DECIMALL 's'
                {
                s=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred152_twyncat3497); if (state.failed) return ;
                match(input,122,FOLLOW_122_in_synpred152_twyncat3499); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:89: (ms= DECIMALL 'ms' )?
        int alt121=2;
        int LA121_0 = input.LA(1);

        if ( (LA121_0==DECIMALL) ) {
            alt121=1;
        }
        switch (alt121) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:795:91: ms= DECIMALL 'ms'
                {
                ms=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred152_twyncat3508); if (state.failed) return ;
                match(input,123,FOLLOW_123_in_synpred152_twyncat3510); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred152_twyncat

    // $ANTLR start synpred157_twyncat
    public final void synpred157_twyncat_fragment() throws RecognitionException {   
        Token d=null;
        Token h=null;
        Token m=null;
        Token s=null;
        Token ms=null;

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:5: ( 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' ) (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:5: 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' ) (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )?
        {
        match(input,118,FOLLOW_118_in_synpred157_twyncat3524); if (state.failed) return ;
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:10: (d= DECIMALL 'd' )?
        int alt122=2;
        int LA122_0 = input.LA(1);

        if ( (LA122_0==DECIMALL) ) {
            int LA122_1 = input.LA(2);

            if ( (LA122_1==119) ) {
                alt122=1;
            }
        }
        switch (alt122) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:12: d= DECIMALL 'd'
                {
                d=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred157_twyncat3530); if (state.failed) return ;
                match(input,119,FOLLOW_119_in_synpred157_twyncat3532); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:30: (h= DECIMALL 'h' )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:32: h= DECIMALL 'h'
        {
        h=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred157_twyncat3541); if (state.failed) return ;
        match(input,120,FOLLOW_120_in_synpred157_twyncat3543); if (state.failed) return ;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:49: (m= DECIMALL 'm' )?
        int alt123=2;
        int LA123_0 = input.LA(1);

        if ( (LA123_0==DECIMALL) ) {
            int LA123_1 = input.LA(2);

            if ( (LA123_1==121) ) {
                alt123=1;
            }
        }
        switch (alt123) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:51: m= DECIMALL 'm'
                {
                m=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred157_twyncat3551); if (state.failed) return ;
                match(input,121,FOLLOW_121_in_synpred157_twyncat3553); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:69: (s= DECIMALL 's' )?
        int alt124=2;
        int LA124_0 = input.LA(1);

        if ( (LA124_0==DECIMALL) ) {
            int LA124_1 = input.LA(2);

            if ( (LA124_1==122) ) {
                alt124=1;
            }
        }
        switch (alt124) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:71: s= DECIMALL 's'
                {
                s=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred157_twyncat3562); if (state.failed) return ;
                match(input,122,FOLLOW_122_in_synpred157_twyncat3564); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:89: (ms= DECIMALL 'ms' )?
        int alt125=2;
        int LA125_0 = input.LA(1);

        if ( (LA125_0==DECIMALL) ) {
            alt125=1;
        }
        switch (alt125) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:797:91: ms= DECIMALL 'ms'
                {
                ms=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred157_twyncat3573); if (state.failed) return ;
                match(input,123,FOLLOW_123_in_synpred157_twyncat3575); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred157_twyncat

    // $ANTLR start synpred162_twyncat
    public final void synpred162_twyncat_fragment() throws RecognitionException {   
        Token d=null;
        Token h=null;
        Token m=null;
        Token s=null;
        Token ms=null;

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:5: ( 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' ) (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:5: 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' ) (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )?
        {
        match(input,118,FOLLOW_118_in_synpred162_twyncat3589); if (state.failed) return ;
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:10: (d= DECIMALL 'd' )?
        int alt126=2;
        int LA126_0 = input.LA(1);

        if ( (LA126_0==DECIMALL) ) {
            int LA126_1 = input.LA(2);

            if ( (LA126_1==119) ) {
                alt126=1;
            }
        }
        switch (alt126) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:12: d= DECIMALL 'd'
                {
                d=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred162_twyncat3595); if (state.failed) return ;
                match(input,119,FOLLOW_119_in_synpred162_twyncat3597); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:30: (h= DECIMALL 'h' )?
        int alt127=2;
        int LA127_0 = input.LA(1);

        if ( (LA127_0==DECIMALL) ) {
            int LA127_1 = input.LA(2);

            if ( (LA127_1==120) ) {
                alt127=1;
            }
        }
        switch (alt127) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:32: h= DECIMALL 'h'
                {
                h=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred162_twyncat3606); if (state.failed) return ;
                match(input,120,FOLLOW_120_in_synpred162_twyncat3608); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:50: (m= DECIMALL 'm' )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:52: m= DECIMALL 'm'
        {
        m=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred162_twyncat3617); if (state.failed) return ;
        match(input,121,FOLLOW_121_in_synpred162_twyncat3619); if (state.failed) return ;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:69: (s= DECIMALL 's' )?
        int alt128=2;
        int LA128_0 = input.LA(1);

        if ( (LA128_0==DECIMALL) ) {
            int LA128_1 = input.LA(2);

            if ( (LA128_1==122) ) {
                alt128=1;
            }
        }
        switch (alt128) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:71: s= DECIMALL 's'
                {
                s=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred162_twyncat3627); if (state.failed) return ;
                match(input,122,FOLLOW_122_in_synpred162_twyncat3629); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:89: (ms= DECIMALL 'ms' )?
        int alt129=2;
        int LA129_0 = input.LA(1);

        if ( (LA129_0==DECIMALL) ) {
            alt129=1;
        }
        switch (alt129) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:799:91: ms= DECIMALL 'ms'
                {
                ms=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred162_twyncat3638); if (state.failed) return ;
                match(input,123,FOLLOW_123_in_synpred162_twyncat3640); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred162_twyncat

    // $ANTLR start synpred167_twyncat
    public final void synpred167_twyncat_fragment() throws RecognitionException {   
        Token d=null;
        Token h=null;
        Token m=null;
        Token s=null;
        Token ms=null;

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:5: ( 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' ) (ms= DECIMALL 'ms' )? )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:5: 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' ) (ms= DECIMALL 'ms' )?
        {
        match(input,118,FOLLOW_118_in_synpred167_twyncat3653); if (state.failed) return ;
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:10: (d= DECIMALL 'd' )?
        int alt130=2;
        int LA130_0 = input.LA(1);

        if ( (LA130_0==DECIMALL) ) {
            int LA130_1 = input.LA(2);

            if ( (LA130_1==119) ) {
                alt130=1;
            }
        }
        switch (alt130) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:12: d= DECIMALL 'd'
                {
                d=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred167_twyncat3659); if (state.failed) return ;
                match(input,119,FOLLOW_119_in_synpred167_twyncat3661); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:30: (h= DECIMALL 'h' )?
        int alt131=2;
        int LA131_0 = input.LA(1);

        if ( (LA131_0==DECIMALL) ) {
            int LA131_1 = input.LA(2);

            if ( (LA131_1==120) ) {
                alt131=1;
            }
        }
        switch (alt131) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:32: h= DECIMALL 'h'
                {
                h=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred167_twyncat3670); if (state.failed) return ;
                match(input,120,FOLLOW_120_in_synpred167_twyncat3672); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:50: (m= DECIMALL 'm' )?
        int alt132=2;
        int LA132_0 = input.LA(1);

        if ( (LA132_0==DECIMALL) ) {
            int LA132_1 = input.LA(2);

            if ( (LA132_1==121) ) {
                alt132=1;
            }
        }
        switch (alt132) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:52: m= DECIMALL 'm'
                {
                m=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred167_twyncat3681); if (state.failed) return ;
                match(input,121,FOLLOW_121_in_synpred167_twyncat3683); if (state.failed) return ;

                }
                break;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:70: (s= DECIMALL 's' )
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:72: s= DECIMALL 's'
        {
        s=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred167_twyncat3692); if (state.failed) return ;
        match(input,122,FOLLOW_122_in_synpred167_twyncat3694); if (state.failed) return ;

        }

        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:89: (ms= DECIMALL 'ms' )?
        int alt133=2;
        int LA133_0 = input.LA(1);

        if ( (LA133_0==DECIMALL) ) {
            alt133=1;
        }
        switch (alt133) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:801:91: ms= DECIMALL 'ms'
                {
                ms=(Token)match(input,DECIMALL,FOLLOW_DECIMALL_in_synpred167_twyncat3702); if (state.failed) return ;
                match(input,123,FOLLOW_123_in_synpred167_twyncat3704); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred167_twyncat

    // Delegated rules

    public final boolean synpred119_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred152_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred152_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred134_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred74_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred74_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred73_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred73_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred95_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred95_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred120_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred120_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred157_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred157_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred167_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred167_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred162_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred162_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred84_twyncat() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_twyncat_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA38 dfa38 = new DFA38(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA101 dfa101 = new DFA101(this);
    static final String DFA38_eotS =
        "\12\uffff";
    static final String DFA38_eofS =
        "\1\6\11\uffff";
    static final String DFA38_minS =
        "\1\13\1\11\1\uffff\4\0\1\12\2\uffff";
    static final String DFA38_maxS =
        "\1\100\1\11\1\uffff\4\0\1\16\2\uffff";
    static final String DFA38_acceptS =
        "\2\uffff\1\2\5\uffff\1\3\1\1";
    static final String DFA38_specialS =
        "\3\uffff\1\1\1\0\1\3\1\2\3\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\5\1\uffff\1\1\1\uffff\1\4\30\uffff\1\2\27\uffff\1\3",
            "\1\7",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\11\3\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "467:2: ( arrayModifier ( '=' ace= arrayConstantExpression )? | ( '[' strl= DECIMALL ']' )? ( '=' t= test )? )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_4 = input.LA(1);

                         
                        int index38_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_twyncat()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index38_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_3 = input.LA(1);

                         
                        int index38_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_twyncat()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index38_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA38_6 = input.LA(1);

                         
                        int index38_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_twyncat()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index38_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA38_5 = input.LA(1);

                         
                        int index38_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_twyncat()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index38_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA39_eotS =
        "\16\uffff";
    static final String DFA39_eofS =
        "\5\uffff\1\7\5\uffff\1\14\2\uffff";
    static final String DFA39_minS =
        "\1\15\1\11\1\12\1\11\1\16\1\13\1\11\1\uffff\1\12\1\11\1\16\1\13"+
        "\2\uffff";
    static final String DFA39_maxS =
        "\1\15\1\11\1\12\1\11\1\16\1\100\1\11\1\uffff\1\12\1\11\1\16\1\100"+
        "\2\uffff";
    static final String DFA39_acceptS =
        "\7\uffff\1\1\4\uffff\1\2\1\3";
    static final String DFA39_specialS =
        "\16\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\5",
            "\1\7\1\uffff\1\6\1\uffff\1\7\30\uffff\1\7\27\uffff\1\7",
            "\1\10",
            "",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14\1\uffff\1\15\1\uffff\1\14\30\uffff\1\14\27\uffff\1\14",
            "",
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "471:1: arrayModifier returns [ String txt ] : ( ( LBRACK arrayRange RBRACK ) | ( LBRACK first= arrayRange RBRACK ) ( LBRACK second= arrayRange RBRACK ) | ( LBRACK first= arrayRange RBRACK ) ( LBRACK second= arrayRange RBRACK ) ( LBRACK third= arrayRange RBRACK ) );";
        }
    }
    static final String DFA48_eotS =
        "\60\uffff";
    static final String DFA48_eofS =
        "\60\uffff";
    static final String DFA48_minS =
        "\1\6\3\uffff\1\0\53\uffff";
    static final String DFA48_maxS =
        "\1\177\3\uffff\1\0\53\uffff";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\21\uffff\1\2\1\uffff\1\3\1\4\31\uffff";
    static final String DFA48_specialS =
        "\4\uffff\1\0\53\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\4\2\uffff\1\1\6\uffff\5\1\11\uffff\1\1\1\uffff\2\1\42\uffff"+
            "\24\26\2\1\10\uffff\6\26\2\23\7\uffff\1\25\3\uffff\2\1\5\uffff"+
            "\4\1",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "537:1: smallStm returns [ List<String> statements, VariablesBundle vbund ] : ( exprStm | flowStm | repeatUntilStm | d= definition );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA48_4 = input.LA(1);

                         
                        int index48_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_twyncat()) ) {s = 1;}

                        else if ( (synpred84_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index48_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 48, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA49_eotS =
        "\25\uffff";
    static final String DFA49_eofS =
        "\25\uffff";
    static final String DFA49_minS =
        "\1\6\22\0\2\uffff";
    static final String DFA49_maxS =
        "\1\177\22\0\2\uffff";
    static final String DFA49_acceptS =
        "\23\uffff\1\1\1\2";
    static final String DFA49_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\2\uffff}>";
    static final String[] DFA49_transitionS = {
            "\1\4\2\uffff\1\5\6\uffff\1\6\1\7\1\10\1\11\1\20\11\uffff\1"+
            "\22\1\uffff\1\2\1\3\66\uffff\1\16\1\17\33\uffff\1\1\1\12\5\uffff"+
            "\1\13\1\14\1\15\1\21",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA49_eot = DFA.unpackEncodedString(DFA49_eotS);
    static final short[] DFA49_eof = DFA.unpackEncodedString(DFA49_eofS);
    static final char[] DFA49_min = DFA.unpackEncodedStringToUnsignedChars(DFA49_minS);
    static final char[] DFA49_max = DFA.unpackEncodedStringToUnsignedChars(DFA49_maxS);
    static final short[] DFA49_accept = DFA.unpackEncodedString(DFA49_acceptS);
    static final short[] DFA49_special = DFA.unpackEncodedString(DFA49_specialS);
    static final short[][] DFA49_transition;

    static {
        int numStates = DFA49_transitionS.length;
        DFA49_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA49_transition[i] = DFA.unpackEncodedString(DFA49_transitionS[i]);
        }
    }

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = DFA49_eot;
            this.eof = DFA49_eof;
            this.min = DFA49_min;
            this.max = DFA49_max;
            this.accept = DFA49_accept;
            this.special = DFA49_special;
            this.transition = DFA49_transition;
        }
        public String getDescription() {
            return "546:1: exprStm returns [ String txt ] : (t1= test augAssign t2= test | t3= test '=' t4= test );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA49_1 = input.LA(1);

                         
                        int index49_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA49_2 = input.LA(1);

                         
                        int index49_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA49_3 = input.LA(1);

                         
                        int index49_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA49_4 = input.LA(1);

                         
                        int index49_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA49_5 = input.LA(1);

                         
                        int index49_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA49_6 = input.LA(1);

                         
                        int index49_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA49_7 = input.LA(1);

                         
                        int index49_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA49_8 = input.LA(1);

                         
                        int index49_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA49_9 = input.LA(1);

                         
                        int index49_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA49_10 = input.LA(1);

                         
                        int index49_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA49_11 = input.LA(1);

                         
                        int index49_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA49_12 = input.LA(1);

                         
                        int index49_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA49_13 = input.LA(1);

                         
                        int index49_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA49_14 = input.LA(1);

                         
                        int index49_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA49_15 = input.LA(1);

                         
                        int index49_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA49_16 = input.LA(1);

                         
                        int index49_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA49_17 = input.LA(1);

                         
                        int index49_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA49_18 = input.LA(1);

                         
                        int index49_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index49_18);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 49, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA51_eotS =
        "\15\uffff";
    static final String DFA51_eofS =
        "\15\uffff";
    static final String DFA51_minS =
        "\1\6\2\uffff\1\14\2\6\1\14\1\uffff\1\14\1\0\1\6\1\uffff\1\14";
    static final String DFA51_maxS =
        "\1\151\2\uffff\1\36\1\6\1\177\1\36\1\uffff\1\164\1\0\1\6\1\uffff"+
        "\1\164";
    static final String DFA51_acceptS =
        "\1\uffff\1\1\1\2\4\uffff\1\3\3\uffff\1\4\1\uffff";
    static final String DFA51_specialS =
        "\11\uffff\1\0\3\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\3\141\uffff\1\1\1\2",
            "",
            "",
            "\1\4\21\uffff\1\5",
            "\1\6",
            "\1\10\2\uffff\1\7\6\uffff\5\7\11\uffff\1\7\1\11\2\7\66\uffff"+
            "\2\7\33\uffff\2\7\5\uffff\4\7",
            "\1\4\21\uffff\1\5",
            "",
            "\1\12\1\7\20\uffff\12\7\1\13\1\7\1\uffff\1\7\1\uffff\5\7\2"+
            "\uffff\1\7\10\uffff\1\7\1\uffff\2\7\62\uffff\2\7",
            "\1\uffff",
            "\1\14",
            "",
            "\1\12\1\7\20\uffff\12\7\1\13\1\7\1\uffff\1\7\1\uffff\5\7\2"+
            "\uffff\1\7\10\uffff\1\7\1\uffff\2\7\62\uffff\2\7"
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "561:1: flowStm returns [ String txt ] : ( 'return' | 'exit' | callFunc | callFuncBlock );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_9 = input.LA(1);

                         
                        int index51_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_twyncat()) ) {s = 7;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index51_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\25\uffff";
    static final String DFA68_eofS =
        "\25\uffff";
    static final String DFA68_minS =
        "\1\6\21\0\3\uffff";
    static final String DFA68_maxS =
        "\1\177\21\0\3\uffff";
    static final String DFA68_acceptS =
        "\22\uffff\1\1\1\2\1\3";
    static final String DFA68_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\3\uffff}>";
    static final String[] DFA68_transitionS = {
            "\1\3\2\uffff\1\4\6\uffff\1\5\1\6\1\7\1\10\1\17\11\uffff\1\21"+
            "\1\uffff\1\1\1\2\66\uffff\1\15\1\16\34\uffff\1\11\5\uffff\1"+
            "\12\1\13\1\14\1\20",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "696:1: shiftExpr returns [ String txt, String dType ] : (aril= arithExpr '<<' ariL= arithExpr | arir= arithExpr '>>' ariR= arithExpr | ari= arithExpr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA68_1 = input.LA(1);

                         
                        int index68_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA68_2 = input.LA(1);

                         
                        int index68_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA68_3 = input.LA(1);

                         
                        int index68_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA68_4 = input.LA(1);

                         
                        int index68_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA68_5 = input.LA(1);

                         
                        int index68_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA68_6 = input.LA(1);

                         
                        int index68_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA68_7 = input.LA(1);

                         
                        int index68_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA68_8 = input.LA(1);

                         
                        int index68_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA68_9 = input.LA(1);

                         
                        int index68_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA68_10 = input.LA(1);

                         
                        int index68_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA68_11 = input.LA(1);

                         
                        int index68_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA68_12 = input.LA(1);

                         
                        int index68_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA68_13 = input.LA(1);

                         
                        int index68_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA68_14 = input.LA(1);

                         
                        int index68_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA68_15 = input.LA(1);

                         
                        int index68_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA68_16 = input.LA(1);

                         
                        int index68_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA68_17 = input.LA(1);

                         
                        int index68_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_twyncat()) ) {s = 18;}

                        else if ( (synpred120_twyncat()) ) {s = 19;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index68_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 68, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA77_eotS =
        "\10\uffff";
    static final String DFA77_eofS =
        "\1\uffff\1\6\5\uffff\1\6";
    static final String DFA77_minS =
        "\1\6\1\10\2\uffff\1\6\2\uffff\1\10";
    static final String DFA77_maxS =
        "\1\177\1\164\2\uffff\1\6\2\uffff\1\164";
    static final String DFA77_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\4\1\1\1\uffff";
    static final String DFA77_specialS =
        "\10\uffff}>";
    static final String[] DFA77_transitionS = {
            "\1\1\2\uffff\1\2\6\uffff\5\2\11\uffff\1\3\71\uffff\2\2\34\uffff"+
            "\1\2\5\uffff\4\2",
            "\1\6\1\uffff\2\6\1\4\3\6\16\uffff\1\5\13\6\1\uffff\1\6\1\uffff"+
            "\11\6\1\uffff\4\6\2\uffff\1\6\1\uffff\2\6\62\uffff\2\6",
            "",
            "",
            "\1\7",
            "",
            "",
            "\1\6\1\uffff\2\6\1\4\3\6\16\uffff\1\5\13\6\1\uffff\1\6\1\uffff"+
            "\11\6\1\uffff\4\6\2\uffff\1\6\1\uffff\2\6\62\uffff\2\6"
    };

    static final short[] DFA77_eot = DFA.unpackEncodedString(DFA77_eotS);
    static final short[] DFA77_eof = DFA.unpackEncodedString(DFA77_eofS);
    static final char[] DFA77_min = DFA.unpackEncodedStringToUnsignedChars(DFA77_minS);
    static final char[] DFA77_max = DFA.unpackEncodedStringToUnsignedChars(DFA77_maxS);
    static final short[] DFA77_accept = DFA.unpackEncodedString(DFA77_acceptS);
    static final short[] DFA77_special = DFA.unpackEncodedString(DFA77_specialS);
    static final short[][] DFA77_transition;

    static {
        int numStates = DFA77_transitionS.length;
        DFA77_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA77_transition[i] = DFA.unpackEncodedString(DFA77_transitionS[i]);
        }
    }

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = DFA77_eot;
            this.eof = DFA77_eof;
            this.min = DFA77_min;
            this.max = DFA77_max;
            this.accept = DFA77_accept;
            this.special = DFA77_special;
            this.transition = DFA77_transition;
        }
        public String getDescription() {
            return "736:1: atom returns [ String txt, String dType ] : ( ID ( trailer )? ( arrayModifierEl )? | literal | '(' test ')' | callFunc );";
        }
    }
    static final String DFA101_eotS =
        "\34\uffff";
    static final String DFA101_eofS =
        "\3\uffff\1\11\1\13\1\15\1\17\25\uffff";
    static final String DFA101_minS =
        "\1\166\1\11\1\167\4\10\1\uffff\1\170\1\uffff\1\171\1\uffff\1\172"+
        "\1\uffff\1\173\1\uffff\3\11\1\0\2\11\1\0\1\11\2\0\1\171\1\172";
    static final String DFA101_maxS =
        "\1\166\1\11\1\173\4\164\1\uffff\1\173\1\uffff\1\173\1\uffff\1\173"+
        "\1\uffff\1\173\1\uffff\3\11\1\0\2\11\1\0\1\11\2\0\2\173";
    static final String DFA101_acceptS =
        "\7\uffff\1\5\1\uffff\1\1\1\uffff\1\2\1\uffff\1\3\1\uffff\1\4\14"+
        "\uffff";
    static final String DFA101_specialS =
        "\20\uffff\1\1\1\5\1\10\1\7\1\6\1\11\1\3\1\4\1\2\1\0\2\uffff}>";
    static final String[] DFA101_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\1\4\1\5\1\6\1\7",
            "\1\11\1\10\2\11\2\uffff\2\11\17\uffff\13\11\1\uffff\1\11\1"+
            "\uffff\11\11\1\uffff\4\11\2\uffff\1\11\1\uffff\2\11\62\uffff"+
            "\2\11",
            "\1\13\1\12\2\13\2\uffff\2\13\17\uffff\13\13\1\uffff\1\13\1"+
            "\uffff\11\13\1\uffff\4\13\2\uffff\1\13\1\uffff\2\13\62\uffff"+
            "\2\13",
            "\1\15\1\14\2\15\2\uffff\2\15\17\uffff\13\15\1\uffff\1\15\1"+
            "\uffff\11\15\1\uffff\4\15\2\uffff\1\15\1\uffff\2\15\62\uffff"+
            "\2\15",
            "\1\17\1\16\2\17\2\uffff\2\17\17\uffff\13\17\1\uffff\1\17\1"+
            "\uffff\11\17\1\uffff\4\17\2\uffff\1\17\1\uffff\2\17\62\uffff"+
            "\2\17",
            "",
            "\1\20\1\21\1\22\1\23",
            "",
            "\1\24\1\25\1\26",
            "",
            "\1\27\1\30",
            "",
            "\1\31",
            "",
            "\1\32",
            "\1\33",
            "\1\7",
            "\1\uffff",
            "\1\33",
            "\1\7",
            "\1\uffff",
            "\1\7",
            "\1\uffff",
            "\1\uffff",
            "\1\5\1\6\1\7",
            "\1\6\1\7"
    };

    static final short[] DFA101_eot = DFA.unpackEncodedString(DFA101_eotS);
    static final short[] DFA101_eof = DFA.unpackEncodedString(DFA101_eofS);
    static final char[] DFA101_min = DFA.unpackEncodedStringToUnsignedChars(DFA101_minS);
    static final char[] DFA101_max = DFA.unpackEncodedStringToUnsignedChars(DFA101_maxS);
    static final short[] DFA101_accept = DFA.unpackEncodedString(DFA101_acceptS);
    static final short[] DFA101_special = DFA.unpackEncodedString(DFA101_specialS);
    static final short[][] DFA101_transition;

    static {
        int numStates = DFA101_transitionS.length;
        DFA101_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA101_transition[i] = DFA.unpackEncodedString(DFA101_transitionS[i]);
        }
    }

    class DFA101 extends DFA {

        public DFA101(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 101;
            this.eot = DFA101_eot;
            this.eof = DFA101_eof;
            this.min = DFA101_min;
            this.max = DFA101_max;
            this.accept = DFA101_accept;
            this.special = DFA101_special;
            this.transition = DFA101_transition;
        }
        public String getDescription() {
            return "794:1: timeL returns [ String txt ] : ( 't!' (d= DECIMALL 'd' ) (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' ) (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' ) (s= DECIMALL 's' )? (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' ) (ms= DECIMALL 'ms' )? | 't!' (d= DECIMALL 'd' )? (h= DECIMALL 'h' )? (m= DECIMALL 'm' )? (s= DECIMALL 's' )? (ms= DECIMALL 'ms' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA101_25 = input.LA(1);

                         
                        int index101_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_twyncat()) ) {s = 15;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index101_25);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA101_16 = input.LA(1);

                         
                        int index101_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA101_16==DECIMALL) ) {s = 26;}

                        else if ( (synpred152_twyncat()) ) {s = 9;}

                        else if ( (synpred157_twyncat()) ) {s = 11;}

                         
                        input.seek(index101_16);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA101_24 = input.LA(1);

                         
                        int index101_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_twyncat()) ) {s = 13;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index101_24);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA101_22 = input.LA(1);

                         
                        int index101_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred157_twyncat()) ) {s = 11;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index101_22);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA101_23 = input.LA(1);

                         
                        int index101_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA101_23==DECIMALL) ) {s = 7;}

                        else if ( (synpred162_twyncat()) ) {s = 13;}

                        else if ( (synpred167_twyncat()) ) {s = 15;}

                         
                        input.seek(index101_23);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA101_17 = input.LA(1);

                         
                        int index101_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA101_17==DECIMALL) ) {s = 27;}

                        else if ( (synpred152_twyncat()) ) {s = 9;}

                        else if ( (synpred162_twyncat()) ) {s = 13;}

                         
                        input.seek(index101_17);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA101_20 = input.LA(1);

                         
                        int index101_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA101_20==DECIMALL) ) {s = 27;}

                        else if ( (synpred157_twyncat()) ) {s = 11;}

                        else if ( (synpred162_twyncat()) ) {s = 13;}

                         
                        input.seek(index101_20);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA101_19 = input.LA(1);

                         
                        int index101_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_twyncat()) ) {s = 9;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index101_19);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA101_18 = input.LA(1);

                         
                        int index101_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA101_18==DECIMALL) ) {s = 7;}

                        else if ( (synpred152_twyncat()) ) {s = 9;}

                        else if ( (synpred167_twyncat()) ) {s = 15;}

                         
                        input.seek(index101_18);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA101_21 = input.LA(1);

                         
                        int index101_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA101_21==DECIMALL) ) {s = 7;}

                        else if ( (synpred157_twyncat()) ) {s = 11;}

                        else if ( (synpred167_twyncat()) ) {s = 15;}

                         
                        input.seek(index101_21);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 101, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_68_in_sdt98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_sdt105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_sdt113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_sdt120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_sdt127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_sdt134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_sdt141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_sdt148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_sdt156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_sdt163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_sdt171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_sdt178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_sdt185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_sdt192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_sdt199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_sdt206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_sdt213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_sdt220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_sdt227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_sdt234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_booleanL251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_booleanL258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_program285 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_program289 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_program293 = new BitSet(new long[]{0x00000003401F0A40L,0xF06203FC03FFFFF0L});
    public static final BitSet FOLLOW_codeBlock_in_program297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_function325 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_function329 = new BitSet(new long[]{0x0000000000000400L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_function334 = new BitSet(new long[]{0x0000000000000040L,0x0000000000FFFFF0L});
    public static final BitSet FOLLOW_sdt_in_function340 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_function346 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_function354 = new BitSet(new long[]{0x00000003401F0A40L,0xF06203FC03FFFFF0L});
    public static final BitSet FOLLOW_codeBlock_in_function358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_callFunc378 = new BitSet(new long[]{0x0000000040001000L});
    public static final BitSet FOLLOW_trailer_in_callFunc383 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_LPAREN_in_callFunc390 = new BitSet(new long[]{0x00000003C01F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_callFuncArgs_in_callFunc396 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RPAREN_in_callFunc401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_callFuncBlock420 = new BitSet(new long[]{0x0000000040001000L});
    public static final BitSet FOLLOW_trailer_in_callFuncBlock424 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_LPAREN_in_callFuncBlock427 = new BitSet(new long[]{0x0000000080000040L});
    public static final BitSet FOLLOW_callFuncBlockArgs_in_callFuncBlock433 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RPAREN_in_callFuncBlock438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_callFuncBlockArgs470 = new BitSet(new long[]{0x0000010000001000L});
    public static final BitSet FOLLOW_trailer_in_callFuncBlockArgs474 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_callFuncBlockArgs477 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_callFuncBlockArgs481 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_COMMA_in_callFuncBlockArgs487 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_callFuncBlockArgs491 = new BitSet(new long[]{0x0000010000001000L});
    public static final BitSet FOLLOW_trailer_in_callFuncBlockArgs495 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_callFuncBlockArgs498 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_callFuncBlockArgs502 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_test_in_callFuncArgs540 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_COMMA_in_callFuncArgs546 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_callFuncArgs550 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_93_in_alias574 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_alias576 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_alias578 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_exprStm_in_alias580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_subrange598 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DOT_in_subrange600 = new BitSet(new long[]{0x0000000000000000L,0x000000000001FFE0L});
    public static final BitSet FOLLOW_subrangeType_in_subrange602 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_subrange604 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_subrange606 = new BitSet(new long[]{0x00000000001F0200L,0xF040000003000000L});
    public static final BitSet FOLLOW_literal_in_subrange610 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_subrange612 = new BitSet(new long[]{0x00000000001F0200L,0xF040000003000000L});
    public static final BitSet FOLLOW_literal_in_subrange616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_pointer641 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DOT_in_pointer643 = new BitSet(new long[]{0x0000000000000040L,0x0000000000FFFFF0L});
    public static final BitSet FOLLOW_sdt_in_pointer649 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_pointer655 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_pointer660 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_COMMA_in_pointer666 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_pointer670 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_96_in_enumeration692 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DOT_in_enumeration694 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_enumeration698 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_enumeration700 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_enumeration702 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_enumerationElementList_in_enumeration704 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RCURLY_in_enumeration706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumerationElement_in_enumerationElementList737 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_COMMA_in_enumerationElementList742 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_enumerationElement_in_enumerationElementList746 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ID_in_enumerationElement778 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_enumerationElement783 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_enumerationElement785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_subrangeType806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_subrangeType813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_subrangeType820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_subrangeType827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_subrangeType834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_subrangeType841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_subrangeType848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_subrangeType855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_subrangeType862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_subrangeType869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_subrangeType876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_subrangeType883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_structure905 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_structure907 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_structure909 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NEWLINE_in_structure913 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_INDENT_in_structure915 = new BitSet(new long[]{0x0000000000000040L,0x0000000000FFFFF0L});
    public static final BitSet FOLLOW_structureElement_in_structure919 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_DEDENT_in_structure922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sdt_in_structureElement952 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_structureElement958 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_structureElementList_in_structureElement961 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NEWLINE_in_structureElement964 = new BitSet(new long[]{0x0000000000000042L,0x0000000000FFFFF0L});
    public static final BitSet FOLLOW_structureField_in_structureElementList992 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_COMMA_in_structureElementList998 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_structureField_in_structureElementList1002 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ID_in_structureField1037 = new BitSet(new long[]{0x0000010000003002L});
    public static final BitSet FOLLOW_trailer_in_structureField1042 = new BitSet(new long[]{0x0000010000002002L});
    public static final BitSet FOLLOW_arrayModifier_in_structureField1053 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structureField1058 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_arrayConstantExpression_in_structureField1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_structureField1075 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_structureField1079 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_structureField1081 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structureField1087 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_structureField1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defPurpose_in_definition1126 = new BitSet(new long[]{0x0000000000000040L,0x000000E000FFFFF0L});
    public static final BitSet FOLLOW_defModifier_in_definition1131 = new BitSet(new long[]{0x0000000000000040L,0x0000000000FFFFF0L});
    public static final BitSet FOLLOW_sdt_in_definition1137 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_definition1143 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_varList_in_definition1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_defPurpose1166 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_99_in_defPurpose1172 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_100_in_defPurpose1178 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DOT_in_defPurpose1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_defModifier1202 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_102_in_defModifier1208 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_103_in_defModifier1214 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DOT_in_defModifier1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varListElem_in_varList1248 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_COMMA_in_varList1254 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_varListElem_in_varList1258 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ID_in_varListElem1293 = new BitSet(new long[]{0x0000010000003002L});
    public static final BitSet FOLLOW_trailer_in_varListElem1298 = new BitSet(new long[]{0x0000010000002002L});
    public static final BitSet FOLLOW_arrayModifier_in_varListElem1311 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_varListElem1316 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_arrayConstantExpression_in_varListElem1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_varListElem1333 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_varListElem1337 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_varListElem1339 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_varListElem1345 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_varListElem1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifier1375 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_arrayRange_in_arrayModifier1377 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifier1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifier1391 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_arrayRange_in_arrayModifier1395 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifier1397 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifier1403 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_arrayRange_in_arrayModifier1407 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifier1409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifier1421 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_arrayRange_in_arrayModifier1425 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifier1427 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifier1433 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_arrayRange_in_arrayModifier1437 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifier1439 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifier1445 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_arrayRange_in_arrayModifier1449 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifier1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMALL_in_arrayRange1473 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_arrayRange1475 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_arrayRange1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayConstantExpression1500 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_literalsList_in_arrayConstantExpression1502 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayConstantExpression1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayConstantExpression1516 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_literalsList_in_arrayConstantExpression1520 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayConstantExpression1522 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_arrayConstantExpression1528 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_literalsList_in_arrayConstantExpression1532 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayConstantExpression1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayConstantExpression1546 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_literalsList_in_arrayConstantExpression1550 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayConstantExpression1552 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_arrayConstantExpression1558 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_literalsList_in_arrayConstantExpression1562 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayConstantExpression1564 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_arrayConstantExpression1570 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_literalsList_in_arrayConstantExpression1574 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayConstantExpression1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_literalsList1608 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_COMMA_in_literalsList1614 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_atom_in_literalsList1618 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_globalStm_in_file1651 = new BitSet(new long[]{0x0000000000000000L,0x000000032C000000L});
    public static final BitSet FOLLOW_function_in_file1662 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_program_in_file1673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_file1677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleStm_in_statement1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundStm_in_statement1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_smallGlobalStm_in_globalStm1716 = new BitSet(new long[]{0x0000000000008800L});
    public static final BitSet FOLLOW_SEMI_in_globalStm1719 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NEWLINE_in_globalStm1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_smallGlobalStm1746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeration_in_smallGlobalStm1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_in_smallGlobalStm1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_smallStm_in_simpleStm1781 = new BitSet(new long[]{0x0000000000008800L});
    public static final BitSet FOLLOW_SEMI_in_simpleStm1784 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NEWLINE_in_simpleStm1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exprStm_in_smallStm1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flowStm_in_smallStm1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeatUntilStm_in_smallStm1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_smallStm1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_exprStm1855 = new BitSet(new long[]{0x07AC000000000000L});
    public static final BitSet FOLLOW_augAssign_in_exprStm1857 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_exprStm1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_exprStm1870 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_exprStm1872 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_exprStm1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUSEQUAL_in_augAssign1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUSEQUAL_in_augAssign1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAREQUAL_in_augAssign1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASHEQUAL_in_augAssign1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERCENTEQUAL_in_augAssign1922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANDEQUAL_in_augAssign1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OREQUAL_in_augAssign1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_flowStm1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_flowStm1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callFunc_in_flowStm1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callFuncBlock_in_flowStm1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStm_in_compoundStm1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseStm_in_compoundStm2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStm_in_compoundStm2007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStm_in_compoundStm2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ifStm2036 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_ifStm2038 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_ifStm2040 = new BitSet(new long[]{0x00000003401F0A40L,0xF06203FC03FFFFF0L});
    public static final BitSet FOLLOW_codeBlock_in_ifStm2044 = new BitSet(new long[]{0x0000000000000002L,0x0000180000000000L});
    public static final BitSet FOLLOW_elifClause_in_ifStm2051 = new BitSet(new long[]{0x0000000000000002L,0x0000180000000000L});
    public static final BitSet FOLLOW_107_in_ifStm2060 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_ifStm2062 = new BitSet(new long[]{0x00000003401F0A40L,0xF06203FC03FFFFF0L});
    public static final BitSet FOLLOW_codeBlock_in_ifStm2066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_elifClause2091 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_elifClause2093 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_elifClause2095 = new BitSet(new long[]{0x00000003401F0A40L,0xF06203FC03FFFFF0L});
    public static final BitSet FOLLOW_codeBlock_in_elifClause2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_caseStm2121 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_caseStm2123 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_caseStm2125 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NEWLINE_in_caseStm2127 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_INDENT_in_caseStm2129 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_caseElementsStm_in_caseStm2131 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_DEDENT_in_caseStm2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_caseElementsStm2160 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_caseElementsStm2162 = new BitSet(new long[]{0x00000003401F0A40L,0xF06203FC03FFFFF0L});
    public static final BitSet FOLLOW_codeBlock_in_caseElementsStm2166 = new BitSet(new long[]{0x00000003401F0240L,0xF060400003000000L});
    public static final BitSet FOLLOW_110_in_caseElementsStm2174 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_caseElementsStm2176 = new BitSet(new long[]{0x00000003401F0A40L,0xF06203FC03FFFFF0L});
    public static final BitSet FOLLOW_codeBlock_in_caseElementsStm2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_forStm2202 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_forStm2204 = new BitSet(new long[]{0x0000000000003000L,0x0000000400000000L});
    public static final BitSet FOLLOW_trailer_in_forStm2209 = new BitSet(new long[]{0x0000000000002000L,0x0000000400000000L});
    public static final BitSet FOLLOW_arrayModifierEl_in_forStm2216 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_forStm2219 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_forStm2221 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_forStm2225 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_forStm2227 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_forStm2231 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_forStm2233 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_forStm2237 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RCURLY_in_forStm2239 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_forStm2241 = new BitSet(new long[]{0x00000003401F0A40L,0xF06203FC03FFFFF0L});
    public static final BitSet FOLLOW_codeBlock_in_forStm2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_whileStm2268 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_whileStm2270 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_whileStm2272 = new BitSet(new long[]{0x00000003401F0A40L,0xF06203FC03FFFFF0L});
    public static final BitSet FOLLOW_codeBlock_in_whileStm2274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_repeatUntilStm2297 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_repeatUntilStm2299 = new BitSet(new long[]{0x00000003401F0A40L,0xF06203FC03FFFFF0L});
    public static final BitSet FOLLOW_codeBlock_in_repeatUntilStm2301 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_repeatUntilStm2303 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_repeatUntilStm2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleStm_in_codeBlock2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_codeBlock2337 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_INDENT_in_codeBlock2339 = new BitSet(new long[]{0x00000003401F0240L,0xF063A7FC03FFFFF0L});
    public static final BitSet FOLLOW_statement_in_codeBlock2345 = new BitSet(new long[]{0x00000003401F0260L,0xF063A7FC03FFFFF0L});
    public static final BitSet FOLLOW_DEDENT_in_codeBlock2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orTest_in_test2367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andTest_in_orTest2396 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_orTest2402 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_andTest_in_orTest2406 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_notTest_in_andTest2437 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_andTest2443 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_notTest_in_andTest2447 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_117_in_notTest2466 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_notTest_in_notTest2470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_notTest2477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_comparison2506 = new BitSet(new long[]{0x0003E0C000000002L});
    public static final BitSet FOLLOW_compOperator_in_comparison2511 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_expr_in_comparison2515 = new BitSet(new long[]{0x0003E0C000000002L});
    public static final BitSet FOLLOW_LESS_in_compOperator2535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_in_compOperator2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_compOperator2549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_compOperator2556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESSEQUAL_in_compOperator2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_NOTEQUAL_in_compOperator2570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compOperator2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xorExpr_in_expr2606 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_VBAR_in_expr2611 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_xorExpr_in_expr2615 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_andExpr_in_xorExpr2647 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_CIRCUMFLEX_in_xorExpr2652 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_andExpr_in_xorExpr2656 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_shiftExpr_in_andExpr2689 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_AMPER_in_andExpr2694 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_shiftExpr_in_andExpr2698 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_arithExpr_in_shiftExpr2731 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_LEFTSHIFT_in_shiftExpr2733 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_arithExpr_in_shiftExpr2737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithExpr_in_shiftExpr2746 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_RIGHTSHIFT_in_shiftExpr2748 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_arithExpr_in_shiftExpr2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithExpr_in_shiftExpr2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_arithExpr2790 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_PLUS_in_arithExpr2796 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_MINUS_in_arithExpr2801 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_term_in_arithExpr2808 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_factor_in_term2840 = new BitSet(new long[]{0x0000020C00000002L});
    public static final BitSet FOLLOW_STAR_in_term2846 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_SLASH_in_term2852 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_PERCENT_in_term2858 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_factor_in_term2865 = new BitSet(new long[]{0x0000020C00000002L});
    public static final BitSet FOLLOW_PLUS_in_factor2897 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_MINUS_in_factor2902 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_power_in_factor2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_power2939 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_DOUBLESTAR_in_power2942 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_factor_in_power2946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom2974 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_trailer_in_atom2979 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_arrayModifierEl_in_atom2987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_atom2998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom3006 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_atom3008 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom3010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callFunc_in_atom3017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifierEl3037 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_expr_in_arrayModifierEl3039 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifierEl3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifierEl3053 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_expr_in_arrayModifierEl3057 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifierEl3059 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifierEl3065 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_expr_in_arrayModifierEl3069 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifierEl3071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifierEl3083 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_expr_in_arrayModifierEl3087 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifierEl3089 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifierEl3095 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_expr_in_arrayModifierEl3099 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifierEl3101 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_arrayModifierEl3107 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_expr_in_arrayModifierEl3111 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayModifierEl3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_trailer3144 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_trailer3146 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_DECIMALL_in_literal3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXDIGITS_in_literal3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATINGPOINTL_in_literal3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINDIGITS_in_literal3193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTDIGITS_in_literal3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timeL_in_literal3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_todL_in_literal3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dateL_in_literal3226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_datetimeL_in_literal3234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanL_in_literal3242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTERL_in_literal3250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringL_in_literal3258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_timeL3459 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3465 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_timeL3467 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3475 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_timeL3477 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3486 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_timeL3488 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3497 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_timeL3499 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3508 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_timeL3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_timeL3524 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3530 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_timeL3532 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3541 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_timeL3543 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3551 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_timeL3553 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3562 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_timeL3564 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3573 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_timeL3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_timeL3589 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3595 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_timeL3597 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3606 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_timeL3608 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3617 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_timeL3619 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3627 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_timeL3629 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3638 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_timeL3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_timeL3653 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3659 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_timeL3661 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3670 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_timeL3672 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3681 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_timeL3683 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3692 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_timeL3694 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3702 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_timeL3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_timeL3717 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3723 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_timeL3725 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3734 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_timeL3736 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3745 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_timeL3747 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3756 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_timeL3758 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_timeL3767 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_timeL3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_todL3792 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_TODLDIGITS_in_todL3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_dateL3843 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DATEDIGITS_in_dateL3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_datetimeL3884 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DATETIMEDIGITS_in_datetimeL3886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_stringL3968 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_stringLContent_in_stringL3970 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_127_in_stringL3972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_stringLContent3989 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF2L,0x7FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_callFuncArgs_in_synpred24_twyncat396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callFuncBlockArgs_in_synpred26_twyncat433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_synpred56_twyncat1075 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred56_twyncat1079 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred56_twyncat1081 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_synpred56_twyncat1087 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_synpred56_twyncat1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_synpred70_twyncat1333 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred70_twyncat1337 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred70_twyncat1339 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_synpred70_twyncat1345 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_synpred70_twyncat1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_synpred73_twyncat1500 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_literalsList_in_synpred73_twyncat1502 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred73_twyncat1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_synpred74_twyncat1516 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_literalsList_in_synpred74_twyncat1520 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred74_twyncat1522 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_synpred74_twyncat1528 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_literalsList_in_synpred74_twyncat1532 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred74_twyncat1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exprStm_in_synpred83_twyncat1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flowStm_in_synpred84_twyncat1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_synpred86_twyncat1855 = new BitSet(new long[]{0x07AC000000000000L});
    public static final BitSet FOLLOW_augAssign_in_synpred86_twyncat1857 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_test_in_synpred86_twyncat1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callFunc_in_synpred95_twyncat1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithExpr_in_synpred119_twyncat2731 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_LEFTSHIFT_in_synpred119_twyncat2733 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_arithExpr_in_synpred119_twyncat2737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithExpr_in_synpred120_twyncat2746 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_RIGHTSHIFT_in_synpred120_twyncat2748 = new BitSet(new long[]{0x00000003401F0240L,0xF040000003000000L});
    public static final BitSet FOLLOW_arithExpr_in_synpred120_twyncat2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_synpred134_twyncat3037 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_expr_in_synpred134_twyncat3039 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred134_twyncat3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_synpred135_twyncat3053 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_expr_in_synpred135_twyncat3057 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred135_twyncat3059 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LBRACK_in_synpred135_twyncat3065 = new BitSet(new long[]{0x00000003401F0240L,0xF060000003000000L});
    public static final BitSet FOLLOW_expr_in_synpred135_twyncat3069 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred135_twyncat3071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_synpred152_twyncat3459 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred152_twyncat3465 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_synpred152_twyncat3467 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred152_twyncat3475 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_synpred152_twyncat3477 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred152_twyncat3486 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_synpred152_twyncat3488 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred152_twyncat3497 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_synpred152_twyncat3499 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred152_twyncat3508 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_synpred152_twyncat3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_synpred157_twyncat3524 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred157_twyncat3530 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_synpred157_twyncat3532 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred157_twyncat3541 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_synpred157_twyncat3543 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred157_twyncat3551 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_synpred157_twyncat3553 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred157_twyncat3562 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_synpred157_twyncat3564 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred157_twyncat3573 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_synpred157_twyncat3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_synpred162_twyncat3589 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred162_twyncat3595 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_synpred162_twyncat3597 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred162_twyncat3606 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_synpred162_twyncat3608 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred162_twyncat3617 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_synpred162_twyncat3619 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred162_twyncat3627 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_synpred162_twyncat3629 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred162_twyncat3638 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_synpred162_twyncat3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_synpred167_twyncat3653 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred167_twyncat3659 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_synpred167_twyncat3661 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred167_twyncat3670 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_synpred167_twyncat3672 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred167_twyncat3681 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_synpred167_twyncat3683 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred167_twyncat3692 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_synpred167_twyncat3694 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DECIMALL_in_synpred167_twyncat3702 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_synpred167_twyncat3704 = new BitSet(new long[]{0x0000000000000002L});

}