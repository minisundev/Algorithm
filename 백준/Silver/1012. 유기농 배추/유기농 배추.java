import java.io.*;
import java.util.*;

public class Main {

    static int [][] arr;
    static boolean [][] checked;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cases = Integer.parseInt(st.nextToken());
        for(int idx = 0; idx<cases; idx++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int [n][m];
            checked = new boolean[n][m];
            int [][] starters = new int [k][2];
            int count = 0;

            for(int i=0;i<k;i++){
                st = new StringTokenizer(br.readLine());
                starters[i][0] = Integer.parseInt(st.nextToken());
                starters[i][1] = Integer.parseInt(st.nextToken());
                arr[starters[i][0]][starters[i][1]] = 1;
            }

            for(int l=0;l<starters.length;l++){
                int i = starters[l][0];
                int j = starters[l][1];
                if(arr[i][j]==1&&!checked[i][j]) {
                    search(i, j);
                    count++;
                }
            }
            list.add(count);
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void search(int n, int m){

        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();

        xq.add(n);
        yq.add(m);
        checked[n][m] = true;

        while(!xq.isEmpty()&&!yq.isEmpty()) {

            int x = xq.poll();
            int y = yq.poll();

                int nextX = x+1;
                int nextY = y;

                if(nextX<arr.length){
                    if(arr[nextX][nextY]==1&&!checked[nextX][nextY]){
                        xq.add(nextX);
                        yq.add(nextY);
                        checked[nextX][nextY] = true;
                    }
                }

            nextX = x-1;
            nextY = y;

            if(nextX>=0){
                if(arr[nextX][nextY]==1&&!checked[nextX][nextY]){
                    xq.add(nextX);
                    yq.add(nextY);
                    checked[nextX][nextY] = true;
                }
            }

            nextX = x;
            nextY = y+1;

            if(nextY<arr[0].length){
                if(arr[nextX][nextY]==1&&!checked[nextX][nextY]){
                    xq.add(nextX);
                    yq.add(nextY);
                    checked[nextX][nextY] = true;
                }
            }

            nextX = x;
            nextY = y-1;

            if(nextY>=0){
                if(arr[nextX][nextY]==1&&!checked[nextX][nextY]){
                    xq.add(nextX);
                    yq.add(nextY);
                    checked[nextX][nextY] = true;
                }
            }

        }
    }
}