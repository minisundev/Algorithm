import java.io.*;
import java.util.*;

public class Main {

    static int arr [];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());//테케
        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < t; test++) {

            int n = Integer.parseInt(br.readLine());
            arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int target = Integer.parseInt(st.nextToken());
                sb.append(search(target)).append("\n");
            }

        }
        System.out.println(sb);
    }

    static int search(int target){
        int answer = 0;

        int min = 0;
        int max = arr.length-1;

        while(min<=max){
            int mid = (min+max)/2;

            int value = arr[mid];

            if(value<target){
                min = mid+1;
            }else if(value>target){
                max = mid-1;
            }else{//value == target
                return 1;
            }
        }
        return answer;
    }
}