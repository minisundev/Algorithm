import java.util.*;

class Solution {
    
    static boolean [] visited;
    static int [][] wire;
    
    public int solution(int n, int[][] wires) {
        //wires하나 잡고 그거 없을때로 양쪽 노드로 들어가서 연결된 노드 개수 찾아옴, 해당 간선의 index는 무시하고
        wire = wires;
        
        int diff = n+1;
        visited = new boolean [n];
        
        for(int i=0;i<wires.length;i++){
            
            int from = wires[i][0]-1;
            int to = wires[i][1]-1;
            
            Arrays.fill(visited,false);
            
            int temp1 = search(i,from, 0);
            
            int temp2 = search(i,to, 0);
            int temp = temp1-temp2;
            if(temp<0){
                temp *= -1;
            }
            
            if(temp<diff){
                diff = temp;
            }
        }
        
        for(boolean b : visited){
            if(!b){
                diff = -1;
                break;
            }
        }
        
        return diff;
    }
    
    public int search(int ignore, int node, int count){
        visited[node] = true;
        count++;
        
        for(int i=0;i<wire.length;i++){
            if(i==ignore){
                continue;
            }
            int from = wire[i][0]-1;
            int to = wire[i][1]-1;
            
            if(from == node&&!visited[to]){
                count = search(i,to,count);
            }
            else if(to == node &&!visited[from]){
                count = search(i,from,count);
            }
        }
        
        return count;
        
    }
}