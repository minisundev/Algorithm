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

        int[] outcome = new int[N];
        int maxExpense = 0;
        int totalExpense = 0;
        for (int i = 0; i < N; i++) {
            outcome[i] = Integer.parseInt(br.readLine());
            maxExpense = Math.max(maxExpense, outcome[i]);
            totalExpense += outcome[i];
        }

        int low = maxExpense;
        int high = totalExpense;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canWithdraw(outcome, N, M, mid)) {
                min = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(min);
    }

    private static boolean canWithdraw(int[] outcome, int N, int M, int K) {
        int count = 1;
        int currentSum = 0;

        for (int i = 0; i < N; i++) {
            if (currentSum + outcome[i] > K) {
                count++;
                currentSum = 0;
            }
            currentSum += outcome[i];
        }
        return count <= M;
    }
}
