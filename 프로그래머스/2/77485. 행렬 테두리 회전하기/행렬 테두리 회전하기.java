class Solution {
    int rows;
    int cols;
    int [][] arr;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        this.rows = rows;
        this.cols = columns;
        arr = new int [rows][columns];
        init();
        
        //회전시키는줄 알았더니 최솟값만 구하면 되면 쏘 이지 아님?
        //해당 인덱스의 원래 값이 무엇인지 계산 -> 해서 테두리 따라 돌리면서 최솟값 보면됨
        //아 아니네... 실제로 수행해야 함 앞에서 한 회전이 뒤에도 영향을 미치고있네
        
        int [] answer = new int [queries.length];
        
        for(int i=0; i<queries.length; i++){
            int [] query = queries[i];
            
            int fromX = query[0]-1;
            int fromY = query[1]-1;
            int toX = query[2]-1;
            int toY = query[3]-1;
            answer[i] = rotate(fromX,toX,fromY,toY);
            
        }
        
        return answer;
    }
    
    int [][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    
    int rotate(int fromX, int toX, int fromY, int toY){
        int min = arr[fromX][fromY];
        int last = arr[fromX+1][fromY];
            
        int x = fromX;
        int y = fromY;
        int way = 0;
        
        while(true){
                
            if(way==move.length) {
                break;
            }
                
            int X = x+move[way][0];
            int Y = y+move[way][1];
                
            if(X<fromX || X>toX ||Y<fromY || Y>toY){
                    //이게 x에다가 fromX를 넣고 들어오자마자 걸리는데 미친거아닌가왜그러지
                way++;
                //System.out.println(x+","+y+" continue");
                continue;
            }
                
            //System.out.println(X+","+Y+" "+arr[X][Y]);
            min = Math.min(min,arr[X][Y]);

            int temp = arr[x][y];
            arr[x][y] = last;
            last = temp;
                
            x = X;
            y = Y;
                
        }
        //System.out.println(x+","+y+" min"+min);
        return min;
    }
    
    int value(int x, int y){
        return cols*x+y+1;
    }
    
    void init(){
        for(int i=0;i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = arr[0].length*i + j + 1;
            }
        }
    }
}