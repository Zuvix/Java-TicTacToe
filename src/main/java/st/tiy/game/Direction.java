package st.tiy.game;

public enum Direction {
    UP(0,1),
    DOWN(0,-1),
    LEFT(-1,0),
    RIGHT(1,0),
    TOPLEFT(-1,1),
    TOPRIGHT(1,1),
    BOTTOMLEFT(-1,-1),
    BOTTOMRIGHT(1,-1);


    public final int x;
    public final int y;

    Direction(int x,int y){
        this.x = x;
        this.y = y;
    }

}
