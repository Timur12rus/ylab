package Lect5.Task1;

public class Cat {
    private String name;
    private int age;
    private double weight;

    public Cat(String name, int age, double weight) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public boolean fight(Cat cat) {
        if (weight > cat.getWeight()) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }
}
