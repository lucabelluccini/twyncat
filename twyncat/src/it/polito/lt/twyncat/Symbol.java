package it.polito.lt.twyncat;

public class Symbol {
	
	String name;
	Component type;
	Boolean isArray;
	
	public Symbol(String n, Boolean a, Component t) {
		name = n;
		type = t;
		isArray = a;
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
