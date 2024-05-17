import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    static int minCost = Integer.MAX_VALUE;
    static int N;
    static int [][] arr;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 도시의 개수
        arr = new int [N][N];
        visited = new boolean [N];

        for(int i=0; i< arr.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j< arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //외판원 순회의 최소비용을 출력하래
        //하나의 도시에서 출발해서 다시 그 도시까지 돌아와야 함
        for(int i=0;i<N;i++){
            //visited[i] = true;
            travel(i,i,0,0);
        }

        System.out.println(minCost);

    }

    static void travel(int endpoint, int visit, int depth, int cost){
        if(depth==N && endpoint==visit){
            minCost = Math.min(minCost,cost);
            return;
        }

        for(int i=0; i<N; i++){
            int c = arr[visit][i];
            if( c!=0 && !visited[i] ){
                visited[i] = true;
                travel(endpoint,i,depth+1,cost+c);
                visited[i] = false;
            }
        }
    }
}
