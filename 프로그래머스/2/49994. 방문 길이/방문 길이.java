import java.util.*;

class Solution {
    boolean [][] v;
    boolean [][] h;
    int max = 5;
    
    public int solution(String dirs) {
        v = new boolean [11][10];
        h = new boolean [10][11];
        Point p = new Point(0,0);
        int answer = 0;
        
        for(int i=0; i<dirs.length(); i++){
            char c = dirs.charAt(i);
            if(move(p,c)){
                answer++;
            }
        }
        
        return answer;
    }
    
    boolean move(Point p, char c){
        boolean result = false;
        int vX = p.x;
        int vY = p.y;
        int hX = p.x;
        int hY = p.y;
        boolean vF = false;
        boolean hF = false;
        
        if(c=='U' && p.y+1<=max){
            p.y = p.y+1;
            vX += 5;
            vY += 5;
            vF = true;
        }else if(c=='D'&& p.y-1>=-max){
            p.y = p.y-1;
            vX += 5;
            vY += 4;
            vF = true;
        }else if(c=='L'&& p.x-1>=-max){
            p.x = p.x-1;
            hY += 5;
            hX += 4;
            hF=true;
        }else if(c=='R'&& p.x+1<=max){
            p.x = p.x+1;
            hY += 5;
            hX += 5;
            hF=true;
        }
        if(vF){
            if(!v[vX][vY]){
                v[vX][vY] = true;
                result = true;
            }
        }
        if(hF){
            if(!h[hX][hY]){
                h[hX][hY] = true;
                result = true;
            }
        }
        return result;
    }
}

class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
