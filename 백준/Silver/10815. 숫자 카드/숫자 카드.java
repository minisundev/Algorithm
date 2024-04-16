import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//카드의 개수

        int[] arr = new int[n];
        int[] target;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        target = new int[m];
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            target[i] = x;
        }

        Arrays.sort(arr);

        for (int tango : target) {

            int min = 0;
            int max = arr.length - 1;
            int index = -1;

            while (min <= max) {
                int mid = (min + max) / 2;
                if (arr[mid] < tango) {
                    min = mid + 1;
                } else if (arr[mid] > tango) {
                    max = mid - 1;
                } else {//(arr[mid]==m)
                    index = mid;
                    break;
                }
            }

            if (index != -1) {
                System.out.print(1 + " ");

            } else {
                System.out.print(0 + " ");
            }
        }
    }
}