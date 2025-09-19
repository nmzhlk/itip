package tasks1;

import java.util.Locale;
import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        scanner.close();
        System.out.println(rectangleArea(a, b));
    }

    public static double rectangleArea(double a, double b) {
        double result = a * b;
        return result;
    }
}
