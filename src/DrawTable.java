import java.util.ArrayList;

public class DrawTable {
    private char[][] table = new char[3][3];
    private final char SIGN_EMPTY = '_';
    private final char SIGN_X = 'x';
    private final char SIGN_O = 'o';
    private XmlLoader xmlLoader;

    public void draw() {
        xmlLoader = new XmlLoader();
        xmlLoader.load();       // загружаем данные из xml
        initTable();
        printTable();
        printPlayers();
    }

    private void printPlayers() {
        ArrayList<Player> players = xmlLoader.getPlayers();
        System.out.println("Имя игрока1 = " + players.get(0).getName() + "; символ игрока1 = " + players.get(0).getSign());
        System.out.println("Имя игрока2 = " + players.get(1).getName() + "; символ игрока2 = " + players.get(1).getSign());
    }

    private void initTable() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                table[row][col] = SIGN_EMPTY;
        ArrayList<Step> steps = xmlLoader.getSteps();
        for (Step step : steps) {
            int value = step.getValue();  // получаем двухзначное число и извлекаем из него координаты
            int x = value / 10 - 1;
            int y = value % 10 - 1;
            if (step.getPlayerId() == 1) {
                table[y][x] = SIGN_X;
            }
            if (step.getPlayerId() == 2) {
                table[y][x] = SIGN_O;
            }
        }
    }

    private void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(table[row][col] + " ");
            System.out.println();
        }
    }
}
