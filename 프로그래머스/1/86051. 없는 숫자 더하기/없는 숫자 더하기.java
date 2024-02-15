import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean [] exists = new boolean[10];
        Arrays.fill(exists, false);
        for(int x : numbers){
            exists[x]=true;
        }
        for(int i =0; i<exists.length; i++){
            if(exists[i]==false){
                answer += i;
            }
        }
        return answer;
    }
}