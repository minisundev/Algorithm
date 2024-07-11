import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double probability = calculateProbability(N, M, K);
        System.out.printf("%.10f\n", probability);
    }

    public static double calculateProbability(int N, int M, int K) {
        long totalCases = comb(N, M);  // 전체 경우의 수

        long successfulCases = 0;
        for (int i = K; i <= M; i++) {
            if (N - M >= M - i) {
                successfulCases += comb(M, i) * comb(N - M, M - i);
            }
        }

        return (double) successfulCases / totalCases;
    }

    public static long comb(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        k = Math.min(k, n - k);  // nCk = nC(n-k)
        long c = 1;
        for (int i = 0; i < k; i++) {
            c = c * (n - i) / (i + 1);
        }
        return c;
    }
}
