import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        HashMap<Integer, Integer> sizeCount = new HashMap<>();
        
        for(int i : tangerine){
            int count = sizeCount.getOrDefault(i,0);
            count++;
            sizeCount.put(i,count);
        }
        
        ArrayList<Integer> entryList = new ArrayList<>(sizeCount.values());
        entryList.sort((o1,o2) -> o2 - o1);
        
        int full = 0;
        int answer = 0;
        
        for(Integer entry : entryList){
            
            if(full>=k){
                break;
            }
            full = full + entry;
            answer++;
            
        }
        
        
        return answer;
    }
}