package st.tiy.player;

import st.tiy.game.Board;
import st.tiy.game.Coordinates;
import st.tiy.game.Sign;

public abstract class Player {

	protected String name;
	protected Sign sign;
	protected Board board;

	public Player(String name, Sign sign, Board board) {
		this.name = name;
		this.sign = sign;
		this.board = board;
	}

	public abstract Coordinates takeTurn();

	public String getName() {
		return name;
	}

	public Sign getSign() {
		return sign;
	}

}
