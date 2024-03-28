import java.util.*;

class Solution {
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int [] index = new int [data.length];
        //초기화
        for(int i=0;i<data.length;i++){
            index[i] = i;
        }
        //읽으면서 순서 변동, 버블 정렬
        for(int i=data.length-1;i>0;i--){
            for(int j = 0; j<i ;j++){
                
                int former = data[index[j]][col-1];
                int latter = data[index[j+1]][col-1];
                
                if(former>latter){//col번째 컬럼의 값을 기준으로 오름차순 정렬
                    swap(index,j+1,j);
                    
                }else if(latter==former){
                    
                    int before = data[index[j]][0];
                    int after = data[index[j+1]][0];
                    
                    if(before<after){//첫 번째 컬럼의 값을 기준으로 내림차순 정렬
                        swap(index,j+1,j);
                    }
                }
            }
        }
        
        //S_i 구하기
        int hash = 0;
        for(int i = row_begin; i<= row_end; i++){
            int idx = index[i-1];
            int S_i = 0;
            for(int j = 0; j< data[0].length; j++){
                S_i += data[idx][j]%i;
            }
            
            hash = hash^S_i;
            
        }
        
        return hash;
    }
    
    public void swap(int [] array , int a, int b){
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}

