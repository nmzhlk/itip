package tasks3;

import java.util.Scanner;

public class CountVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(countVowels(s));
    }

    public static int countVowels(String s) {
        String vowels = "aeiou";
        int counter = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                counter++;
            }
        }
        return counter;
    }
}
