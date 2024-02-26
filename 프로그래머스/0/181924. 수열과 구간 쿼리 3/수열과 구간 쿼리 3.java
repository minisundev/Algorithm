class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        int[] answer = new int [arr.length];
        
        for(int i=0;i<arr.length;i++){
            answer[i] = arr[i];
        }
        
        for(int i=0;i<queries.length;i++){
            int value1 = answer[queries[i][0]];
            int value2 = answer[queries[i][1]];
            answer[queries[i][0]] = value2;
            answer[queries[i][1]] = value1;
        }
        
        return answer;
    }
}