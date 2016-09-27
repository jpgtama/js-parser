/**
 * 
 */
package com.evan.parser.js.parser.exp;

/**
 * @author evan
 *
 */
public class NumberExp<T extends Number> extends Exp {

	private T value;

	/**
	 * @param value
	 */
	public NumberExp(T value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evan.parser.js.parser.exp.Exp#interpret()
	 */
	@Override
	public T interpret() {
		// TODO Auto-generated method stub
		return null;
	}

}
