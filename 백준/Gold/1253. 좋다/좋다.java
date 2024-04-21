import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long temp = Long.parseLong(st.nextToken());
            arr[i] = temp;
        }

        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < arr.length; i++) {//합 인덱스
            long target = arr[i];
            int min = 0;
            int max = arr.length-1;
            while (min < max) {
                long sum = arr[min] + arr[max];

                if (sum < target) {
                    min++;
                } else if (sum > target) {
                    max--;
                } else {//sum==target
                    if(min==i){
                        min++;
                    }else if(max==i){
                        max--;
                    }else{
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}