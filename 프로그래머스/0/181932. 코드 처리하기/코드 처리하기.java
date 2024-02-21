class Solution {
    public String solution(String code) {
        String answer = "";
        boolean mode = false;
        for(int i=0; i<code.length();i++){
            char c = code.charAt(i);
            if(mode){
                if(c=='1'){
                    mode = false;
                }else{
                    if(i%2==1){
                        answer  = answer+c;
                    }
                }
            }else{
                if(c=='1'){
                    mode = true;
                }else{
                    if(i%2==0){
                        answer = answer+c;
                    }
                }
            }
        }
        if(answer.equals("")){
            answer = "EMPTY";
        }
        return answer;
    }
}