import java.io.*;
import java.util.*;

public class Main {

    static int [][] arr;
    static boolean [] checked;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        checked = new boolean[n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            arr[from][to] = 1;
            arr[to][from] = 1;
        }
        int count = 0;

        for(int i=0;i<n;i++){
            if(!checked[i]){
                search(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void search(int n){

        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        checked[n] = true;

        while(!q.isEmpty()) {

            int x = q.poll();

            for(int i=0; i<arr[x].length; i++){
                if(arr[x][i]==1&&!checked[i]){
                    checked[i] = true;
                    q.add(i);
                }
            }
        }
    }
}