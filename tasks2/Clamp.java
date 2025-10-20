package tasks2;

import java.util.Scanner;

public class Clamp {
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] numbers = input.split(", ");

        int value = Integer.parseInt(numbers[0]);
        int min = Integer.parseInt(numbers[1]);
        int max = Integer.parseInt(numbers[2]);

        int result = clamp(value, min, max);
        System.out.println(result);
    }
}
