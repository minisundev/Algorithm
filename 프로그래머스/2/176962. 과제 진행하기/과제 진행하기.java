import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        
        String[] answer = new String[plans.length];
        
        PriorityQueue<Assignment> pq = new PriorityQueue<>((o1,o2)->o1.time-o2.time);
        PriorityQueue<Assignment> remained = new PriorityQueue<>((o1,o2)->o2.time-o1.time);
        
        for(int i=0; i<plans.length; i++){
            pq.add(new Assignment(toInt(plans[i][1]),plans[i][0],Integer.parseInt(plans[i][2])));
        }
        
        int index = 0;
        Assignment now = pq.poll();
        boolean endPQ = false;
        while(!endPQ){
            
            if(pq.isEmpty()){
                endPQ = true;
                answer[index++] = now.subject;
                continue;
            }

            Assignment next = pq.poll();
            int timediff = timeDiff(now.time,next.time);
            //int diff = timediff - now.cost;
            
            if(timediff - now.cost<0){//다음 것을 실행시작하는데 이번것의 실행시간이 남았으면
                now.cost = now.cost - timediff;
                remained.add(now);
            }else if(timediff - now.cost==0){
                answer[index++] = now.subject;
            }else{//다 실행하고 다음까지 시간이 비면
                answer[index++] = now.subject;
                int diff = diff = timediff - now.cost;
                
                //전의 것 가져와서 실행함
                while(diff>0){
                    
                    if(!remained.isEmpty()){
                        Assignment last = remained.poll();
                        if(last.cost<=diff){
                            diff -= last.cost;
                            answer[index++] = last.subject;
                        }else{
                            last.cost = last.cost-(diff);
                            remained.add(last);
                            break;
                        }
                    }else{
                        diff = 0;
                    }
                }
            }
            
            now = next;
        }
        
        while(!remained.isEmpty()){
            Assignment a = remained.poll();
            answer[index++] = a.subject;
        }
        
        return answer;
    }
    
    public int timeDiff(int i1,int i2){
       int h1 = i1/100;
        int m1 = i1%100;
        int h2 = i2/100;
        int m2 = i2%100;
        
        int hourdiff = h2-h1;
        int mindiff = m2-m1;
        
        return hourdiff*60+mindiff;
        
    }
    
    public int toInt(String s){
        s = s.replace(":","");
        int temp = Integer.parseInt(s);
        return temp;
    }
}

class Assignment{
    public int time;
    public String subject;
    public int cost;
    
    public Assignment(int t,String s,int c){
        time = t;
        subject = s;
        cost = c;
    }
}