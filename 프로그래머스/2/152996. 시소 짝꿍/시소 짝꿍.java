import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer,Long> values = new HashMap<>();
        Map<Integer,Long> origins = new HashMap<>();
        
        for(int i=0;i<weights.length;i++){
            int element = weights[i];
            long count = 0;
            count = origins.getOrDefault(element,0L);
            count++;
            origins.put(element,count);
            
            count = values.getOrDefault(element*2,0L);
            count++;
            values.put(element*2,count);
            
            count = values.getOrDefault(element*3,0L);
            count++;
            values.put(element*3,count);
            
            count = values.getOrDefault(element*4,0L);
            count++;
            values.put(element*4,count);
        }
        
        List<Map.Entry<Integer,Long>> list = new ArrayList<>(values.entrySet());
        
        for(Map.Entry<Integer,Long> entry : list){
            
            long count = entry.getValue();
            long combination = 0;
            if(count<2){
                continue;
            }else{
                combination = count*(count-1)/2;
            }
            
            answer+=combination;
            
            //System.out.println(entry.getKey()+","+entry.getValue()+":"+combination);
        }
        
        //아예 같은 수인 것 배제
        list = new ArrayList<>(origins.entrySet());
        for(Map.Entry<Integer,Long> entry : list){
            
            long count = entry.getValue();
            long same = 0;
            if(count<2){
                continue;
            }else{
                same = count*(count-1);//(count*(count-1)/2)*2 -> element*2에서 센 경우 *3과 *4 에서 배제
            }
            
            answer-=same;
            
            //System.out.println(entry.getKey()+","+entry.getValue()+"same:"+same);
        }
        
        return answer;
    }
}