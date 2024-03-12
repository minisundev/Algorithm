import java.util.*;

class Solution {
    
    static int [][] arr;
    static boolean [][] checked;
    
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        
        arr = new int [maps.length][maps[0].length()];
        checked = new boolean [maps.length][maps[0].length()];
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                char c = maps[i].charAt(j);
                if(c!='X'){
                    arr[i][j] = Integer.parseInt(c+"");
                }
            }
        }
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(!checked[i][j]){
                    int temp = search(i,j,0);
                    if(temp!=0){
                        list.add(temp);
                    }
                }
            }
        }
        
        if(list.size()==0){
            int [] answer = {-1};
            return answer;
        }
        
        Collections.sort(list);
        int [] answer = new int [list.size()];
        for(int i=0;i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int search(int i, int j, int sum){
        checked[i][j] = true;
        sum += arr[i][j];
        
        if(arr[i][j]==0){
            return 0;
        }
        
        if(i-1>=0&&!checked[i-1][j]&&arr[i-1][j]!=0){
            sum = search(i-1,j,sum);
        }
        if(j-1>=0&&!checked[i][j-1]&&arr[i][j-1]!=0){
            sum = search(i,j-1,sum);
        }
        if(i+1<arr.length&&!checked[i+1][j]&&arr[i+1][j]!=0){
            sum = search(i+1,j,sum);
        }
        if(j+1<arr[0].length&&!checked[i][j+1]&&arr[i][j+1]!=0){
            sum = search(i,j+1,sum);
        }
        
        return sum;
    }
}