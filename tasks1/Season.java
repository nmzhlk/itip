package tasks1;

import java.util.*;

public class Season {
    public static String season(int n) {
        if (n == 12 || n == 1 || n == 2) {
            return "зима";
        }
        if (n == 3 || n == 4 || n == 5) {
            return "весна";
        }
        if (n == 6 || n == 7 || n == 8) {
            return "лето";
        }
        if (n == 9 || n == 10 || n == 11) {
            return "осень";
        }
        return "нет такого месяца";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(season(n));
    }
}
