/**
 * 
 */
package com.evan.parser.js.lexer;


/**
 * @author evan
 *
 */
public class Input {

	private int index;

	private char[] charArray;

	/**
	 * @param str
	 */
	public Input(char[] charList) {
		super();
		this.charArray = charList;
	}

	public boolean hasNext() {

		return this.index < this.charArray.length;

	}

	public char current() {
		return this.charArray[this.index];
	}

	public char next() {
		return next(null);
	}

	public char next(Integer n) {
		n = n != null ? Math.max(n, 1) : 1;
		return this.charArray[this.index + n];
	}

	public Input forward(Integer n) {
		n = n != null ? Math.max(n, 1) : 1;
		this.index += n;

		return this;
	}

	public Input forward() {
		return forward(null);
	}

	public int length() {
		return this.charArray.length;
	}

	public char[] getValue(int start, int end) {
		char[] result = new char[end - start];

		System.arraycopy(this.charArray, start, result, 0, end - start);
		// return this.charList.substring(start, end);
		return result;
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
