import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        String[] answer = new String[files.length];
        
        PriorityQueue<File> pq = new PriorityQueue<File>();
        
        for(int i=0;i<files.length;i++){
            
            String s = files[i];
            
            StringBuilder headupper = new StringBuilder();
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            
            boolean isHead = true;
            boolean isNumber = false;
            
            for(int j=0; j<s.length(); j++){
                
                char c = s.charAt(j);
                
                if(!isNumber &&isHead && c-'0'>=0 && c-'9'<=0){
                    isHead = false;
                    isNumber = true;
                    
                }else if(isNumber){
                    if(c<'0'||c>'9'){
                        isNumber = false;
                    }else if(number.length()>5){
                        isNumber = false;
                    }
                }
                
                if(isHead){
                    headupper.append(Character.toUpperCase(c));
                    head.append(c);
                }else if(isNumber){
                    number.append(c);
                }else{//tail
                    tail.append(c);
                }
            }
            
            pq.add(new File(headupper.toString(), head.toString(),number.toString(), tail.toString(),i));
        }
        
        for(int i=0; i<answer.length;i++){
            File file = pq.poll();
            StringBuilder sb = new StringBuilder();
            sb.append(file.headorigin).append(file.number).append(file.tail);
            answer[i] = sb.toString();
        }

        return answer;
    }
}

class File implements Comparable<File>{
    public String head;
    public String headorigin;
    public String number;
    public String tail; //tail을 정렬 기준으로 안 쓰는 거 같은데 출력은 해야함
    public int index;
    
    public File(String h,String ho, String n, String t, int i){
        head = h;
        headorigin = ho;
        number = n;
        tail = t;
        index = i;
    }
    
    public int compareTo(File o2){
        if(!this.head.equals(o2.head)){
            return this.head.compareTo(o2.head);
        }
        
        int thisnumber = Integer.parseInt(this.number);
        int thatnumber = Integer.parseInt(o2.number);
        if(thisnumber!=thatnumber){
            return thisnumber-thatnumber;
        }
        
        return this.index - o2.index;
    }
}