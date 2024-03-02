class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            int [] query = queries[i];
            int from = query[0];
            int to = query[1];
            int k = query[2];
 
            
            for(int j = from; j<=to; j++){
                int temp = arr[j];
                if(j%k==0){
                    arr[j]++;
                }
            }
            
        }
        return arr;
    }
}