package st.tiy.game;

import java.util.Arrays;

public class Board {

	private int boardSize;
	private final Sign[][] board;

	public Board(int boardSize, int winningLength) {
		this.board = initializeBoard(boardSize);
	}
	public int getBoardSize(){
		return this.boardSize;
	}

	private Sign[][] initializeBoard(int boardSize) {
		Sign[][] board = new Sign[boardSize][boardSize];
		Arrays.stream(board).forEach(row -> Arrays.fill(row, Sign.EMPTY));
		return board;
	}

	public Sign[][] resetBoard() {
		initializeBoard(this.boardSize);
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
        return coordinates.x >= 0 && coordinates.y >= 0 && coordinates.x < this.boardSize && coordinates.y < this.boardSize;
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
