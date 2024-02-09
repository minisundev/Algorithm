import java.lang.Math;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int idxA = a;
        int idxB = b;
        
        for(int i = 0; i<n; i++){
            
            if(idxB==idxA){
                break;
            }
            
            answer++;
            idxA = idxA%2==0 ? idxA/2 : (idxA+1)/2;
            idxB = idxB%2==0 ? idxB/2 : (idxB+1)/2;
            
        }

        return answer;
    }
}