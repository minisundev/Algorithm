import java.util.*;
import java.lang.Math;

public class Main {

    static int [] dp;
    static int [] cost;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        cost = new int[n];

        //초기화
        for(int i=0;i<n;i++){
            cost[i] = scanner.nextInt();
        }
        getMax(n);
        System.out.println(dp[dp.length-1]);
    }

    public static void getMax(int n) {
        dp = new int[n];
        dp[0]=cost[0];

        if (n > 1) {
            dp[1] = Math.max(cost[0] + cost[1], cost[1]);
        }
        if (n > 2) {
            dp[2] = Math.max(cost[0] + cost[2], cost[1] + cost[2]);
        }

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + cost[i], dp[i - 3] + cost[i - 1] + cost[i]);
        }
    }

}