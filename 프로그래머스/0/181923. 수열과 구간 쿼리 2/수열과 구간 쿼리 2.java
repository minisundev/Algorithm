class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int [] query = queries[i];
            int from = query[0];
            int to = query[1];
            int k = query[2];
            
            int min = Integer.MAX_VALUE;
            
            for(int j = from; j<=to; j++){
                int temp = arr[j];
                if(temp>k&&min>temp){
                    min = temp;
                }
            }
            
            if(min==Integer.MAX_VALUE){
                min = -1;
            }
            
            answer[i] = min;
            
        }
        return answer;
    }
}