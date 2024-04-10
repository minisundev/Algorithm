import java.io.*;
import java.util.*;

public class Main {

    static int [][] arr;
    static boolean [][] visit;

    static int h;
    static int count;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new int [n][n];
        visit = new boolean[n][n];

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(min>x){
                    min = x;
                }else if(max<x){
                    max = x;
                }
                arr[i][j] = x;
            }
        }
        for(int H=min; H<=max; H++) {//물의 높이
            count = 0;
            h=H;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    visit[i][j] = false;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j]>=h&&!visit[i][j]){
                        visit[i][j] = true;
                        search(i,j);
                        count++;
                    }
                }
            }
            if(count>maxCount){
                maxCount = count;
            }
        }
        System.out.println(maxCount);
    }

    static int X [] = {1,-1,0,0};
    static int Y [] = {0,0,1,-1};
    public static void search(int x, int y){
        for(int i=0; i<4; i++){
            int nX = x+X[i];
            int nY = y+Y[i];
            if(nX>=0&&nX<arr.length&&nY>=0&&nY<arr[0].length){
                if (arr[nX][nY] >= h && !visit[nX][nY]) {
                    visit[nX][nY] = true;
                    search(nX, nY);
                }
            }
        }
    }
}