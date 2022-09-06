package s2recursion;

import java.util.Arrays;

public class Recursion {
    public int power(int base, int exponent) {
        if (exponent == 0) return 1;
        else {
            return base * power(base, exponent - 1);
        }
    }

    public int productOfArray(int A[], int N) {
        if (N == 0) return 1;
        else {
            return A[N - 1] * productOfArray(A, N - 1);
        }
    }

    public String reverse(String str) {
        if (str.isEmpty()) return "";
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) return true;

        int start = 0;
        int end = s.length() - 1;

        if (s.charAt(start) != s.charAt(end)) return false;
        else
            return isPalindrome(s.substring(start + 1, end));
    }
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
