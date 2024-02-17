class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i =0; i < s.length() ; i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                
            }
            else if((""+c).matches("[a-z]")){
                c += n;
                if(c>122){
                    c -= 122-97+1;
                } 
            }else{
                c += n;
                if(c>90){
                    c -= 90-65+1;
                }   
            }
            answer += ""+c;
        }
        return answer;
    }
}