/**
 * 
 */
package com.evan.parser.js.lexer;

import java.io.BufferedInputStream;
import java.io.IOException;

import com.evan.parser.js.lexer.tokens.Token;

/**
 * @author evan
 *
 */
public class LexerTest {

	static int LF = 10;

	public static void main(String[] args) throws IOException {
		// input from console
		BufferedInputStream bis = new BufferedInputStream(System.in);

		char[] charArray = new char[1024 * 2];
		int index = 0;

		while (true) {
			int b = bis.read();

			if (b == LF) {
				if (index > 0) {

					if (charArray.length == 4 && "exit".equals(String.valueOf(charArray))) {
						break;
					}

					try {

						// convert to array
						char[] dest = new char[index];
						System.arraycopy(charArray, 0, dest, 0, index);
						index = 0;

						for (Token t : Lexer.lex(dest)) {
							System.out.println(t);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					// do nothing
				}
			} else {
				charArray[index++] = (char) b;
			}

		}

	}
}
