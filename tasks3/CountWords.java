package tasks3;

import java.util.*;

public class CountWords {
    public static int countWords(String text) {
        text = text.trim();
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        System.out.println(countWords(input));
    }
}
