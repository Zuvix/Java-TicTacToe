package st.tiy.game;

import st.tiy.player.AiPlayer;
import st.tiy.player.HumanPlayer;
import st.tiy.player.Player;

import java.util.stream.Stream;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	ScoringManager scoringManager;

	public Game(Board board,ScoringManager scoringManager) {
		this.board = board;
		this.player1 = new HumanPlayer("1", Sign.X, board);
		this.player2 = new HumanPlayer("2", Sign.O, board);
		this.scoringManager = scoringManager;
	}

	public GameResult startGame() {
		Player activePlayer = this.player1;
		GameResult result = GameResult.UNFINISHED;
		do {
			activePlayer = activePlayer == player1 ? player2 : player1;
			this.board.printBoard();
			Coordinates placedSign = activePlayer.takeTurn();
			//Early return if any player win
			if(scoringManager.checkWinningPlay(placedSign)) return activePlayer == player1 ? GameResult.Player1 : GameResult.Player2;
			if(scoringManager.checkTie()) result = GameResult.TIE;
			
		} while (result == GameResult.UNFINISHED);
		return result;
	}

}
