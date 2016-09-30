/**
 * 
 */
package com.evan.parser.js.parser.exp;

/**
 * @author evan
 *
 */
public class IdExp extends Exp {

	private String value;

	/**
	 * @param value
	 */
	public IdExp(String value) {
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
	public Object interpret() {
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
