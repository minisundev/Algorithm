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
        int[] jewels = new int[M];

        int maxJewels = 0;

        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            maxJewels = Math.max(maxJewels, jewels[i]);
        }

        int low = 1;
        int high = maxJewels;
        int minJealousy = maxJewels;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canDistribute(jewels, N, mid)) {
                minJealousy = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(minJealousy);
    }

    private static boolean canDistribute(int[] jewels, int N, int max) {
        int count = 0;

        for (int jewel : jewels) {
            count += jewel / max;
            if (jewel % max != 0) {
                count++;
            }
        }

        return count <= N;
    }
}
