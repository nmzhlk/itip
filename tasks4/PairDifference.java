package tasks4;

import java.util.Scanner;

public class PairDifference {
    public static int pairDifference(String[] inputArray) {
        int difference = Integer.parseInt(inputArray[inputArray.length - 1]);
        int pairCount = 0;
        int arrayLength = inputArray.length - 1;

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                int firstNumber = Integer.parseInt(inputArray[i]);
                int secondNumber = Integer.parseInt(inputArray[j]);

                boolean isFirstGreaterOrEqual = firstNumber >= secondNumber;
                boolean hasCorrectDifference = (firstNumber - secondNumber) == difference;
                boolean isNotSameIndex = i != j;

                if (isFirstGreaterOrEqual && hasCorrectDifference && isNotSameIndex) {
                    pairCount++;
                }
            }
        }

        if (difference == 0) {
            pairCount /= 2;
        }
        return pairCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        input = input.replaceAll("\\s+", "")
                .replace("[", "")
                .replace("]", "");

        String[] numbers = input.split(",");
        System.out.println(pairDifference(numbers));
        scanner.close();
    }
}