class Solution {
    public int solution(int n) {
        
        int nCount = count(n);
        int answer = n+1;
        
        while(true){
            if(count(answer)==nCount){
                break;
            }
            answer++;
        }
        
        return answer;
    }
    
    public int count(int n){
        int cnt = 0;
        for(int i = n; i>0; i= i/2){
            if(i%2==1){
                cnt++;
            }
        }
        return cnt;
    }
}