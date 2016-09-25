/**
 * 
 */
package com.evan.parser.js.lexer.tokens;

/**
 * @author evan
 *
 */
public class FloatToken extends Token {

	private double value;

	public FloatToken(Double value, Integer startPosition) {
		super(TokenTypeEnum.FLOAT, startPosition);
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FloatToken [getValue()=" + getValue() + ", getType()=" + getType() + ", getStartPosition()=" + getStartPosition() + "]";
	}

}
