package it.polito.lt.twyncat;

public class Symbol {
	
	String name;
	Component type;
	
	public Symbol(String n, Component t) {
		name = n;
		type = t;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return ("Symbol '" + name + "' - " + type.getName());
	}

}
