import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int num = n;
        list.add(n);
        while(num!=1){
            if(num%2==0){
                num = num/2;
            }else{
                num = 3*num+1;
            }
            list.add(num);
        }
        int [] answer = new int[list.size()];
        for(int i=0;i< list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}