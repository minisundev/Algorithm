import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static ArrayList<Integer> listX;
    static ArrayList<Integer> listY;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        listX = new ArrayList<>();
        listY = new ArrayList<>();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    listX.add(i);
                    listY.add(j);
                }
                arr[i][j] = temp;
            }
        }
        br.close();
        answer = search();

        loop:
        for (int[] i : arr) {
            for (int x : i) {
                if (x == 0) {
                    answer = 0;
                    break loop;
                }
            }
        }
        System.out.println(answer - 1);
    }

    public static int search() {

        ArrayList<Integer> xq = new ArrayList<>();
        ArrayList<Integer> yq = new ArrayList<>();

        ArrayList<Integer> nextX;
        ArrayList<Integer> nextY;


        for (int x : listX) {
            xq.add(x);
        }
        for (int y : listY) {
            yq.add(y);
        }

        int count = 0;

        while (!xq.isEmpty() && !yq.isEmpty()) {

            int i = 0;

            nextX = new ArrayList<>();
            nextY = new ArrayList<>();

            while (i < xq.size()) {

                int x = xq.get(i);
                int y = yq.get(i);

                if (x + 1 < arr.length && arr[x + 1][y] == 0) {
                    nextX.add(x + 1);
                    nextY.add(y);
                    arr[x + 1][y] = 1;
                }

                if (x - 1 >= 0 && arr[x - 1][y] == 0) {
                    nextX.add(x - 1);
                    nextY.add(y);
                    arr[x - 1][y] = 1;
                }

                if (y + 1 < arr[0].length && arr[x][y + 1] == 0) {
                    nextX.add(x);
                    nextY.add(y + 1);
                    arr[x][y + 1] = 1;
                }

                if (y - 1 >= 0 && arr[x][y - 1] == 0) {
                    nextX.add(x);
                    nextY.add(y - 1);
                    arr[x][y - 1] = 1;
                }

                i++;
            }

            xq = nextX;
            yq = nextY;
            count++;

        }

        return count;

    }
}