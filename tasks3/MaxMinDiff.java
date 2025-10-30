package tasks3;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMinDiff {
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

        System.out.println(differenceMaxMin(numbers));
    }

    public static int differenceMaxMin(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1] - arr[0];
    }
}
