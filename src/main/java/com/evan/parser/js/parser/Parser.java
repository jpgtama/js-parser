/**
 * 
 */
package com.evan.parser.js.parser;

import java.util.List;

import com.evan.parser.js.lexer.tokens.Token;
import com.evan.parser.js.parser.exp.Exp;

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
		return null;
	}
}
