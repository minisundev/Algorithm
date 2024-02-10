import java.lang.Math;
class Solution {
    public String solution(String s) {
        String [] array = s.split(" ");
        int max = Integer.parseInt(array[0]);
        int min = Integer.parseInt(array[0]);
        for(String str : array){
            max = Math.max(Integer.parseInt(str),max);
            min = Math.min(Integer.parseInt(str),min);
        }
        String answer = min +" "+ max;
        return answer;
    }
}