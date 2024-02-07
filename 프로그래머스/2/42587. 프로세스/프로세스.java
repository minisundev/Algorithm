import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] priorities, int location) {
        //등록, 뭐가 몇번째에 실행되었는지 알려면 Map 써야할듯
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Map<Integer,Integer> order = new HashMap<Integer,Integer>();
        for(int i = 0; i<priorities.length; i++){
            map.put(i,priorities[i]);
        }

        int max = 0;
        //find max
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet()); 
        for(Map.Entry<Integer,Integer> entry : list){
                            
                Integer key = entry.getKey();
                Integer index = entry.getValue();
            
            if(index>max){
                max = index;
            }
        }
        System.out.println("max: "+max);
        
        //인덱스
        int idx = 0;
        int count = 1;
        //find process
        //order에 포함됐으면 건너뜀
        while(idx>=priorities.length){
            if(order.getOrDefault(idx,-1)!=-1){
                if(map.get(idx)>=max){
                    System.out.println("idx: "+idx+" count: "+count);
                    order.put(idx,count);
                    map.remove(idx);
                    count++;
                }
            }
            idx = (idx+1)%priorities.length;
        }
        return order.get(location);
    }
}