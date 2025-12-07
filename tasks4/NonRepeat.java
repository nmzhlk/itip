package tasks4;

import java.util.*;

public class NonRepeat {
    public static String nonRepeat(String inputString) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = Character.toLowerCase(inputString.charAt(i));
            frequencyMap.put(currentChar,
                    frequencyMap.getOrDefault(currentChar, 0) + 1);
        }

        Set<Character> charsToRemove = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 3) {
                charsToRemove.add(entry.getKey());
            }
        }

        if (charsToRemove.isEmpty()) {
            return inputString;
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (!charsToRemove.contains(Character.toLowerCase(currentChar))) {
                resultBuilder.append(currentChar);
            }
        }

        return nonRepeat(resultBuilder.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        System.out.println(nonRepeat(input));
        scanner.close();
    }
}