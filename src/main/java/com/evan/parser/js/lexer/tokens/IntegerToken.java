/**
 * 
 */
package com.evan.parser.js.lexer.tokens;

/**
 * @author evan
 *
 */
public class IntegerToken extends Token {

	private long value;

	public IntegerToken(Long value, Integer startPosition) {
		super(TokenTypeEnum.INTEGER, startPosition);
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public Long getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(long value) {
		this.value = value;
	}

}
