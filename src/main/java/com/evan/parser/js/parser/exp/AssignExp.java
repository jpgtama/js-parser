/**
 * 
 */
package com.evan.parser.js.parser.exp;

/**
 * @author evan
 *
 */
public class AssignExp extends Exp {

	String name;

	Exp valueExp;

	/**
	 * @param name
	 * @param valueExp
	 */
	public AssignExp(String name, Exp valueExp) {
		super();
		this.name = name;
		this.valueExp = valueExp;
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
		return String.format("(= %s %s)", name, valueExp.toString());
	}

}
