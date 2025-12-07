package tasks4;

import java.util.*;

public class MaxConsecutiveOnes {
    public static int maxConsecutiveOnes(String[] numbersAsStrings) {
        int maxSequenceLength = 0;
        int currentSequenceLength = 0;

        for (String numberString : numbersAsStrings) {
            int currentNumber = Integer.parseInt(numberString.trim());

            if (currentNumber == 1) {
                currentSequenceLength++;
            } else {
                if (maxSequenceLength < currentSequenceLength) {
                    maxSequenceLength = currentSequenceLength;
                }
                currentSequenceLength = 0;
            }
        }

        if (currentSequenceLength > maxSequenceLength) {
            return currentSequenceLength;
        } else {
            return maxSequenceLength;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if (input.equals("[]")) {
            System.out.println(0);
        } else {
            String cleanedInput = input.replace("[", "").replace("]", "");
            String[] numbers = cleanedInput.split(",");

            System.out.println(maxConsecutiveOnes(numbers));
        }
        scanner.close();
    }
}