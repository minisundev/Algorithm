import java.util.*;
import java.lang.Math;

public class Main {

    static int [] dp;
    static int [] list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(getNumber(n));
    }

    public static int getNumber(int n) {
        dp = new int[n];
        dp[0] = list[0];
        if(n>1) {
            dp[1] = list[0] + list[1];
        }
        if(n>2) {
            dp[2] = Math.max(dp[1], Math.max(dp[0] + list[2], list[1] + list[2]));
        }
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + list[i], dp[i - 3] + list[i - 1] + list[i]));
        }
        return dp[n - 1];
    }
}