import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
        (o1,o2)-> o1-o2);
        pq.add(players.length); //서버 1대는 항상 있는 값
        
        for(int i=0; i<players.length; i++){
            int player = players[i];
            while(!pq.isEmpty()&&pq.peek()<=i-k){
                pq.poll();
            }
            if(player>=m*(pq.size())){
                int remained = player-m*pq.size()+1;
                while(remained>0){
                    remained -= m;
                    pq.add(i);
                    answer++;
                }
                //answer += server-1;
            }
            //System.out.println(i+": player: "+player+" pq.size():"+pq.size()+" answer: "+answer);
        }
        return answer;
    }
}