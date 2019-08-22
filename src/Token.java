
public class Token {

	/**
	 * The type of data the Token holds.
	 * 
	 */
	public final TokenType type;

	/**
	 * The text representation of the data held by the token. 
	 */
	public final String text;

	public Token(Object obj, TokenType type) {
		text = obj.toString();
		this.type = type;
	}

	public String toString() {
		return "<" + type.name() + ": " + text + ">";
	}

}