package tasks3;

import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        System.out.println(countWords(input));
    }

    public static int countWords(String text) {
        text = text.trim();
        String[] words = text.split("\\s+");
        return words.length;
    }
}
