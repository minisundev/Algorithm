class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        //2진수로 변환해서 or 연산을 하고 그걸 가져다가 '#', ' '으로 출력하기
        for(int row = 0; row<arr1.length; row++){
            int i1 = arr1[row];
            int i2 = arr2[row];
            answer[row] = binToMap(n,i1|i2);
        }
        return answer;
    }
    
    String binToMap(int row, int i){
        StringBuilder sb = new StringBuilder();
        for(int n=i;n>0;n=n/2){
            if(n%2==0){
                sb.append(' ');
            }else{
                sb.append('#');
            }
        }
        
        while(sb.length() < row){
            sb.append(' ');
        }
        
        return sb.reverse().toString();
    }
}