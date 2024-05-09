import java.io.*;
import java.util.*;

public class Main {
    static boolean [][] arr;
    static boolean [] visit;
    static int N;

    static int [][] memoization;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        visit = new boolean[N];
        memoization = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                boolean way = Integer.parseInt(st.nextToken())==0 ? false : true ;
                arr[i][j] = way;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int mid=0;mid<N;mid++){
            for(int start=0;start<N;start++){
                for(int end=0;end<N; end++){
                    if(arr[start][mid] && arr[mid][end]){
                        arr[start][end] = true;
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int result = arr[i][j] ? 1 : 0 ;
                sb.append(result+" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }
}