package Lecture2;

public class Dog {
    private String name;
    private Women owner;

    // присваивает владельца
    public void setOwner(Women owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
