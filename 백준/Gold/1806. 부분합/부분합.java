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
        long S = Long.parseLong(st.nextToken());

        int min = Integer.MAX_VALUE;
        int start = 0;

        long [] arr = new long[N+1];

        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for(int i=1; i<=N; i++){
            sum += Long.parseLong(st.nextToken());
            arr[i] = sum;
            while(sum - arr[start]>= S && start<arr.length){
                min = Math.min(min,i-start);
                start++;
            }
        }

        if(min==Integer.MAX_VALUE){
            min = 0;
        }

        System.out.println(min);
    }
}