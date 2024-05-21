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
                    if(learned>seq){//나중에 배워야 하는게 먼저 나오면 
                        continue loop;//다음것으로 넘어가기
                    }else{//아니라면 배운 것에 저장하기, 1 차이가 날 때만 저장할 수 있다
                        if(learned+1 == seq){
                            learned++;
                        }else{//하나 건너뛰면 또 넘어감
                            continue loop;
                        }
                    }
                }
            }
            //무사히 다 돌았다면 문제가 없는 것
            answer++;
        }
        
        return answer;
    }
}