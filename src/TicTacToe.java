import java.util.Scanner;

public class TicTacToe {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '_';
    char[][] table;
    Scanner scanner;
    boolean turnPlayer1 = true;

    TicTacToe() {
        scanner = new Scanner(System.in);
        table = new char[3][3];
    }

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    void game() {
        initTable();
        while (true) {
            turnHuman();
            if (checkWin(SIGN_X)) {
                System.out.println("Победил игрок 1!");
                break;
            } else if (checkWin(SIGN_O)) {
                System.out.println("Победил игрок 2!");
            }
            if (isTableFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Игра окончена!");
        printTable();
        tryAgain();
    }

    void tryAgain() {
        System.out.println("Сыграем еще раз? (Y) - Да / (N) - Нет");
        String answer = scanner.nextLine();
    }

    void initTable() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                table[row][col] = SIGN_EMPTY;
    }

    void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(table[row][col] + " ");
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;

        do {
            printTable();
            if (turnPlayer1) {
                System.out.println("Ходит игрок 1:");
            } else {
                System.out.println("Ходит игрок 2:");
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

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3)
            return false;
        return table[y][x] == SIGN_EMPTY;
    }

    boolean checkWin(char dot) {
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

    boolean isTableFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (table[row][col] == SIGN_EMPTY)
                    return false;
        return true;
    }

    void loadRating() {

    }

    void saveRating() {

    }
}
