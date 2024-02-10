class Solution {
    public String solution(String s) {
        
        String answer = "";
        boolean isFirst = true;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' '){
               isFirst = true; 
            }else if(isFirst){
                if(Character.isLowerCase(c)){
                    c = Character.toUpperCase(c);
                }
                isFirst = false;
            }else if(Character.isUpperCase(c)){
                c = Character.toLowerCase(c);    
            }
            answer = answer + c;
        }
   
         return answer;   
    }
}
