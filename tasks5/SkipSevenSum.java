package tasks5;

import java.util.*;

public class SkipSevenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(skipSevenSum(n));
    }

    public static int skipSevenSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!containsSeven(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean containsSeven(int num) {
        while (num > 0) {
            if (num % 10 == 7) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}