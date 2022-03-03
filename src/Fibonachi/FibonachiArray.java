package Fibonachi;

public class FibonachiArray {
    public static void main(String[] args) {
        System.out.println(fib(10));   // (порядковый номер в последовательности, не индекс!    }
    }

    private static int fib(int n) {
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[array.length - 1];
    }
}
