package s2recursion;

import java.util.Arrays;

public class Questions {
    /*
    1. How to find the sum of digits of a positive integer number using recursion?
        123 = 6, 10 = 1, 22 = 4
     */
    private int sumOfDigits(int n) {
        if (n <= 0) return 0;
        return n % 10 + sumOfDigits(n / 10);
    }

    /*
    2. How to calculate power of a number using recursion?
    2**2 = 4, 3**2 = 9, 3**3 = 27
     */
    private int power(int base, int times) {
        if (times < 0) return 0;
        if (times == 0) return 1;
        return base * power(base, times - 1);
    }

    /*
    3. How to find GCD(greatest common division) of two numbers using recursion?
     */
    private int gcd(int a, int b) {
        if (a < 0 || b < 0) return -1;
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    /*
    4. How to convert a number from Decimal to Binary using recursion
     */
    private int convert(int n) {
        if (n == 0) return 0;
        return n % 2 + 10 * convert(n / 2);
    }

    static char first(String str) {
        if (str.isEmpty()) return ' ';
        char c = str.charAt(0);
        if (c >= 65 && c <= 90) return c;

        return first(str.substring(1));
    }

    /*
    Implement a function that capitalizes each word in String
     */
    public static String capitalizeWord(String str) {
        if (str.isEmpty()) return "";

        char chr = str.charAt(str.length()-1);
        if (str.length() == 1) {
            return Character.toString(Character.toUpperCase(chr));
        }
        if (str.charAt(str.length() - 2) == ' ') {
            chr = Character.toUpperCase(chr);
        }
        return capitalizeWord(str.substring(0, str.length() - 1)) + chr;
    }

    public static void main(String[] args) {
        Questions q = new Questions();
        System.out.println(q.sumOfDigits(123));
        System.out.println(q.sumOfDigits(10));
        System.out.println(q.sumOfDigits(22));
        System.out.println(q.sumOfDigits(0));

        System.out.println(q.power(3, 3));
        //gcd(48, 18) = 6
        System.out.println(q.gcd(48, 18));
        // 10 = 1010
        System.out.println(q.convert(10));

        int[] arr = {1, 2, 3, 4, 5};

        int[] newArr = Arrays.copyOf(arr, arr.length - 1);
        System.out.println(Arrays.toString(newArr));

        System.out.println(first("appmillerS"));

        System.out.println(capitalizeWord("i love java"));

    }
}
