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
		boolean turnPlayedSuccessfully;
		Coordinates coordinates;
		do
		{
			coordinates = getCoordinates();
			turnPlayedSuccessfully = this.board.putSign(this.sign, coordinates);
			if(!turnPlayedSuccessfully) System.out.println("Incorrect placement [column: "+coordinates.x +" row: "+coordinates.y+"]");
		}
		while(!turnPlayedSuccessfully);
		return coordinates;
	}

	private Coordinates getCoordinates(){
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		return new Coordinates(x,y);
	}
}
