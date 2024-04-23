import java.util.*;

class Solution {
    int target=0;
    int count=0;
    
    public int solution(int n) {
        target = n;
        
        for(int i=1;i<n;i++){
            search(i,0);//i부터 연속으로 더해서 target이 되는지 확인함
        }
        
        return count+1;
    }
    
    public void search(int number,int sum){
        if(number>target){
            return;
        }
        if(sum>target){
            return;
        }
        if(sum == target){
            count++;
            return;
        }
        
        search(number+1,sum+number);
        
    }
    
    
}