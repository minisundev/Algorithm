import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        Map<String,String> numberAndTime = new HashMap<>();
        Map<String,Integer> numberAndMinutes = new HashMap<>();
        Set<String> cars = new HashSet<>();
        
        for(int i=0; i<records.length; i++){
            String [] split = records[i].split(" ");
            String time = split[0];
            String number = split[1];
            String way = split[2];
            
            
            if(way.equals("IN")){//입차시에 시간과 분을 저장함
                numberAndTime.put(number,time);
                cars.add(number);
            }else{//출차시에 입차기록이 있다면 시간++
                
                String enterTime = numberAndTime.get(number);
                int mins = getTime(enterTime,time);
                int formerMins = numberAndMinutes.getOrDefault(number,0);
                mins += formerMins;
    
                numberAndMinutes.put(number,mins);
                cars.remove(number);
            }
            
        }
        
        //IN만 한거 체크함
        List<String> remained = new ArrayList<>(cars);
        
        for(int i=0; i<remained.size();i++){
            String number = remained.get(i);
            String enterTime = numberAndTime.get(number);
            String time = "23:59";
            
           int mins = getTime(enterTime,time);
           int formerMins = numberAndMinutes.getOrDefault(number,0);
           mins += formerMins;
    
           numberAndMinutes.put(number,mins);
           cars.remove(number);
        }
        
        //number 순으로 정렬
        List<Map.Entry<String,Integer>> entries = new ArrayList<>(numberAndMinutes.entrySet());
        entries.sort((o1,o2)->o1.getKey().compareTo(o2.getKey()));
            
        //number순으로 fee넣음
        int[] answer = new int[entries.size()];
        
        for(int i=0; i<entries.size();i++){
        answer[i] = getFee(entries.get(i).getValue(),fees);
        }
        
        return answer;
    }
    int getTime(String from, String to){
        
        String [] froms = from.split(":");
        String [] tos = to.split(":");
        int hours = Integer.parseInt(tos[0])-Integer.parseInt(froms[0]);
        int minutes = Integer.parseInt(tos[1])-Integer.parseInt(froms[1]);
        minutes += hours*60;
        return minutes;
        
    }
    int getFee(int minutes, int [] fees){
        
        int minTime = fees[0];
        int minFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        int fee = 0;
        if(minutes<=minTime){//기본 시간 이하
            fee = minFee;//기본 요금
        }else{//기본 시간 초과
            fee = minFee;
            minutes = minutes - minTime;//초과한 시간
            
            if(minutes%unitTime==0){
                fee += (minutes/unitTime)*unitFee;
            }else{
                fee += (minutes/unitTime+1)*unitFee;
            }
            
        }
        return fee;
    }
}