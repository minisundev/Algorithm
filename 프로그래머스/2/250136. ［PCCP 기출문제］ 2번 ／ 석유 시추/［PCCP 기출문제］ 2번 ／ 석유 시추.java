import java.util.*;
import java.lang.Math;

class Solution {
    //근본부터 잘못되었다...!
    
    boolean [][] visit;
    int [][] map;
    Union [][] memo;
    int max = 0;
    int number = 0;
    
    public int solution(int[][] land) {
        map = land;
        visit = new boolean[land.length][land[0].length];
        memo = new Union[land.length][land[0].length];
        
        //union 만들기 -> 번호 부여해야 할 것 같다
        for(int x = 0; x<land.length; x++){
            for(int y = 0; y<land[0].length; y++){
                if(!visit[x][y] && land[x][y]==1){
                    visit[x][y] = true;
                    int size = 1;
                    number++;
                    Union union = new Union(size,number);
                    memo[x][y] = union;
                    search(x,y,union);
                }
            }
        }
        
        //시추하기
        for(int y = 0; y<land[0].length; y++){
            int sum = 0;
            Set<Integer> exist = new HashSet<>();
            
            for(int x = 0; x<land.length; x++){
                if(memo[x][y]!=null){
                    if(!exist.contains(memo[x][y].number)){
                        exist.add(memo[x][y].number);
                        sum += memo[x][y].size;
                    }
                }
            }
            max = Math.max(max,sum);
        }
        return max;
    }
    
    int[][] diff = {{0,1},{1,0},{0,-1},{-1,0}};
    
    void search(int startx, int starty, Union union){
        Stack<Coord> stack = new Stack();
        stack.push(new Coord(startx,starty));
        
        while(!stack.isEmpty()){
            Coord c = stack.pop();
            int x = c.x;
            int y = c.y;
            
            for(int [] next: diff){
                int X = x+next[0];
                int Y = y+next[1];
                if(X<0||Y<0||X>=map.length||Y>=map[0].length){
                    continue;
                }
                if(!visit[X][Y]&&map[X][Y]==1){
                    visit[X][Y] = true;
                    union.size++;
                    memo[X][Y] = union;
                    stack.push(new Coord(X,Y));
                }
            }
        }
        
    }
}

class Union{
    //visit이 존재하는데 set으로 추가하지 않아도 괜찮을 것 같기도... 객체 주소 공유용으로 Set 대신 Union을 들고다니면 될 것 같아
    public int size = 0;
    public int number;
    public Union(int s, int n){
        this.size = s;
        this.number = n;
    }
}

class Coord{
    int x;
    int y;
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}