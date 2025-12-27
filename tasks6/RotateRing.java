package tasks6;

import java.util.Scanner;

public class RotateRing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split(" ");
        String s = parts[0];
        int k = Integer.parseInt(parts[1]);

        System.out.println(rotateRing(s, k));
    }

    public static String rotateRing(String s, int k) {
        if (s.isEmpty())
            return s;
        int n = s.length();
        k = ((k % n) + n) % n;
        if (k == 0)
            return s;
        return s.substring(k) + s.substring(0, k);
    }
}
