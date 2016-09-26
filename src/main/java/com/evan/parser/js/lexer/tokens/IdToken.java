/**
 * 
 */
package com.evan.parser.js.lexer.tokens;

/**
 * @author evan
 *
 */
public class IdToken extends Token {

	private String value;

	/**
	 * @param type
	 * @param value
	 * @param startPosition
	 */
	public IdToken(String value, Integer startPosition) {
		super(TokenTypeEnum.ID, startPosition);
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

}
