package Lecture2;

public class Task2_2 {
    public static void main(String[] args) {

//      Создайте 10 переменных типа Cat и 8 объектов типа Cat.
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();
        Cat cat8 = new Cat();
        Cat cat9;   // переменная типа Cat
        Cat cat10;  // переменная типа Cat

//     Создайте объект типа Cat(кот), объект типа Dog (собака), объект типа Fish (рыбка) и объект типа Woman.
//     Присвойте каждому животному владельца (owner).
        Cat cat = new Cat();
        Dog dog = new Dog();
        Fish fish = new Fish();
        Women owner = new Women();

        cat.setOwner(owner);
        dog.setOwner(owner);
        fish.setOwner(owner);



    }
}
