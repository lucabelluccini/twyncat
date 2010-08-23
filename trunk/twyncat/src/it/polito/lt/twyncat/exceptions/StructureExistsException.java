package it.polito.lt.twyncat.exceptions;

public class StructureExistsException extends Exception{
	private static final long serialVersionUID = 2140719441732286784L;
	String message;
	
	public StructureExistsException() {
		message = "Unknown";
	}
	
	public StructureExistsException(String name) {
		message = name;
	}

	public String getMessage() {
		return "Structure named '" + message + "' already exists!";
	}
	
}
