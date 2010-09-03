package it.polito.lt.twyncat;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

public class TwyncatManager {

	
	public static void main(String[] args) throws IOException {
		TwyncatLexer lex = new TwyncatLexer(new ANTLRFileStream("H:\\Documents and Settings\\Luca\\Desktop\\TwynCAT\\test.twyncat", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        TwyncatParser g = new TwyncatParser(tokens, null);
        try {
            g.file();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
	}

}
