import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int max = 0;
        int [][] books = new int [book_time.length][2];
        for(int i=0;i<books.length;i++){
            int start = getTime(book_time[i][0]);
            int end = increaseTenMins(getTime(book_time[i][1]));
            books[i][0] = start;
            books[i][1] = end;
        }

        for(int i=0;i<books.length;i++){
            int occupy = 1;
            int start = books[i][0];
            int end = books[i][1];
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int j=i+1;j<book_time.length;j++){
                int from = books[j][0];
                int to = books[j][1];
                if(coexist(start,end,from,to)){//동시에 돌고있음
                    occupy++; 
                    list.add(j);
                }
            }
            for(int j = 0; j<list.size();j++){
                for(int k=j+1; k<list.size();k++){
                    if(!coexist(books[list.get(j)][0],books[list.get(j)][1],books[list.get(k)][0],books[list.get(k)][1])){
                        occupy--;
                    }
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