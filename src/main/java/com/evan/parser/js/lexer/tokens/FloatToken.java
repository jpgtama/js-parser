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
	public Double getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

}
