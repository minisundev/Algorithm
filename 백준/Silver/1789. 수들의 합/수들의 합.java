import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long count = 0;
        long sum = 0;
        long last = 0;
        long diff = 0;

        for(long l = 1; l<=n;l++){
            sum = sum+l;
            if(sum>n){
                last = l-1;
                diff = sum-n;
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}

