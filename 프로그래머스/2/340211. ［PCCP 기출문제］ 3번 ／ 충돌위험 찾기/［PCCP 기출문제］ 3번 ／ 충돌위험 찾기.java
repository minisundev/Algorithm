import java.util.*;

class Solution {
    int answer = 0;
    List<Point> list = new ArrayList<>();
    
    int max = 0;
    int [][] points;
    int [][] routes;
    
    public int solution(int[][] points, int[][] routes) {
        //point 처음 위치 좌표 +1
        //routes 로봇이 좌표 몇번에서 좌표 몇번으로 가느냐+1
        //x 좌표가 변하는 이동을 y 좌표가 변하는 이동보다 먼저
        this.points = points;
        this.routes = routes;
        
        for(int i=0; i<routes.length; i++){
            list.add(makePoint(i,0));
        }
        
        calculate();
        
        while(!list.isEmpty()){
            move();
            calculate();
        }
        
        return answer;
    }
    
    Point makePoint(int botIdx, int routeIdx){
        if(routeIdx>=routes[0].length-1){
            return null;
        }
        int [] route = routes[botIdx];
       
        int fromIdx = route[routeIdx]-1;
        int toIdx = route[routeIdx+1]-1;
            
        int fromX = points[fromIdx][0]-1;
        int fromY = points[fromIdx][1]-1;
            
        int toX = points[toIdx][0]-1;
        int toY = points[toIdx][1]-1;
            
        return new Point(fromX, fromY, toX, toY,botIdx,routeIdx);
    }
    
    boolean setDestination(Point point) {
        int nextRouteIdx = point.routeIdx + 1;
    
        if(nextRouteIdx >= routes[point.botIdx].length-1) {
            return false;
        }
        
        int[] route = routes[point.botIdx];
        
        int fromIdx = route[nextRouteIdx] - 1;
        int toIdx = route[nextRouteIdx + 1] - 1;
        
        int fromX = points[fromIdx][0] - 1;
        int fromY = points[fromIdx][1] - 1;
        
        int toX = points[toIdx][0] - 1;
        int toY = points[toIdx][1] - 1;
        
        point.routeIdx = nextRouteIdx;
        point.x = fromX;
        point.y = fromY;
        point.toX = toX;
        point.toY = toY;
    
        return true;
    }
    
    void move(){
        for(int i=list.size()-1; i>=0; i--){
            Point p = list.get(i);
            if(p.x!=p.toX){
                p.x = p.x + (p.toX-p.x)/Math.abs(p.toX-p.x);
            }
            else if(p.y!=p.toY){
                p.y = p.y + (p.toY-p.y)/Math.abs(p.toY-p.y);
            }
            
            if(p.x==p.toX && p.y==p.toY){
                if(p.routeIdx+1 == routes[p.botIdx].length-1){
                    p.routeIdx++;
                    continue;
                }
                if(!setDestination(p)) {
                    list.remove(i);
                }
            }
            }
        }
    
    
    void calculate(){
        Set<String> set = new HashSet<>();
        Set<String> collide = new HashSet<>();
        
       for(Point p : list){
               
            StringBuilder sb = new StringBuilder();
            sb.append(p.x).append(' ').append(p.y);
            String location = sb.toString();
               
            if(!collide.contains(location)){
               
            if(set.contains(location)){
                collide.add(location);
            }else{
                set.add(location);
            }
               }
           
           //System.out.println(p.botIdx+": "+p.x+","+p.y);
        } 
        
        answer += collide.size();
    }
    
}
class Point{
    public int x;
    public int y;
    public int toX;//target
    public int toY;
    public int botIdx;
    public int routeIdx;
    
    public Point(int x, int y, int toX, int toY, int botIdx, int routeIdx){
        this.x = x;
        this.y = y;
        this.toX = toX;
        this.toY = toY;
        this.botIdx = botIdx;
        this.routeIdx = routeIdx;
    }
    
    public Point(){}
}