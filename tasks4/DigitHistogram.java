package tasks4;

import java.util.*;

public class DigitHistogram {
    public static int[] digitHistogram(int number) {
        int[] digitCounts = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        while (number > 0) {
            int currentDigit = number % 10;
            digitCounts[currentDigit] += 1;
            number /= 10;
        }

        return digitCounts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        scanner.close();

        int[] histogram = digitHistogram(inputNumber);
        System.out.println(Arrays.toString(histogram).replaceAll("\\s+", ""));
    }
}