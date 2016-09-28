/**
 * 
 */
package com.evan.parser.js.parser.exp;

import java.util.List;

/**
 * @author evan
 *
 */
public class ExpListExp extends Exp {

	List<Exp> expList;

	public ExpListExp add(Exp e) {
		expList.add(e);

		return this;
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
