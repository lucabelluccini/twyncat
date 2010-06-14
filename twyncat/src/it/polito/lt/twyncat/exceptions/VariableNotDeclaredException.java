package it.polito.lt.twyncat.exceptions;

public class VariableNotDeclaredException extends Exception {
	private static final long serialVersionUID = 8130487429056871077L;
	String message;
	
	public VariableNotDeclaredException() {
		message = "Unknown";
	}
	
	public VariableNotDeclaredException(String name) {
		message = name;
	}

	public String getMessage() {
		return "Variable named '" + message + "' not declared!";
	}

}
