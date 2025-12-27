package tasks6;

import java.util.*;

public class PilishString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        System.out.println(pilish_string(input));
    }

    public static String pilish_string(String s) {
        int[] piDigits = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9 };
        List<String> words = new ArrayList<>();
        int index = 0;

        for (int len : piDigits) {
            if (index >= s.length())
                break;

            if (index + len <= s.length()) {
                words.add(s.substring(index, index + len));
            } else {
                String part = s.substring(index);
                char lastChar = part.charAt(part.length() - 1);
                StringBuilder padded = new StringBuilder(part);
                while (padded.length() < len) {
                    padded.append(lastChar);
                }
                words.add(padded.toString());
            }
            index += len;
        }

        return String.join(" ", words);
    }
}
