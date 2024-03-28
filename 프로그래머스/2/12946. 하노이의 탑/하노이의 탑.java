import java.util.*;

class Solution {
    
    ArrayList<Move> list;
    boolean [] way = new boolean[3];
    
    public int[][] solution(int n) {
        
        list = new ArrayList<>();
        move(n,1,3);
        int[][] answer = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            Move m = list.get(i);
            answer[i][0] = m.from;
            answer[i][1] = m.to;
        }
        return answer;
    }
    
    public void move(int number, int from, int to){
        if(number==1){
            list.add(new Move(from,to));
            return;
        }
        int another = another(from,to);
        move(number-1,from,another);//뚜껑빼기
        move(1,from,to);//밑장빼기
        move(number-1,another,to);//뚜껑덮기
        
    }
    
    public int another(int from, int to){
        Arrays.fill(way,false);
        way[from-1] = true;
        way[to-1]= true;
        for(int i=0;i<way.length;i++){
            if(!way[i]){
                return i+1;
            }
        }
        return 0;
    }
}

class Move{
    public int from;
    public int to;
    public Move(int from, int to){
        this.from = from;
        this.to = to;
    }
}