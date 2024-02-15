class Solution {
    public String solution(int n) {
        if(n%2==0){
            return "수박".repeat(n/2);
        }else{
            String answer = "수";
            if(n==1){
                return answer;
            }else{
                return "수박".repeat(n/2) + answer; 
            }
        }
    }
}