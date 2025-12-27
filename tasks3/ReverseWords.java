package tasks3;

import java.util.*;

public class ReverseWords {
    public static String reverseWords(String[] wordsNormal) {
        String[] wordsReversed = new String[wordsNormal.length];
        for (int i = 0; i < wordsNormal.length; i++) {
            wordsReversed[i] = wordsNormal[wordsNormal.length - 1 - i];
        }
        return String.join(" ", wordsReversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] wordsInput = input.split(" ");
        String[] words = new String[wordsInput.length];

        for (int i = 0; i < words.length; i++) {
            words[i] = wordsInput[i];
        }

        System.out.println(reverseWords(words));
    }
}
