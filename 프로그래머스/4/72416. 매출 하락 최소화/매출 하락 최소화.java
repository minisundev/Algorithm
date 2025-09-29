import java.util.*;

class Solution {
    List<Integer>[] children;
    int[] sales;
    int[][] dp;
    
    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        this.sales = sales;
        this.children = new List[n];
        this.dp = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        
        for(int[] link : links) {
            int leader = link[0] - 1;
            int member = link[1] - 1;
            children[leader].add(member);
        }
        
        dfs(0);
        return Math.min(dp[0][0], dp[0][1]);
    }
    
    void dfs(int node) {
        // dp[node][0] = 현재 노드를 선택하지 않았을 때의 최소 비용
        // dp[node][1] = 현재 노드를 선택했을 때의 최소 비용
        
        dp[node][1] = sales[node]; // 현재 노드 선택 시 비용
        dp[node][0] = 0;           // 현재 노드 선택 안할 시 기본 비용
        
        if(children[node].isEmpty()) {
            // 리프 노드인 경우
            return;
        }
        
        // 자식들을 모두 처리
        for(int child : children[node]) {
            dfs(child);
        }
        
        // 현재 노드를 선택한 경우: 자식들은 자유롭게 선택
        for(int child : children[node]) {
            dp[node][1] += Math.min(dp[child][0], dp[child][1]);
        }
        
        // 현재 노드를 선택하지 않은 경우: 자식들 중 최소 한 명은 선택되어야 함
        int sumMin = 0;
        int minIncrease = Integer.MAX_VALUE;
        boolean hasSelectedChild = false;
        
        for(int child : children[node]) {
            int childMin = Math.min(dp[child][0], dp[child][1]);
            sumMin += childMin;
            
            // 자식을 강제로 선택했을 때의 추가 비용
            int increase = dp[child][1] - childMin;
            if(increase <= 0) {
                hasSelectedChild = true;
            } else {
                minIncrease = Math.min(minIncrease, increase);
            }
        }
        
        dp[node][0] = sumMin;
        
        // 만약 어떤 자식도 자연스럽게 선택되지 않았다면
        // 가장 비용이 적게 드는 자식을 강제로 선택
        if(!hasSelectedChild && minIncrease != Integer.MAX_VALUE) {
            dp[node][0] += minIncrease;
        }
    }
}