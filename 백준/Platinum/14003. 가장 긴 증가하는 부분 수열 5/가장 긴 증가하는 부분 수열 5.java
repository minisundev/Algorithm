import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] LIS = new int[n];
        int[] index = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = 0;

        for (int i = 0; i < n; i++) {
            int key = arr[i];
            if (length == 0 || LIS[length - 1] < key) {
                LIS[length] = key;
                index[i] = length;
                length++;
            } else {
                int low = 0;
                int high = length - 1;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (LIS[mid] >= key) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                LIS[low] = key;
                index[i] = low;
            }
        }

        System.out.println(length);

        List<Integer> list = new ArrayList<>();
        int target = length - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (index[i] == target) {
                target--;
                list.add(arr[i]);
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}