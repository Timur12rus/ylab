package Lect5.Task1;

public class Task5 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", 5, 2.6);
        Cat cat2 = new Cat("Murzik", 2, 1.8);
        Cat cat3 = new Cat("Kesha", 7, 4.2);
        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat3));
        System.out.println(cat1.fight(cat3));
    }
}
