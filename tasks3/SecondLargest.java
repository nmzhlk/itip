package tasks3;

import java.util.*;

public class SecondLargest {
    public static int secondLargest(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        input = input.replaceAll("\\[|\\]|\\s", "");
        String[] parts = input.split(",");

        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(secondLargest(numbers));
    }
}
