import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int j = 0; j<=discount.length-10; j++){
            Map<String,Integer> wants = new HashMap<String,Integer>();
            for(int i = 0; i<want.length; i++){
                wants.put(want[i],number[i]);
            }
            for(int i = j; i<j+10; i++){
                Integer count = wants.getOrDefault(discount[i],-1);
                if(count>=0){
                    count--;
                }
                wants.put(discount[i],count);
            }
            boolean allZero = true;
            for(int i = 0; i<want.length; i++){
                if(wants.getOrDefault(want[i],-1)!=0){
                    allZero = false;
                    break;
                }
            }
            if(allZero){
                answer++;
            }
        }
        
        return answer;
    }
}