import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;

public class Main {
    static char [][] arr;
    static boolean [][] visit;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visit = new boolean[R][C];

        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                arr[i][j] = s.charAt(j);
            }
        }

        visit[0][0] = true;
        search(0,0,""+arr[0][0]);
        System.out.println(max);
    }

    static int [][] ds = {{1,0},{-1,0},{0,-1},{0,1}};

    static void search(int x, int y, String s){
        max = Math.max(max,s.length());

        for(int i=0; i<ds.length;i++){
            int [] d = ds[i];
            int X = x+d[0];
            int Y = y+d[1];
            if(X>=0 && X<arr.length && Y>=0 && Y<arr[0].length){
                char c = arr[X][Y];
                if(!visit[X][Y] && s.indexOf(c)==-1){
                    visit[X][Y] = true;
                    search(X,Y,s+c);
                    visit[X][Y] = false;
                }
            }
        }
    }
}