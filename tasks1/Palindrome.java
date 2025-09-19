package tasks1;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(isPalindrome(s));
    }

    public static String reverseString(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            r = r + s.charAt(s.length() - i - 1);
        }
        return r;
    };

    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}