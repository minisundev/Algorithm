import java.util.*;

class Solution {
        
    public int[] solution(int n, long k) {
        
        int [] count = new int[n];
        long f = fact(n);
        k--;//0 based로 만들어줌
        
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        
        for(int i=n-1; i>=0; i--){
            
            f = f/(i+1);
            int index = (int)(k/f);//k/(n-1)! -> 0 based
            count[count.length - 1 - i] = list.get(index);
            list.remove(index);
            k = k%f;
        }
        
        return count;
    }
    
    long fact(int n){
        long result = 1;
        for(int i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }
}