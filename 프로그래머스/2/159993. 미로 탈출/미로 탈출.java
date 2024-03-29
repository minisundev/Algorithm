import java.util.*;

class Solution {
    
    char [][] arr;
    boolean [][] visit;
    int lx = 0;
    int ly = 0;
    
    public int solution(String[] maps) {
        
        arr = new char[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        
        int startx = 0;
        int starty = 0;
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                char c = maps[i].charAt(j);
                arr[i][j] = c;
                if(c=='S'){
                    startx = i;
                    starty = j;
                }
            }
        }
        int countL = search(startx,starty,'L');
        System.out.println(countL);
        if(countL==-1){
            return -1;
        }
        
        for(boolean [] b : visit){
            Arrays.fill(b,false);
        }
        
        int countE = search(lx,ly,'E');
        if(countE==-1){
            return -1;
        }
        System.out.println(countE);
        return countL+countE;
    }
    
    public int search(int startx, int starty, char target){
    int count = -1;
    ArrayList<int[]> list = new ArrayList<>();
    ArrayList<int[]> next;
    
    visit[startx][starty] = true;
    list.add(new int[] {startx, starty});
    
    while(!list.isEmpty()){
        next = new ArrayList<>();
        count++;
        
        for(int[] i : list){
            int x = i[0];
            int y = i[1];
            
            if(arr[x][y] == target){
                lx = x;
                ly = y;
                return count;
            }
            
            
            if(x - 1 >= 0 && !visit[x - 1][y] && arr[x - 1][y] != 'X'){
                next.add(new int[] {x - 1, y});
                visit[x - 1][y] = true;
            }
            
            if(x + 1 < arr.length && !visit[x + 1][y] && arr[x + 1][y] != 'X'){
                next.add(new int[] {x + 1, y});
                visit[x + 1][y] = true;
            }
            
            if(y - 1 >= 0 && !visit[x][y - 1] && arr[x][y - 1] != 'X'){
                next.add(new int[] {x, y - 1});
                visit[x][y - 1] = true;
            }
            
            if(y + 1 < arr[0].length && !visit[x][y + 1] && arr[x][y + 1] != 'X'){
                next.add(new int[] {x, y + 1});
                visit[x][y + 1] = true;
            }
        }
        
        list = next;
    }
    
    return -1;
}

}