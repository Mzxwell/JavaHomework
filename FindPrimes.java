import java.util.Scanner;

public class FindPrimes {
    public static boolean IsPrime(int n) {
        if (n == 2 || n ==3) return false;
        if (n % 2 == 0)return true;
        for (int i = 3; i * i <= n; i += 2) if (n % i == 0) return true;
        return false;
    }
    public static int NextPrime(int n) {
        if (n == 2) return 3;
        do n+=2;while (IsPrime(n));
        return n;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int[] even = new int[t];
        int prime;
        for (int i = 0; i < t; i++) even[i] = input.nextInt();
        for (int i = 0; i < t; i++) {
            prime = 2;
            while (IsPrime(even[i] - prime)) prime = NextPrime(prime);
            System.out.printf("%d %d\n", prime, even[i] - prime);
        }
    }
}