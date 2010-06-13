package it.polito.lt.twyncat;

import java.util.HashMap;

public interface Component {
	
	String getName();
	Component getType();
	HashMap<String, Field> getFields();
	
}
