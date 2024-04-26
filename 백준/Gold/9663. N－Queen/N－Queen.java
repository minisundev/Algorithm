import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] col, leftDiagonal, rightDiagonal;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        col = new boolean[n];
        leftDiagonal = new boolean[2 * n - 1];
        rightDiagonal = new boolean[2 * n - 1];
        set(0);
        System.out.println(count);
    }

    public static void set(int depth) {
        if (depth >= n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !leftDiagonal[depth + i] && !rightDiagonal[depth - i + n - 1]) {
                col[i] = true;
                leftDiagonal[depth + i] = true;
                rightDiagonal[depth - i + n - 1] = true;
                arr[depth] = i;
                set(depth + 1);
                col[i] = false;
                leftDiagonal[depth + i] = false;
                rightDiagonal[depth - i + n - 1] = false;
            }
        }
    }
}