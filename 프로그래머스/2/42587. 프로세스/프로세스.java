import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] p, int location) {
        //등록, 뭐가 몇번째에 실행되었는지 알려면 Map 써야할듯
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Map<Integer,Integer> order = new HashMap<Integer,Integer>();

        Integer [] priorities = new Integer[p.length];
        for(int i = 0; i<p.length; i++){
            map.put(i,p[i]);
            priorities[i] = p[i];
        }
        
        Arrays.sort(priorities, Collections.reverseOrder());
        
        //인덱스
        int idx = 0;
        int count = 1;
        //find process
        //order에 포함됐으면 건너뜀
        while(count<=priorities.length){
            if(order.getOrDefault(idx,-1)==-1){
                if(map.get(idx)>=priorities[count-1]){
                    order.put(idx,count);
                    count++;
                }

            }
            idx = (idx+1)%priorities.length;
        }
        return order.get(location);
    }
}