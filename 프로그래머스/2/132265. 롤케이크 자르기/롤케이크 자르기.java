import java.util.*;

class Solution {
    Map<Integer,Integer> map1 = new HashMap<>();
    Map<Integer,Integer> map2 = new HashMap<>();
    
    int count1 = 0;
    int count2 = 0;
    
    public int solution(int[] topping) {
        int answer = 0;
        //초기화
        int slice = 0;
        for(int i : topping){
            int count = map2.getOrDefault(i,0);
            map2.put(i,count+1);
            if(count==0){
                count2++;
            }
        }
        
        for(int i : topping){
            int temp1 = map1.getOrDefault(i,0);
            map1.put(i,temp1+1);
            if(temp1==0){
                count1++;
            }
            
            int temp2 = map2.getOrDefault(i,0);
            temp2--;
            map2.put(i,temp2);
            if(temp2==0){
                count2--;
            }
            
            if(count1==count2){
                answer++;
            }
            
        }
        
        return answer;
    }
}