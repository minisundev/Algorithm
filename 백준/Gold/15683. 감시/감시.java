import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
* 4 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
* */

public class Main {

    static int [][] arr;
    static int [][] clone;
    static int max = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        clone = new int[n][m];

        for(int i=0; i<n;i++){
            st = new StringTokenizer(scanner.nextLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                clone[i][j] = arr[i][j];
            }
        }
        /* 등록 끝 ~ */
        //상,하,좌,우

        //백트래킹밖에 모르겠으니까 일단 백트래킹으로 풀어봄
        dfs(0, 0,arr);
        System.out.println(min);
    }

    static int [][][] matchWays = {
            {},//0
            {{0},{1},{2},{3}},//1
            {{0,1},{2,3}},//2
            {{0,2},{0,3},{1,2},{1,3}},//3
            {{0,1,2},{0,1,3},{0,2,3},{1,2,3}},//4
            {{0,1,2,3}},//5
    };

    static int [][] ways = {
            {-1,0},//상
            {1,0},//하
            {0,-1},//좌
            {0,1}//우
    };

    static void dfs(int x, int y, int [][] arr) {
        if(y >= arr[0].length) {
            x++;
            y = 0;
        }

        if(x >= arr.length) {
            // 사각지대 계산
            int blindSpot = 0;
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[0].length; j++) {
                    if(arr[i][j] == 0) blindSpot++;
                }
            }
            min = Math.min(min, blindSpot);
            return;
        }

        if(arr[x][y] >= 1 && arr[x][y] <= 5) {

            for(int[] dirs : matchWays[arr[x][y]]) {

                int [][] clone = new int [arr.length][arr[0].length];
                for(int i=0;i< arr.length;i++){
                    for(int j=0;j<arr[0].length;j++){
                        clone[i][j] = arr[i][j];
                    }
                }

                // 감시 영역 체크
                for(int dir : dirs) {
                    markArea(x, y, dir, -1,clone);
                }

                dfs(x, y + 1, clone);

                // 감시 영역 원상복구
                for(int dir : dirs) {
                    markArea(x, y, dir, 0,clone);
                }
            }
        } else {
            dfs(x, y + 1,arr);
        }
    }

    static int markArea(int x, int y, int dir, int mark, int [][] arr) {
        int count = 0;
        int nx = x + ways[dir][0];
        int ny = y + ways[dir][1];

        while(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && arr[nx][ny] != 6) {
            if(arr[nx][ny] <= 0) {
                if(mark == -1) count++;
                arr[nx][ny] = mark;
            }
            nx += ways[dir][0];
            ny += ways[dir][1];
        }
        return count;
    }
}