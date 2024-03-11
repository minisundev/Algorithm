import java.io.*;
import java.util.*;

public class Main {

    static int [] arr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        br.close();

       Arrays.sort(arr);

       int sum = 0;
       for(int i=n-1;i>=0;i--){
           sum += arr[i]*(n-i);
       }

       System.out.println(sum);
    }
}