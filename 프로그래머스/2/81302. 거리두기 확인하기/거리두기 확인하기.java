import java.util.*;

class Solution {
    
    static char [][] arr;
    
    public int[] solution(String[][] places) {
        int[] answer = new int [places.length];
        
        arr = new char[5][5];
        
        for(int i=0;i<places.length;i++){
            for(int j=0;j<places[i].length;j++){
                for(int k=0;k<places[i][j].length();k++){
                    arr[j][k] = places[i][j].charAt(k);
                    System.out.print(arr[j][k]);
                }
                System.out.println();
            }
            if(travel()){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }

        return answer;
    }
    
    public boolean travel(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(arr[i][j]=='P'){
                    if(!search(i,j,0,'a')){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean search(int x, int y, int depth, char side){
        
        boolean b = true;
        
        if(depth>2){
            return true;
        }
        
        char c = arr[x][y];
        System.out.println(x+","+y+":"+arr[x][y]+" depth:"+depth);
        if(c=='X'){
            return true;//왼쪽에 파티션이 있었으면 거기서 상 좌 하 로 가도 다 괜찮음 -> 아닌가..?
        }
        if(depth!=0&&c=='P'){//아 0일때는 이거 하면 안됨
            return false;//2번까지 파티션이 안 나오고 다른 참가자가 나왔으면 실패임
        }
        
        if(x+1<5&&side!='l'){
            if(!search(x+1,y,depth+1,'r')){
                b = false;
            }
        }
        if(y+1<5&&side!='u'){
            if(!search(x,y+1,depth+1,'d')){
                b = false;
            }
        }
        if(x-1>=0&&side!='r'){
            if(!search(x-1,y,depth+1,'l')){
                b = false;
            }
        }
        if(y-1>=0&&side!='d'){
            if(!search(x,y-1,depth+1,'u')){
                b = false;
            }
        }
        //아 들어온 방향으로 다시 가서 P 만나면 false가 돌아가겠네 이거는 1이 나온게 더 신기한 상황
        
        return b;
        
    }
}