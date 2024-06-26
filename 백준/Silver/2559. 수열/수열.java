import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        long sum = 0;
        long max = Long.MIN_VALUE;

        for(int i=1; i<K; i++){
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;
            sum += now;
        }
        for(int i=K; i<=N; i++){
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;
            sum += now;
            if(i>K){
                sum = sum - arr[i-K];
            }
            max = Math.max(max,sum);

        }

        System.out.println(max);
    }
}