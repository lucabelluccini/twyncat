package it.polito.lt.twyncat.exceptions;

public class FieldExistsException extends Exception {
	private static final long serialVersionUID = -7336621687996116991L;
	String message;
	
	public FieldExistsException() {
		message = "Unknown";
	}
	
	public FieldExistsException(String string) {
		message = string;
	}
	
	public String getMessage() {
		return "Field '" + message + "' already exists!";
	}
	
}
