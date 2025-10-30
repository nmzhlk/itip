package tasks3;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] words = input.split("\\s*,\\s*");
        System.out.println(isAnagram(words[0], words[1]));
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        if (str1.length() != str2.length())
            return false;
        if (str1.isEmpty() && str2.isEmpty())
            return true;

        char[] charArray1 = str1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] charArray2 = str2.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
}
