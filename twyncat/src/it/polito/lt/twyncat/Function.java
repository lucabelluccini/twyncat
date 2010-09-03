package it.polito.lt.twyncat;

import java.util.LinkedList;

public class Function {
	String name;
	Type output;
	LinkedList<Type> args = null;
	
	public Function (String n) {
		name = n;
		args = new LinkedList<Type>();
	}
	
	public void addArg(Type t) {
		args.add(t);
	}
	
	public void setOut(Type t) {
		output = t;
	}
}
