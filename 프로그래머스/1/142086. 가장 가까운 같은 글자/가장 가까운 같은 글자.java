class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i = 0; i<s.length();i++){
            char target = s.charAt(i);
            for(int j = i-1; j>=-1; j--){
                if(j==-1){
                    answer[i]=j;
                    break;
                }
                if(target == s.charAt(j)){
                    answer[i] = i-j;
                    break;
                }
            }
        }
        return answer;
    }
}