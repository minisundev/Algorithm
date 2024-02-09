import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        for(int i = 0; i<s.length(); i++){
            
            Stack<Character> stack = new Stack<Character>();
            
            String leftout = s.substring(0,i);
            String right = s.substring(i,s.length());
            String pushed = right+leftout;
            
            boolean noReverse = true;
            
            for(int j = 0; j<pushed.length(); j++){
                char c = pushed.charAt(j);
                
                if(c=='('||c=='{'||c=='['||stack.size()==0){
                    stack.push(c);
                }else{
                    char pop = stack.pop();
                    
                    if(c==')'){
                        if(pop!='('){
                            noReverse=false;
                            break;
                        }
                    }else if(c==']'){
                        if(pop!='['){
                            noReverse=false;
                            break;
                        }
                    }else if(c=='}'){
                        if(pop!='{'){
                            noReverse=false;
                            break;
                        }
                    }
                }
            }
            if(noReverse == true && stack.size() == 0){
                answer++;
            }

        }
        return answer;
    }
}