import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors; 
import java.util.stream.Stream;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length ==1){
            int [] answer = {-1};
            return answer;
        }
        int min = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        int [] answer = new int[arr.length-1];
        int i=0;
        int j=0;
        while(i<answer.length){
            if(arr[j]==min){
                j++;
                continue;
            }
            answer[i] = arr[j];
            i++;
            j++;
        }
        return answer;
    }
}