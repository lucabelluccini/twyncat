package it.polito.lt.twyncat;

public class Symbol {
	
	String name;
	Component type;
	Boolean isLocal;
	
	public Symbol(String n, Component t) {
		name = n.toLowerCase();
		type = t;
		isLocal = false;
	}

	public Symbol(String n, Component t, boolean isL) {
		name = n.toLowerCase();
		type = t;
		isLocal = isL;
	}

	public String getName() {
		return name;
	}
	
	public Boolean isLocal() {
		return isLocal;
	}
	
	public String toString() {
		return ("Symbol '" + name + "' - " + type.getName());
	}

}
