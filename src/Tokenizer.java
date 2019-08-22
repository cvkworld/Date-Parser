/**
 * 
 * @author chandraveer kunwar
 *
 */
public class Tokenizer {

	/**
	 * The input String.
	 */
	private String input;

	/**
	 * The current position of the Tokenizer in the Input.
	 */
	private int pos;

	/**
	 * The current character being processed.
	 */
	private char ch;

	/**
	 * Determines whether we reached the end of the input.
	 */
	private boolean eof = false;

	public Tokenizer(String input) {
		this.input = input;
		pos = 0;
	}

	/**
	 * Advances in the input.
	 * 
	 * @return Whether we reached the end of the input or not.
	 */
	private boolean next() {
		if (pos >= input.length()) {
			eof = true;
			return false;
		}

		ch = input.charAt(pos++);
		return true;
	}

	/**
	 * Processes a complete tokenizing cycle.
	 * 
	 * @return the next Token found in the input, type is set to EOF if the
	 *         input has been totally processed.
	 */
	public Token tokenize() {
		// It's interesting to place the "eof" condition first, otherwise the
		// call
		// to next is wasted and will just loop over a cycle again.
		if (eof || !next())
			return new Token("", TokenType.EOF);

		// If matches a digit, the parse the next integer.
		if (Character.isDigit(ch))
			return integer();

		// Match any kind of word.
		if (Character.isAlphabetic(ch))
			return word();

		
		// Cycle through the input again to retrieve the next interesting Token
		return tokenize();
	}

	/**
	 * Tries to match the longest integer in the input.
	 * 
	 * @return the wrapping Token for the integer
	 */
	private Token integer() {
		String num = "";

		// Loop as long as we match a digit
		while (Character.isDigit(ch)) {
			num += ch;

			// If we reach the end of the Input prematurely return anyways
			if (!next())
				return new Token(num, TokenType.INTEGER);
		}
		return new Token(num, TokenType.INTEGER);
	}

	private Token word() {
		String word = "";

		// Loop as long as we match a letter, no matter the case.
		while (Character.isAlphabetic(ch)) {
			word += ch;
			if (!next())
				break;
		}

		// It's interesting and efficient to determine whether the matched word
		// is a Month or not. If it is, then replace the Month name by its
		// number.
		int m = 1;
		
		
		for (String pattern : Month.monthPatterns) {
			if (word.matches(pattern)) // If the input matches, then return a Month token.
				return new Token(m, TokenType.MONTH);
			m++;
		}
		
		// return a Word otherwise.
		return new Token(word, TokenType.WORD);
	}

}
