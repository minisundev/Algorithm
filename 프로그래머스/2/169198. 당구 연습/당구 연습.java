class Solution {
    int m;
    int n;
    boolean slope1;
    boolean slope2;
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        this.m = m;
        this.n = n;
        
        int [] answer = new int [balls.length];
        //튕기려는 벽으로 좌표반전을 시켜가지고 거기까지의 거리를 구하면 될듯?
        //사방으로 좌표반전 시켜가지고 거리 구해서 그것의 최솟값을 넣어주면 될 듯 하다~
        //꼭짓점에서 튀기는 반전까지 시키면 => 이건 특수케이스로 분류해서 두 점이 모두 이거나 n*x+m*y==n*m 이거나 n*x + (n-y)*m = n*m
        slope1 = slope1(startX,startY);
        slope2 = slope2(startX,startY);
        
        for(int i=0; i<balls.length; i++){
            int [] ball = balls[i];
            int endX = ball[0];
            int endY = ball[1];
            
            answer[i] = min(startX,startY,endX,endY);
            
        }
        
        
        return answer;
    }
    int min(int startX, int startY, int endX, int endY){
        int min = Integer.MAX_VALUE;
        
        if(startX==endX){
            if(startY>endY){
                min = Math.min(min,upFlip(startX,startY,endX,endY));
            }else{
                min = Math.min(min,downFlip(startX,startY,endX,endY));
            }
        }else{
            min = Math.min(min,upFlip(startX,startY,endX,endY));
            min = Math.min(min,downFlip(startX,startY,endX,endY)); 
        }
        
        if(startY==endY){
            if(startX>endX){
                min = Math.min(min,rightFlip(startX,startY,endX,endY));
            }else{
                min = Math.min(min,leftFlip(startX,startY,endX,endY));
            }
        }else{
            min = Math.min(min,leftFlip(startX,startY,endX,endY));
            min = Math.min(min,rightFlip(startX,startY,endX,endY));
        }
        
//         if(slope1 && slope1(endX,endY)){
//             min = Math.min(upperLeftFlip(startX,startY,endX,endY),min);
//             min = Math.min(lowerRightFlip(startX,startY,endX,endY),min);
//         }
        
//         if(slope2 && slope2(endX,endY)){
//             min = Math.min(upperRightFlip(startX,startY,endX,endY),min);
//             min = Math.min(lowerLeftFlip(startX,startY,endX,endY),min);
//         }
            
        return min;
    }
    
    int distance(int startX, int startY, int endX, int endY){
        int dx = Math.abs(startX-endX);
        int dy = Math.abs(startY-endY);
        
        return dx*dx+dy*dy;
    }
    
    int leftFlip(int startX, int startY, int endX, int endY){
        int newX = -endX;
        int newY = endY;
        
        return distance(startX,startY,newX,newY);
    }
    
    int upFlip(int startX, int startY, int endX, int endY){
        int newX = endX;
        int newY = 2*n-endY;
        
        return distance(startX,startY,newX,newY);
    }
    
    int rightFlip(int startX, int startY, int endX, int endY){
        int newX = 2*m-endX;
        int newY = endY;
        return distance(startX,startY,newX,newY);
    }
    
    int downFlip(int startX, int startY, int endX, int endY){
        int newX = endX;
        int newY = -endY;
        return distance(startX,startY,newX,newY);
    }
    
    int upperLeftFlip(int startX, int startY, int endX, int endY){
        int newX = -endX;
        int newY = 2*n-endY;
        return distance(startX,startY,newX,newY);
    }
    
    int upperRightFlip(int startX, int startY, int endX, int endY){
        int newX = 2*m-endX;
        int newY = 2*n-endY;
        return distance(startX,startY,newX,newY);
    }
    
    int lowerLeftFlip(int startX, int startY, int endX, int endY){
        int newX = -endX;
        int newY = -endY;
        return distance(startX,startY,newX,newY);
    }
    
    int lowerRightFlip(int startX, int startY, int endX, int endY){
        int newX = 2*m-endX;
        int newY = -endY;
        return distance(startX,startY,newX,newY);
    }
    //꼭짓점에서 튀기는 반전까지 시키면 => 이건 특수케이스로 분류해서 두 점이 모두 이거나 n*x+m*y==n*m 이거나 n*x + (n-y)*m = n*m
    boolean slope1(int x, int y){//n*x+m*y==n*m
        if(n*x+m*y==n*m) return true;
        return false;
    }
    
    boolean slope2(int x, int y){//n*x + (n-y)*m = n*m
        if(n*x +(n-y)*m == n*m) return true;
        return false;
    }
}