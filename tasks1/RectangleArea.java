package tasks1;

import java.util.*;

public class RectangleArea {
    public static double rectangleArea(double a, double b) {
        double result = a * b;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        scanner.close();
        System.out.println(rectangleArea(a, b));
    }
}
