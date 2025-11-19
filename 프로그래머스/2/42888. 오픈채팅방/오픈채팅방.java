import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String,String> map = new HashMap<>();
        int change = 0;
        
        for(int i=0; i<record.length; i++){
            String [] arr = record[i].split(" ");
            if(arr[0].equals("Enter")){
                map.put(arr[1],arr[2]);
            }else if(arr[0].equals("Change")){
                map.put(arr[1],arr[2]);
                change++;
            }
        }
        
        String[] answer = new String[record.length-change];
        
        int index = 0;
        for(int i=0; i<record.length; i++){
            StringBuilder sb = new StringBuilder();
            String [] arr = record[i].split(" ");
            if(arr[0].equals("Enter")){
                String nick = map.get(arr[1]);
                sb.append(nick).append("님이 들어왔습니다.");
                answer[index++] = sb.toString();
            }else if(arr[0].equals("Leave")){
                String nick = map.get(arr[1]);
                sb.append(nick).append("님이 나갔습니다.");
                answer[index++] = sb.toString();
            }
            
        }
        
        
        return answer;
    }
}