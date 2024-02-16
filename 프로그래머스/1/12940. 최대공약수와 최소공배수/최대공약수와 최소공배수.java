class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int [2];
        for(int i=n;i>0;i--){
            if(m%i==0 & n%i==0){
                answer[0]=i;
                break;
            }
        }
        for(int i=m;m<2147483647;i++){
            if(i%m==0 & i%n==0){
                answer[1]=i;
                break;
            }
        }
        return answer;
    }
}