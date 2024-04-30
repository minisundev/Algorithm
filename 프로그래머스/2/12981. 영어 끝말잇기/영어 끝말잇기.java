import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> set = new HashSet<>();
        
        int last = 0;
        String lastString = words[0];
        set.add(lastString);
        
        for(int i=1;i<words.length;i++){
            last = i;
            String s = words[i];
            if(s.charAt(0)!=lastString.charAt(lastString.length()-1)){
                break;
            }
            if(set.contains(s)){
                break;
            }
            set.add(s);
            lastString = s;
        }

        int turn;
        int person;
        
        if(last==words.length-1&&lastString.equals(words[words.length-1])){
   
            turn = 0;
            person = 0;
            
        }else{
            person = last%n+1;
            turn = last/n+1;
        }
        
        int [] answer = {person,turn};
        return answer;
    }
}