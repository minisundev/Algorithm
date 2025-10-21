import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 합승지점을 k라고 하면
        // 총 비용 = s->k 비용 + k->a 비용 + k->b 비용
        // 
        // 근데!!!여기서!!! k->a === a->k 당연하다. 양방향그래프니까.
        // 그러면 경로를 반대로 써도 되므로
        // 정리하자면 총 비용 = s->k + a->k + b->k
        //
        // s,a,b 세 지점에서 각각 다익스트라 돌려서
        // 각 지점으로부터 모든 노드까지의 최단거리를 미리 구해놓고
        // 모든 k를 시도해보면서 최솟값 찾기!
        
        // 그래프는 인접 리스트 방식으로 만들것임
        List<Node>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선등록~~
        for(int[] fare : fares) {
            int from = fare[0] - 1;
            int to = fare[1] - 1;
            int cost = fare[2];
            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        
        /*다익스트라 3회!!*/
        // s->k 최단거리
        int[] sk = dij(graph, n, s - 1);
        
        // a->k 최단거리
        int[] ak = dij(graph, n, a - 1);
        
        // b->k 최단거리
        int[] bk = dij(graph, n, b - 1);
        
        /*모든 k에 대해 시도해보자~! 어느 환승지점이 최소일것인가*/
        int answer = Integer.MAX_VALUE;
        
        for(int k = 0; k < n; k++) {
            // s->k: 같이 타고 감 sk
            // k->a: A 혼자 감 ak
            // k->b: B 혼자 감 bk
            // 
            // 총 비용 = sk + ak + bk
            // 이게 최소가 되는 k를 찾으면 됨!
            int cost = sk[k] + ak[k] + bk[k];
            answer = Math.min(answer, cost);
        }
        
        return answer;
    }
    
    // 옛날 내 스타일 다익스트라!!
    int[] dij(List<Node>[] graph, int n, int start) {
        PriorityQueue<Node> q = new PriorityQueue<>(); // pq를 정의해줌~~
        int[] min = new int[n]; // dist 배열 (start에서 각 노드까지 최단거리)
        boolean[] check = new boolean[n]; // 방문 체크 배열
        
        Arrays.fill(min, Integer.MAX_VALUE); // 무한대로 초기화
        min[start] = 0; // dp 초기값 설정 - 자기 자신은 0
        q.offer(new Node(start, 0)); // 시작 노드를 pq에 등록해줌
        
        while(!q.isEmpty()) {
            Node cur = q.poll(); // 가장 비용 낮은 노드 꺼내기
            
            // 이미 방문했으면 패스 
            if(check[cur.end]) continue;
            check[cur.end] = true; // 방문 체크!
            
            // 현재 노드에서 연결된 모든 노드들 확인
            for(Node node : graph[cur.end]) {
                // 아직 방문 안 한 노드만 처리
                if(!check[node.end]) {
                    // 새로운 경로가 기존보다 짧으면 갱신
                    if(min[cur.end] + node.cost < min[node.end]) {
                        min[node.end] = min[cur.end] + node.cost;
                        // 새로 만들어서 넣는게... 다음으로 탐색할 것과 현재까지의 최소 cost를 넣어주는것!
                        q.offer(new Node(node.end, min[node.end]));
                    }
                }
            }
        }
        
        return min; // start에서 모든 노드까지의 최단거리 반환
    }
}

class Node implements Comparable<Node> {
    int end;
    int cost;
        
    Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
        
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}