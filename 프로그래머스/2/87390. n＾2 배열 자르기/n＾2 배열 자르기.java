
class Solution {
    public int[] solution(int n, long left, long right) {
        
        int length = (int)(right-left)+1;
        long[] answer = new long[length] ;
        
        for(int i = 0; i<answer.length; i++){
            
            long row = (left+(long)i)/(long)n;
            long col = (left+(long)i)%(long)n;
            if(row>=col){
                answer[i] = row;
            }else{
                answer[i] = col;
            }
            
        }
        
        int[] ans = new int[answer.length] ;
         for(int i = 0; i<answer.length; i++){
            ans[i] = (int)answer[i]+1;
        }   

        return ans;
    }
}