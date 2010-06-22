import java.io.*;
import org.antlr.runtime.*;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;

public class Main {
    public static StringTemplateGroup templates;

    public static void main(String[] args) throws Exception {
        String templateFileName;
        int a = 0;
        if ( args.length <= 1 ) {
			templateFileName = "Z:/Documenti/Appunti e Dispense/Corsi Politecnico To DO/Linguaggi e Traduttori/Tesina/TwynCAT/twincatST.stg";
			
        } else {
			templateFileName = args[a];
			a++;
        }
        templates = new StringTemplateGroup(new FileReader(templateFileName));
        System.out.println("Loaded " + templateFileName + ".");
        twyncatLexer lex = new twyncatLexer(new ANTLRFileStream("Z:/Documenti/Appunti e Dispense/Corsi Politecnico To DO/Linguaggi e Traduttori/Tesina/TwynCAT/test.twyncat"));
        //CommonTokenStream tokens = new CommonTokenStream(lex);
        CommonTokenStream tokens = new TokenRewriteStream(lex);
        twyncatParser g = new twyncatParser(tokens, 49100, null);
        g.setTemplateLib(templates);
        twyncatParser.file_return fr;
		fr = g.file();
		StringTemplate outputST = (StringTemplate) fr.getTemplate();
        System.out.println(outputST.toString());
    }
}