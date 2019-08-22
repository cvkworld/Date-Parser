
public class Parser {

	/**
	 * The tokenizer used to split the input in understandable Tokens.
	 * 
	 * 
	 */
	public Tokenizer tokenizer;

	/**
	 * The current Token being parsed.
	 */
	private Token token;

	public Parser(String input) {
		tokenizer = new Tokenizer(input);
	}

	/**
	 * Starts the parse of the input string. Registers matched Dates using the
	 * Dates class.
	 * 
	 */
	public void parse() {
		// Loop through all Tokens the Tokenizer delivers as long as it is not
		// matching the end of the input.
		while ((token = tokenizer.tokenize()).type != TokenType.EOF)
			switch (token.type) {
			case INTEGER:
				checkIntDate();
				break;
			case MONTH:
				checkMonthDate();
				break;
			case WORD:
			default:
				break;
			}
	}

	/**
	 * Checks if the matched Integer is not leading to a comprehensive date
	 * format.
	 * 
	 * Matches INT INT INT as (YYYY MM DD) and INT MONTH INT as (DD MM YYYY).
	 */
	private void checkIntDate() {
		Token first = token;

		int day, month, year;
		
		token = tokenizer.tokenize();

		switch (token.type) {
		case INTEGER: 
			year = Integer.parseInt(first.text);
			month = Integer.parseInt(token.text);
			
			// Retrieve last token
			token = tokenizer.tokenize();
			
			// If it isn't an Integer, you cannot match anything anymore.
			if (token.type == TokenType.INTEGER) {
				day = Integer.parseInt(token.text);
				Dates.addDate(year, month, day);
			}

			break;
		case MONTH: // INT MONTH INT ?
			day = Integer.parseInt(first.text);
			month = Integer.parseInt(token.text);

			token = tokenizer.tokenize();
			
			// If it isn't an Integer, you cannot match anything anymore.
			if (token.type == TokenType.INTEGER) {
				year = Integer.parseInt(token.text);
				Dates.addDate(year, month, day);
			}

			break;
		default:
			break;
		}

	}
	
	/**
	 * Checks whether the matched Token leads to a comprehensive Date format starting with the Month.
	 * 
	 * Matches MONTH INT INT as (MM DD YYYY).
	 */
	private void checkMonthDate() {
		int month = Integer.parseInt(token.text), day, year;

		if ((token = tokenizer.tokenize()).type == TokenType.INTEGER)
			day = Integer.parseInt(token.text);
		else // If we didn't match an Integer it cannot be a Date, skip.
			return;

		if ((token = tokenizer.tokenize()).type == TokenType.INTEGER)
			year = Integer.parseInt(token.text);
		else // If we didn't match an Integer it cannot be a Date, skip.
			return;

		Dates.addDate(year, month, day);
	}

}
