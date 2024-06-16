package st.tiy.game;

import java.util.Arrays;

public class Board {

	public static final int BOARD_SIZE = 3;
	private final Sign[][] board;

	public Board() {
		this.board = initializeBoard();
	}

	private Sign[][] initializeBoard() {
		Sign[][] board = new Sign[BOARD_SIZE][BOARD_SIZE];
		Arrays.stream(board).forEach(row -> Arrays.fill(row, Sign.EMPTY));

		return board;
	}

	public Sign[][] resetBoard() {
		initializeBoard();

		return this.board;
	}

	public boolean putSign(Sign sign, Coordinates coordinates) {
		//Early exit check
		if(!placementAllowed(coordinates) || !placementEmpty(coordinates)) return false;
		this.board[coordinates.x][coordinates.y] = sign;
		return true;
	}
	private boolean placementEmpty(Coordinates coordinates)
	{
		return board[coordinates.x][coordinates.y] == Sign.EMPTY;
	}
	private boolean placementAllowed(Coordinates coordinates)
	{
        return coordinates.x >= 0 && coordinates.y >= 0 && coordinates.x < BOARD_SIZE && coordinates.y < BOARD_SIZE;
    }

	public void printBoard() {
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				System.out.print(this.board[i][j].sign + " ");
			}
			System.out.println();
		}
	}

	public Sign[][] getBoard() {
		return board;
	}

}
