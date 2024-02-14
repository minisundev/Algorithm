class Solution {
    public int solution(int num) {
        if(num == 1){
            return 0;
        }
        int count = 0;
        long value = Long.parseLong(Integer.toString(num));
        while(count <= 500){
            if(value%2==0){
                value = value/2;
            }else{
                value = (value*3)+1;
            } 
            count++;
            if(value==1){
                return count;
            }
        }
        return -1;
    }
}