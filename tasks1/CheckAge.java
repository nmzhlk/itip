package tasks1;

import java.util.*;

public class CheckAge {
    public static String checkAge(int n) {
        if (n <= 17) {
            return "несовершеннолетний";
        }
        return "совершеннолетний";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(checkAge(n));
    }
}
