package lab7;

public class MatrixMax {
    private static int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };
    private static int[] maxInRow = new int[matrix.length];

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                int max = matrix[row][0];
                for (int j = 1; j < matrix[row].length; j++) {
                    if (matrix[row][j] > max) {
                        max = matrix[row][j];
                    }
                }
                maxInRow[row] = max;
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        int matrixMax = maxInRow[0];
        for (int i = 1; i < maxInRow.length; i++) {
            if (maxInRow[i] > matrixMax) {
                matrixMax = maxInRow[i];
            }
        }

        System.out.println(matrixMax);
    }
}