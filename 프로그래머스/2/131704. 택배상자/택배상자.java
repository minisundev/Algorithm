import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> second = new Stack<>();
        Stack<Integer> first = new Stack<>();
        
        for(int i=order.length; i>=1; i--){
            first.push(i);
        }
        int index=0;
        while(index<order.length){
            int target = order[index];
            if(!second.isEmpty()&&second.peek()==target){
                second.pop();
                index++;
                answer++;
                continue;
            }else if(first.isEmpty()){
                int element = second.pop();
                if(element==target){
                    index++;
                    answer++;
                    continue;
                }else{
                    break;
                }
            }
            else
            {
                int element = first.pop();
                if(element==target){
                    index++;
                    answer++;
                    continue;
                }else{
                    second.push(element);
                    continue;
                }
            }
        }
        
        return answer;
    }
}