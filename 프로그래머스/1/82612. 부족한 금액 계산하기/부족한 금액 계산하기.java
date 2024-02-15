class Solution {
    public long solution(int price, int money, int count) {
        double halfCount = count/2.0;
        long answer = (long)(price*(1+count)*halfCount)-money;
        if(answer>0){
            return answer;
        }else{
            return 0;
        } 
    }
}