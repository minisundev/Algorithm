import java.util.*;

class Solution {
    
    int [][] map;
    boolean [][] visit;
    
    public int solution(int[][] maps) {
        map = maps;
        visit = new boolean[map.length][map[0].length];
        return search();
    }
    
    int [][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    
    int search(){
        int count = 1;
        List<int []> list = new ArrayList<>();
        list.add(new int[]{0,0});
        List<int []> next;
        
        while(!list.isEmpty()){
            next = new ArrayList<>();
            for(int [] i : list){
                for(int [] d : move){
                    int X = i[0]+d[0];
                    int Y = i[1]+d[1];
                    if(X==map.length-1 && Y==map[0].length-1){
                        return count+1;
					}
                    if(X>=0 && X<map.length && Y>=0 && Y<map[0].length && !visit[X][Y] && map[X][Y]==1){
                        visit[X][Y] = true;
                        next.add(new int[]{X,Y});
                    }
                }
            }
            list = next;
            count++;
        }
        
        return -1;        
    }
}