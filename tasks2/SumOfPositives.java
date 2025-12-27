package tasks2;

import java.util.*;

public class SumOfPositives {
    public static int sumOfPositives(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] numbersStrings = input.split(", ");
        int[] numbers = new int[numbersStrings.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersStrings[i]);
        }

        int result = sumOfPositives(numbers);
        System.out.println(result);
    }
}
