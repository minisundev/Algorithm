import java.util.*;

class Solution {
    boolean [] visit;
    int [][] dp;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        dp = new int[n][n];
        visit = new boolean[n];
        int MAX_VALUE = 200_000_00+1;
        //start-end의 값을 기록한 다음에
        //환승해제지점을 지정해가지고 거기서부터 a까지랑 b까지의 최소비용을 읽어와서 
        //answer = Math.min(환승-a + 환승-b, answer); //맨 처음에
        //answer = Math.min(s-환승지점 + 환승-a + 환승-b, answer); //매번
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) dp[i][j] = 0;
                else dp[i][j] = MAX_VALUE;
            }
        }
        
        /*비용 등록*/
        for(int [] fare : fares){
            int start = fare[0]-1;
            int end = fare[1]-1;
            int cost = fare[2];
            
            dp[start][end] = cost;
            dp[end][start] = cost;
        }
        
        //각 노드에서 출발하기=>도착하기 최솟값 dp 구하기~
        for(int middle = 0; middle < n; middle++){
            for(int from = 0; from < n; from++){
                for(int to = 0; to < n; to++){
                    dp[from][to] = Math.min(dp[from][to], dp[from][middle] + dp[middle][to]);
                }
            }
        }
        
        
        int answer = MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            answer = Math.min(answer, dp[s-1][i] + dp[i][a-1] + dp[i][b-1]);
        }
        
        return answer;
    }
}