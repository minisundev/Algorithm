import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder(s);
        
        int index = 0;
        while(index<sb.length()){
            char now = sb.charAt(index);
            char last = '0';
            if(!stack.isEmpty()){
                last = stack.peek();
            }
            
            if(last==now){
                stack.pop();
            }else{
                stack.push(now);
            }
            index++;
        }
        
        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
        
    }
    
}