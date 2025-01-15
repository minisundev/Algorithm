class Solution {

    Time start;
    Time end;

    Time zero;
    Time full;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Time time = new Time(pos);
        start = new Time(op_start);
        end = new Time(op_end);
        zero = new Time(0,0);
        full = new Time(video_len);
        
        for(String command : commands){
            move(time,command);
        }

        return padding(time);
    }
    
    String padding(Time time){
        StringBuilder sb = new StringBuilder();
        if(time.m/10==0){
            sb.append("0");
        }
        sb.append(time.m);
        sb.append(":");
        if(time.s/10==0){
            sb.append("0");
        }
        sb.append(time.s);
        return sb.toString();
    }

    void move(Time time, String command){
        //System.out.println(command+ " " + padding(time));
        if(compareTo(start,time)<=0&&compareTo(time,end)<=0){
            time.m = end.m;
            time.s = end.s;
        }
        if(command.equals("next")){
            calculate(time,1);
        }else{//prev
            calculate(time,-1);
        }
    }

    void calculate(Time time, int d){
        time.s = time.s +10*d;
        time.m = time.m;
        if(time.s>=60){
            time.s = time.s-60;
            time.m++;
        }else if(time.s<0){
            time.s = time.s+60;
            time.m--;
        }
        if(compareTo(start,time)<=0&&compareTo(time,end)<=0){
            time.m = end.m;
            time.s = end.s;
            return;
        }
        if(compareTo(time,full)>0){
            time.m = full.m;
            time.s = full.s;
            return;
        }else if(compareTo(zero,time)>=0){
            time.m = zero.m;
            time.s = zero.s;
            return;
        }
        System.out.println("after "+padding(time));
    }

    //t1-t2<0 -> t1<t2
    int compareTo(Time t1, Time t2){
        if(t1.m!=t2.m){
            return t1.m-t2.m;
        }
        return t1.s-t2.s;
    }
}

class Time{
    public int s;
    public int m;
    public Time(int m, int s){
        this.s = s;
        this.m = m;
    }
    public Time(String s){
        String [] arr = s.split(":");
        this.m = Integer.parseInt(arr[0]);
        this.s = Integer.parseInt(arr[1]);
    }
}