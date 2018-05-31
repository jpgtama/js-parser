/**
 * 
 */
package com.evan.parser.js.parser.exp;

import com.evan.parser.js.parser.Result;

/**
 * @author evan
 *
 */
public class StringExp extends Exp {

	private String value;

	/**
	 * @param value
	 */
	public StringExp(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evan.parser.js.parser.exp.Exp#interpret()
	 */
	@Override
	public Result interpret() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s", value);
	}
}
