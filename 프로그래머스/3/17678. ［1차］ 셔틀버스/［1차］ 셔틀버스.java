import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        //"09:00"자리없는데 다 빨리오면 이보다 1분 빨리왔어야 하는것임 "08:59"
        //셔틀의 마지막 호차가 꽉참: 셔틀의 마지막 호차에 탄 마지막 사람보다 1분 빨리 오면 됨
        //셔틀의 마지막 호차가 꽉 차지 않음: 마지막 셔틀 출발시간에 오면 됨  
        // point! ["09:10", "09:09", "08:00"] timetable이 no정렬임
        PriorityQueue<Time> pq = new PriorityQueue<>(
            (o1,o2)->Time.compare(o1,o2)
        );
        
        for(int i=0; i<timetable.length; i++){//crew index
            pq.offer(new Time(timetable[i]));
        }
        
        int count = 0;//다음 차가 몇회차인지! <n
        Time next = new Time("09:00");//다음 차가 언제 출발하는지!
        Time last = pq.peek();//맨 첫사람 시간
        
        while (count < n) {
            int cap = 0;//지금 차에 몇명 탔는지! <=m

            //이번 셔틀에 사람태움
            while (!pq.isEmpty() && Time.compare(pq.peek(), next) <= 0 && cap < m) {
                last = pq.poll();
                cap++;
            }

            //마지막 셔틀이면 답 결정
            if (count == n - 1) {
                Time mytime;
                if (cap < m) { //꽉안참 -> 셔틀 출발 시각
                    mytime = new Time(next);
                } else {       //꽉참 -> 마지막 탑승자보다 1분 빠르게
                    mytime = new Time(last);
                    mytime.minus(1);
                }
                return Time.toString(mytime);
            }

            next.plus(t);
            count++;
        }
        
        return "09:00";
    }
    
    public static class Time{
        public int h;
        public int m;
        public Time(String s){
            int i1 = s.charAt(0)-'0';
            int i2 = s.charAt(1)-'0';
            int i3 = s.charAt(3)-'0';
            int i4 = s.charAt(4)-'0';
            h = i1*10 + i2;
            m = i3*10 + i4;
        }
        
        public Time(Time t){
            h = t.h;
            m = t.m;
        }
        
        public void plus(int i){
            //System.out.print(toString(this)+" plus "+i+" -> ");
            if(m+i>=60){
                h++;
                m = m+i-60;
            }else{
                m = m+i;
            }
            //System.out.println(toString(this));
        }
        
        public void minus(int i){
            //System.out.print(toString(this)+" minus "+i+" -> ");
            if(m-i<0){
                h--;
                m = 60+m-i;
            }else{
                m = m-i;
            }
            //System.out.println(toString(this));
        }
        
        public static int compare(Time t1,Time t2){
            if(t1.h!=t2.h) return t1.h-t2.h;
            return t1.m-t2.m;
        }
        
        public static String toString(Time t){
            StringBuilder sb = new StringBuilder();
            if(t.h>=10){
                sb.append(t.h);
            }else{
                sb.append('0').append(t.h);
            }
            sb.append(':');
            if(t.m>=10){
                sb.append(t.m);
            }else{
                sb.append('0').append(t.m);
            }
            return sb.toString();
        }
    }
}

