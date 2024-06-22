import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=1;i<N+1;i++){
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) -1;
            int end = Integer.parseInt(st.nextToken());

            int diff = arr[end] - arr[start];

            sb.append(diff).append("\n");
        }
        System.out.println(sb);

    }

}