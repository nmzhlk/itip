package tasks2;

import java.util.*;

public class DiagonalSum {
    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int[][] parseMatrix(String input) {
        String cleaned = input.replaceAll("[\\[\\]\\s]", "");
        String[] allElements = cleaned.split(",");
        int[] numbers = new int[allElements.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(allElements[i]);
        }

        int size = (int) Math.sqrt(allElements.length);

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = numbers[i * size + j];
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int[][] matrix = parseMatrix(input);
        int result = diagonalSum(matrix);
        System.out.println(result);
    }
}
