package st.tiy.game;

import st.tiy.player.AiPlayer;
import st.tiy.player.HumanPlayer;
import st.tiy.player.Player;

import java.util.stream.Stream;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;


	public Game(Board board) {
		this.board = board;
		this.player1 = new HumanPlayer("1", Sign.X, board);
		this.player2 = new AiPlayer("2", Sign.O, board);
	}

	public void startGame() {
		Player activePlayer = this.player1;
		do {
			activePlayer = activePlayer == player1 ? player2 : player1;
			this.board.printBoard();
			activePlayer.takeTurn();
		} while (!isGameEnded());

	}


	private boolean isGameEnded() {
		Sign[][] brd = this.board.getBoard();

		//Left diagonal
		if (brd[0][0] != Sign.EMPTY &&
				brd[0][0] == brd[1][1] &&
				brd[0][0] == brd[2][2]) {
			return true;
		}
		// TODO dorobit zvysne checky (right diagonal, rows, columns)

		//Is board full, with no winner
		if (Stream.of(brd).flatMap(Stream::of).noneMatch(sign -> sign.equals(Sign.EMPTY))) {
			return true;
		}
		return false;
	}

	private Player findWinner(Sign sign) {

		return null;
	}
}
