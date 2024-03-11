import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int x :queue1){
            sum1 += x;
            q1.add(x);
        }
        for(int x: queue2){
            sum2 += x;
            q2.add(x);
        }
        if(sum1==sum2){
            return 0;
        }
        
        int count=0;
        
        while(count<(queue1.length+queue2.length)*3){
            if(sum1>sum2){
                int x = q1.poll();
                q2.add(x);
                sum1 -= x;
                sum2 += x;
                count++;
            }else if(sum1==sum2){
                return count;
            }else{
                int x = q2.poll();
                q1.add(x);
                sum1 += x;
                sum2 -= x;
                count++;
            }
        }
        
        return -1; 
        
    }
}