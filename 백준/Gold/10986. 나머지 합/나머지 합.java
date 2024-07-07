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

        int mod = 0;
        long [] modulo = new long[M];
        long count = 0;
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            mod = (mod+Integer.parseInt(st.nextToken()))%M;
            modulo[mod]++;
        }

        count += modulo[0];
        for(int i=0; i<M; i++){
            count += modulo[i]*(modulo[i]-1)/2;
        }
        System.out.println(count);
    }
}