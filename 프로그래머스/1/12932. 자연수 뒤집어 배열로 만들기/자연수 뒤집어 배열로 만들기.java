class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            answer[str.length()-1-i]=Integer.parseInt(""+str.charAt(i));
        }
        return answer;
    }
}