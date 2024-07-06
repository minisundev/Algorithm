import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N+1];
        long count = 0;

        HashMap<Long, Long> remainderMap = new HashMap<>();
        remainderMap.put(0L, 1L);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + now;
            long remainder = arr[i] % M;

            if (remainder < 0) {
                remainder += M;
            }

            if (remainderMap.containsKey(remainder)) {
                count += remainderMap.get(remainder);
            }

            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0L) + 1);
        }

        System.out.println(count);
    }
}
