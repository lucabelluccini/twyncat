package it.polito.lt.twyncat;

import java.util.HashMap;

public class Type implements Component{
	String name;

	public Type(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public HashMap<String, Field> getFields() {
		return null;
	}

	public Component getType() {
		return this;
	}
	
}
