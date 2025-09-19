package tasks1;

import java.util.Scanner;

public class Parity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(isEven(n));
    }

    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }
}
