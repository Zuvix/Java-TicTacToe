package st.tiy.game;

import st.tiy.player.AiPlayer;
import st.tiy.player.HumanPlayer;
import st.tiy.player.Player;

import java.util.stream.Stream;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;

	private boolean isTie;

	public Game(Board board) {
		this.board = board;
		this.player1 = new HumanPlayer("1", Sign.X, board);
		this.player2 = new AiPlayer("2", Sign.O, board);
	}

	public void startGame() {
		this.isTie = false;
		Player activePlayer = this.player1;
		do {
			activePlayer = activePlayer == player1 ? player2 : player1;

			this.board.printBoard();
			Coordinates coordinates = activePlayer.takeTurn();
			this.board.putSign(activePlayer.getSign(), coordinates);
		} while (!isGameEnded());

		String gameEndMessage = this.isTie
				? "Game over, ended in tie"
				: "Game over, winner is: " + activePlayer.getName();

		System.out.println(gameEndMessage);
	}

	public void resetGame() {

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
			this.isTie = true;
			return true;
		}
		return false;
	}

	private Player findWinner(Sign sign) {

		return null;
	}
}
