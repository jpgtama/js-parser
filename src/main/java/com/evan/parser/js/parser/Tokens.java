/**
 * 
 */
package com.evan.parser.js.parser;

import java.util.List;

import com.evan.parser.js.lexer.tokens.Token;

/**
 * @author evan
 *
 */
public class Tokens {

	private List<Token> tokenList;

	private int index;

	/**
	 * @param tokenList
	 */
	public Tokens(List<Token> tokenList) {
		super();
		this.tokenList = tokenList;
	}

	public boolean hasNext() {
		return this.index < this.tokenList.size();
	}

	public Token current() {
		return this.tokenList.get(this.index);
	}

	public Token next() {
		return next(null);
	}

	public Token next(Integer n) {
		n = n == null ? 1 : Math.max(n, 1);

		return this.tokenList.get(index + n);
	}

	public Tokens forward(Integer n) {
		n = n != null ? Math.max(n, 1) : 1;
		this.index += n;

		return this;
	}

	public Tokens forward() {
		return forward(null);
	}

	public Tokens back() {
		return back(null);
	}

	public Tokens back(Integer n) {
		n = n != null ? Math.max(n, 1) : 1;
		this.index -= n;

		return this;
	}

	public int length() {
		return this.tokenList.size();
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

}
