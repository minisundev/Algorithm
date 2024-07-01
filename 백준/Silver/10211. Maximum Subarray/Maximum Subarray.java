import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long max = arr[0];
            long currentSum = arr[0];

            for(int j=1; j<N; j++){
                currentSum = Math.max(arr[j], currentSum + arr[j]);
                max = Math.max(max, currentSum);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
