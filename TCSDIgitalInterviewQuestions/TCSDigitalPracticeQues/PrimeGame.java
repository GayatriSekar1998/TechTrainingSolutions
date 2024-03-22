import java.util.Scanner;

public class PrimeGame {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
            i += 6;
        }
        return true;
    }

    public static int maximumPrimeDifference(int L, int R) {
        int maxPrime = -1, minPrime = -1;
        for (int i = L; i <= R; i++) {
            if (isPrime(i)) {
                if (minPrime == -1) minPrime = i;
                maxPrime = i;
            }
        }
        if (minPrime == -1) return -1;
        if (maxPrime == minPrime) return 0;
        return maxPrime - minPrime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int L = scanner.nextInt(), R = scanner.nextInt();
            System.out.println(maximumPrimeDifference(L, R));
        }
        scanner.close();
    }
}
