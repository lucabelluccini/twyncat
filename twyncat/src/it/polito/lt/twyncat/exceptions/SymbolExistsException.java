package it.polito.lt.twyncat.exceptions;

public class SymbolExistsException extends Exception {
	private static final long serialVersionUID = 5107917187039664868L;
	String message;
	
	public SymbolExistsException() {
		message = "Unknown";
	}
	
	public SymbolExistsException(String name) {
		message = name;
	}
	
	public String getMessage() {
		return "Symbol named '" + message + "' already exists!";
	}
	
}
