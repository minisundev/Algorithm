import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<skill.length(); i++){
            char c = skill.charAt(i);
            map.put(c,i);
        }
        
        loop:
        for(int i=0; i<skill_trees.length; i++){
            
            String s = skill_trees[i];
            int learned = -1;
            
            for(int j=0; j<s.length(); j++){
                
                char c = s.charAt(j);
                int seq = map.getOrDefault(c,-1);
                
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
}