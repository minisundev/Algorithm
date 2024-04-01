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
            //이전 탐색 저장 : 오픈된 박스 치우기 
            for(int j=0;j<visit.length;j++){
                if(secondvisit[j]){
                    visit[j] = true;
                }
                secondvisit[j] = false;
            }
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
        
        secondvisit[i] = true;
        
        if(!secondvisit[boxes[i]-1]){
            search(boxes[i]-1,count+1);
        }else{
            result = count+1;
            return;
        }
    }
}