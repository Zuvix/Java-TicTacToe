package st.tiy.player;

import st.tiy.game.Board;
import st.tiy.game.Coordinates;
import st.tiy.game.Sign;

import java.util.Scanner;

public class HumanPlayer extends Player	{

	public HumanPlayer(String name, Sign sign, Board board) {
		super(name, sign, board);
	}

	@Override
	public Coordinates takeTurn() {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();

		//TODO Check if x & y are valid
		return new Coordinates(x, y);
	}
}
