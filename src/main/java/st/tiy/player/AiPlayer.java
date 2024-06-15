package st.tiy.player;

import st.tiy.game.Board;
import st.tiy.game.Coordinates;
import st.tiy.game.Sign;

public class AiPlayer extends Player {

	public AiPlayer(String name, Sign sign, Board board) {
		super(name, sign, board);
	}

	@Override
	public Coordinates takeTurn() {
		// TODO do AI magic (take random empty)
		return null;
	}
}
