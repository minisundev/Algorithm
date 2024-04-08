import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }
        System.out.println(sb.toString());
    }

    private static int lowerBound(int[] arr, int key) {
        int lowest = 0;
        int highest = arr.length;

        while (lowest < highest) {

            int mid = (lowest + highest) / 2;

            if (key <= arr[mid]) {
                highest = mid;
            } else {
                lowest = mid + 1;
            }
        }

        return lowest;
    }

    private static int upperBound(int[] arr, int key) {
        int lowest = 0;
        int highest = arr.length;

        while (lowest < highest) {

            int mid = (lowest + highest) / 2;

            if (key < arr[mid]) {
                highest = mid;
            } else {
                lowest = mid + 1;
            }
        }

        return lowest;
    }
}