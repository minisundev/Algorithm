import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] arr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//노드의 개수

        arr = new List[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        parent = new int[n];
        parent[0] = -1;  // 루트 노드의 부모는 없으므로 -1로 설정
        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(parent[i] + 1).append("\n");  // 1-based index로 출력
        }
        System.out.println(sb);
    }

    // DFS를 사용하여 부모 노드를 기록하는 메서드
    public static void dfs(int cur) {
        for (int next : arr[cur]) {
            if (next != parent[cur]) {
                parent[next] = cur;
                dfs(next);
            }
        }
    }
}