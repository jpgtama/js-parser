/**
 * 
 */
package com.evan.parser.js.lexer.tokens;

/**
 * @author evan
 *
 */
public class SymbolToken extends Token {

	private char value;

	public SymbolToken(char value, Integer startPosition) {
		super(TokenTypeEnum.SYMBOL, startPosition);
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public char getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(char value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SymbolToken [value=" + value + ", getValue()=" + getValue() + ", getType()=" + getType() + ", getStartPosition()=" + getStartPosition() + "]";
	}

}
