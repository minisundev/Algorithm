import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int count = 0;
        int start = 0;

        long [] arr = new long[N+1];

        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for(int i=1; i<=N; i++){
            sum += Long.parseLong(st.nextToken());
            arr[i] = sum;
            while(sum - arr[start]> M && start<arr.length){
                start++;
            }
            if(sum-arr[start]==M){
                count++;
            }
        }

        System.out.println(count);
    }
}