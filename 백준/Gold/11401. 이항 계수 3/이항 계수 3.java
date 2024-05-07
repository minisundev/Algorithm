import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long MOD = 1000000007;
        long max = Math.max(n - k, k);
        long min = Math.min(n - k, k);

        long numerator = 1;
        for (long i = n; i > max; i--) {
            numerator = (numerator * i) % MOD;
        }

        long denominator = 1;
        for (long i = min; i >= 2; i--) {
            denominator = (denominator * i) % MOD;
        }

        long inverse = modInverse(denominator, MOD);
        long comb = (numerator * inverse) % MOD;
        System.out.println(comb);

    }

    private static long modInverse(long a, long m) {
        return power(a, m - 2, m);
    }

    private static long power(long x, long y, long m) {
        if (y == 0)
            return 1;
        long p = power(x, y / 2, m) % m;
        p = (p * p) % m;
        return (y % 2 == 0) ? p : (x * p) % m;
    }
}