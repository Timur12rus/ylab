package Fibonachi;

public class Fibonachi {
    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    private static int fib(int n) {
        // n - индекс числа фибоначи в последовательности чисел, считается с 0
        int a = 0;
        int b = 1;
        int c;
        if (n == 0) {
            return a;
        }
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
