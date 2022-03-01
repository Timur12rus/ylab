package Fibonachi;

public class FibonachiArray {
    public static void main(String[] args) {
        System.out.println(fib(10));   // (индексация чисел начинается с "0", n - порядковый номер числа в последовательности
    }

    private static int fib(int n) {
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }
}
