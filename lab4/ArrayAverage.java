package lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = { "1", "2", "3", "4", "5" };
        // String[] arr = { "1", "2", "test", "4", "5" };
        int sum = 0;

        if (arr == null || arr.length == 0) {
            System.out.println("Ошибка: массив пуст");
            return;
        }

        try {
            for (int i = 0; i <= arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }

            double average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: элемент массива не является целым числом");
        }
    }
}
