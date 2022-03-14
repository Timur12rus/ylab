public class Player {
    private char sign;
    private String name;
    private int id;

    public char getSign() {
        return sign;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player() {

    }

    @Override
    public String toString() {
        return "symbol = " + Character.toString(getSign()) + "; " +
                "name = " + getName() + "; " +
                "id = " + getId();
    }
}
