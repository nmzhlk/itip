package tasks3;

import java.util.*;

public class SumOfDigits {
    public static long sumOfDigits(int number) {
        number = Math.abs(number);
        long result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(sumOfDigits(n));
    }
}
