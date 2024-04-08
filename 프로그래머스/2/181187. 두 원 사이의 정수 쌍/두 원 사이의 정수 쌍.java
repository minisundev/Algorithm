import java.lang.Math;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long l1 = (long)r1;
        long l2 = (long)r2;
        
        for(long x = 1; x <= l2 ; x++){

            long right = (long)Math.floor(Math.sqrt(l2*l2-x*x));
            long left = (long)Math.ceil(Math.sqrt(l1*l1-x*x));
            long number = right-left+1;
            answer += number;
        }
        answer *= 4;
        return answer;
    }
}