import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)-> o2-o1);
        
        for(int i=0;i<enemy.length;i++){
            
            q.add(enemy[i]);
            n = n - enemy[i];
            
            if(n>=0){
                answer++;
            }else{//n-enemy[i]이 0보다 작아졌을 때 나온것 중에 제일 큰 것에 무적권 적용함
                if(k>0){
                    k--;
                    n += q.poll();//나왔던 것중에 제일 큰 것만큼 더하고 현재것 빼줌, i가 temp.index와 같아도 문제 x 
                    if(n>=0){
                        answer++;
                    }
                }
            }
            
            if(n<0&&k<=0){
                break;
            }
   
        }

        return answer;
    }
}