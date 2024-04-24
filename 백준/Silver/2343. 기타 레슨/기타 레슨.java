import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//강의의 수
        int m = Integer.parseInt(st.nextToken());//블루레이의 수
        long[] arr = new long[n];

        long minimum = 0;
        long total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long length = Long.parseLong(st.nextToken());
            total += length;
            arr[i] = length;
            minimum = Math.max(minimum, length);
        }

        long min = minimum;
        long max = total;

        while (min <= max) {
            long size = (min + max) / 2;

            long count = 0;
            long full = 0;
            for (int i = 0; i < arr.length; i++) {
                long element = arr[i];
                if (full + element <= size) {
                    full += element;
                } else {
                    full = element;
                    count++;
                }
            }

            if (full > 0) {
                count++;
            }

            if (count > m) {
                min = size + 1;
            } else {
                max = size - 1;
            }
        }
        System.out.println(min);
    }
}