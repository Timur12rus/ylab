package Lecture2;

//Написать функцию, которая возвращает минимум из двух чисел.
public class Task2_3 {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int c = 7;
        int d = 1;
        int minFromTwo = min(a, b);
        int maxFromTwo = max(a, b);
        int minFromThree = minFromThree(a, b, c);
        int minFromFour = minFromFour(a, b, c, d);
        System.out.println("minFromTwo is = " + minFromTwo);
        System.out.println("maxFromTwo is = " + maxFromTwo);
        System.out.println("minFromThree is = " + minFromThree);
        System.out.println("minFromFour is = " + minFromFour);

        printThreeStrings("Дублирование строки");

        printStrings("Строка");
    }

    // возвращает минимум из двух чисел
    public static int min(int a, int b) {
        int min;
        if (a < b) {
            min = a;
        } else {
            min = b;
        }
        return min;
    }

    // возвращает максимум из двух чисел
    public static int max(int a, int b) {
        int max;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }
        return max;
    }

    // возвращает минимум из трёх чисел
    public static int minFromThree(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        }
        return c;
    }

    // возвращает минимум четырёх чисел
    public static int minFromFour(int a, int b, int c, int d) {
        int min1 = min(a, b);
        int min2 = min(c, d);
        int min = min(min1, min2);
        return min;
    }

    //    Написать функцию, которая выводит переданную строку на экран три раза, каждый раз с новой строки.
    public static void printThreeStrings(String str) {
        System.out.println(str);
        System.out.println(str);
        System.out.println(str);
    }

//    Написать функцию, которая выводит переданную строку (слово) на экран три раза, но в одной строке.
//    Слова должны быть разделены пробелом и не должны сливаться в одно.
    public static void printStrings(String str) {
        System.out.print(str + " ");
        System.out.print(str + " ");
        System.out.print(str + " ");
    }
}
