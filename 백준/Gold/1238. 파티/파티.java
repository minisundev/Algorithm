import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static ArrayList<Node> [] nodes;
    static boolean [] visit;
    static int [] way;
    static int [] cost;
    static int [] costback;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//노드 수
        int m = Integer.parseInt(st.nextToken());//간선 수
        int x = Integer.parseInt(st.nextToken())-1;//target

        nodes = new ArrayList[n];
        visit = new boolean[n];
        way = new int [n];
        cost = new int [n];
        costback = new int [n];

        for(int i=0;i<n;i++){
            nodes[i] = new ArrayList<>();
            way[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int charge = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to,charge));
        }

        for(int i=0; i<n; i++){//가장 오래 걸리는 학생의 소요시간을 출력한다.
            if(i==x){
                continue;
            }
            Arrays.fill(way,Integer.MAX_VALUE);
            Arrays.fill(visit,false);
            cost[i] = search(i,x);

            Arrays.fill(way,Integer.MAX_VALUE);
            Arrays.fill(visit,false);
            costback[i] = search(x,i);
        }

        int maxInt = 0;

        for(int i=0;i<n;i++){//가장 오래 걸리는 학생의 소요시간을 출력한다.
            int element = cost[i]+costback[i];
            if(element>maxInt){
                maxInt = element;
            }
        }
        System.out.println(maxInt);
    }

    public static int search(int from, int to){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(from,0));
        way[from] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();
            visit[now.end] = true;

            if(now.end==to){
                return now.cost;
            }

            for(Node next : nodes[now.end]){
                if(!visit[next.end]){
                    if(way[next.end]>way[now.end]+next.cost){
                        way[next.end] = way[now.end]+next.cost;
                        q.offer(new Node(next.end,way[next.end]));//값 변동이 일어날때만 다시 계산하게 q에 넣음
                    }
                }
            }
        }
        return 0;
    }
}

class Node implements Comparable<Node>{

    public int end;
    public int cost;


    public int compareTo(Node o){
        return this.cost - o.cost;
    }

    public Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
}


