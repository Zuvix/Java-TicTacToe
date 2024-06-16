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
		do
		{
			Coordinates coordinates = getCoordinates();
			turnPlayedSuccessfully = this.board.putSign(this.getSign(), coordinates);
			if(!turnPlayedSuccessfully){
			 System.out.println("Incorrect placement [x: "+coordinates.x +" y: "+coordinates.y+"]");
			 }
			else{
				return coordinates;
			}
		}
		while(!turnPlayedSuccessfully);
		// Lets consider -1, -1 error coordinates
		return new Coordinates(-1,-1);

	}

	private Coordinates getCoordinates(){
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		return new Coordinates(x,y);
	}
}
