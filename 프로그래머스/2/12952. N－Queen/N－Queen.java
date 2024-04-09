import java.util.*;

class Solution {
    
    int count;
    int limit;
    int [] arr;
    
    public int solution(int n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        boolean [] visit = new boolean[n];
        arr= new int[n];
        limit = n;
        add(0);
        
        return count;
    }
    
    public void add(int depth){

        if(limit<=depth){
            count++;
            return;
        }
        
        boolean [] visit = new boolean [limit];
        
        for(int i=0;i<depth;i++){
            
            int element = arr[i];
            visit[element]=true;
            //좌대각선 체크
            int diff = depth -i;
            int left =  element - diff;
            if(left>=0){
                visit[left] = true;
            }
            //우대각선 체크
            int right = element + diff;
            if(right<limit){
                visit[right]=true;
            }
        }
        
        for(int i=0;i<limit;i++){
            if(visit[i]){
                continue;
            }
            arr[depth] = i;
            add(depth+1);
        }
    }
}