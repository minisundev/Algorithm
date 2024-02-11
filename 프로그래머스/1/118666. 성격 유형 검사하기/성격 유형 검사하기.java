import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String,Integer> mbti = new HashMap<String,Integer>();
        for(int i=0; i<choices.length; i++){
            if(choices[i]<4){
                int value = 4 - choices[i];
                int count = mbti.getOrDefault(""+(survey[i].charAt(0)),0);
                value = count+value;
                mbti.put(""+survey[i].charAt(0),value);
            }else if(choices[i]>4){
                int value = choices[i] - 4;
                int count = mbti.getOrDefault(""+(survey[i].charAt(1)),0);
                value = count+value;
                mbti.put(""+survey[i].charAt(1),value);
            }
        }
        
        String RT = mbti.getOrDefault("R",0)>=mbti.getOrDefault("T",0)? "R": "T";
        String CF = mbti.getOrDefault("C",0)>=mbti.getOrDefault("F",0)? "C": "F";
        String JM = mbti.getOrDefault("J",0)>=mbti.getOrDefault("M",0)? "J": "M";
        String AN = mbti.getOrDefault("A",0)>=mbti.getOrDefault("N",0)? "A": "N";
        
        return RT+CF+JM+AN;
    }
}