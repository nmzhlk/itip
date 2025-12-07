package tasks4;

import java.util.Scanner;

public class ConvertToRome {
    public static String convertToRome(int number) {
        int[] arabicValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanNumerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder romanNumber = new StringBuilder();
        int remainingNumber = number;

        for (int i = 0; i < arabicValues.length; i++) {
            while (remainingNumber >= arabicValues[i]) {
                romanNumber.append(romanNumerals[i]);
                remainingNumber -= arabicValues[i];
            }
        }

        return romanNumber.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        System.out.println(convertToRome(inputNumber));
        scanner.close();
    }
}