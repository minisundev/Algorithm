import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());  // 조카의 수
        int N = Integer.parseInt(st.nextToken());  // 과자의 수

        long[] lengths = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lengths[i] = Long.parseLong(st.nextToken());
        }

        long low = 1;
        long high = 1_000_000_000L;
        long max = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = 0;

            for (long length : lengths) {
                count += length / mid;
            }

            if (count >= M) {
                max = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(max);
    }
}
