import java.io.*;
import java.util.*;

public class Main {

    static int [][] arr;
    static boolean [][] checked;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        arr = new int [n][n];
        checked = new boolean[n][n];

        for(int i=0;i<n;i++){
            String str = scanner.nextLine();
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='1'){
                    arr[i][j]=1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1&&!checked[i][j]){
                    list.add(search(i, j));
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static int search(int n, int m){
        int count = 0;

        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();

        xq.add(n);
        yq.add(m);
        checked[n][m] = true;
        count++;

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
                        count++;
                    }
                }

            nextX = x-1;
            nextY = y;

            if(nextX>=0){
                if(arr[nextX][nextY]==1&&!checked[nextX][nextY]){
                    xq.add(nextX);
                    yq.add(nextY);
                    checked[nextX][nextY] = true;
                    count++;
                }
            }

            nextX = x;
            nextY = y+1;

            if(nextY<arr.length){
                if(arr[nextX][nextY]==1&&!checked[nextX][nextY]){
                    xq.add(nextX);
                    yq.add(nextY);
                    checked[nextX][nextY] = true;
                    count++;
                }
            }

            nextX = x;
            nextY = y-1;

            if(nextY>=0){
                if(arr[nextX][nextY]==1&&!checked[nextX][nextY]){
                    xq.add(nextX);
                    yq.add(nextY);
                    checked[nextX][nextY] = true;
                    count++;
                }
            }

        }

        return count;
    }
}