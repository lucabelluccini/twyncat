package it.polito.lt.twyncat;
// $ANTLR 3.2 Sep 23, 2009 12:02:23 H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g 2010-09-02 21:03:30

import java.util.ListIterator;
import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TwyncatLexer extends Lexer {
    public static final int EXPONENT=21;
    public static final int BACKQUOTE=42;
    public static final int SLASHEQUAL=55;
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
    public static final int T__98=98;
    public static final int ANDEQUAL=58;
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
    public static final int T__85=85;
    public static final int RIGHTSHIFT=63;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int FF=27;
    public static final int T__88=88;
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
    public static final int CHARACTERL=20;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int COMMA=64;
    public static final int T__109=109;
    public static final int AMPER=37;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int EQUAL=45;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int TILDE=44;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int LEFTSHIFTEQUAL=60;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int PLUS=32;
    public static final int LEFTSHIFT=61;
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
    			/* System.out.println("DED at EOF"); */
    			return new ClassicToken(DEDENT);
    		}
    		return Token.EOF_TOKEN;
    	}
    	return (Token)tokens.remove();
    }

    protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException {
    	throw new MismatchedTokenException(ttype, input);
    }



    // delegates
    // delegators

    public TwyncatLexer() {;} 
    public TwyncatLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TwyncatLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g"; }

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:53:7: ( 'bool' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:53:9: 'bool'
            {
            match("bool"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:54:7: ( 'byte' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:54:9: 'byte'
            {
            match("byte"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:55:7: ( 'word' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:55:9: 'word'
            {
            match("word"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:56:7: ( 'dword' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:56:9: 'dword'
            {
            match("dword"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:57:7: ( 'lint' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:57:9: 'lint'
            {
            match("lint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:58:7: ( 'ulint' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:58:9: 'ulint'
            {
            match("ulint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:59:7: ( 'lword' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:59:9: 'lword'
            {
            match("lword"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:60:7: ( 'sint' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:60:9: 'sint'
            {
            match("sint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:61:7: ( 'usint' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:61:9: 'usint'
            {
            match("usint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:62:7: ( 'int' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:62:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:63:7: ( 'uint' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:63:9: 'uint'
            {
            match("uint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:64:7: ( 'dint' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:64:9: 'dint'
            {
            match("dint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:65:7: ( 'udint' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:65:9: 'udint'
            {
            match("udint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:66:7: ( 'real' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:66:9: 'real'
            {
            match("real"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:67:7: ( 'lreal' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:67:9: 'lreal'
            {
            match("lreal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:68:7: ( 'string' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:68:9: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:69:7: ( 'time' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:69:9: 'time'
            {
            match("time"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:70:7: ( 'tod' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:70:9: 'tod'
            {
            match("tod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:71:7: ( 'date' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:71:9: 'date'
            {
            match("date"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:72:7: ( 'dt' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:72:9: 'dt'
            {
            match("dt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:73:7: ( 'True' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:73:9: 'True'
            {
            match("True"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:74:7: ( 'False' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:74:9: 'False'
            {
            match("False"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:75:7: ( 'prog' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:75:9: 'prog'
            {
            match("prog"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:76:7: ( 'func' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:76:9: 'func'
            {
            match("func"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:77:7: ( 'returns' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:77:9: 'returns'
            {
            match("returns"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:78:7: ( 'alias' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:78:9: 'alias'
            {
            match("alias"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:79:7: ( 'subrange' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:79:9: 'subrange'
            {
            match("subrange"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:80:7: ( 'pointer' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:80:9: 'pointer'
            {
            match("pointer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:81:7: ( 'enum' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:81:9: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:82:7: ( 'structure' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:82:9: 'structure'
            {
            match("structure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:83:7: ( 'in' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:83:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:84:7: ( 'out' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:84:9: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:85:8: ( 'inout' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:85:10: 'inout'
            {
            match("inout"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:86:8: ( 'persistent' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:86:10: 'persistent'
            {
            match("persistent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:87:8: ( 'retain' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:87:10: 'retain'
            {
            match("retain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:88:8: ( 'constant' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:88:10: 'constant'
            {
            match("constant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:89:8: ( 'return' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:89:10: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:90:8: ( 'exit' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:90:10: 'exit'
            {
            match("exit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:91:8: ( 'if' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:91:10: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:92:8: ( 'else' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:92:10: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:93:8: ( 'elif' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:93:10: 'elif'
            {
            match("elif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:94:8: ( 'case' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:94:10: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:95:8: ( 'default' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:95:10: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:96:8: ( 'for' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:96:10: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:97:8: ( 'while' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:97:10: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:98:8: ( 'repeat' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:98:10: 'repeat'
            {
            match("repeat"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:99:8: ( 'until' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:99:10: 'until'
            {
            match("until"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:100:8: ( 'or' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:100:10: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:101:8: ( 'and' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:101:10: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:102:8: ( 'not' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:102:10: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:103:8: ( 't!' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:103:10: 't!'
            {
            match("t!"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:104:8: ( 'd' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:104:10: 'd'
            {
            match('d'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:105:8: ( 'h' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:105:10: 'h'
            {
            match('h'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:106:8: ( 'm' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:106:10: 'm'
            {
            match('m'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "T__122"
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:107:8: ( 's' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:107:10: 's'
            {
            match('s'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "T__123"
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:108:8: ( 'ms' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:108:10: 'ms'
            {
            match("ms"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "T__124"
    public final void mT__124() throws RecognitionException {
        try {
            int _type = T__124;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:109:8: ( 'tod!' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:109:10: 'tod!'
            {
            match("tod!"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__124"

    // $ANTLR start "T__125"
    public final void mT__125() throws RecognitionException {
        try {
            int _type = T__125;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:110:8: ( 'd!' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:110:10: 'd!'
            {
            match("d!"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__125"

    // $ANTLR start "T__126"
    public final void mT__126() throws RecognitionException {
        try {
            int _type = T__126;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:111:8: ( 'dt!' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:111:10: 'dt!'
            {
            match("dt!"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__126"

    // $ANTLR start "T__127"
    public final void mT__127() throws RecognitionException {
        try {
            int _type = T__127;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:112:8: ( '\"' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:112:10: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__127"

    // $ANTLR start "T__128"
    public final void mT__128() throws RecognitionException {
        try {
            int _type = T__128;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:113:8: ( '\\\\' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:113:10: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__128"

    // $ANTLR start "FLOATINGPOINTL"
    public final void mFLOATINGPOINTL() throws RecognitionException {
        try {
            int _type = FLOATINGPOINTL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:777:2: ( ( '0' .. '9' )* '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:777:4: ( '0' .. '9' )* '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:777:4: ( '0' .. '9' )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:777:5: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    match('.'); 
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:777:20: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:777:21: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:777:32: ( EXPONENT )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='E'||LA3_0=='e') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:777:32: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:778:4: ( '0' .. '9' )+ EXPONENT
                    {
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:778:4: ( '0' .. '9' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:778:5: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    mEXPONENT(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOATINGPOINTL"

    // $ANTLR start "HEXDIGITS"
    public final void mHEXDIGITS() throws RecognitionException {
        try {
            int _type = HEXDIGITS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:781:11: ( 'h!' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:781:13: 'h!' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match("h!"); 

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:781:18: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='F')||(LA6_0>='a' && LA6_0<='f')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HEXDIGITS"

    // $ANTLR start "DECIMALL"
    public final void mDECIMALL() throws RecognitionException {
        try {
            int _type = DECIMALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:783:10: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:783:12: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:783:12: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='0') ) {
                alt8=1;
            }
            else if ( ((LA8_0>='1' && LA8_0<='9')) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:783:13: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:783:19: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:783:28: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:783:28: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECIMALL"

    // $ANTLR start "OCTDIGITS"
    public final void mOCTDIGITS() throws RecognitionException {
        try {
            int _type = OCTDIGITS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:785:11: ( 'o!' ( '0' .. '7' )+ )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:785:13: 'o!' ( '0' .. '7' )+
            {
            match("o!"); 

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:785:18: ( '0' .. '7' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:785:19: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OCTDIGITS"

    // $ANTLR start "BINDIGITS"
    public final void mBINDIGITS() throws RecognitionException {
        try {
            int _type = BINDIGITS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:787:11: ( 'b!' ( '0' .. '1' )+ )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:787:13: 'b!' ( '0' .. '1' )+
            {
            match("b!"); 

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:787:18: ( '0' .. '1' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='1')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:787:19: '0' .. '1'
            	    {
            	    matchRange('0','1'); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BINDIGITS"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:789:19: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:789:21: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:789:31: ( '+' | '-' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='+'||LA11_0=='-') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:789:42: ( '0' .. '9' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:789:43: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:792:25: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | OctalEscape )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\\') ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1=='\"'||LA13_1=='\''||LA13_1=='\\'||LA13_1=='b'||LA13_1=='f'||LA13_1=='n'||LA13_1=='r'||LA13_1=='t') ) {
                    alt13=1;
                }
                else if ( ((LA13_1>='0' && LA13_1<='7')) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:792:27: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:792:71: OctalEscape
                    {
                    mOctalEscape(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "TODLDIGITS"
    public final void mTODLDIGITS() throws RecognitionException {
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:811:21: ( DECIMALL ':' DECIMALL ':' DECIMALL ( '.' DECIMALL )? )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:811:23: DECIMALL ':' DECIMALL ':' DECIMALL ( '.' DECIMALL )?
            {
            mDECIMALL(); 
            match(':'); 
            mDECIMALL(); 
            match(':'); 
            mDECIMALL(); 
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:811:58: ( '.' DECIMALL )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='.') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:811:60: '.' DECIMALL
                    {
                    match('.'); 
                    mDECIMALL(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "TODLDIGITS"

    // $ANTLR start "DATEDIGITS"
    public final void mDATEDIGITS() throws RecognitionException {
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:817:21: ( DECIMALL '-' DECIMALL '-' DECIMALL )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:817:23: DECIMALL '-' DECIMALL '-' DECIMALL
            {
            mDECIMALL(); 
            match('-'); 
            mDECIMALL(); 
            match('-'); 
            mDECIMALL(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DATEDIGITS"

    // $ANTLR start "DATETIMEDIGITS"
    public final void mDATETIMEDIGITS() throws RecognitionException {
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:823:25: ( DECIMALL '-' DECIMALL '-' DECIMALL '-' DECIMALL ':' DECIMALL )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:823:27: DECIMALL '-' DECIMALL '-' DECIMALL '-' DECIMALL ':' DECIMALL
            {
            mDECIMALL(); 
            match('-'); 
            mDECIMALL(); 
            match('-'); 
            mDECIMALL(); 
            match('-'); 
            mDECIMALL(); 
            match(':'); 
            mDECIMALL(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DATETIMEDIGITS"

    // $ANTLR start "CHARACTERL"
    public final void mCHARACTERL() throws RecognitionException {
        try {
            int _type = CHARACTERL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:826:3: ( '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:826:7: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:826:12: ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\\') ) {
                alt15=1;
            }
            else if ( ((LA15_0>='\u0000' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFF')) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:826:14: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:826:31: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHARACTERL"

    // $ANTLR start "OctalEscape"
    public final void mOctalEscape() throws RecognitionException {
        try {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:837:3: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\\') ) {
                int LA16_1 = input.LA(2);

                if ( ((LA16_1>='0' && LA16_1<='3')) ) {
                    int LA16_2 = input.LA(3);

                    if ( ((LA16_2>='0' && LA16_2<='7')) ) {
                        int LA16_4 = input.LA(4);

                        if ( ((LA16_4>='0' && LA16_4<='7')) ) {
                            alt16=1;
                        }
                        else {
                            alt16=2;}
                    }
                    else {
                        alt16=3;}
                }
                else if ( ((LA16_1>='4' && LA16_1<='7')) ) {
                    int LA16_3 = input.LA(3);

                    if ( ((LA16_3>='0' && LA16_3<='7')) ) {
                        alt16=2;
                    }
                    else {
                        alt16=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:837:7: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:837:12: ( '0' .. '3' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:837:13: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:837:23: ( '0' .. '7' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:837:24: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:837:34: ( '0' .. '7' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:837:35: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:838:7: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:838:12: ( '0' .. '7' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:838:13: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:838:23: ( '0' .. '7' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:838:24: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:839:7: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:839:12: ( '0' .. '7' )
                    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:839:13: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OctalEscape"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:842:4: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:843:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:843:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='0' && LA17_0<='9')||(LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "FF"
    public final void mFF() throws RecognitionException {
        try {
            int _type = FF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:846:7: ( '\\u000C' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:846:9: '\\u000C'
            {
            match('\f'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FF"

    // $ANTLR start "TAB"
    public final void mTAB() throws RecognitionException {
        try {
            int _type = TAB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:847:7: ( '\\t' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:847:9: '\\t'
            {
            match('\t'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TAB"

    // $ANTLR start "CR"
    public final void mCR() throws RecognitionException {
        try {
            int _type = CR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:848:7: ( '\\r' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:848:9: '\\r'
            {
            match('\r'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CR"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:849:11: ( '(' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:849:13: '('
            {
            match('('); 
            implicitLineJoiningLevel++;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:850:11: ( ')' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:850:13: ')'
            {
            match(')'); 
            implicitLineJoiningLevel--;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:851:11: ( '[' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:851:13: '['
            {
            match('['); 
            implicitLineJoiningLevel++;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:852:11: ( ']' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:852:13: ']'
            {
            match(']'); 
            implicitLineJoiningLevel--;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:853:9: ( ':' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:853:11: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:854:9: ( ';' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:854:11: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:855:9: ( '+' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:855:11: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:856:9: ( '-' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:856:11: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:857:9: ( '*' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:857:11: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:858:9: ( '/' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:858:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "VBAR"
    public final void mVBAR() throws RecognitionException {
        try {
            int _type = VBAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:859:9: ( '|' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:859:11: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VBAR"

    // $ANTLR start "AMPER"
    public final void mAMPER() throws RecognitionException {
        try {
            int _type = AMPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:860:9: ( '&' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:860:11: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AMPER"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:861:9: ( '<' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:861:11: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS"

    // $ANTLR start "GREATER"
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:862:11: ( '>' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:862:13: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:863:11: ( '=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:863:13: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:864:11: ( '%' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:864:13: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "BACKQUOTE"
    public final void mBACKQUOTE() throws RecognitionException {
        try {
            int _type = BACKQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:865:11: ( '`' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:865:13: '`'
            {
            match('`'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BACKQUOTE"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:866:11: ( '{' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:866:13: '{'
            {
            match('{'); 
            implicitLineJoiningLevel++;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:867:11: ( '}' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:867:13: '}'
            {
            match('}'); 
            implicitLineJoiningLevel--;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "CIRCUMFLEX"
    public final void mCIRCUMFLEX() throws RecognitionException {
        try {
            int _type = CIRCUMFLEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:868:13: ( '^' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:868:15: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CIRCUMFLEX"

    // $ANTLR start "TILDE"
    public final void mTILDE() throws RecognitionException {
        try {
            int _type = TILDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:869:9: ( '~' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:869:11: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TILDE"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:870:9: ( '==' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:870:11: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "NOTEQUAL"
    public final void mNOTEQUAL() throws RecognitionException {
        try {
            int _type = NOTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:871:11: ( '!=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:871:13: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOTEQUAL"

    // $ANTLR start "ALT_NOTEQUAL"
    public final void mALT_NOTEQUAL() throws RecognitionException {
        try {
            int _type = ALT_NOTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:872:15: ( '<>' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:872:17: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALT_NOTEQUAL"

    // $ANTLR start "LESSEQUAL"
    public final void mLESSEQUAL() throws RecognitionException {
        try {
            int _type = LESSEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:873:11: ( '<=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:873:13: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESSEQUAL"

    // $ANTLR start "GREATEREQUAL"
    public final void mGREATEREQUAL() throws RecognitionException {
        try {
            int _type = GREATEREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:874:15: ( '>=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:874:17: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATEREQUAL"

    // $ANTLR start "PLUSEQUAL"
    public final void mPLUSEQUAL() throws RecognitionException {
        try {
            int _type = PLUSEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:875:11: ( '+=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:875:13: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUSEQUAL"

    // $ANTLR start "MINUSEQUAL"
    public final void mMINUSEQUAL() throws RecognitionException {
        try {
            int _type = MINUSEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:876:13: ( '-=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:876:15: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUSEQUAL"

    // $ANTLR start "DOUBLESTAR"
    public final void mDOUBLESTAR() throws RecognitionException {
        try {
            int _type = DOUBLESTAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:877:13: ( '**' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:877:15: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLESTAR"

    // $ANTLR start "STAREQUAL"
    public final void mSTAREQUAL() throws RecognitionException {
        try {
            int _type = STAREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:878:11: ( '*=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:878:13: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAREQUAL"

    // $ANTLR start "DOUBLESLASH"
    public final void mDOUBLESLASH() throws RecognitionException {
        try {
            int _type = DOUBLESLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:879:13: ( '//' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:879:15: '//'
            {
            match("//"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLESLASH"

    // $ANTLR start "SLASHEQUAL"
    public final void mSLASHEQUAL() throws RecognitionException {
        try {
            int _type = SLASHEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:880:13: ( '/=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:880:15: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASHEQUAL"

    // $ANTLR start "OREQUAL"
    public final void mOREQUAL() throws RecognitionException {
        try {
            int _type = OREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:881:11: ( '|=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:881:13: '|='
            {
            match("|="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OREQUAL"

    // $ANTLR start "PERCENTEQUAL"
    public final void mPERCENTEQUAL() throws RecognitionException {
        try {
            int _type = PERCENTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:882:15: ( '%=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:882:17: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERCENTEQUAL"

    // $ANTLR start "ANDEQUAL"
    public final void mANDEQUAL() throws RecognitionException {
        try {
            int _type = ANDEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:883:11: ( '&=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:883:13: '&='
            {
            match("&="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANDEQUAL"

    // $ANTLR start "CIRCUMFLEXEQUAL"
    public final void mCIRCUMFLEXEQUAL() throws RecognitionException {
        try {
            int _type = CIRCUMFLEXEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:884:17: ( '^=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:884:19: '^='
            {
            match("^="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CIRCUMFLEXEQUAL"

    // $ANTLR start "LEFTSHIFTEQUAL"
    public final void mLEFTSHIFTEQUAL() throws RecognitionException {
        try {
            int _type = LEFTSHIFTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:885:17: ( '<<=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:885:19: '<<='
            {
            match("<<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFTSHIFTEQUAL"

    // $ANTLR start "LEFTSHIFT"
    public final void mLEFTSHIFT() throws RecognitionException {
        try {
            int _type = LEFTSHIFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:886:11: ( '<<' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:886:13: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFTSHIFT"

    // $ANTLR start "RIGHTSHIFTEQUAL"
    public final void mRIGHTSHIFTEQUAL() throws RecognitionException {
        try {
            int _type = RIGHTSHIFTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:887:17: ( '>>=' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:887:19: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHTSHIFTEQUAL"

    // $ANTLR start "RIGHTSHIFT"
    public final void mRIGHTSHIFT() throws RecognitionException {
        try {
            int _type = RIGHTSHIFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:888:12: ( '>>' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:888:14: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHTSHIFT"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:889:7: ( '.' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:889:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:890:9: ( ',' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:890:11: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:891:7: ( '@' )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:891:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:903:9: ( ( ( FF )? ( CR )? '\\n' )+ )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:904:5: ( ( FF )? ( CR )? '\\n' )+
            {
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:904:5: ( ( FF )? ( CR )? '\\n' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='\n'||(LA20_0>='\f' && LA20_0<='\r')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:904:6: ( FF )? ( CR )? '\\n'
            	    {
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:904:6: ( FF )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0=='\f') ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:904:8: FF
            	            {
            	            mFF(); 

            	            }
            	            break;

            	    }

            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:904:13: ( CR )?
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0=='\r') ) {
            	        alt19=1;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:904:15: CR
            	            {
            	            mCR(); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

             if ( state.tokenStartCharIndex == 0 || implicitLineJoiningLevel > 0 )
                    _channel=HIDDEN;
                

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:912:5: ({...}? => ( ' ' | TAB | FF )+ )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:913:5: {...}? => ( ' ' | TAB | FF )+
            {
            if ( !(( getCharPositionInLine() > 0 )) ) {
                throw new FailedPredicateException(input, "WS", " getCharPositionInLine() > 0 ");
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:914:5: ( ' ' | TAB | FF )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\t'||LA21_0=='\f'||LA21_0==' ') ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "LEADINGWS"
    public final void mLEADINGWS() throws RecognitionException {
        try {
            int _type = LEADINGWS;
            int _channel = DEFAULT_TOKEN_CHANNEL;

            	int nSpaces = 0;

            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:923:3: ({...}? => ( ' ' | '\\t' )+ )
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:924:2: {...}? => ( ' ' | '\\t' )+
            {
            if ( !(( getCharPositionInLine() == 0 )) ) {
                throw new FailedPredicateException(input, "LEADINGWS", " getCharPositionInLine() == 0 ");
            }
            // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:925:3: ( ' ' | '\\t' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==' ') ) {
                    alt22=1;
                }
                else if ( (LA22_0=='\t') ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:925:5: ' '
            	    {
            	    match(' '); 
            	     nSpaces++; 

            	    }
            	    break;
            	case 2 :
            	    // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:926:5: '\\t'
            	    {
            	    match('\t'); 
            	     nSpaces += 8; nSpaces -= (nSpaces % 8); 

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


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
            				Token t = new ClassicToken(INDENT, new String(spaces)); t.setLine(state.tokenStartLine);
            				emit( t );
            				//System.out.println("IND Spaces: " + nSpaces + " at line " + state.tokenStartLine);
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
            				    			Token t = new ClassicToken(DEDENT, new String(spaces)); t.setLine(state.tokenStartLine);
            				    			emit(t);
            							//System.out.println("DED Spaces: " + nSp + " at line " + state.tokenStartLine);
            				    		} else {
            		           				int nSp = indentations.pop();
            							Token t = new ClassicToken(DEDENT, new String("")); t.setLine(state.tokenStartLine);
            							emit(t);
            							//System.out.println("DED Spaces: " + nSp + " at line " + state.tokenStartLine);
            						}
            					} else { break; }
            				    }
            				} else {
            					// Should raise IndentationException
            					System.err.println("ERROR in indentation");
            				}
            			}
            			_channel = HIDDEN;
            		

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEADINGWS"

    public void mTokens() throws RecognitionException {
        // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:8: ( T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | FLOATINGPOINTL | HEXDIGITS | DECIMALL | OCTDIGITS | BINDIGITS | CHARACTERL | ID | FF | TAB | CR | LPAREN | RPAREN | LBRACK | RBRACK | COLON | SEMI | PLUS | MINUS | STAR | SLASH | VBAR | AMPER | LESS | GREATER | ASSIGN | PERCENT | BACKQUOTE | LCURLY | RCURLY | CIRCUMFLEX | TILDE | EQUAL | NOTEQUAL | ALT_NOTEQUAL | LESSEQUAL | GREATEREQUAL | PLUSEQUAL | MINUSEQUAL | DOUBLESTAR | STAREQUAL | DOUBLESLASH | SLASHEQUAL | OREQUAL | PERCENTEQUAL | ANDEQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | LEFTSHIFT | RIGHTSHIFTEQUAL | RIGHTSHIFT | DOT | COMMA | AT | NEWLINE | WS | LEADINGWS )
        int alt23=117;
        alt23 = dfa23.predict(input);
        switch (alt23) {
            case 1 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:10: T__68
                {
                mT__68(); 

                }
                break;
            case 2 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:16: T__69
                {
                mT__69(); 

                }
                break;
            case 3 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:22: T__70
                {
                mT__70(); 

                }
                break;
            case 4 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:28: T__71
                {
                mT__71(); 

                }
                break;
            case 5 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:34: T__72
                {
                mT__72(); 

                }
                break;
            case 6 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:40: T__73
                {
                mT__73(); 

                }
                break;
            case 7 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:46: T__74
                {
                mT__74(); 

                }
                break;
            case 8 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:52: T__75
                {
                mT__75(); 

                }
                break;
            case 9 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:58: T__76
                {
                mT__76(); 

                }
                break;
            case 10 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:64: T__77
                {
                mT__77(); 

                }
                break;
            case 11 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:70: T__78
                {
                mT__78(); 

                }
                break;
            case 12 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:76: T__79
                {
                mT__79(); 

                }
                break;
            case 13 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:82: T__80
                {
                mT__80(); 

                }
                break;
            case 14 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:88: T__81
                {
                mT__81(); 

                }
                break;
            case 15 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:94: T__82
                {
                mT__82(); 

                }
                break;
            case 16 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:100: T__83
                {
                mT__83(); 

                }
                break;
            case 17 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:106: T__84
                {
                mT__84(); 

                }
                break;
            case 18 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:112: T__85
                {
                mT__85(); 

                }
                break;
            case 19 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:118: T__86
                {
                mT__86(); 

                }
                break;
            case 20 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:124: T__87
                {
                mT__87(); 

                }
                break;
            case 21 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:130: T__88
                {
                mT__88(); 

                }
                break;
            case 22 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:136: T__89
                {
                mT__89(); 

                }
                break;
            case 23 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:142: T__90
                {
                mT__90(); 

                }
                break;
            case 24 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:148: T__91
                {
                mT__91(); 

                }
                break;
            case 25 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:154: T__92
                {
                mT__92(); 

                }
                break;
            case 26 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:160: T__93
                {
                mT__93(); 

                }
                break;
            case 27 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:166: T__94
                {
                mT__94(); 

                }
                break;
            case 28 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:172: T__95
                {
                mT__95(); 

                }
                break;
            case 29 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:178: T__96
                {
                mT__96(); 

                }
                break;
            case 30 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:184: T__97
                {
                mT__97(); 

                }
                break;
            case 31 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:190: T__98
                {
                mT__98(); 

                }
                break;
            case 32 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:196: T__99
                {
                mT__99(); 

                }
                break;
            case 33 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:202: T__100
                {
                mT__100(); 

                }
                break;
            case 34 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:209: T__101
                {
                mT__101(); 

                }
                break;
            case 35 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:216: T__102
                {
                mT__102(); 

                }
                break;
            case 36 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:223: T__103
                {
                mT__103(); 

                }
                break;
            case 37 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:230: T__104
                {
                mT__104(); 

                }
                break;
            case 38 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:237: T__105
                {
                mT__105(); 

                }
                break;
            case 39 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:244: T__106
                {
                mT__106(); 

                }
                break;
            case 40 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:251: T__107
                {
                mT__107(); 

                }
                break;
            case 41 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:258: T__108
                {
                mT__108(); 

                }
                break;
            case 42 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:265: T__109
                {
                mT__109(); 

                }
                break;
            case 43 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:272: T__110
                {
                mT__110(); 

                }
                break;
            case 44 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:279: T__111
                {
                mT__111(); 

                }
                break;
            case 45 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:286: T__112
                {
                mT__112(); 

                }
                break;
            case 46 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:293: T__113
                {
                mT__113(); 

                }
                break;
            case 47 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:300: T__114
                {
                mT__114(); 

                }
                break;
            case 48 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:307: T__115
                {
                mT__115(); 

                }
                break;
            case 49 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:314: T__116
                {
                mT__116(); 

                }
                break;
            case 50 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:321: T__117
                {
                mT__117(); 

                }
                break;
            case 51 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:328: T__118
                {
                mT__118(); 

                }
                break;
            case 52 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:335: T__119
                {
                mT__119(); 

                }
                break;
            case 53 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:342: T__120
                {
                mT__120(); 

                }
                break;
            case 54 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:349: T__121
                {
                mT__121(); 

                }
                break;
            case 55 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:356: T__122
                {
                mT__122(); 

                }
                break;
            case 56 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:363: T__123
                {
                mT__123(); 

                }
                break;
            case 57 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:370: T__124
                {
                mT__124(); 

                }
                break;
            case 58 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:377: T__125
                {
                mT__125(); 

                }
                break;
            case 59 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:384: T__126
                {
                mT__126(); 

                }
                break;
            case 60 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:391: T__127
                {
                mT__127(); 

                }
                break;
            case 61 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:398: T__128
                {
                mT__128(); 

                }
                break;
            case 62 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:405: FLOATINGPOINTL
                {
                mFLOATINGPOINTL(); 

                }
                break;
            case 63 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:420: HEXDIGITS
                {
                mHEXDIGITS(); 

                }
                break;
            case 64 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:430: DECIMALL
                {
                mDECIMALL(); 

                }
                break;
            case 65 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:439: OCTDIGITS
                {
                mOCTDIGITS(); 

                }
                break;
            case 66 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:449: BINDIGITS
                {
                mBINDIGITS(); 

                }
                break;
            case 67 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:459: CHARACTERL
                {
                mCHARACTERL(); 

                }
                break;
            case 68 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:470: ID
                {
                mID(); 

                }
                break;
            case 69 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:473: FF
                {
                mFF(); 

                }
                break;
            case 70 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:476: TAB
                {
                mTAB(); 

                }
                break;
            case 71 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:480: CR
                {
                mCR(); 

                }
                break;
            case 72 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:483: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 73 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:490: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 74 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:497: LBRACK
                {
                mLBRACK(); 

                }
                break;
            case 75 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:504: RBRACK
                {
                mRBRACK(); 

                }
                break;
            case 76 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:511: COLON
                {
                mCOLON(); 

                }
                break;
            case 77 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:517: SEMI
                {
                mSEMI(); 

                }
                break;
            case 78 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:522: PLUS
                {
                mPLUS(); 

                }
                break;
            case 79 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:527: MINUS
                {
                mMINUS(); 

                }
                break;
            case 80 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:533: STAR
                {
                mSTAR(); 

                }
                break;
            case 81 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:538: SLASH
                {
                mSLASH(); 

                }
                break;
            case 82 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:544: VBAR
                {
                mVBAR(); 

                }
                break;
            case 83 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:549: AMPER
                {
                mAMPER(); 

                }
                break;
            case 84 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:555: LESS
                {
                mLESS(); 

                }
                break;
            case 85 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:560: GREATER
                {
                mGREATER(); 

                }
                break;
            case 86 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:568: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 87 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:575: PERCENT
                {
                mPERCENT(); 

                }
                break;
            case 88 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:583: BACKQUOTE
                {
                mBACKQUOTE(); 

                }
                break;
            case 89 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:593: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 90 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:600: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 91 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:607: CIRCUMFLEX
                {
                mCIRCUMFLEX(); 

                }
                break;
            case 92 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:618: TILDE
                {
                mTILDE(); 

                }
                break;
            case 93 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:624: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 94 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:630: NOTEQUAL
                {
                mNOTEQUAL(); 

                }
                break;
            case 95 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:639: ALT_NOTEQUAL
                {
                mALT_NOTEQUAL(); 

                }
                break;
            case 96 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:652: LESSEQUAL
                {
                mLESSEQUAL(); 

                }
                break;
            case 97 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:662: GREATEREQUAL
                {
                mGREATEREQUAL(); 

                }
                break;
            case 98 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:675: PLUSEQUAL
                {
                mPLUSEQUAL(); 

                }
                break;
            case 99 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:685: MINUSEQUAL
                {
                mMINUSEQUAL(); 

                }
                break;
            case 100 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:696: DOUBLESTAR
                {
                mDOUBLESTAR(); 

                }
                break;
            case 101 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:707: STAREQUAL
                {
                mSTAREQUAL(); 

                }
                break;
            case 102 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:717: DOUBLESLASH
                {
                mDOUBLESLASH(); 

                }
                break;
            case 103 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:729: SLASHEQUAL
                {
                mSLASHEQUAL(); 

                }
                break;
            case 104 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:740: OREQUAL
                {
                mOREQUAL(); 

                }
                break;
            case 105 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:748: PERCENTEQUAL
                {
                mPERCENTEQUAL(); 

                }
                break;
            case 106 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:761: ANDEQUAL
                {
                mANDEQUAL(); 

                }
                break;
            case 107 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:770: CIRCUMFLEXEQUAL
                {
                mCIRCUMFLEXEQUAL(); 

                }
                break;
            case 108 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:786: LEFTSHIFTEQUAL
                {
                mLEFTSHIFTEQUAL(); 

                }
                break;
            case 109 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:801: LEFTSHIFT
                {
                mLEFTSHIFT(); 

                }
                break;
            case 110 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:811: RIGHTSHIFTEQUAL
                {
                mRIGHTSHIFTEQUAL(); 

                }
                break;
            case 111 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:827: RIGHTSHIFT
                {
                mRIGHTSHIFT(); 

                }
                break;
            case 112 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:838: DOT
                {
                mDOT(); 

                }
                break;
            case 113 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:842: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 114 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:848: AT
                {
                mAT(); 

                }
                break;
            case 115 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:851: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 116 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:859: WS
                {
                mWS(); 

                }
                break;
            case 117 :
                // H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\twyncat.g:1:862: LEADINGWS
                {
                mLEADINGWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA5_eotS =
        "\4\uffff";
    static final String DFA5_eofS =
        "\4\uffff";
    static final String DFA5_minS =
        "\2\56\2\uffff";
    static final String DFA5_maxS =
        "\1\71\1\145\2\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA5_specialS =
        "\4\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\2\1\uffff\12\1\13\uffff\1\3\37\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "776:1: FLOATINGPOINTL : ( ( '0' .. '9' )* '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA23_eotS =
        "\1\uffff\2\33\1\104\2\33\1\120\14\33\1\152\1\154\2\uffff\1\156"+
        "\1\157\1\156\2\uffff\1\161\1\163\1\165\6\uffff\1\167\1\171\1\174"+
        "\1\177\1\u0081\1\u0083\1\u0087\1\u008a\1\u008c\1\u008e\3\uffff\1"+
        "\u0090\5\uffff\1\u0091\2\33\1\uffff\5\33\1\u009a\1\33\2\uffff\13"+
        "\33\1\uffff\1\u00a9\1\u00aa\3\33\1\uffff\15\33\1\u00be\1\uffff\3"+
        "\33\2\uffff\1\u00c2\4\uffff\1\156\3\uffff\1\u0091\21\uffff\1\u00c7"+
        "\2\uffff\1\u00c9\10\uffff\7\33\2\uffff\14\33\1\u00de\1\33\2\uffff"+
        "\4\33\1\u00e6\6\33\1\u00ed\1\33\1\u00ef\4\33\1\u00f4\1\uffff\2\33"+
        "\1\u00f7\10\uffff\1\u00f8\1\u00f9\1\u00fa\2\33\1\u00fd\1\u00fe\1"+
        "\33\1\u0100\4\33\1\u0105\2\33\1\u0108\3\33\1\uffff\1\33\1\u010d"+
        "\3\33\1\u0111\2\uffff\1\u0112\1\33\1\u0114\2\33\1\u0117\1\uffff"+
        "\1\33\1\uffff\1\u0119\1\u011a\1\u011b\1\u011c\1\uffff\1\33\1\u011e"+
        "\4\uffff\1\u011f\1\u0120\2\uffff\1\33\1\uffff\1\u0122\1\u0123\1"+
        "\u0124\1\u0125\1\uffff\1\u0126\1\u0127\1\uffff\3\33\1\u012b\1\uffff"+
        "\3\33\2\uffff\1\u012f\1\uffff\2\33\1\uffff\1\u0132\4\uffff\1\33"+
        "\3\uffff\1\33\6\uffff\1\u0135\2\33\1\uffff\1\u0139\1\u013a\1\u013b"+
        "\1\uffff\2\33\1\uffff\1\33\1\u013f\1\uffff\2\33\1\u0142\3\uffff"+
        "\1\u0143\2\33\1\uffff\1\33\1\u0147\2\uffff\1\33\1\u0149\1\u014a"+
        "\1\uffff\1\33\2\uffff\1\u014c\1\uffff";
    static final String DFA23_eofS =
        "\u014d\uffff";
    static final String DFA23_minS =
        "\1\11\1\41\1\150\1\41\1\151\1\144\1\60\1\146\1\145\1\41\1\162\1"+
        "\141\1\145\1\157\2\154\1\41\1\141\1\157\1\41\1\60\2\uffff\1\56\1"+
        "\60\1\56\2\uffff\2\11\1\12\6\uffff\2\75\1\52\1\57\2\75\1\74\3\75"+
        "\3\uffff\1\75\5\uffff\1\11\1\157\1\164\1\uffff\1\162\1\151\1\157"+
        "\1\156\1\164\1\41\1\146\2\uffff\1\156\1\157\1\145\2\151\1\156\1"+
        "\151\1\164\1\156\1\162\1\142\1\uffff\2\60\1\141\1\155\1\144\1\uffff"+
        "\1\165\1\154\1\157\1\151\1\162\1\156\1\162\1\151\1\144\1\165\2\151"+
        "\1\164\1\60\1\uffff\1\156\1\163\1\164\2\uffff\1\60\4\uffff\1\56"+
        "\1\0\1\uffff\1\0\1\11\21\uffff\1\75\2\uffff\1\75\7\uffff\1\0\1\154"+
        "\1\145\1\144\1\154\1\162\1\164\1\145\2\uffff\1\141\1\164\1\162\1"+
        "\141\2\156\1\164\1\156\1\151\1\164\1\151\1\162\1\60\1\165\2\uffff"+
        "\1\154\1\141\2\145\1\41\1\145\1\163\1\147\1\156\1\163\1\143\1\60"+
        "\1\141\1\60\1\155\1\164\1\145\1\146\1\60\1\uffff\1\163\1\145\1\60"+
        "\10\uffff\3\60\1\145\1\144\2\60\1\165\1\60\1\144\1\154\2\164\1\60"+
        "\1\164\1\154\1\60\1\156\1\143\1\141\1\uffff\1\164\1\60\1\162\1\151"+
        "\1\141\1\60\2\uffff\1\60\1\145\1\60\1\164\1\151\1\60\1\uffff\1\163"+
        "\1\uffff\4\60\1\uffff\1\164\1\60\4\uffff\2\60\2\uffff\1\154\1\uffff"+
        "\4\60\1\uffff\2\60\1\uffff\1\147\1\164\1\156\1\60\1\uffff\2\156"+
        "\1\164\2\uffff\1\60\1\uffff\1\145\1\163\1\uffff\1\60\4\uffff\1\141"+
        "\3\uffff\1\164\6\uffff\1\60\1\165\1\147\1\uffff\3\60\1\uffff\1\162"+
        "\1\164\1\uffff\1\156\1\60\1\uffff\1\162\1\145\1\60\3\uffff\1\60"+
        "\1\145\1\164\1\uffff\1\145\1\60\2\uffff\1\156\2\60\1\uffff\1\164"+
        "\2\uffff\1\60\1\uffff";
    static final String DFA23_maxS =
        "\1\176\1\171\1\157\1\172\1\167\1\163\1\172\1\156\1\145\1\157\1"+
        "\162\1\141\1\162\1\165\1\156\1\170\1\165\2\157\2\172\2\uffff\1\145"+
        "\1\71\1\145\2\uffff\2\40\1\12\6\uffff\6\75\2\76\2\75\3\uffff\1\75"+
        "\5\uffff\1\40\1\157\1\164\1\uffff\1\162\1\151\1\157\1\156\1\164"+
        "\1\172\1\146\2\uffff\1\156\1\157\1\145\2\151\1\156\1\151\1\164\1"+
        "\156\1\162\1\142\1\uffff\2\172\1\164\1\155\1\144\1\uffff\1\165\1"+
        "\154\1\157\1\151\1\162\1\156\1\162\1\151\1\144\1\165\1\151\1\163"+
        "\1\164\1\172\1\uffff\1\156\1\163\1\164\2\uffff\1\172\4\uffff\1\145"+
        "\1\0\1\uffff\1\0\1\40\21\uffff\1\75\2\uffff\1\75\7\uffff\1\0\1\154"+
        "\1\145\1\144\1\154\1\162\1\164\1\145\2\uffff\1\141\1\164\1\162\1"+
        "\141\2\156\1\164\1\156\1\151\1\164\1\165\1\162\1\172\1\165\2\uffff"+
        "\1\154\1\165\2\145\1\172\1\145\1\163\1\147\1\156\1\163\1\143\1\172"+
        "\1\141\1\172\1\155\1\164\1\145\1\146\1\172\1\uffff\1\163\1\145\1"+
        "\172\10\uffff\3\172\1\145\1\144\2\172\1\165\1\172\1\144\1\154\2"+
        "\164\1\172\1\164\1\154\1\172\1\156\1\143\1\141\1\uffff\1\164\1\172"+
        "\1\162\1\151\1\141\1\172\2\uffff\1\172\1\145\1\172\1\164\1\151\1"+
        "\172\1\uffff\1\163\1\uffff\4\172\1\uffff\1\164\1\172\4\uffff\2\172"+
        "\2\uffff\1\154\1\uffff\4\172\1\uffff\2\172\1\uffff\1\147\1\164\1"+
        "\156\1\172\1\uffff\2\156\1\164\2\uffff\1\172\1\uffff\1\145\1\163"+
        "\1\uffff\1\172\4\uffff\1\141\3\uffff\1\164\6\uffff\1\172\1\165\1"+
        "\147\1\uffff\3\172\1\uffff\1\162\1\164\1\uffff\1\156\1\172\1\uffff"+
        "\1\162\1\145\1\172\3\uffff\1\172\1\145\1\164\1\uffff\1\145\1\172"+
        "\2\uffff\1\156\2\172\1\uffff\1\164\2\uffff\1\172\1\uffff";
    static final String DFA23_acceptS =
        "\25\uffff\1\74\1\75\3\uffff\1\103\1\104\3\uffff\1\110\1\111\1\112"+
        "\1\113\1\114\1\115\12\uffff\1\130\1\131\1\132\1\uffff\1\134\1\136"+
        "\1\161\1\162\1\163\3\uffff\1\102\7\uffff\1\72\1\64\13\uffff\1\67"+
        "\5\uffff\1\63\16\uffff\1\101\3\uffff\1\77\1\65\1\uffff\1\66\1\76"+
        "\1\100\1\160\2\uffff\1\164\2\uffff\1\107\1\142\1\116\1\143\1\117"+
        "\1\144\1\145\1\120\1\146\1\147\1\121\1\150\1\122\1\152\1\123\1\137"+
        "\1\140\1\uffff\1\124\1\141\1\uffff\1\125\1\135\1\126\1\151\1\127"+
        "\1\153\1\133\10\uffff\1\73\1\24\16\uffff\1\37\1\47\23\uffff\1\60"+
        "\3\uffff\1\70\1\105\1\106\1\165\1\154\1\155\1\156\1\157\24\uffff"+
        "\1\12\6\uffff\1\71\1\22\6\uffff\1\54\1\uffff\1\61\4\uffff\1\40\2"+
        "\uffff\1\62\1\1\1\2\1\3\2\uffff\1\14\1\23\1\uffff\1\5\4\uffff\1"+
        "\13\2\uffff\1\10\4\uffff\1\16\3\uffff\1\21\1\25\1\uffff\1\27\2\uffff"+
        "\1\30\1\uffff\1\35\1\46\1\50\1\51\1\uffff\1\52\1\55\1\4\1\uffff"+
        "\1\7\1\17\1\6\1\11\1\15\1\57\3\uffff\1\41\3\uffff\1\26\2\uffff\1"+
        "\32\2\uffff\1\20\3\uffff\1\45\1\43\1\56\3\uffff\1\53\2\uffff\1\31"+
        "\1\34\3\uffff\1\33\1\uffff\1\44\1\36\1\uffff\1\42";
    static final String DFA23_specialS =
        "\1\6\33\uffff\1\4\1\5\32\uffff\1\0\70\uffff\1\3\1\uffff\1\7\1\1"+
        "\34\uffff\1\2\u00bb\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\35\1\67\1\uffff\1\34\1\36\22\uffff\1\70\1\64\1\25\2\uffff"+
            "\1\56\1\52\1\32\1\37\1\40\1\47\1\45\1\65\1\46\1\30\1\50\1\27"+
            "\11\31\1\43\1\44\1\53\1\55\1\54\1\uffff\1\66\5\33\1\13\15\33"+
            "\1\12\6\33\1\41\1\26\1\42\1\62\1\33\1\57\1\16\1\1\1\21\1\3\1"+
            "\17\1\15\1\33\1\23\1\7\2\33\1\4\1\24\1\22\1\20\1\14\1\33\1\10"+
            "\1\6\1\11\1\5\1\33\1\2\3\33\1\60\1\51\1\61\1\63",
            "\1\73\115\uffff\1\71\11\uffff\1\72",
            "\1\75\6\uffff\1\74",
            "\1\103\16\uffff\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\1"+
            "\100\3\33\1\102\3\33\1\77\12\33\1\101\2\33\1\76\3\33",
            "\1\105\10\uffff\1\107\4\uffff\1\106",
            "\1\113\4\uffff\1\112\2\uffff\1\110\1\uffff\1\114\4\uffff\1"+
            "\111",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\10\33\1\115\12\33"+
            "\1\116\1\117\5\33",
            "\1\122\7\uffff\1\121",
            "\1\123",
            "\1\126\107\uffff\1\124\5\uffff\1\125",
            "\1\127",
            "\1\130",
            "\1\133\11\uffff\1\132\2\uffff\1\131",
            "\1\135\5\uffff\1\134",
            "\1\136\1\uffff\1\137",
            "\1\142\1\uffff\1\140\11\uffff\1\141",
            "\1\145\120\uffff\1\144\2\uffff\1\143",
            "\1\147\15\uffff\1\146",
            "\1\150",
            "\1\151\16\uffff\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\22\33\1\153\7\33",
            "",
            "",
            "\1\155\1\uffff\12\155\13\uffff\1\155\37\uffff\1\155",
            "\12\155",
            "\1\155\1\uffff\12\160\13\uffff\1\155\37\uffff\1\155",
            "",
            "",
            "\1\162\1\67\1\uffff\1\162\1\67\22\uffff\1\162",
            "\1\164\2\uffff\1\162\23\uffff\1\70",
            "\1\67",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\166",
            "\1\170",
            "\1\172\22\uffff\1\173",
            "\1\175\15\uffff\1\176",
            "\1\u0080",
            "\1\u0082",
            "\1\u0086\1\u0085\1\u0084",
            "\1\u0088\1\u0089",
            "\1\u008b",
            "\1\u008d",
            "",
            "",
            "",
            "\1\u008f",
            "",
            "",
            "",
            "",
            "",
            "\1\164\2\uffff\1\162\23\uffff\1\70",
            "\1\u0092",
            "\1\u0093",
            "",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099\16\uffff\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff"+
            "\32\33",
            "\1\u009b",
            "",
            "",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\16\33\1\u00a8\4"+
            "\33\1\u00a7\6\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00ab\16\uffff\1\u00ad\3\uffff\1\u00ac",
            "\1\u00ae",
            "\1\u00af",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bc\11\uffff\1\u00bb",
            "\1\u00bd",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "",
            "",
            "\1\155\1\uffff\12\160\13\uffff\1\155\37\uffff\1\155",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\164\2\uffff\1\162\23\uffff\1\70",
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
            "\1\u00c6",
            "",
            "",
            "\1\u00c8",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "",
            "",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db\13\uffff\1\u00dc",
            "\1\u00dd",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00df",
            "",
            "",
            "\1\u00e0",
            "\1\u00e2\23\uffff\1\u00e1",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5\16\uffff\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff"+
            "\32\33",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00ee",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u00f5",
            "\1\u00f6",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00fb",
            "\1\u00fc",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00ff",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0106",
            "\1\u0107",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "",
            "\1\u010c",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0113",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0115",
            "\1\u0116",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u0118",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u011d",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "\1\u0121",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u0130",
            "\1\u0131",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "",
            "",
            "\1\u0133",
            "",
            "",
            "",
            "\1\u0134",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0136",
            "\1\u0137",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\22\33\1\u0138\7"+
            "\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u013c",
            "\1\u013d",
            "",
            "\1\u013e",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u0140",
            "\1\u0141",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0144",
            "\1\u0145",
            "",
            "\1\u0146",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
            "\1\u0148",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u014b",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | FLOATINGPOINTL | HEXDIGITS | DECIMALL | OCTDIGITS | BINDIGITS | CHARACTERL | ID | FF | TAB | CR | LPAREN | RPAREN | LBRACK | RBRACK | COLON | SEMI | PLUS | MINUS | STAR | SLASH | VBAR | AMPER | LESS | GREATER | ASSIGN | PERCENT | BACKQUOTE | LCURLY | RCURLY | CIRCUMFLEX | TILDE | EQUAL | NOTEQUAL | ALT_NOTEQUAL | LESSEQUAL | GREATEREQUAL | PLUSEQUAL | MINUSEQUAL | DOUBLESTAR | STAREQUAL | DOUBLESLASH | SLASHEQUAL | OREQUAL | PERCENTEQUAL | ANDEQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | LEFTSHIFT | RIGHTSHIFTEQUAL | RIGHTSHIFT | DOT | COMMA | AT | NEWLINE | WS | LEADINGWS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_56 = input.LA(1);

                         
                        int index23_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_56==' ') && ((( getCharPositionInLine() == 0 )||( getCharPositionInLine() > 0 )))) {s = 56;}

                        else if ( (LA23_56=='\t') && ((( getCharPositionInLine() == 0 )||( getCharPositionInLine() > 0 )))) {s = 116;}

                        else if ( (LA23_56=='\f') && (( getCharPositionInLine() > 0 ))) {s = 114;}

                        else s = 145;

                         
                        input.seek(index23_56);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_116 = input.LA(1);

                         
                        int index23_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_116==' ') && ((( getCharPositionInLine() == 0 )||( getCharPositionInLine() > 0 )))) {s = 56;}

                        else if ( (LA23_116=='\t') && ((( getCharPositionInLine() == 0 )||( getCharPositionInLine() > 0 )))) {s = 116;}

                        else if ( (LA23_116=='\f') && (( getCharPositionInLine() > 0 ))) {s = 114;}

                        else s = 145;

                         
                        input.seek(index23_116);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_145 = input.LA(1);

                         
                        int index23_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( getCharPositionInLine() > 0 )) ) {s = 114;}

                        else if ( (( getCharPositionInLine() == 0 )) ) {s = 197;}

                         
                        input.seek(index23_145);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_113 = input.LA(1);

                         
                        int index23_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((( getCharPositionInLine() > 0 )))) ) {s = 195;}

                        else if ( (( getCharPositionInLine() > 0 )) ) {s = 114;}

                         
                        input.seek(index23_113);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_28 = input.LA(1);

                         
                        int index23_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_28=='\t'||LA23_28=='\f'||LA23_28==' ') && (( getCharPositionInLine() > 0 ))) {s = 114;}

                        else if ( (LA23_28=='\n'||LA23_28=='\r') ) {s = 55;}

                        else s = 113;

                         
                        input.seek(index23_28);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_29 = input.LA(1);

                         
                        int index23_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_29==' ') && ((( getCharPositionInLine() == 0 )||( getCharPositionInLine() > 0 )))) {s = 56;}

                        else if ( (LA23_29=='\t') && ((( getCharPositionInLine() == 0 )||( getCharPositionInLine() > 0 )))) {s = 116;}

                        else if ( (LA23_29=='\f') && (( getCharPositionInLine() > 0 ))) {s = 114;}

                        else s = 115;

                         
                        input.seek(index23_29);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_0 = input.LA(1);

                         
                        int index23_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_0=='b') ) {s = 1;}

                        else if ( (LA23_0=='w') ) {s = 2;}

                        else if ( (LA23_0=='d') ) {s = 3;}

                        else if ( (LA23_0=='l') ) {s = 4;}

                        else if ( (LA23_0=='u') ) {s = 5;}

                        else if ( (LA23_0=='s') ) {s = 6;}

                        else if ( (LA23_0=='i') ) {s = 7;}

                        else if ( (LA23_0=='r') ) {s = 8;}

                        else if ( (LA23_0=='t') ) {s = 9;}

                        else if ( (LA23_0=='T') ) {s = 10;}

                        else if ( (LA23_0=='F') ) {s = 11;}

                        else if ( (LA23_0=='p') ) {s = 12;}

                        else if ( (LA23_0=='f') ) {s = 13;}

                        else if ( (LA23_0=='a') ) {s = 14;}

                        else if ( (LA23_0=='e') ) {s = 15;}

                        else if ( (LA23_0=='o') ) {s = 16;}

                        else if ( (LA23_0=='c') ) {s = 17;}

                        else if ( (LA23_0=='n') ) {s = 18;}

                        else if ( (LA23_0=='h') ) {s = 19;}

                        else if ( (LA23_0=='m') ) {s = 20;}

                        else if ( (LA23_0=='\"') ) {s = 21;}

                        else if ( (LA23_0=='\\') ) {s = 22;}

                        else if ( (LA23_0=='0') ) {s = 23;}

                        else if ( (LA23_0=='.') ) {s = 24;}

                        else if ( ((LA23_0>='1' && LA23_0<='9')) ) {s = 25;}

                        else if ( (LA23_0=='\'') ) {s = 26;}

                        else if ( ((LA23_0>='A' && LA23_0<='E')||(LA23_0>='G' && LA23_0<='S')||(LA23_0>='U' && LA23_0<='Z')||LA23_0=='_'||LA23_0=='g'||(LA23_0>='j' && LA23_0<='k')||LA23_0=='q'||LA23_0=='v'||(LA23_0>='x' && LA23_0<='z')) ) {s = 27;}

                        else if ( (LA23_0=='\f') ) {s = 28;}

                        else if ( (LA23_0=='\t') ) {s = 29;}

                        else if ( (LA23_0=='\r') ) {s = 30;}

                        else if ( (LA23_0=='(') ) {s = 31;}

                        else if ( (LA23_0==')') ) {s = 32;}

                        else if ( (LA23_0=='[') ) {s = 33;}

                        else if ( (LA23_0==']') ) {s = 34;}

                        else if ( (LA23_0==':') ) {s = 35;}

                        else if ( (LA23_0==';') ) {s = 36;}

                        else if ( (LA23_0=='+') ) {s = 37;}

                        else if ( (LA23_0=='-') ) {s = 38;}

                        else if ( (LA23_0=='*') ) {s = 39;}

                        else if ( (LA23_0=='/') ) {s = 40;}

                        else if ( (LA23_0=='|') ) {s = 41;}

                        else if ( (LA23_0=='&') ) {s = 42;}

                        else if ( (LA23_0=='<') ) {s = 43;}

                        else if ( (LA23_0=='>') ) {s = 44;}

                        else if ( (LA23_0=='=') ) {s = 45;}

                        else if ( (LA23_0=='%') ) {s = 46;}

                        else if ( (LA23_0=='`') ) {s = 47;}

                        else if ( (LA23_0=='{') ) {s = 48;}

                        else if ( (LA23_0=='}') ) {s = 49;}

                        else if ( (LA23_0=='^') ) {s = 50;}

                        else if ( (LA23_0=='~') ) {s = 51;}

                        else if ( (LA23_0=='!') ) {s = 52;}

                        else if ( (LA23_0==',') ) {s = 53;}

                        else if ( (LA23_0=='@') ) {s = 54;}

                        else if ( (LA23_0=='\n') ) {s = 55;}

                        else if ( (LA23_0==' ') && ((( getCharPositionInLine() == 0 )||( getCharPositionInLine() > 0 )))) {s = 56;}

                         
                        input.seek(index23_0);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_115 = input.LA(1);

                         
                        int index23_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((( getCharPositionInLine() == 0 )||( getCharPositionInLine() > 0 ))))) ) {s = 196;}

                        else if ( (( getCharPositionInLine() > 0 )) ) {s = 114;}

                        else if ( (( getCharPositionInLine() == 0 )) ) {s = 197;}

                         
                        input.seek(index23_115);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}