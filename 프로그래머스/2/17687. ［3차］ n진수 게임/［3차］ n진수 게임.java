import java.util.*;

class Solution {
    
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        //차례 계산
        Stack<Integer> stack = new Stack<>();
        int turn = 0;
        int number = 0;
        int tube = 0;
        
        while(tube<t){
            for(int i=number; i>0; i = i/n){
                stack.push(i%n);//1의자리부터 거꾸로 등록 -> stack에 넣어서 똑바로 나옴
            }
            if(number==0){
                stack.push(0);
            }
            while(!stack.isEmpty()){
                int popped = stack.pop();
                if(turn%m==(p-1)){
                     sb.append(convert(popped));
                    tube++;
                    if(tube>=t){
                        break;
                    }
                }
                turn++;
            }
            number++;
        }
        
        return sb.toString();
    }
    
    public String convert(int i){
        if(i>=10){
            char c = (char)('A'+i-10);
            return c+"";
        }else{
            return Integer.toString(i);
        }
    }
}