public class Step {
    private int playerId;
    private int num;
    private int value;

    public Step(int playerId, int num, int value) {
        this.playerId = playerId;
        this.num = num;
        this.value = value;
    }

    public Step() {

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
