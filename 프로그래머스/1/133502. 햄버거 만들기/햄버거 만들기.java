import java.util.LinkedList;
import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<Integer>();
        int answer = 0;
        int [] counts = new int [4];
        for(int i = 0; i<ingredient.length; i++)
        {
            int pos3 = stack.search(3);
            int pos2 = stack.search(2);
            int pos1 = stack.search(1);
            
            if(ingredient[i]==1){
                if(pos3==1){
                    if(pos2==2){
                        if(pos1==3){
                            answer++;
                            stack.pop();
                            stack.pop();
                            stack.pop();
                            continue;
                        }
                    }
                }
            }
            stack.push(new Integer(ingredient[i]));
           
        }
        return answer;
    }
}