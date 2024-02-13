import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> count = new HashMap<String,Integer>();
        Map<String,Integer> combination = new HashMap<String,Integer>();
        
        for(int i=0; i< clothes.length;i++){
            int countInt = count.getOrDefault(clothes[i][1],0);
            countInt++;
            count.put(clothes[i][1],countInt);
        }
        
        
        int sum = 1;
        ArrayList<Map.Entry<String, Integer>> sums = new ArrayList<>(count.entrySet());
        for(Map.Entry<String, Integer> entry : sums){
            sum = sum*(entry.getValue()+1);
        }

        return sum-1;
    }
    
}