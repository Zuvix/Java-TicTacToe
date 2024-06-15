package st.tiy;

import st.tiy.game.Board;
import st.tiy.game.Game;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		Game game = new Game(board);
		game.startGame();

	}

}