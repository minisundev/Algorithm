import java.io.*;
import java.util.*;

public class Main {

    static int [][] arr;
    static int [][] count;

    static Queue<Integer> xq = new LinkedList<>();
    static Queue<Integer> yq = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String [] strarr = str.split(" ");
        int n = Integer.parseInt(strarr[0]);
        int m = Integer.parseInt(strarr[1]);

        arr = new int [n][m];
        count = new int[n][m];

        for(int i=0;i<n;i++){
            str = scanner.nextLine();

            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        int answer = 0;

        xq.add(0);
        yq.add(0);
        count[0][0]=1;

        while(true) {

            int x = xq.poll();
            int y = yq.poll();
            int cnt = count[x][y];
            cnt++;

            if(x==n-1&&y==m-1){
                break;
            }

            if(y+1<arr[x].length){
                if(arr[x][y+1]==1){
                    if(count[x][y+1]==0){
                        xq.add(x);
                        yq.add(y+1);
                        count[x][y+1] = cnt;
                    }
                }

            }

            if(x+1<arr.length){
                if(arr[x+1][y]==1){
                    if(count[x+1][y]==0){
                        xq.add(x+1);
                        yq.add(y);
                        count[x+1][y] = cnt;
                    }
                }

            }

            if(y-1>=0){
                if(arr[x][y-1]==1){
                    if(count[x][y-1]==0){
                        xq.add(x);
                        yq.add(y-1);
                        count[x][y-1] = cnt;
                    }
                }

            }

            if(x-1>=0){
                if(arr[x-1][y]==1){
                    if(count[x-1][y]==0){
                        xq.add(x-1);
                        yq.add(y);
                        count[x-1][y] = cnt;
                    }
                }

            }
        }

        System.out.println(count[n-1][m-1]);

    }

}