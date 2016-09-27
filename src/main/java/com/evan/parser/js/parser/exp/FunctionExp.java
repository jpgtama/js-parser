/**
 * 
 */
package com.evan.parser.js.parser.exp;

import java.util.List;

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
	public Object interpret() {
		// TODO Auto-generated method stub
		return null;
	}

}
