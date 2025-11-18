import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int [] hit = new int [N+1];
        //그 스테이지에 있는애들 다 전번 넘어왔을테니까 뒤부터 누적합으로 처리해~
        for(int i : stages){
            hit[i-1] = hit[i-1]+1;
        }
        
        PriorityQueue<Rate> pq = new PriorityQueue<>(
        (o1,o2)->{
            if(o2.rate!=o1.rate){
                if(o2.rate-o1.rate>0)return 1;
                if(o2.rate-o1.rate<0)return -1;
            }
            return o1.index-o2.index;
        });
        
        double total = hit[hit.length-1];
        
        for(int i=hit.length-2; i>=0; i--){
            total += hit[i];
            Rate r = new Rate();
            r.index = i;
            if(hit[i]==0){
                r.rate = 0;
            }else{
                r.rate = hit[i]/total;
            }
            pq.offer(r);
        }
        
        int [] answer = new int [N];
        for(int i=0;i<answer.length; i++){
            answer[i] = pq.poll().index+1;
        }
        return answer;
    }
}
class Rate{
    public int index;
    public double rate;
    public Rate(){};
}