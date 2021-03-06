/**
 * 
 */
package com.evan.parser.js.parser.exp;

import java.util.ArrayList;
import java.util.List;

import com.evan.parser.js.parser.Result;

/**
 * @author evan
 *
 */
public class ExpListExp extends Exp {

	List<Exp> expList = new ArrayList<Exp>();

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

		if (expList.size() > 0) {
			StringBuffer sb = new StringBuffer();

			for (Exp e : expList) {
				sb.append(e.toString());
				sb.append(' ');
			}

			sb.deleteCharAt(sb.length() - 1);

			return String.format("(expList %s)", sb.toString());

		} else {
			return "(expList )";
		}

	}

}
