package it.polito.lt.twyncat.exceptions;

public class UnknownTypeException extends Exception {
	private static final long serialVersionUID = 5946852220224600322L;
	String message;
	
	public UnknownTypeException() {
		message = "Unknown";
	}
	
	public UnknownTypeException(String name) {
		message = name;
	}
	
	public String getMessage() {
		return "Type named '" + message + "' unknown!";
	}

}
