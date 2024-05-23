import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        loop:
        for(int i=0; i<skill_trees.length; i++){
            
            char [] chars = skill_trees[i].toCharArray();
            int learned = -1;
            
            for(char c : chars){
                int seq = indexOf(c,skill);
                
                if(seq!=-1){
                    if(learned+1 == seq){
                        learned++;
                    }else{//그 이외의 모든 경우는 맞지 않다
                        continue loop;
                    }
                }
            }
            
            //무사히 다 돌았다면 문제가 없는 것
            answer++;
        }
        
        return answer;
    }
    
    int indexOf(char target, String s){
        int index = 0;
        for(char c : s.toCharArray()){
            if(c==target){
                return index;
            }
            index++;
        }
        return -1;
    }
}