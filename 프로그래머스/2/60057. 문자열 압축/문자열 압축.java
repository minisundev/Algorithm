import java.util.*;

class Solution {
    public int solution(String s) {
        
        
        int answer = s.length();
        
        //약수만큼 돌 수 있네->2번 케이스를 보면 아니잖아...
        for(int size = 1; size<=s.length()/2; size++){
            StringBuilder sb = new StringBuilder();//로그 찍기 좋을듯..
            
            String last = s.substring(0,size);
            int count = 1;
                //마지막에 length가 왜 0이 나오지?
            for(int i = 1; i<=s.length()/size; i++){
                int end = size*(i+1)>=s.length() ? s.length() : size*(i+1);
                String sub = s.substring(size*i,end);
                if(sub.equals(last)){
                    count++;
                }else{
                    if(count>1){//1은 생략함
                        sb.append(count);
                    }
                    sb.append(last);
                    
                    last = sub;
                    count = 1;
                }
            }
            
            //마지막 실행값 넣기
            if(count>1){//1은 생략함
                sb.append(count);
            }
            sb.append(last);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}