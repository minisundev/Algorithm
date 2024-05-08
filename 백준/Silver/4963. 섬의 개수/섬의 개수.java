import java.io.*;
import java.util.*;

public class Main {
    static int [][] arr;
    static boolean [][] visit;
    static int count;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        while(true){
            int h = sc.nextInt();
            int w = sc.nextInt();

            if(w==0 && h==0){
                return;
            }

            arr = new int [w][h];
            visit = new boolean[w][h];

            for(int j=0; j<w; j++){
                for(int i=0; i<h; i++){
                    arr[j][i] = sc.nextInt();
                }
            }

            count = 0;

            for(int i=0;i<arr.length; i++){//1은 땅
                for(int j=0;j<arr[0].length; j++) {
                    if(arr[i][j]==1&&!visit[i][j]){
                        visit[i][j] = true;
                        search(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }


    }

    //대각선도 움직일 수 있음
    static int [][] ds = {{1,0},{-1,0},{0,1},{0,-1}
            ,{1,1}//북동
            ,{1,-1}//남동
            ,{-1,1}//북서
            ,{-1,-1}//남서
    };

    public static void search(int x, int y){//섬의 개수를 알아보자~
        for(int [] direction : ds){
            int X = x + direction[0];
            int Y = y + direction[1];

            if(X>=0&&Y>=0&&X<arr.length&&Y<arr[0].length&&!visit[X][Y]&&arr[X][Y]==1){
                visit[X][Y] = true;
                search(X,Y);
            }
        }
    }
}