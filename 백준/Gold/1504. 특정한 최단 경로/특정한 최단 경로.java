import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Node>[] nodes;
    static boolean[] visit;
    static int[][] dp; // Change dp to a 2D array to store distances for each combination of vertices

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // Number of vertices
        int m = Integer.parseInt(st.nextToken()); // Number of edges

        nodes = new ArrayList[n];
        visit = new boolean[n];
        dp = new int[n][n]; // Initialize the 2D array

        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
            Arrays.fill(dp[i], Integer.MAX_VALUE); // Initialize distances with infinity
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int charge = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, charge));
            nodes[to].add(new Node(from, charge));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken()) - 1;
        int v = Integer.parseInt(st.nextToken()) - 1;

        // Call Dijkstra's algorithm for each pair of vertices
        int zeroU = search(0, u);
        int zeroV = search(0, v);
        int uV = search(u, v);
        int vN = search(v, n - 1);
        int uN = search(u, n - 1);

        // Check for invalid paths
        if (zeroU == Integer.MAX_VALUE || zeroV == Integer.MAX_VALUE || uV == Integer.MAX_VALUE || vN == Integer.MAX_VALUE || uN == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        // Calculate the shortest path considering the required vertices
        int result = zeroU + uV + vN;
        result = Math.min(result, zeroV + uV + uN);
        System.out.println(result);
    }

    public static int search(int from, int to) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(from, 0));
        dp[from][from] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int currentVertex = now.end;
            if (visit[currentVertex]) continue;
            visit[currentVertex] = true;

            for (Node next : nodes[currentVertex]) {
                int nextVertex = next.end;
                int newCost = dp[from][currentVertex] + next.cost;
                if (newCost < dp[from][nextVertex]) {
                    dp[from][nextVertex] = newCost;
                    q.offer(new Node(nextVertex, newCost));
                }
            }
        }
        int shortestDistance = dp[from][to];
        resetVisitArray(); // Reset visit array for the next Dijkstra's execution
        return shortestDistance;
    }

    public static void resetVisitArray() {
        Arrays.fill(visit, false);
    }
}

class Node implements Comparable<Node> {

    public int end;
    public int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}