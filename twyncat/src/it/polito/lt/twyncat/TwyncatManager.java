package it.polito.lt.twyncat;

import it.polito.lt.twyncat.exceptions.FieldExistsException;
import it.polito.lt.twyncat.exceptions.StructureExistsException;
import it.polito.lt.twyncat.exceptions.SymbolExistsException;
import it.polito.lt.twyncat.exceptions.TypeUnknownException;
import it.polito.lt.twyncat.exceptions.UnknownTypeException;
import it.polito.lt.twyncat.exceptions.VariableNotDeclaredException;

public class TwyncatManager {

	
	public static void main(String[] args) throws SymbolExistsException, TypeUnknownException {
		Twyncat twy = Twyncat.getInstance();
		
		Structure s3 = new Structure("myType3");
		try {
			s3.addField("a", "udint");
			s3.addField("v", "myType7");
		} catch (FieldExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnknownTypeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			twy.declareStructure(s3);
		} catch (StructureExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Structure s2 = new Structure("myType2");
		try {
			s2.addField("a", "bool");
			s2.addField("b", "myType3");
		} catch (FieldExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnknownTypeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			twy.declareStructure(s2);
		} catch (StructureExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Structure s1 = new Structure("myType");
		try {
			s1.addField("x", "int");
			s1.addField("y", "bool");
			s1.addField("z", "uint");
			s1.addField("k", "uint");
			s1.addField("w", "myType2");
		} catch (FieldExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			twy.declareStructure(s1);
		} catch (StructureExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Structures: " + Twyncat.structures.size());
		
		twy.declare("myint", "int");
		twy.declare("var", "myType");

		for(Symbol s : Twyncat.symbols.values())
			System.out.println(s);
		
		try {
			twy.checkVariable("var.x");
		} catch (VariableNotDeclaredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
