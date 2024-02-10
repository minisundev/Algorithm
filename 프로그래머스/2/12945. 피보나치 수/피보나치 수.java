import java.math.BigInteger;

class Solution {
    public int solution(int n) {
        
        int now = 1;
        int before2 = 1;
        int before1 = 1;
        
        for(int i = 0;i<n-2;i++){
            now = (before2+before1)%1234567;
            before2 = before1;
            before1 = now;
            
        }
        
        return now;
    }
}