class Solution {
    public int solution(int[][] info, int maxA, int maxB) {
        int n = info.length; //물건의 개수
        
        Boolean[][][] dp = new Boolean[n + 1][maxA + 1][maxB + 1];
        //[물건 인덱스][a무게][b무게]가 가능한지 여부
        
        //0개를 가졌을때 0,0인거 삽가능
        dp[0][0][0] = true;
        
        //각 물건별로
        for (int i = 1; i <= n; i++) {
            int weightA = info[i-1][0];
            int weightB = info[i-1][1];
            
            //가능한 모든 조합을 구해봄
            for (int w1 = 0; w1 < maxA; w1++) {
                for (int w2 = 0; w2 < maxB; w2++) {
                    //디폴트 세팅중 ...
                    dp[i][w1][w2] = false;
                    
                    //a가 가져가는 경우
                    if (w1 >= weightA && 
                        dp[i-1][w1-weightA][w2] != null && 
                        dp[i-1][w1-weightA][w2]) 
                    {
                        dp[i][w1][w2] = true;
                        continue;
                    }
                    
                    //b가 가져가는 경우
                    if (w2 >= weightB && 
                        dp[i-1][w1][w2-weightB] != null && 
                        dp[i-1][w1][w2-weightB]) {
                        dp[i][w1][w2] = true;
                    }
                }
            }
        }
        
        //최소무게를 찾아보자~~
        int minWeight = Integer.MAX_VALUE;
        
        //모든 무게 조합 확인하기~~
        for (int w1 = 0; w1 <= maxA; w1++) {
            for (int w2 = 0; w2 <= maxB; w2++) {
                //n개의 물건이 다 팔린 상태에서만 확인하기~~
                if (dp[n][w1][w2] != null && dp[n][w1][w2]) {
                    minWeight = Math.min(minWeight, w1);
                }
            }
        }
        
        return minWeight == Integer.MAX_VALUE ? -1 : minWeight;
    }
}