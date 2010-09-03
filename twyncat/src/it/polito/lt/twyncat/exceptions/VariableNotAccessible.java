package it.polito.lt.twyncat.exceptions;

public class VariableNotAccessible extends Exception {
	private static final long serialVersionUID = 8130487429056871077L;
	String message;
	
	public VariableNotAccessible() {
		message = "Unknown";
	}
	
	public VariableNotAccessible(String name) {
		message = name;
	}

	public String getMessage() {
		return "Variable named '" + message + "' not accessible.";
	}

}
