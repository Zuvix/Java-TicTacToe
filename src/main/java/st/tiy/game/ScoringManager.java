package st.tiy.game;

public class ScoringManager {
    private Board board;
    private final int maxBoardSize;
    private final int requiredScoringLength;
    private int currentBoardSize;

    public ScoringManager(Board board, int requiredScoringLength){
        this.board = board;
        this.maxBoardSize = board.getBoardSize() * board.getBoardSize();
        this.currentBoardSize =  0;
        this.requiredScoringLength = requiredScoringLength;
    }

    public boolean checkTie(){
        currentBoardSize++;
        return currentBoardSize>=maxBoardSize;
    }

    public boolean checkWinningPlay(Coordinates placedSign)
    {
        return checkLine(placedSign,Direction.UP,Direction.DOWN)
            || checkLine(placedSign,Direction.LEFT,Direction.RIGHT)
            || checkLine(placedSign,Direction.TOPLEFT,Direction.BOTTOMRIGHT)
            || checkLine(placedSign,Direction.TOPRIGHT,Direction.BOTTOMLEFT);

    }

    private boolean checkLine(Coordinates placedSign, Direction positive, Direction negative)
    {

        int length = 1 + checkOneDirection(placedSign,positive) + checkOneDirection(placedSign,negative);
        if(length>=this.requiredScoringLength) return true;
        return false;
    }

    private int checkOneDirection(Coordinates placedSign, Direction currentDir)
    {
        Sign selectedSign = board.getSign(placedSign);
        int result = 0;
        int x = placedSign.x;
        int y = placedSign.y;
        while(board.isSignPresent(new Coordinates(x+currentDir.x,y+currentDir.y),selectedSign))
        {
            x+=currentDir.x;
            y+=currentDir.y;
            result++;
        }
        return result;
    }


}
