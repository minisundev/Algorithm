import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

class Solution {
    public int solution(int n, int k) {
        
        int answer = 0;
        ArrayList<Long> splits = new ArrayList<>();
        
        //k진수로 변환
        String digitK = toK(n, k);

        // 0으로 쪼개기
        String [] split = digitK.split("0");
        
        //소수인지 확인
        for(int i = 0; i < split.length; i++){
            String s = split[i];
            if(s.equals("")){
                continue;
            }
            long candidate = Long.parseLong(s);
            if(isPrime(candidate)){
                answer++;
            }
        }

        return answer;
    }
    
    //10진수 -> k진수
    public String toK(int n, int k) {
        String digitK = "";
        for (int i = n; i > 0; i = i / k) {
            digitK = i % k + digitK;
        }
        return digitK;
    }
    
    //소수인지 확인
    public boolean isPrime(long number){
        if(number<=1){
            return false;
        }
        
        for (long i = 2; i <= Math.sqrt(number); i++) {
             
            if(number%i==0){
                return false;
            }
            
        }
        
        return true;

    }
}