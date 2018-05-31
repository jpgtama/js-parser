package com.evan.parser.js.parser;

/**
 * Result of exp
 * @author evan
 *
 */
public class Result {

	private Class typeClass;
	
	
	private Object value;


	/**
	 * @return the typeClass
	 */
	public Class getTypeClass() {
		return typeClass;
	}


	/**
	 * @param typeClass the typeClass to set
	 */
	public void setTypeClass(Class typeClass) {
		this.typeClass = typeClass;
	}


	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
}
