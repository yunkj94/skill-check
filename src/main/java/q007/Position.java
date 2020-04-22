package q007;

public class Position {
    private int tmpX;
    private int tmpY;
    private int beforeX;
    private int beforeY;
    private int moveCount;


    public Position(int startX, int startY) {
        this.tmpX = startX;
        this.tmpY = startY;
        this.beforeX = -99;
        this.beforeY = -99;
    }

    public Position(int tmpX, int tmpY, int beforeX, int beforeY, int moveCount) {
        this.tmpX = tmpX;
        this.tmpY = tmpY;
        this.beforeX = beforeX;
        this.beforeY = beforeY;
        this.moveCount = moveCount;
    }

    public int getTmpX() {
        return tmpX;
    }

    public int getTmpY() {
        return tmpY;
    }

    public int getBeforeX() {
        return beforeX;
    }

    public int getBeforeY() {
        return beforeY;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
