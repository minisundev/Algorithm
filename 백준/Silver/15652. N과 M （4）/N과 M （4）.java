import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n;
    static int m;

    static StringBuilder s = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        dfs(0);
        System.out.println(s.toString());
    }

    public static void dfs(int depth) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                s.append(arr[i]);
                s.append(' ');
            }
            s.append('\n');
            return;
        }

        int last;
        if(depth==0){
            last = 0;
        }else{
            last = arr[depth-1];
        }

        for (int i = 1; i <= n; i++) {
            if(last<=i){
                arr[depth] = i;
                dfs(depth + 1);
            }
        }
    }
}