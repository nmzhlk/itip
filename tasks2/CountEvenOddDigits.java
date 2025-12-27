package tasks2;

import java.util.*;

public class CountEvenOddDigits {
    public static int[] countEvenOddDigits(int n) {
        int evenCount = 0;
        int oddCount = 0;

        int num = Math.abs(n);

        if (num == 0) {
            return new int[] { 1, 0 };
        }

        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            num = num / 10;
        }

        return new int[] { evenCount, oddCount };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        int[] result = countEvenOddDigits(number);
        System.out.println(result[0] + ", " + result[1]);
    }
}
