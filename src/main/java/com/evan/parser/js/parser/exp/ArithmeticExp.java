/**
 * 
 */
package com.evan.parser.js.parser.exp;

/**
 * @author evan
 *
 */
public class ArithmeticExp extends Exp {

	String op;

	Exp left;
	Exp right;

	/**
	 * @param op
	 * @param left
	 * @param right
	 */
	public ArithmeticExp(String op, Exp left, Exp right) {
		super();
		this.op = op;
		this.left = left;
		this.right = right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evan.parser.js.parser.exp.Exp#interpret()
	 */
	@Override
	public Object interpret() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("(%s %s %s)", op, left.toString(), right.toString());
	}

}
