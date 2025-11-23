import java.util.*;
import java.lang.Math;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        //무조건 먼 데부터 배달+수거 해와야 먼데는 다시는 안 가가지고 총 움직인 거리가 짧아지는거아냐?
        //배달을 cap만큼 채움 -> 수거를 cap만큼 채움 으로 점점 해가면? 되지 않나~ 
        //회차별 거리 더하기~
        long answer = 0L;
        
        int d_i = n-1;
        int p_i = n-1;
        
        while(d_i>=0 || p_i>=0){
            int give = 0;
            int take = 0;
            while(d_i>=0 && deliveries[d_i]==0){
                d_i--;
            }
            while(p_i>=0 && pickups[p_i]==0){
                p_i--;
            }
            int max = Math.max(d_i+1,p_i+1);
            
            if(d_i>=0 && give + deliveries[d_i] <=cap){
                while(d_i>=0 && give + deliveries[d_i] <=cap){
                    give+=deliveries[d_i];
                    d_i--;
                }
            }
            if(d_i>=0 && give + deliveries[d_i] >cap){
                int diff = cap-give;
                deliveries[d_i] = deliveries[d_i]-diff;
            }
            
            if(p_i>=0 && take + pickups[p_i] <=cap){
                while(p_i>=0 && take + pickups[p_i] <=cap){
                    take+=pickups[p_i];
                    p_i--;
                }
            }
            if(p_i>=0 && take + pickups[p_i] >cap){
                int diff = cap-take;
                pickups[p_i] = pickups[p_i]-diff;
            }
            //System.out.println(p_i+" "+d_i);
            
            answer += max;
        }
        
        
        return answer*2;
    }
}