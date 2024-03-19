import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        HashSet<Integer> times = new HashSet<>();
        int max = 0;
        int [][] books = new int [book_time.length][2];
        
        for(int i=0;i<books.length;i++){
            int start = getTime(book_time[i][0]);
            int end = increaseTenMins(getTime(book_time[i][1]));
            books[i][0] = start;
            books[i][1] = end;
            times.add(start);
            times.add(end);
        }
        
        List<Integer> list = new ArrayList<>(times);
        for(int time : list){
            int occupy = 0;
            for(int i=0;i<books.length;i++){
                int start = books[i][0];
                int end = books[i][1];
                if(start<=time&&time<end){
                    occupy++;
                }
            }
            if(occupy>max){
                max = occupy;
            }
        }

        return max;
    }
    
    public boolean coexist(int start, int end,int from, int to){
        if((end<=from)||(start>=to)){//완전히 바깥에 존재하는 경우
                    return false;
        }
        return true;
    }
    
    public int getTime(String s){
        s = s.replace(":","");
        return Integer.parseInt(s);
    }
    
    public int increaseTenMins(int i){
        if(i>=2350){
            return i;
        }
        int hours = i/100;
        int mins = i%100;
        mins += 10;
        if(mins>=60){
            mins -= 60;
            hours += 1;
        }
        int answer = hours*100+mins;
        return answer;
    }
}