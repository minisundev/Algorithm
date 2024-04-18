import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];
        int [] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result[0] = arr[0];
        int length = 1;

        for(int i=1; i<n; i++){

            int key = arr[i];

            if(result[length-1]<key){
                length++;
                result[length-1] = key;
            }else {
                int low = 0;
                int high = length;
                while (low < high) {
                    int mid = (low + high) / 2;

                    if (result[mid] < key) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                result[low] = key;
            }
        }
        System.out.println(length);
    }
}