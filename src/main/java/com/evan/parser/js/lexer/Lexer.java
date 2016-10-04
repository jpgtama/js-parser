package com.evan.parser.js.lexer;

import java.util.ArrayList;
import java.util.List;

import com.evan.parser.js.lexer.tokens.FloatToken;
import com.evan.parser.js.lexer.tokens.IdToken;
import com.evan.parser.js.lexer.tokens.IntegerToken;
import com.evan.parser.js.lexer.tokens.StringToken;
import com.evan.parser.js.lexer.tokens.SymbolToken;
import com.evan.parser.js.lexer.tokens.Token;

/**
 * 
 */

/**
 * @author evan
 *
 */
public class Lexer {

	public static List<Token> lex(char[] charArray) {

		if (charArray == null || charArray.length == 0) {
			throw new IllegalArgumentException("null parameter");
		}

		Input input = new Input(charArray);

		List<Token> tokens = new ArrayList<Token>();

		// parse
		while (input.hasNext()) {
			Token t = null;
			if ((t = getSymbolToken(input)) != null || (t = getIdToken(input)) != null || (t = getNumberToken(input)) != null
					|| (t = getStringToken(input)) != null) {
				tokens.add(t);
			} else if ((t = getSpaceToken(input)) != null) {
				// ignore space
			} else {
				throw new RuntimeException("Invalid character at " + input.getIndex() + ": " + input.current());
			}
		}

		return tokens;

	}

	private static StringToken getSpaceToken(Input input) {

		int index = input.getIndex();

		int state = 0;

		while (input.hasNext()) {
			char c = input.current();

			if (state == 0 && c == ' ') {
				state = 1;
			} else if (state == 1 && c == ' ') {
				state = 1;
			} else {
				break;
			}

			input.forward();
		}

		if (state == 1) {
			StringToken t = new StringToken(String.valueOf(input.getValue(index, input.getIndex())), index);
			return t;
		} else {
			return null;
		}

	}

	private static Token getSymbolToken(Input input) {
		char c = input.current();

		// special handle for '-' and negative number
//		if (c == '-' && input.hasNext() && Pattern.test("[0-9]", input.next())) {
//			return null;
//		} else

		if ("+-*/(),=[].{}:".contains(String.valueOf(c))) {
			Token token = new SymbolToken(c, input.getIndex());
			input.forward();
			return token;
		} else {
			return null;
		}

	}

	private static Token getIdToken(Input input) {
		// hold start index
		int index = input.getIndex();

		int state = 0;
		while (input.hasNext()) {
			char c = input.current();

			if (state == 0 && Pattern.matches("[a-zA-Z]", c)) {
				state = 1;
			} else if (state == 1 && Pattern.matches("[a-zA-Z0-9_]", c)) {
				state = 1;
			} else {
				break;
			}

			input.forward();
		}

		// check state
		if (state == 1) {
			// success
			String value = String.valueOf(input.getValue(index, input.getIndex()));
			IdToken token = new IdToken(value, index);
			return token;
		} else {
			return null;
		}
	}

	private static Token getNumberToken(Input input) {
		//
		int index = input.getIndex();

		int state = 0;
		while (input.hasNext()) {
			char c = input.current();

			if (state == 0 && Pattern.test("[0-9]", c)) {
				state = 1;
			} else if (state == 1 && Pattern.test("[0-9]", c)) {
				state = 1;
			} else if (state == 1 && Pattern.test("[\\.]", c)) {
				state = 2;
			} else if (state == 2 && Pattern.test("[0-9]", c)) {
				state = 2;
			} else {
				break;
			}

			input.forward();
		}

		// check state
		if (state == 1) {
			// no decimal
			String value = String.valueOf(input.getValue(index, input.getIndex()));
			long numValue = Long.valueOf(value);

			IntegerToken token = new IntegerToken(numValue, index);
			return token;
		} else if (state == 2) {
			// has decimal
			String value = String.valueOf(input.getValue(index, input.getIndex()));
			double numValue = Double.valueOf(value);

			FloatToken token = new FloatToken(numValue, index);
			return token;
		} else {
			return null;
		}
	}

	private static Token getStringToken(Input input) {
		//
		int startPosition = input.getIndex();

		StringBuffer sb = new StringBuffer();

		int state = 0;
		while (input.hasNext()) {
			char c = input.current();

			if ((state == 1 || state == 2) && c == '\\') {
				// handle escape
				input.forward();
				c = input.current();
				sb.append(c);
			} else if (state == 0 && c == '\'') {
				state = 1;
			} else if (state == 1 && c != '\'') {
				state = 1;
				sb.append(c);
			} else if (state == 1 && c == '\'') {
				state = 3;
			} else if (state == 0 && c == '"') {
				state = 2;
			} else if (state == 2 && c != '"') {
				state = 2;
				sb.append(c);
			} else if (state == 2 && c == '"') {
				state = 4;
			} else {
				break;
			}

			input.forward();
		}

		// check state
		if (state == 3 || state == 4) {
			// success
			String value = sb.toString();
			StringToken token = new StringToken(value, startPosition);
			return token;
		} else if (state == 1) {
			throw new RuntimeException("no end \' for string");
		} else if (state == 2) {
			throw new RuntimeException("no end \" for string");
		} else {
			return null;
		}
	}
}
