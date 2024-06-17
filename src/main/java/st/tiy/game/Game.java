package st.tiy.game;

import st.tiy.player.AiPlayer;
import st.tiy.player.HumanPlayer;
import st.tiy.player.Player;

import java.util.stream.Stream;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	private ScoringHelper scoringHelper;
	public Game(Board board) {
		this.board = board;
		this.player1 = new HumanPlayer("1", Sign.X, board);
		this.player2 = new AiPlayer("2", Sign.O, board);
		scoringHelper = new ScoringHelper()
	}

	public void startGame() {
		Player activePlayer = this.player1;
		do {
			activePlayer = activePlayer == player1 ? player2 : player1;
			this.board.printBoard();
			Coordinates placedSign = activePlayer.takeTurn();
			this.boardSize++;
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
	private boolean resolveTurnScoring(Coordinates coordinates)
	{
		Sign[][] brd = this.board.getBoard();
		Sign selecetdSign = brd[coordinates.x][coordinates.y];
		Direction positive = Direction.UP;
		Direction negative = Direction.DOWN;

	}
	private Player findWinner(Sign sign) {

		return null;
	}
}
