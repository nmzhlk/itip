package tasks1;

import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        scanner.close();
        System.out.println(toFahrenheit(c));
    }

    public static int toFahrenheit(int c) {
        int result = c * 9 / 5 + 32;
        return result;
    }
}