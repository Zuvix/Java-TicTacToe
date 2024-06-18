package st.tiy;

import st.tiy.game.Board;
import st.tiy.game.Game;
import st.tiy.game.GameResult;
import st.tiy.game.ScoringManager;

public class Main {

	private static final int BOARD_SIZE =5;
	private static final int REQUIRED_SCORE_LENGTH =4;

	public static void main(String[] args) {
		Board board = new Board(BOARD_SIZE);
		ScoringManager scoringManager = new ScoringManager(board,REQUIRED_SCORE_LENGTH);
		Game game = new Game(board,scoringManager);
		GameResult result= game.startGame();

		//Lazy game over
		System.out.print("Victory for: " + result);

	}

}