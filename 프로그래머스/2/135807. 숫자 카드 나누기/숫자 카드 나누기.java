import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        
        //약수 찾기
        for(int j=2;j<=arrayA[0];j++){
            if(arrayA[0]%j==0){
                aList.add(j);
            }
        }
        for(int i : arrayA){
            for(int j=0;j<aList.size();j++){
                if(i%aList.get(j)!=0){
                    aList.remove(j);
                    j--;
                }
            }
        }
        
        //약수 찾기
        for(int j=2;j<=arrayB[0];j++){
            if(arrayB[0]%j==0){
                bList.add(j);
            }
        }
        for(int i : arrayB){
            for(int j=0;j<bList.size();j++){
                if(i%bList.get(j)!=0){
                    bList.remove(j);
                    j--;
                }
            }
        }
        
        //B 나눠보기
        boolean allgood = true;
        int divider = 0;
        for(int i: aList){
            allgood = true;
            for(int j : arrayB){
                if(j%i==0){
                    allgood = false;
                    break;
                }
            }
            if(allgood){
                divider = i;
            }
        }
        if(answer<divider)
                answer = divider;
        //A나눠보기
        allgood = true;
        divider = 0;
        for(int i: bList){
            allgood = true;
            for(int j : arrayA){
                if(j%i==0){
                    allgood = false;
                    break;
                }
            }
            if(allgood){
                divider = i;
            }
        }
        if(answer<divider)
                answer = divider;
        
        return answer;
    }
}