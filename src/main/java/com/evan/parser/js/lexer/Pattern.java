/**
 * 
 */
package com.evan.parser.js.lexer;

/**
 * @author evan
 *
 */
public class Pattern {

	public static boolean matches(String regex, String c) {
		return java.util.regex.Pattern.matches(regex, c);
	}

	public static boolean matches(String regex, char c) {
		return java.util.regex.Pattern.matches(regex, String.valueOf(c));
	}

	public static boolean test(String regex, String c) {
		return java.util.regex.Pattern.matches(regex, c);
	}

	public static boolean test(String regex, char c) {
		return java.util.regex.Pattern.matches(regex, String.valueOf(c));
	}

}
