class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0); 
        int yesX = 0;
        int noX = 0;
        boolean first = true;
        for(int i = 0; i<s.length();i++){
            if(first == true){
                x = s.charAt(i); 
                first = false;
            }
            if(s.charAt(i)==x){
                yesX++;
            }else{
                noX++;
            }
            if(yesX==noX){
                if(yesX!=0){
                    answer++;
                    yesX = 0;
                    noX = 0;
                    first = true;;
                }
            }
        }
        if(yesX != noX){
            answer++;
        }

        return answer;
    }
}