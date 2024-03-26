import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static boolean [] visit;
    static int count = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int me = Integer.parseInt(st.nextToken());//내 위치
        int sister = Integer.parseInt(st.nextToken());//동생 위치
        visit = new boolean [100001];

        search(me,sister);
        System.out.println(count);

    }

    public static void search(int start, int end){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));

        while(!q.isEmpty()){
            Node now = q.poll();
            visit[now.value] = true;

            if(now.value==end){
                count = now.count;
                return;
            }

            if(now.value-1>=0&&!visit[now.value-1]){
                q.offer(new Node(now.value-1,now.count+1));

            }

            if(now.value+1<=100000&&!visit[now.value+1]){
                q.offer(new Node(now.value+1,now.count+1));
            }

            if(now.value*2<=100000&&!visit[now.value*2]){
                q.offer(new Node(now.value*2,now.count));
            }
        }
    }
}

class Node implements Comparable<Node> {
    public int value;
    public int count;


    @Override
    public int compareTo(Node o) {
        return this.count-o.count;
    }

    public Node(int v, int c){
        this.value = v;
        this.count = c;
    }
}
