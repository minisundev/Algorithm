class Solution {
    public String solution(String s) {
        String answer = "";
        boolean newWord = true;
        boolean uppercase = true;
        for(int i=0;i<s.length();i++){
            if((""+s.charAt(i)).equals(" ")){
                newWord = true;
                uppercase = true;
                answer += " ";
                continue;
            }
            if(uppercase==true){
                answer += (""+s.charAt(i)).toUpperCase();
                uppercase = false;
            }else{
                answer += (""+s.charAt(i)).toLowerCase();
                uppercase = true;    
            }     
        }
        return answer;
    }
}