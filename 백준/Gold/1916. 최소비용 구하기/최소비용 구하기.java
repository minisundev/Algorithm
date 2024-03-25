import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static ArrayList<Node> [] nodes;
    static boolean [] visit;
    static int [] mincost;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//노드 개수
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());//간선 개수


        nodes = new ArrayList [n]; //new ArrayList<Integer> []이 아님에 주의!
        visit = new boolean[n];
        mincost = new int[n];

        for(int i=0;i<n;i++){
            nodes[i] = new ArrayList<>();
            mincost[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to,cost));
        }
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken())-1;
        int to = Integer.parseInt(st.nextToken())-1;

        dij(from,to);

        System.out.println(mincost[to]);

    }

    public static void dij(int start, int end){
        PriorityQueue<Node> q = new PriorityQueue<>();
        mincost[start] = 0;
        q.offer(new Node(start,0));

        while(!q.isEmpty()){
            Node now = q.poll();
            visit[now.to] = true;
            if(now.to==end){
                return;
            }
            for(Node next : nodes[now.to]){
                if (!visit[next.to]){//기존에 방문을 이미 했으면 제외
                    if (mincost[now.to] + next.cost < mincost[next.to]){
                        mincost[next.to] = mincost[now.to] + next.cost;
                        q.offer(new Node(next.to, mincost[next.to]));
                    }
                }
            }
        }
    }

}

class Node implements Comparable<Node> {
    public int to;
    public int cost;


    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }

    public Node(int end, int charge){
        this.to = end;
        this.cost = charge;
    }
}
