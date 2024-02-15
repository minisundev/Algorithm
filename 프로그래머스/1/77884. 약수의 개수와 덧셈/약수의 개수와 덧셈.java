class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i<= right;i++){
            double sqrt = Math.sqrt(i);
            int sqrtInt = (int)sqrt;
            double decimalPart = sqrt-sqrtInt;
            if(decimalPart==0.0){
                answer=answer-i;
                }else{
                answer=answer+i;
            }
        }
        return answer;
    }
}