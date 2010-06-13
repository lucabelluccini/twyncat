package it.polito.lt.twyncat;

import it.polito.lt.twyncat.exceptions.UnknownTypeException;

public class Field {
	String name;
	Component type;
	
	public Field(String n, String type) throws UnknownTypeException {
		this.name = n;
		// Check if type is in types keys
		if(Twyncat.getType(type) != null) {
			// get Type Object
			this.type = Twyncat.getType(type);
			return;
		}
		if(Twyncat.getStructure(type) != null) {
			// get Structure Object
			this.type = Twyncat.getStructure(type);
			return;
		}
		throw new UnknownTypeException(type);
	}

	public String getName() {
		return name;
	}

	public Component getType() {
		return type;
	}
	
}
