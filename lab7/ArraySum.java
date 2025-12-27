package lab7;

public class ArraySum {
    private static int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private static int sum1 = 0;
    private static int sum2 = 0;

    public static void main(String[] args) throws InterruptedException {
        int middle = array.length / 2;

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < middle; i++) {
                sum1 += array[i];
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = middle; i < array.length; i++) {
                sum2 += array[i];
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(sum1 + sum2);
    }
}