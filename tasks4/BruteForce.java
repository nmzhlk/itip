package tasks4;

import java.util.*;

public class BruteForce {
    public static List<String> bruteForce(int wordLength, int alphabetSize) {
        if (wordLength > alphabetSize) {
            return new ArrayList<>();
        }

        if (wordLength == 0) {
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        List<String> result = new ArrayList<>();

        for (int digit = 0; digit < alphabetSize; digit++) {
            char currentChar = (char) ('0' + digit);

            List<String> shorterCombinations = bruteForce(wordLength - 1, alphabetSize);

            for (String shorterCombination : shorterCombinations) {
                if (!shorterCombination.contains(String.valueOf(currentChar))) {
                    result.add(currentChar + shorterCombination);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(",");

        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        List<String> result = bruteForce(n, k);

        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            System.out.print("\"" + result.get(i) + "\"");
            if (i < result.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        scanner.close();
    }
}