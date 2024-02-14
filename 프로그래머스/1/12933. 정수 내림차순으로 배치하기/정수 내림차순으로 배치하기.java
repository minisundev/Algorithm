class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = Long.toString(n);
        long [] arr = new long[s.length()];
        //배열화
        for(int i=0; i<s.length();i++){
            arr[i] = Long.parseLong(""+s.charAt(i));
        }
        //정렬
        int pos;
        long temp;
        for (int i=0; i < arr.length; i++){ 
            pos = i; 
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] > arr[pos]){
                    pos = j;
                }
            }
            temp = arr[pos];            
            arr[pos] = arr[i]; 
            arr[i] = temp; 
        } 
        //String화
        s = "";
        for(int i=0; i<arr.length;i++){
            s = s+arr[i];
        }
        answer = Long.parseLong(s);
        return answer;
    }
}