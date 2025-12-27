package tasks4;

import java.util.*;

public class WordHistogram {
    public static String wordHistogram(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> wordFrequency = new LinkedHashMap<>();

        for (String word : words) {
            if (wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        }

        StringBuilder resultBuilder = new StringBuilder("{");
        boolean isFirstEntry = true;

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (!isFirstEntry) {
                resultBuilder.append(", ");
            }
            resultBuilder.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue());
            isFirstEntry = false;
        }

        resultBuilder.append("}");
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        scanner.close();

        String cleanedText = inputText.replaceAll("\\p{Punct}+", "").toLowerCase();
        System.out.println(wordHistogram(cleanedText));
    }
}