import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static List<Node>[] nodes;
    static boolean[] check;
    static int[] min;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());//노드 개수
        int e = Integer.parseInt(st.nextToken());//간선 개수

        nodes = new ArrayList[v];
        check = new boolean[v];

        min = new int[v+1];

        int start = Integer.parseInt(br.readLine())-1;
        for (int i = 0; i < v; i++){
            nodes[i] = new ArrayList<>(); //각 노드마다 연결된 노드를 저장하나봄!
            min[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, cost));
        }

        StringBuilder sb = new StringBuilder();
        dij(start);
        for (int i = 0; i <v; i++){
            if (min[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(min[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dij(int start){
        PriorityQueue<Node> q = new PriorityQueue<>(); //pq를 정의해줌~~
        min[start] = 0; //dp 초기값 설정
        q.offer(new Node(start,0)); //시작 노드를 pq에 등록해줌

        while (!q.isEmpty()){
            Node cur = q.poll();
            check[cur.end] = true;
            for(Node node : nodes[cur.end]){
                if (!check[node.end]){//-> 한번 방문을 했는데 그 다음에 또 방문을 하는 경우는 안 치나?//출발노드를 true로 만들어서 상관 없을듯
                    if (min[cur.end] + node.cost < min[node.end]){
                        min[node.end] = min[cur.end] + node.cost;
                        q.offer(new Node(node.end, min[node.end]));//다음으로 탐색할 것과 현재까지의 최소 cost를 넣어주는것!
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    public int end;
    public int cost;

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}