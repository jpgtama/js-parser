/**
 * 
 */
package com.evan.parser.js.lexer.tokens;

/**
 * @author evan
 *
 */
public abstract class Token {

	private TokenTypeEnum type;

	private Integer startPosition;

	/**
	 * 
	 */
	public Token() {
	}

	/**
	 * @param type
	 * @param value
	 * @param startPosition
	 */
	public Token(TokenTypeEnum type, Integer startPosition) {
		this.type = type;
		this.startPosition = startPosition;
	}

	/**
	 * @return the type
	 */
	public TokenTypeEnum getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TokenTypeEnum type) {
		this.type = type;
	}

	/**
	 * @return the startPosition
	 */
	public Integer getStartPosition() {
		return startPosition;
	}

	/**
	 * @param startPosition
	 *            the startPosition to set
	 */
	public void setStartPosition(Integer startPosition) {
		this.startPosition = startPosition;
	}

}
