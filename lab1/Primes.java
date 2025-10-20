package lab1;

public class Primes {
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int num = 2; num <= 100; num++) {
            if (isPrime(num)) {
                System.out.println(num);
            }
        }
    }
}