class Solution {
    public int solution(int n) {
        int answer = 0;
        String digit3 = "";
        //3진법으로
        for(int i = n; i>0; i=i/3){
            digit3 = Integer.toString(i%3) +digit3;
        }
        //10진법으로 하는거 안 뒤집고 하는게 더 편하겠음
        for(int i = 1; i<=digit3.length(); i++){
            int place = (int)Math.pow(3, i)/3;
            int value = Integer.parseInt(""+digit3.charAt(i-1));
            answer = answer + place*value;
        }
        return answer;
    }
}