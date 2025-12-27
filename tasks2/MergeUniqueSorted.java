package tasks2;

import java.util.*;

public class MergeUniqueSorted {
    public static int[] mergeUniqueSorted(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            merged[a.length + i] = b[i];
        }

        Arrays.sort(merged);

        int uniqueCount = 0;
        for (int i = 0; i < merged.length; i++) {
            if (i == 0 || merged[i] != merged[i - 1]) {
                uniqueCount++;
            }
        }

        int[] result = new int[uniqueCount];
        int index = 0;
        for (int i = 0; i < merged.length; i++) {
            if (i == 0 || merged[i] != merged[i - 1]) {
                result[index++] = merged[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String cleaned = input.replaceAll("\\s+", "");
        String[] arraysStrings = cleaned.split("\\],\\[");

        int[] array1;
        String arr1String = arraysStrings[0];
        if (arr1String.startsWith("[")) {
            arr1String = arr1String.substring(1);
        }
        if (arr1String.isEmpty() || arr1String.equals("")) {
            array1 = new int[0];
        } else {
            String[] arr1Elements = arr1String.split(",");
            array1 = new int[arr1Elements.length];
            for (int i = 0; i < arr1Elements.length; i++) {
                array1[i] = Integer.parseInt(arr1Elements[i]);
            }
        }

        int[] array2;
        String arr2String = arraysStrings[1];
        if (arr2String.endsWith("]")) {
            arr2String = arr2String.substring(0, arr2String.length() - 1);
        }
        if (arr2String.isEmpty() || arr2String.equals("")) {
            array2 = new int[0];
        } else {
            String[] arr2Elements = arr2String.split(",");
            array2 = new int[arr2Elements.length];
            for (int i = 0; i < arr2Elements.length; i++) {
                array2[i] = Integer.parseInt(arr2Elements[i]);
            }
        }

        int[] result = mergeUniqueSorted(array1, array2);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
