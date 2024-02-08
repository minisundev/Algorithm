import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        int start = 0;

        while(start<progresses.length){
            
            for(int i = start; i<progresses.length; i++){
               progresses[i] = progresses[i]+speeds[i];  
            }
            
            int lastIdx = start-1;
            int startIdx = start;
            boolean allCompleted = true;
            
            for(int i = start; i<progresses.length; i++){
               if(progresses[i]>=100&&allCompleted == true){
                   lastIdx = i;
               }else{
                   allCompleted = false;
                   break;
               }
            }
            
            if(lastIdx>=startIdx){
                list.add(lastIdx-startIdx+1);
                start = lastIdx+1;
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}