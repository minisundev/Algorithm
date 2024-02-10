import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        
        
        String [] toDay = today.split("\\.");
        ArrayList<Integer> delete = new ArrayList<Integer>();
        HashMap<String,Integer> term = new HashMap<String,Integer>();
        
        for(int i=0; i<terms.length; i++){
            String [] temp = terms[i].split(" ");
            term.put(temp[0],Integer.parseInt(temp[1]));    
        }
        
        for(int i=0; i<privacies.length; i++){
            String [] temp = privacies[i].split(" ");//temp[1]==약관 종류,temp[0] 계약 날짜
            String [] theday = temp[0].split("\\.");
            
            int span = term.get(temp[1])*28;
            
            int years = Integer.parseInt(toDay[0])-Integer.parseInt(theday[0]);
            int months = (years*12)+Integer.parseInt(toDay[1])-Integer.parseInt(theday[1]);
            int days = (months*28)+Integer.parseInt(toDay[2])-Integer.parseInt(theday[2]);
            
             if(span-days<=0){
                 delete.add(i+1);
             }  
        }
        
        int[] answer = new int[delete.size()];
        
        for(int i=0;i<delete.size(); i++){
            answer[i] = delete.get(i);
        }

        return answer;
    }
}