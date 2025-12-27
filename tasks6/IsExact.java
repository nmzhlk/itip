package tasks6;

import java.util.Scanner;

public class IsExact {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        scanner.close();

        long[] result = isExact(number);
        System.out.println(formatResult(result));
    }

    public static long[] isExact(long number) {
        return findFactorial(number, 1, 1);
    }

    private static long[] findFactorial(long target, long current, long n) {
        if (current == target) {
            return new long[] { target, n };
        }
        if (current > target) {
            return new long[] {};
        }
        return findFactorial(target, current * (n + 1), n + 1);
    }

    private static String formatResult(long[] arr) {
        if (arr.length == 0)
            return "[]";
        return "[" + arr[0] + ", " + arr[1] + "]";
    }
}