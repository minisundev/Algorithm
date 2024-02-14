class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        double counts = 0;
        if(b>a){
            counts = (b-a+1)/2.0;
        }else{
            counts = (a-b+1)/2.0;
        }
        answer = (long)((a+b)*counts);
        return answer;
    }
}