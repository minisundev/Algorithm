import java.util.Scanner;

public class Main {

    static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] k = new int[number];
        int[] n = new int[number];
        for (int i = 0; i < number; i++) {
            k[i] = scanner.nextInt();
            n[i] = scanner.nextInt();
        }
        for (int i = 0; i < number; i++) {
            int count = getNumber(k[i], n[i]);
            System.out.println(count);
        }
    }

    public static int getNumber(int k, int n) {
        dp = new int[k+1][n*2];//k층 n호

        for (int i = 0; i < n; i++) {//0층 채우기
            dp[0][i] = i + 1;
        }

        return dp(k, n-1);
    }

    public static int dp(int k, int n) {
        int element = dp[k][n];

        if (element == 0) {
            for (int j = 0; j <= n; j++) {
                element += dp(k - 1, j);
            }
            dp[k][n] = element;
        }
        return element;
    }
}