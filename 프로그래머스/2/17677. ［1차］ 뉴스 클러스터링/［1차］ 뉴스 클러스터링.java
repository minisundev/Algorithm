import java.util.*;
import java.lang.Math;

class Solution {
    public int solution(String str1, String str2) {
        
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        Map<String,Integer> union = new HashMap<>();
        Map<String,Integer> intersection = new HashMap<>();
        
        boolean skipped = false;
        char last = Character.toUpperCase(str1.charAt(0));
        for(int i=1; i<str1.length(); i++){
            char now = Character.toUpperCase(str1.charAt(i));
            StringBuilder sb = new StringBuilder();
            
            if(now<'A' || now>'Z' || last<'A' || last>'Z'){
                last = now;
                continue;
            }
            
            sb.append(last);
            sb.append(now);
            
            String s = sb.toString();
            int count = map1.getOrDefault(s,0)+1;
            map1.put(s,count);
            union.put(s,count);
            
            last = now;
        }
        
        last = Character.toUpperCase(str2.charAt(0));
        for(int i=1; i<str2.length(); i++){
            char now = Character.toUpperCase(str2.charAt(i));
            StringBuilder sb = new StringBuilder();
            
            if(now<'A' || now>'Z' || last<'A' || last>'Z'){
                last = now;
                continue;
            }
            
            sb.append(last);
            sb.append(now);
            
            String s = sb.toString();
            int count2 = map2.getOrDefault(s,0)+1;
            map2.put(s,count2);
            int count1 = map1.getOrDefault(s,0);
            union.put(s,union.getOrDefault(s,0)+1);
            intersection.put(s, Math.min(count1,count2));
            
            last = now;
        }
       
        List<Map.Entry<String,Integer>> outer = new ArrayList<>(union.entrySet());
        List<Map.Entry<String,Integer>> inner = new ArrayList<>(intersection.entrySet());

        double total = 0;
        double same = 0;
        
        for(Map.Entry<String,Integer> entry : outer){
            total += entry.getValue();
        }
        
        for(Map.Entry<String,Integer> entry : inner){
            same += entry.getValue();
        }
        
        total = total - same;
        
        double divided;
        
        if(total == 0){
            divided = 1;
        }else{
            divided = same/total;
        }
        
        System.out.println(same+"/"+total);
        
        double result = 65536*divided;
        int answer = (int)result;
        return answer;
        
    }
}