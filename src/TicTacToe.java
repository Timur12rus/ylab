import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicTacToe {
    private final char SIGN_X = 'x';
    private final char SIGN_O = 'o';
    private final char SIGN_EMPTY = '_';
    private char[][] table;
    private Scanner scanner;
    private boolean turnPlayer1 = true;
    private static int counterPlayer1;
    private static int counterPlayer2;
    private static String namePlayer1;
    private static String namePlayer2;
    private Map<String, Integer> ratingMap;

    public TicTacToe() {
        scanner = new Scanner(System.in);
        table = new char[3][3];
        ratingMap = new HashMap<>();
    }

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    private void game() {
        initPlayers();
        ratingMap = loadRating();
        if (!ratingMap.containsKey(namePlayer1)) {
            ratingMap.put(namePlayer1, 0);
        }
        if (!ratingMap.containsKey(namePlayer2)) {
            ratingMap.put(namePlayer2, 0);
        }
        counterPlayer1 = ratingMap.get(namePlayer1);
        counterPlayer2 = ratingMap.get(namePlayer2);
        initTable();
        boolean isEndGame = false;
        while (!isEndGame) {
            turnHuman();
            if (checkWin(SIGN_X)) {
                System.out.println("Победил " + namePlayer1 + "!");
                counterPlayer1++;
                ratingMap.put(namePlayer1, counterPlayer1);
                isEndGame = true;
            } else if (checkWin(SIGN_O)) {
                System.out.println("Победил " + namePlayer2 + "!");
                counterPlayer2++;
                ratingMap.put(namePlayer2, counterPlayer2);
                isEndGame = true;
            }
            if (isTableFull()) {
                System.out.println("Ничья!");
                isEndGame = true;
            }
        }
        System.out.println("Игра окончена!");
        printTable();
        saveRating(ratingMap);
        tryAgain();
    }

    private void initPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя первого игрока: ");
        namePlayer1 = scanner.nextLine();
        System.out.println("Введите имя второго игрока: ");
        namePlayer2 = scanner.nextLine();
    }

    private void tryAgain() {
        String answer;
        boolean isExit = false;
        System.out.println("Сыграем еще раз? (Y) - Да / (N) - Нет");
        while (!isExit) {
            answer = scanner.nextLine();
            if (answer.equals("n") || answer.equals("N")) {
                isExit = true;
            }
            if (answer.equals("Y") || answer.equals("y")) {
                restartGame();
            }
        }
    }

    private void restartGame() {
        counterPlayer1 = 0;
        counterPlayer2 = 0;
        new TicTacToe().game();
    }

    private void initTable() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                table[row][col] = SIGN_EMPTY;
    }

    private void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(table[row][col] + " ");
            System.out.println();
        }
    }

    private void turnHuman() {
        int x, y;
        do {
            printTable();
            if (turnPlayer1) {
                System.out.println("Ходит " + namePlayer1 + ":");
            } else {
                System.out.println("Ходит " + namePlayer2 + ":");
            }
            System.out.println("Введите координату X (1..3):");
            x = scanner.nextInt() - 1;
            System.out.println("Введите координату Y (1..3):");
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        if (turnPlayer1) {
            table[y][x] = SIGN_X;
        } else {
            table[y][x] = SIGN_O;
        }
        turnPlayer1 = !turnPlayer1;
    }

    private boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3)
            return false;
        return table[y][x] == SIGN_EMPTY;
    }

    private boolean checkWin(char dot) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == dot && table[i][1] == dot &&
                    table[i][2] == dot) ||
                    (table[0][i] == dot && table[1][i] == dot &&
                            table[2][i] == dot))
                return true;
        if ((table[0][0] == dot && table[1][1] == dot &&
                table[2][2] == dot) ||
                (table[2][0] == dot && table[1][1] == dot &&
                        table[0][2] == dot))
            return true;
        return false;
    }

    private boolean isTableFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (table[row][col] == SIGN_EMPTY)
                    return false;
        return true;
    }

    private Map<String, Integer> loadRating() {
        HashMap<String, Integer> map = new HashMap<>();
        try {
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] str = line.split(":");
                map.put(str[0], Integer.parseInt(str[1]));
                System.out.println(str[0] + ":" + str[1]);
            }
            scanner.close();
        } catch (Exception e) {

        }
        return map;
    }

    private void saveRating(Map<String, Integer> map) {
        try {
            File file = new File("data.txt");
            FileWriter fileWriter = new FileWriter(file);

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String playerName = entry.getKey();
                Integer value = entry.getValue();
                fileWriter.write(playerName + ":" + value + "\n");
                System.out.println(playerName + ":" + value);
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Ошибка записи файла!");
        }
    }
}
