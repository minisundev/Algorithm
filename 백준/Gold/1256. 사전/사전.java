import java.io.*;
import java.util.*;

public class Main {

    static final long INF = 0x3f3f3f3f3f3f3f3fL;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int total = N + M;
        dp = new long[N + M + 1][N + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        StringBuilder sb = new StringBuilder();

        long fact = combination(N + M, N);

        if (fact < K) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < total; i++) {
            if (N == 0) {
                sb.append('z');
                M--;
                continue;
            }
            if (M == 0) {
                sb.append('a');
                N--;
                continue;
            }

            long factA = combination(N - 1 + M, N - 1);
            if (factA > 1_000_000_000) factA = INF;

            if (K <= factA) {
                N--;
                sb.append('a');
            } else {
                M--;
                K -= factA;
                sb.append('z');
            }
        }

        System.out.println(sb);
    }

    static long combination(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        if (dp[n][k] != -1) return dp[n][k];

        long val = combination(n - 1, k - 1);
        long val2 = combination(n - 1, k);

        if (val + val2 > 1_000_000_000) return dp[n][k] = INF;

        return dp[n][k] = val + val2;
    }
}
