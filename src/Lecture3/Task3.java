package Lecture3;

//      Создать 10 зергов, 5 протосов и 12 терран.
//      Дать им всем уникальные имена.
public class Task3 {
    public static void main(String[] args) {
        Zerg zerg1 = new Zerg("Zerg1");
        Zerg zerg2 = new Zerg("Zerg2");
        Zerg zerg3 = new Zerg("Zerg3");
        Zerg zerg4 = new Zerg("Zerg4");
        Zerg zerg5 = new Zerg("Zerg5");
        Zerg zerg6 = new Zerg("Zerg6");
        Zerg zerg7 = new Zerg("Zerg7");
        Zerg zerg8 = new Zerg("Zerg8");
        Zerg zerg9 = new Zerg("Zerg9");
        Zerg zerg10 = new Zerg("Zerg10");

        Protoss protoss1 = new Protoss("Protoss1");
        Protoss protoss2 = new Protoss("Protoss2");
        Protoss protoss3 = new Protoss("Protoss3");
        Protoss protoss4 = new Protoss("Protoss4");
        Protoss protoss5 = new Protoss("Protoss5");

        Terran terran1 = new Terran("Terran1");
        Terran terran2 = new Terran("Terran2");
        Terran terran3 = new Terran("Terran3");
        Terran terran4 = new Terran("Terran4");
        Terran terran5 = new Terran("Terran5");
        Terran terran6 = new Terran("Terran6");
        Terran terran7 = new Terran("Terran7");
        Terran terran8 = new Terran("Terran8");
        Terran terran9 = new Terran("Terran9");
        Terran terran10 = new Terran("Terran10");
        Terran terran11 = new Terran("Terran11");
        Terran terran12 = new Terran("Terran12");
    }
}

class Zerg {
    private String name;

    public Zerg(String name) {
        this.name = name;
    }
}

class Terran {
    private String name;

    public Terran(String name) {
        this.name = name;
    }
}

class Protoss {
    private String name;

    public Protoss(String name) {
        this.name = name;
    }
}
