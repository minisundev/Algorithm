import java.io.*;
import java.util.*;

public class Main {

    static int [][] arr;
    static boolean [] checked;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        arr = new int [n+1][n+1];
        checked = new boolean[n+1];

        for(int i=0;i<m;i++){
            String str = scanner.nextLine();
            String [] temp = str.split(" ");
            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);
            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        int count = 0;

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        checked[1] = true;

        while(!q.isEmpty()) {

            int x = q.poll();

            for(int i=0;i<arr[x].length;i++){
                if(arr[x][i]==1){
                    if(!checked[i]){
                        q.add(i);
                        checked[i] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}