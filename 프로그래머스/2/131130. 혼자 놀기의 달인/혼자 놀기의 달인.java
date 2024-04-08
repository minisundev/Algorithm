import java.util.*;

class Solution {
    
    int [] boxes;
    boolean [] visit;
    boolean [] secondvisit;
    int result = 0;
    
    public int solution(int[] cards) {
        boxes = cards;
        visit = new boolean[cards.length];
        secondvisit = new boolean[cards.length];
        
        int max = 0;
        int secondmax = 0;
        
        for(int i=0;i<visit.length;i++){
          
            result = 0;
            if(!visit[i]){
                search(i,0);
                if(max<result){
                    int temp = max;
                    max = result;
                    secondmax = temp;
                    
                }else if(secondmax<result){
                    secondmax = result;
                }
            }
        }
        return max*secondmax;
    }
    
    void search(int i, int count){
        if(visit[i]){
            return;
        }
        
        visit[i] = true;
        
        if(!visit[boxes[i]-1]){
            search(boxes[i]-1,count+1);
        }else{
            result = count+1;
            return;
        }
    }
}