package ro.fasttrackit.course17.homework;

public class RecursionExercises {
    public static void main(String[] args) {
        System.out.println(sumOfFirst_n_integers(5));
        System.out.println(sumOfFirstNEven(5));
        System.out.println(firstNEvenSum(0, 5));
        System.out.println(reverseString("Alex"));
        System.out.println(isPalindromeRecursiveCheck("Madam"));
        System.out.println(sumOfDigits(123));
    }

    // 1. Sum of first n integers recursively
    public static int sumOfFirst_n_integers(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfFirst_n_integers(n - 1);
    }

    // 2.
    public static int sumOfFirstNEven(int n) {
        if (n == 2) {
            return 2;
        }

        if (n % 2 != 0) {
            return sumOfFirstNEven(n - 1);
        } else {
            return n + sumOfFirstNEven(n - 2);
        }
    }

    public static int firstNEvenSum(int value, int count) {
        if (count == 0) {
            return 0;
        }

        if (value % 2 != 0 || value == 0) {
            return firstNEvenSum(++value, count);
        } else {
            return value + firstNEvenSum(++value, --count);
        }
    }

    //3.1
    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }

        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static boolean isPalindrome(String word) {
        return word.equals(reverseString(word));
    }

    // 3.2
    public static boolean isPalindromeRecursiveCheck(String str) {
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindromeRecursiveCheck(str.substring(1, str.length() - 1));
        }
        return false;
    }

    // 4
    public static int sumOfDigits(int number) {
        if (number < 10) {
            return number;
        }

        return number % 10 + sumOfDigits(number / 10);
    }
}
