package st.tiy.game;

public enum Sign {
	X('X'),
	O('O'),
	EMPTY('-');

	public final char sign;

	Sign(char sign) {
		this.sign = sign;
	}
}
