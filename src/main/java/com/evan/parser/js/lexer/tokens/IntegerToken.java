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
	public long getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(long value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IntegerToken [getValue()=" + getValue() + ", getType()=" + getType() + ", getStartPosition()=" + getStartPosition() + "]";
	}

}
