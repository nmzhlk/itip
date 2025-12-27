package tasks6;

import java.util.*;

public class HiddenPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        System.out.println(hiddenPalindrome(input));
    }

    public static String hiddenPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int n = s.length();
        String result = "none";

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (canBePalindrome(sub)) {
                    if (sub.length() > result.length()) {
                        result = sub;
                    }
                }
            }
        }

        return result;
    }

    private static boolean canBePalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int oddCount = 0;
        for (int freq : count) {
            if (freq % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
