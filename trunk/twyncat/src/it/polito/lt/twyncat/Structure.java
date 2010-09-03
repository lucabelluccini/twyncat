package it.polito.lt.twyncat;

import it.polito.lt.twyncat.exceptions.FieldExistsException;
import it.polito.lt.twyncat.exceptions.TypeUnknownException;

import java.util.HashMap;

public class Structure implements Component {
	String name;
	HashMap<String,Field> fields;
	
	public Structure(String name) {
		this.name = name.toLowerCase();
		this.fields = new HashMap<String,Field>();
	}

	public String getName() {
		return name;
	}
	
	public void addField(String n, String type) throws FieldExistsException, TypeUnknownException {
		// Check if name is in fields
		if (fields.containsKey(n)) {
			throw new FieldExistsException(n + " in " + this.name);
		} else {
			Field f;
			f = new Field(n.toLowerCase(), type.toLowerCase());
			fields.put(f.getName(), f);
		}
	}

	public HashMap<String, Field> getFields() {
		HashMap<String,Field> allFields = new HashMap<String,Field>();
		for(Field f : fields.values()) {
			if(f.getType() instanceof Type) {
				allFields.put(f.getName(), f);
			}
			if(f.getType() instanceof Structure) {
				allFields.put(f.getName(), f);
				HashMap<String,Field> subFields = f.getType().getFields();
				for(String sfs : subFields.keySet()) {
					Field sf = subFields.get(sfs);
					allFields.put(f.getName() + "." + sfs, sf);
				}
			}
		}
		return allFields;
	}

	public Component getType() {
		return this;
	}

}
