import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(String s: spell){
            map.put(s.charAt(0),0);
        }
        
        boolean exist = false;

        for(String s: dic){
            int existCount = 0;
            for(int i=0;i<s.length();i++){
                int count = map.getOrDefault(s.charAt(i),-1);
                if(count>0){
                    continue;
                }else if(count==-1){
                    continue;
                }
                count++;
                map.put(s.charAt(i),count);
                existCount++;
            }
            if(existCount==s.length()&&existCount==spell.length){
                exist = true;
                break;
            }
            for(String sp: spell){
                map.put(sp.charAt(0),0);
            }
        }
      
        if(exist){
            return 1;
        }
        return 2;
    }
}