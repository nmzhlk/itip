package tasks4;

import java.util.*;

public class CountIslands {
    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    islandCount++;
                    markIsland(grid, row, col);
                }
            }
        }

        return islandCount;
    }

    private static void markIsland(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        markIsland(grid, row - 1, col);
        markIsland(grid, row + 1, col);
        markIsland(grid, row, col - 1);
        markIsland(grid, row, col + 1);
    }

    public static int[][] parseMatrix(String input) {
        input = input.trim();

        if (input.startsWith("[[") && input.endsWith("]]")) {
            input = input.substring(2, input.length() - 2);
        }

        String[] rows = input.split("\\],\\[|\\],|\\[");

        if (input.isEmpty() || rows.length == 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].trim();
            if (row.isEmpty()) {
                matrix[i] = new int[0];
                continue;
            }

            String[] numbers = row.split(",");
            matrix[i] = new int[numbers.length];

            for (int j = 0; j < numbers.length; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j].trim());
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        scanner.close();

        int[][] grid = parseMatrix(inputLine);
        System.out.println(countIslands(grid));
    }
}