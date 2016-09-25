/**
 * 
 */
package com.evan.parser.js.lexer.tokens;

/**
 * @author evan
 *
 */
public class StringToken extends Token {

	private String value;

	/**
	 * @param type
	 * @param value
	 * @param startPosition
	 */
	public StringToken(String value, Integer startPosition) {
		super(TokenTypeEnum.STRING, startPosition);
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StringToken [getValue()=" + getValue() + ", getType()=" + getType() + ", getStartPosition()=" + getStartPosition() + "]";
	}

}
