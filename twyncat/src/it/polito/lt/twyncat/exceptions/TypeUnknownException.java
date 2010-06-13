package it.polito.lt.twyncat.exceptions;

public class TypeUnknownException extends Exception {
	private static final long serialVersionUID = 3294897894628332119L;
	String message;
	
	public TypeUnknownException() {
		message = "Unknown";
	}
	
	public TypeUnknownException(String name) {
		message = name;
	}
	
	public String getMessage() {
		return "Type named '" + message + "' unknown!";
	}
	
}
