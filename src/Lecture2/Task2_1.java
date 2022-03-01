package Lecture2;

//Создать объект типа Cat 2 раза.
public class Task2_1 {
    public static void main(String[] args) {
        Cat barsik = new Cat();
        Cat murzik = new Cat();

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();

        dog1.setName("Max");
        dog2.setName("Bella");
        dog3.setName("Jack");

        System.out.println("Мне так хорошо!");
    }
}
