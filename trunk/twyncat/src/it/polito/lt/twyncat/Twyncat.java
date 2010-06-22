package it.polito.lt.twyncat;

import it.polito.lt.twyncat.exceptions.FieldExistsException;
import it.polito.lt.twyncat.exceptions.StructureExistsException;
import it.polito.lt.twyncat.exceptions.SymbolExistsException;
import it.polito.lt.twyncat.exceptions.TypeUnknownException;
import it.polito.lt.twyncat.exceptions.UnknownTypeException;
import it.polito.lt.twyncat.exceptions.VariableNotDeclaredException;
import it.polito.lt.twyncat.rules.Function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Twyncat {
	
	private static Twyncat instance = null;
	static HashMap<String,Structure> structures;
	static HashMap<String,Type> types;
	static HashMap<String,Symbol> symbols;
	static HashMap<String,Function> functions;
	
	private Twyncat(){
		structures = new HashMap<String, Structure>();
		types = new HashMap<String,Type>();
		symbols = new HashMap<String,Symbol>();
		File fT = new File("C:\\Users\\Luca\\Desktop\\types");
		File fS = new File("C:\\Users\\Luca\\Desktop\\structures");
		initTypes(fT);
		initStructures(fS);
	}
	
	protected static Type getType(String name) {
		if (instance == null)
			return null;
		if (types.containsKey(name))
			return types.get(name);
		return null;
	}
	
	protected static Structure getStructure(String name) {
		if (instance == null)
			return null;
		if (structures.containsKey(name))
			return structures.get(name);
		return null;
	}
	
	private void initTypes(File f) {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(f));
			String line = null;
			while (( line = input.readLine()) != null) {
				Type t = new Type(line.trim());
				types.put(t.getName(), t);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Known Types: " + types.size());
	}

	private void initStructures(File f) {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(f));
			String line = null;
			while (( line = input.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "->");
				Structure s = new Structure(st.nextToken(" "));
				while(st.hasMoreTokens() && (st.countTokens() >= 2)){
					String fieldName = st.nextToken().trim();
					String fieldType = st.nextToken().trim();
					s.addField(fieldName, fieldType);
				}
				structures.put(s.getName(), s);
				System.out.println(s.getName() + " added!");
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (FieldExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Known Structures: " + structures.size());
	}

	public static synchronized Twyncat getInstance() {
		if (instance == null) {
			instance = new Twyncat();
		}
		return instance;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public void declareStructure(Structure s) throws StructureExistsException{
		if (structures.containsKey(s.getName())) {
			throw new StructureExistsException(s.getName());
		} else {
			structures.put(s.getName(), s);
		}
	}
	
	public void declare(String n, String type) throws SymbolExistsException, TypeUnknownException {
		// Check if name is in symbols keys
		if(symbols.containsKey(n)) {
			throw new SymbolExistsException(n);
		} else {
			// Check if Type exists in base types
			if(types.containsKey(type)) {
				Symbol s = new Symbol(n, false, types.get(type));
				symbols.put(s.getName(), s);
				return;
			}
			// Check if Type exists in structures
			if(structures.containsKey(type)) {
				Structure s = structures.get(type);
				Symbol sym = new Symbol(n, s.getType());
				symbols.put(sym.getName(), sym);
				HashMap<String,Field> fields = s.getFields();
				for(String fs : fields.keySet()) {
					Field sf = fields.get(fs);
					sym = new Symbol(n + "." + fs, sf.getType());
					symbols.put(sym.getName(), sym);
				}
				return;
			}
			throw new TypeUnknownException(type);
		}
	}
	
	void checkVariable(String name) throws VariableNotDeclaredException {
		if(symbols.containsKey(name)) {
			return;
		} else {
			String unscopedName = name.substring(name.indexOf("."));
			if(symbols.containsKey(unscopedName)){
				return;
			} else {
				throw new VariableNotDeclaredException(name);
			}
		}
	}
}
 