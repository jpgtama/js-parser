/**
 * 
 */
package com.evan.parser.js.parser;

import java.util.ArrayList;
import java.util.List;

import com.evan.parser.js.lexer.tokens.FloatToken;
import com.evan.parser.js.lexer.tokens.IdToken;
import com.evan.parser.js.lexer.tokens.IntegerToken;
import com.evan.parser.js.lexer.tokens.StringToken;
import com.evan.parser.js.lexer.tokens.SymbolToken;
import com.evan.parser.js.lexer.tokens.Token;
import com.evan.parser.js.lexer.tokens.TokenTypeEnum;
import com.evan.parser.js.parser.exp.Exp;
import com.evan.parser.js.parser.exp.FunctionExp;
import com.evan.parser.js.parser.exp.IdExp;
import com.evan.parser.js.parser.exp.NumberExp;
import com.evan.parser.js.parser.exp.StringExp;

/**
 * @author evan
 *
 */
public class Parser {

	// //////////////////////////////////////////////////////////////////////////////////////////////
	// syntax:
	// term = <string> | <number> | <id> | '(' valueExp ')' | function
	//
	// function = <id> ( '()' | ( '(' paramlist ')' ) )
	//
	// paramlist = valueExp (',' valueExp )*
	//
	// factor = term (('*' | '/') term)*
	//
	// valueExp = factor (('+' | '-') factor)*
	//
	// assignExp = <id> '=' valueExp
	//
	// exp = valueExp | assignExp
	//
	// expList = exp*
	//
	public static Exp parse(List<Token> tokenList) {
		Tokens tokens = new Tokens(tokenList);

		// TODO
		return getExpList(tokens);
	}

	private StringExp getStringExp(Tokens tokens) {
		Token t = tokens.current();

		if (t != null && t.getType() == TokenTypeEnum.STRING) {
			String value = ((StringToken) t).getValue();
			tokens.forward();

			return new StringExp(value);
		} else {
			return null;
		}
	}

	private NumberExp getNumberExp(Tokens tokens) {
		Token t = tokens.current();

		if (t != null) {

			if (t.getType() == TokenTypeEnum.INTEGER) {
				long value = ((IntegerToken) t).getValue();
				tokens.forward();
				return new NumberExp<Long>(value);
			} else if (t.getType() == TokenTypeEnum.FLOAT) {

				double value = ((FloatToken) t).getValue();
				tokens.forward();
				return new NumberExp<Double>(value);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	private IdExp getIdExp(Tokens tokens) {
		Token t = tokens.current();
		if (t != null && t.getType() == TokenTypeEnum.ID) {
			String value = ((IdToken) t).getValue();
			tokens.forward();

			return new IdExp(value);
		} else {
			return null;
		}

	}

	private FunctionExp getFunctionExp(Tokens tokens) {
		// function = <id> ( '()' | ( '(' paramlist ')' ) )
		IdExp id = getIdExp(tokens);

		if (id != null) {
			Token lb = tokens.current();

			if (lb != null && lb instanceof SymbolToken && ((SymbolToken) lb).getValue() == '(') {
				tokens.forward();

				Token rb = tokens.next();
				if (rb != null && rb instanceof SymbolToken && ((SymbolToken) rb).getValue() == ')') {
					// no param
					tokens.forward();
					return new FunctionExp(id.getValue());
				} else {
					List<Exp> paramlist = getParamList(tokens);

					if (paramlist != null && paramlist.size() > 0) {
						rb = tokens.next();
						if (rb != null && rb instanceof SymbolToken && ((SymbolToken) rb).getValue() == ')') {
							tokens.forward();
							return new FunctionExp(id.getValue(), paramlist);
						} else {
							throw new RuntimeException("no ')' after param list of function: " + id.getValue());
						}
					} else {
						throw new RuntimeException("no param list for function: " + id.getValue());
					}

				}

			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	private List<Exp> getParamList(Tokens tokens) {
		// paramlist = exp (',' exp )*
		Exp exp = getValueExp(tokens);

		if (exp != null) {
			List<Exp> paramlist = new ArrayList<Exp>();
			paramlist.add(exp);

			while (tokens.hasNext()) {
				Token cm = tokens.current();

				if (cm instanceof SymbolToken && ((SymbolToken) cm).getValue() == ',') {
					tokens.forward();
					Exp nextExp = getValueExp(tokens);

					if (nextExp != null) {
						paramlist.add(nextExp);
					} else {
						throw new RuntimeException("no exp after ','");
					}

				} else {
					break;
				}

			}

			return paramlist;
		} else {
			return null;
		}
	}

	private Exp getTerm(Tokens tokens) {
		// Term = <string> | <数字> | Function | <变量> | “(”Exp”)”

		StringExp string = getStringExp(tokens);

		if (string != null) {
			return string;
		}

		NumberExp number = getNumberExp(tokens);

		if (number != null) {
			return number;
		}

		FunctionExp function = getFunctionExp(tokens);
		if (function != null) {
			return function;
		}

		IdExp id = getIdExp(tokens);

		if (id != null) {

			Token next = tokens.current();

			if (next != null && next instanceof SymbolToken && (((SymbolToken) next).getValue() == '(' || ((SymbolToken) next).getValue() == '=')) {
				// do nothing
				tokens.back();
			} else {
				return id;
			}
		}

		Token t = tokens.current();

		if (t != null && t instanceof SymbolToken && ((SymbolToken) t).getValue() == '(') {
			tokens.forward();

			Exp exp = getValueExp(tokens);

			t = tokens.current();

			if (t != null && t instanceof SymbolToken && ((SymbolToken) t).getValue() == ')') {
				tokens.forward();
				return exp;
			} else {
				throw new RuntimeException("need ')' here");
			}

		}

		return null;

	}

	private Exp getValueExp(Tokens tokens) {
		return null;
	}

	private static Exp getExpList(Tokens tokens) {

		return null;
	}

}
