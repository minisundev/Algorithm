import java.util.*;
import java.lang.Math;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int node, line, start;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String [] array = temp.split(" ");
        node = Integer.parseInt(array[0]);
        line = Integer.parseInt(array[1]);
        start = Integer.parseInt(array[2]);

        check = new boolean[node+1];
        arr = new int[node+1][node+1];

        for(int i = 0 ; i < line ; i ++) {
            temp = sc.nextLine();
            array = temp.split(" ");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);

            arr[a][b] = arr[b][a] =  1;
        }

        dfs(start);

        sb.append("\n");
        check = new boolean[node+1];

        bfs(start);

        System.out.println(sb);

    }
    public static void dfs(int start) {

        check[start] = true;
        sb.append(start + " ");

        for(int i = 0 ; i <= node ; i++) {
            if(arr[start][i] == 1 && !check[i])
                dfs(i);
        }

    }

    public static void bfs(int start) {
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            sb.append(start + " ");

            for(int i = 1 ; i <= node ; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}