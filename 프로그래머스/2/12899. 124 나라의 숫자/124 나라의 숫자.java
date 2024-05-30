import java.util.*;

class Solution {
    public String solution(int n) {
        String s = new String();
        
        if(n==1){
            return "1";
        }
        
        while(n>0){
            n=n-1;
            
            int mod = n%3;
            
            if(mod==0){
                s =  1+s;
                
            }else if(mod==1){
               s = 2+s;
                
            }else if(mod==2){
                s = 4+s;
            }
            
            n=n/3;
        } 
        
        return s;
    }
}