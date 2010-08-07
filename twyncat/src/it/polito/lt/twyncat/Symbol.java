package it.polito.lt.twyncat;

public class Symbol {
	
	String name;
	Component type;
	Boolean isArray;
	
	public Symbol(String n, Component t) {
		name = n;
		type = t;
		isArray = false;
	}

	public String getName() {
		return name;
	}
	
	public Boolean isArray() {
		return isArray;
	}
	
	public String toString() {
		return ("Symbol '" + name + "' - " + type.getName());
	}

}
