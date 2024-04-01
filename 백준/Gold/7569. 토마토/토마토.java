import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][][] arr;
    static ArrayList<Integer> listX;
    static ArrayList<Integer> listY;
    static ArrayList<Integer> listZ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        arr = new int[n][m][h];
        listX = new ArrayList<>();
        listY = new ArrayList<>();
        listZ = new ArrayList<>();

        for(int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) {
                        listX.add(i);
                        listY.add(j);
                        listZ.add(k);
                    }
                    arr[i][j][k] = temp;
                }
            }
        }

        br.close();

        int result = search();

        boolean allfine = true;
        loop:
        for(int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j][k]==0){
                        allfine = false;
                        break loop;
                    }
                }
            }
        }
        if(allfine){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }

    }

    public static int search() {

        List<Integer> xq = new ArrayList<>();
        List<Integer> yq = new ArrayList<>();
        List<Integer> zq = new ArrayList<>();

        List<Integer> nextX;
        List<Integer> nextY;
        List<Integer> nextZ;


        for (int x : listX) {
            xq.add(x);
        }
        for (int y : listY) {
            yq.add(y);
        }
        for(int z : listZ){
            zq.add(z);
        }

        int count = -1;

        while (!xq.isEmpty() && !yq.isEmpty()&& !zq.isEmpty()) {
            count++;

            int i = 0;

            nextX = new ArrayList<>();
            nextY = new ArrayList<>();
            nextZ = new ArrayList<>();

            while (i < xq.size()) {

                int x = xq.get(i);
                int y = yq.get(i);
                int z = zq.get(i);

                if (x + 1 < arr.length && arr[x + 1][y][z] == 0) {
                    nextX.add(x + 1);
                    nextY.add(y);
                    nextZ.add(z);
                    arr[x + 1][y][z] = 1;
                }

                if (x - 1 >= 0 && arr[x - 1][y][z] == 0) {
                    nextX.add(x - 1);
                    nextY.add(y);
                    nextZ.add(z);
                    arr[x - 1][y][z] = 1;
                }

                if (y + 1 < arr[0].length && arr[x][y + 1][z] == 0) {
                    nextX.add(x);
                    nextY.add(y + 1);
                    nextZ.add(z);
                    arr[x][y + 1][z] = 1;
                }

                if (y - 1 >= 0 && arr[x][y - 1][z] == 0) {
                    nextX.add(x);
                    nextY.add(y - 1);
                    nextZ.add(z);
                    arr[x][y - 1][z] = 1;
                }

                if (z - 1 >= 0 && arr[x][y][z-1] == 0) {
                    nextX.add(x);
                    nextY.add(y);
                    nextZ.add(z-1);
                    arr[x][y][z-1] = 1;
                }

                if (z+1<arr[0][0].length && arr[x][y][z+1] == 0) {
                    nextX.add(x);
                    nextY.add(y);
                    nextZ.add(z+1);
                    arr[x][y][z+1] = 1;
                }

                i++;
            }

            xq = nextX;
            yq = nextY;
            zq = nextZ;

        }

        return count;


    }
}