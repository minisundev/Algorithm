import java.util.*;

class Solution {
    
    static int [][] arr;
    static boolean [] visited;
    
    public int solution(int n, int[][] wires) {
        //wires하나 잡고 그거 없을때로 양쪽 노드로 들어가서 연결된 노드 개수 찾아옴, 해당 간선의 index는 무시하고
        arr = new int[n][n];
        
        for(int i=0;i<wires.length;i++){
            int from = wires[i][0];
            int to = wires[i][1];
            arr[from-1][to-1] = 1;
            arr[to-1][from-1] = 1;
        } 
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        
        int diff = n+1;
        visited = new boolean [n];
        
        for(int i=0;i<wires.length;i++){
            
            int from = wires[i][0]-1;
            int to = wires[i][1]-1;
            
            arr[from][to] = 0;
            arr[to][from] = 0;
            
            Arrays.fill(visited,false);
            
            int temp1 = search(from, 0);
            
            int temp2 = search(to, 0);
            int temp = temp1-temp2;
            if(temp<0){
                temp *= -1;
            }
            
            if(temp<diff){
                diff = temp;
            }
            
            arr[from][to] = 1;
            arr[to][from] = 1;
        }
        
        for(boolean b : visited){
            if(!b){
                diff = -1;
                break;
            }
        }
        
        return diff;
    }
    
    public int search(int node, int count){
        visited[node] = true;
        count++;
        
        for(int i=0;i<arr[0].length;i++){
            if(arr[node][i]==1&&!visited[i]){
                count = search(i,count);
            }
        }
        
        return count;
        
    }
}