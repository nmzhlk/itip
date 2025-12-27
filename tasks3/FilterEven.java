package tasks3;

import java.util.*;

public class FilterEven {
    public static int[] filterEven(int[] arr) {
        List<Integer> evens = new ArrayList<>();

        for (int num : arr) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }

        int[] result = new int[evens.size()];
        for (int i = 0; i < evens.size(); i++) {
            result[i] = evens.get(i);
        }

        return result;
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

        int[] evenNumbers = filterEven(numbers);
        System.out.println(Arrays.toString(evenNumbers));
    }
}
