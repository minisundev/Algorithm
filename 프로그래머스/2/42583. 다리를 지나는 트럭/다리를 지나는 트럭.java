import java.util.Stack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int count = 0;
        int presentWeight = 0;
        
        int[] time = new int[truck_weights.length];
        Arrays.fill(time,0);
        
        int next = 0;
        int finished = 0;
        int unloaded = 0;
        
        while(finished<truck_weights.length){
            count++;
            if(next<truck_weights.length){
                if(presentWeight+truck_weights[next]<=weight){
                    presentWeight += truck_weights[next];
                    time[next]++;
                    next++;
                }
            }
            
            for(int i=finished;i<next;i++){//next 포함일 경우에 next++해놔서 맞음
                time[i]++;
                if(time[i]>bridge_length){
                    presentWeight -= truck_weights[i];
                    finished = i+1;
                }
            }
        }
        
        return count+1;
    }
}