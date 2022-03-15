public class Step {
    private int playerId;
    private int num;
    private int value;
    private int x, y;

    public Step(int playerId, int x, int y) {
        this.playerId = playerId;
        this.x = x;
        this.y = y;
    }

    public Step() {

    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getNum() {
        return num;
    }

    public int getValue() {
        return value;
    }
}
