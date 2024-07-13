import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        int count = 0;
        int x = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            if(set.contains(x-arr[i])) count++;
        }

        System.out.println(count/2);
    }    
}