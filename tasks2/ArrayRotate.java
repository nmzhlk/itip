package tasks2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotate {
    public static int[] rotateRight(int[] arr, int k) {
        if (arr.length == 0)
            return arr;

        int shifts = k % arr.length;
        if (shifts == 0)
            return arr;

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int newPosition = (i + shifts) % arr.length;
            result[newPosition] = arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] inputSplit = input.split("],");
        String numbersString = inputSplit[0].replace("[", "").replace("]", "").trim();
        int k = Integer.parseInt(inputSplit[1].trim());

        int[] numbers;
        if (numbersString.isEmpty()) {
            numbers = new int[0];
        } else {
            String[] numbersStringsArray = numbersString.split("[,\\\\s]+");
            numbers = new int[numbersStringsArray.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(numbersStringsArray[i].trim());
            }
        }

        int[] result = rotateRight(numbers, k);
        System.out.println(Arrays.toString(result));
    }
}
