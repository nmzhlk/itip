package tasks6;

import java.util.*;

public class TwoProduct {
    public static int[] twoProduct(int[] arr, int n) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (current != 0 && n % current == 0) {
                int complement = n / current;
                if (indexMap.containsKey(complement)) {
                    return new int[] { complement, current };
                }
            }
            indexMap.put(current, i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split("(?<=\\])\\s*");
        String arrayPart = parts[0].trim();
        int n = Integer.parseInt(parts[1].trim().replaceAll(", ", ""));

        String numPart = arrayPart.substring(arrayPart.indexOf('[') + 1, arrayPart.indexOf(']'));
        String[] numStrings = numPart.split(",\\s*");
        int[] arr = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            arr[i] = Integer.parseInt(numStrings[i].trim());
        }

        System.out.println(Arrays.toString(twoProduct(arr, n)));
    }
}
