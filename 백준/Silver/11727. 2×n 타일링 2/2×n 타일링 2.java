import java.util.*;
import java.lang.Math;

public class Main {

    static long [][] dp;
    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(getNumber(n));
    }

    public static long getNumber(int n) {
        long sum = 0;
        dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n / 2; i++) {
            int two = i;
            int one = n - i * 2;
            long result = (dp(one + two, two) % MOD) * modPow(2, two) % MOD;
            sum = (sum + result) % MOD;
        }
        return sum;
    }

    public static long dp(int all, int select){
        if(all<0||select<0){
            return 0;
        }else if(all==0||all==select){
            return 1;
        } else if(select==1){
            return all;
        }
        long element = dp[all][select];
        if(element==0){
            element = (dp(all - 1, select - 1) + dp(all - 1, select)) % MOD;
            dp[all][select]= element;
        }
        return element;
    }

    public static long modPow(long base, int exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return result;
    }
}