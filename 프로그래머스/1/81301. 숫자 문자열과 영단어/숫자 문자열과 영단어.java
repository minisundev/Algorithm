class Solution {
    public int solution(String s) {
       
        String answer = "";
        String number = "";
        for(int i=0; i<s.length() ; i++){
            char c = s.charAt(i);

            if((""+c).matches("[0-9]")){
                answer += c;
            }else{
                number += c;
                if(number.equals("zero")){
                    answer += 0;
                    number = "";
                }else if(number.equals("one")){
                    answer += 1;
                    number = "";
                }else if(number.equals("two")){
                    answer += 2;
                    number = "";
                }else if(number.equals("three")){
                    answer += 3;
                    number = "";
                }else if(number.equals("four")){
                    answer += 4;
                    number = "";
                }else if(number.equals("five")){
                    answer += 5;
                    number = "";
                }else if(number.equals("six")){
                    answer += 6;
                    number = "";
                }else if(number.equals("seven")){
                    answer += 7;
                    number = "";
                }else if(number.equals("eight")){
                    answer += 8;
                    number = "";
                }else if(number.equals("nine")){
                    answer += 9;
                    number = "";
                } 
            }  
        }
        return Integer.parseInt(answer);
    }
}