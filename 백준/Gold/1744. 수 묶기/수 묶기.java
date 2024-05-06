import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(br.readLine());
            arr[i] = current;
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;

        boolean minus = false;
        int i = 0;
        while (i < arr.length - 1 && !minus) {//양수
            int element1 = arr[i];
            int element2 = arr[i + 1];
            if (element1 <= 0 || element2 <= 0) {
                minus = true;
                break;
            }
            if (element1 * element2 > element1 + element2) {//곱이 크다면 묶자
                sum += element1 * element2;
            } else {
                sum += element1 + element2;
            }
            i += 2;
        }

        int j = arr.length - 1;
        while (i < j) {//음수는 뒤부터 곱해줌
            int element1 = arr[j];
            int element2 = arr[j - 1];
            if (element1 <= 0 && element2 <= 0) {//음수인 경우에만 곱셈
                sum += element1 * element2;
            } else {//양수인 경우에는 덧셈
                sum += element1 + element2;
            }
            j -= 2;
        }

        if(i==j){
            sum += arr[i];
        }

        System.out.println(sum);
    }
}