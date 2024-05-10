import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book,(o1,o2)->o1.length()-o2.length());
        
        Set<String> set = new HashSet<>();
        
        loop:
        for(String number : phone_book){
            for(int i = 1; i<number.length(); i++){
                if(set.contains(number.substring(0,i))){
                    answer = false;
                    break loop;
                }
            }
            set.add(number);
        }
        
        return answer;
    }
}