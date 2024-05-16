import java.util.*;

class Solution {
        
    public int[] solution(int[] prices) {
        
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);
        
        for(int i=1; i<prices.length; i++){
            while(!indexStack.isEmpty() && prices[indexStack.peek()] > prices[i])               {
                int index = indexStack.pop();
                prices[index] = i-index;
            }
            indexStack.push(i);
            
        }
        
        while(!indexStack.isEmpty()){
            int index = indexStack.pop();
            prices[index] = prices.length-index-1;
        }
        
        return prices;
    }
}