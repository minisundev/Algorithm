import java.lang.Math;
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int width = 0;
        int height = 0;
        
        for(int i=1;i<=Math.sqrt(yellow);i++){
            
            double divDouble = (double)yellow/i;
            int divInt = yellow/i;
            double difference = divDouble - divInt;
            
            if(difference!=0){//약수가 아니면
                continue;
            }
            width = i;
            height = divInt;
            
            int count = 2*(width+2) + 2*height;
            
            if(count == brown){
                break;
            }
        }
        
        int []  answer = {Math.max(height+2, width+2),Math.min(height+2, width+2)};
        return answer;
    }
}