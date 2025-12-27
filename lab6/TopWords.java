package lab6;

import java.io.*;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "file.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        Map<String, Integer> wordCount = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-zа-я]", "");
            if (word.isEmpty()) {
                continue;
            }
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        scanner.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int count = Math.min(10, list.size());
        System.out.println("Топ-" + Integer.toString(count) + " по частоте использования в тексте");

        for (int i = 0; i < count; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " раз(а)");
        }
    }
}