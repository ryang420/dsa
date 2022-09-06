package s2recursion;

import java.util.Arrays;

public class Recursion {
    private int factorial(int n) {
        if (n < 0) {
            return -1;
        }

        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    private int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Recursion r = new Recursion();
        System.out.println(r.factorial(10));

        int n = 10;
        int[] fibo = new int[n]; // 0 1 1 2 3 5 8 13
        for (int i = 0; i < n; i++) {
            fibo[i] = r.fibonacci(i);
        }
        System.out.println(Arrays.toString(fibo));
    }
}
