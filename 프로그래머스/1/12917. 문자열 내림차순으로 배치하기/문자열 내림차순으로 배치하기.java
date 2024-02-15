import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(String s) {
        char [] charArr = s.toCharArray();
        Integer [] intArr = new Integer[charArr.length];
        for(int i=0; i<charArr.length;i++){
            intArr[i] = (int)charArr[i];
        }
        Arrays.sort(intArr,Collections.reverseOrder());
        String answer = "";
        for(int i=0; i<charArr.length;i++){
            charArr[i] = (char)(intArr[i].intValue());
        }
        return new String(charArr);
    }
}