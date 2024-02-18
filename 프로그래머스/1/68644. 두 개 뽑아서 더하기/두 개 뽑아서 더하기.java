import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> sums = new ArrayList<Integer>();
        

        for(int i =0;i<numbers.length-1;i++){
            for(int j = i+1;j<numbers.length;j++){

                    boolean contains = false;
                    for(int k=0;k<sums.size();k++){
                        if(sums.get(k)==(numbers[i]+numbers[j])){
                        contains = true;
                        }          
                    }
                    if(!contains){
                    sums.add(numbers[i]+numbers[j]);
                    }
            }
        }
        //sum 등록 끝
        Collections.sort(sums);
        int[] answer = new int[sums.size()];
        for(int i =0; i < answer.length;i++){
            answer[i] = sums.get(i);
        }
        return answer;
    }
}