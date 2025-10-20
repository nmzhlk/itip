package tasks2;

import java.util.Scanner;

public class Duplicates {
    public static boolean hasDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
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

        boolean result = hasDuplicates(numbers);
        System.out.println(result);
    }
}
