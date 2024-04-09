import java.util.*;

class Solution {
    
    int count;
    
    public int solution(int n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        boolean [] visit = new boolean[n];
        add(n,list);
        
        return count;
    }
    
    public void add(int limit, ArrayList<Integer> list){

        if(limit==list.size()){
            count++;
            return;
        }
        
        boolean [] visit = new boolean [limit+2];
        
        for(int i=0;i<list.size();i++){
            
            int element = list.get(i);
            visit[element]=true;
            int left =  element - (list.size()-i);
            if(left>=0){
                visit[left] = true;
            }
            int right = element + (list.size()-i);
            if(right<limit){
                visit[right]=true;
            }
        }
        
        for(int i=0;i<limit;i++){
            if(visit[i]){
                continue;
            }
            
            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(i);
            add(limit,newList);
        }
    }
}