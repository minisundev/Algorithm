import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int max = Math.max(k,n-k);
        int min = Math.min(k,n-k);

        int combination = 1;
        for(int i = n; i>max; i--){
            combination *= i;
        }
        for(int i=min; i>=2; i--){
            combination /= i;
        }


        System.out.println(combination);
    }
}
