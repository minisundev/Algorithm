import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int count = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int currentSum = 0;
        for (int i = 1; i <= X; i++) {
            currentSum += arr[i];
        }

        max = currentSum;
        count = 1;

        for (int i = X + 1; i <= N; i++) {
            currentSum = currentSum + arr[i] - arr[i - X];
            if (currentSum > max) {
                max = currentSum;
                count = 1;
            } else if (currentSum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
