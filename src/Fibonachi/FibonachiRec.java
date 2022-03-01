package Fibonachi;

public class FibonachiRec {

    // алгоритм поиска через рекурсию
    public static void main(String[] args) {
        int n = 10;  // индекс числа в последовательности чисел фибоначи
        System.out.println(fib(n));
    }

    private static int fib(int num) {
        if (num <= 1) {
            return num;
        }
        return fib(num - 1) + fib(num - 2);
    }
}
