import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//로프 수

        int [] w = new int[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            w[i] =  Integer.parseInt(st.nextToken());//로프 수
        }

        int max = 0;
        Arrays.sort(w);
        for(int i=0;i<w.length;i++){
            int now = w[i]*(w.length-i);
            if(now>max){
                max = now;
            }
        }

        System.out.println(max);
    }
}