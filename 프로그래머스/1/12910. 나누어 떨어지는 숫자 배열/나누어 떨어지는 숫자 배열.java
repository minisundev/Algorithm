import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] a, int divisor) {
        int [] arr = {};
        List<Integer> al = new ArrayList<Integer>();
        String str = "";
        for(int i =0; i<a.length;i++){
            if(a[i]%divisor==0){
                al.add(a[i]);
            }
        }
        if(al.size()==0){
            arr = new int[1];
            arr[0]=-1;
        }else{
            Collections.sort(al);
            arr = new int[al.size()];
            for(int i = 0; i < arr.length; i++){
                arr[i] = al.get(i);
            }
        }
        return arr;
    }
}