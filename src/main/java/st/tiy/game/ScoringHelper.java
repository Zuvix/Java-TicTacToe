package st.tiy.game;

public class ScoringHelper {
    private Board board;
    private int maxBoardSize;
    private int currentBoardSize;
    private int requiredScoringLength;

    public ScoringHelper(Board board, int requiredScoringLength){
        this.board = board;
        this.maxBoardSize = board.getBoardSize() * board.getBoardSize();
        this.currentBoardSize =  0;
        this.requiredScoringLength = requiredScoringLength;
    }
    public boolean resolveTurnScoring(Coordinates placedSign){

    }
    private bool checkLine(Coordinates placedSign, Direction positive, Direction negative)
    {
        Sign[][] brd = this.board.getBoard();
        int x = placedSign.x;
        int y = placedSign.y;
        Sign selectedSign = brd[x][y];
        int length = 1;
    }
    private bool checkNextSymbol()...


}
