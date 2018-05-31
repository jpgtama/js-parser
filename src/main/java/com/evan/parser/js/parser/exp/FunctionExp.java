/**
 * 
 */
package com.evan.parser.js.parser.exp;

import java.util.List;

import com.evan.parser.js.parser.Result;

/**
 * @author evan
 *
 */
public class FunctionExp extends Exp {

	private String name;

	private List<Exp> paramlist;

	/**
	 * 
	 */
	public FunctionExp(String name) {
		this.name = name;
	}

	public FunctionExp(String name, List<Exp> paramlist) {
		this.name = name;
		this.paramlist = paramlist;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evan.parser.js.parser.exp.Exp#interpret()
	 */
	@Override
	public Result interpret() {
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

		StringBuffer sb = new StringBuffer();

		for (Exp e : paramlist) {
			sb.append(e.toString());
			sb.append(' ');
		}

		sb.deleteCharAt(sb.length() - 1);

		return String.format("(%s %s)", name, sb.toString());
	}

}
