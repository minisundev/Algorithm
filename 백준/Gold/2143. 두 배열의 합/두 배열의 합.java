import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long T = Long.parseLong(br.readLine());
        long count = 0;
        Map<Long,Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long [] A = new long[N+1];

        for(int i=1; i<=N; i++){
            A[i] = A[i-1] + Long.parseLong(st.nextToken());
            for(int j=0; j<i; j++){
                int cnt = map.getOrDefault(A[i]-A[j],0);
                cnt++;
                map.put(A[i]-A[j],cnt);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long [] B = new long[M+1];

        for(int i=1; i<=M; i++){
            B[i] = B[i-1] + Long.parseLong(st.nextToken());
            for(int j=0; j<i; j++){
                long key = T-(B[i]-B[j]);
                int cnt = map.getOrDefault(key,0);
                count += cnt;
            }
        }

        System.out.println(count);
    }
}