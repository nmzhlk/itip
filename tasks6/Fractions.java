package tasks6;

import java.math.BigInteger;
import java.util.Scanner;

public class Fractions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String decimal = scanner.nextLine();
        scanner.close();

        System.out.println(fractions(decimal));
    }

    public static String fractions(String decimal) {
        // Разделяем на целую, непериодическую и периодическую части
        int dotIdx = decimal.indexOf('.');
        int openIdx = decimal.indexOf('(');
        int closeIdx = decimal.indexOf(')');

        String wholePart = decimal.substring(0, dotIdx);
        String nonRepeating = "";
        String repeating = "";

        if (openIdx != -1) {
            nonRepeating = decimal.substring(dotIdx + 1, openIdx);
            repeating = decimal.substring(openIdx + 1, closeIdx);
        } else {
            nonRepeating = decimal.substring(dotIdx + 1);
        }

        String numBeforePeriod = wholePart + nonRepeating;
        if (numBeforePeriod.isEmpty())
            numBeforePeriod = "0";

        if (!repeating.isEmpty()) {
            String numWithPeriod = numBeforePeriod + repeating;
            BigInteger a = new BigInteger(numWithPeriod);
            BigInteger b = new BigInteger(numBeforePeriod);

            BigInteger ninePart = new BigInteger("9".repeat(repeating.length()));
            BigInteger tenPower = BigInteger.TEN.pow(nonRepeating.length());
            BigInteger denominator = ninePart.multiply(tenPower);

            BigInteger numerator = a.subtract(b);
            BigInteger gcd = numerator.gcd(denominator);
            return numerator.divide(gcd) + "/" + denominator.divide(gcd);
        } else {
            BigInteger numerator = new BigInteger(numBeforePeriod);
            BigInteger denominator = BigInteger.TEN.pow(nonRepeating.length());
            BigInteger gcd = numerator.gcd(denominator);
            return numerator.divide(gcd) + "/" + denominator.divide(gcd);
        }
    }
}
