import java.util.HashMap;
class Solution {
    public String solution(String s, String skip, int index) {
        
        HashMap<String,String> replace = new HashMap<String,String>();
        HashMap<String,String> skips = new HashMap<String,String>();
        
        for(int i = 0; i<skip.length(); i++){
            skips.put(Character.toString(skip.charAt(i)),"0");
        }
        
        for(char c = 'a'; c<='z';c++){
            if(!skips.containsKey(Character.toString(c))){
                char c2 = c;
                int i = 0;
                while(true){
                    if(i>=index){
                        if(!skips.containsKey(Character.toString(c2))){
                            break;
                        }
                    }
                    if(!skips.containsKey(Character.toString(c2))){
                           i++;
                    }
                    
                    c2++;
                    if((int)c2>122){
                        c2 = (char)((int)c2-26);
                    }
                }              
  
                replace.put(Character.toString(c),Character.toString(c2));
                System.out.println( c +" -> "+c2);
            }
        }
        
        String answer = "";
        for(int i=0; i<s.length(); i++){
            answer = answer + replace.get(Character.toString(s.charAt(i)));
        }
        
        return answer;
    }
}