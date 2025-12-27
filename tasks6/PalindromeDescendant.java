package tasks6;

import java.util.Scanner;

public class PalindromeDescendant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        scanner.close();

        long n;
        if (input.contains("(")) {
            String numStr = input.substring(input.indexOf('(') + 1, input.indexOf(')'));
            n = Long.parseLong(numStr);
        } else {
            n = Long.parseLong(input);
        }

        System.out.println(palindromeDescendant(n));
    }

    public static boolean palindromeDescendant(long n) {
        if (isPalindrome(n)) {
            return true;
        }

        long descendant = getDescendant(n);
        if (descendant == n || descendant < 10) {
            return false;
        }

        return palindromeDescendant(descendant);
    }

    private static boolean isPalindrome(long num) {
        String s = Long.toString(num);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static long getDescendant(long num) {
        String s = Long.toString(num);
        if (s.length() < 2)
            return num;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            if (i + 1 < s.length()) {
                int sum = (s.charAt(i) - '0') + (s.charAt(i + 1) - '0');
                sb.append(sum);
            }
        }
        return Long.parseLong(sb.toString());
    }
}