import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long min = 1;
        long max = k;

        //lowerbound
        while(min < max) {
            long mid = (min + max) / 2;
            long count = 0;

            for(int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if(k <= count) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }
}