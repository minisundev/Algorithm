class Solution {
    public int solution(int[] num_list) {
        int multiply=1;
        int sum=0;
        for(int i=0;i<num_list.length;i++){
            multiply=multiply*num_list[i];
        }
        for(int i=0;i<num_list.length;i++){
            sum=sum+num_list[i];
        }
        if(sum*sum>multiply){
            return 1;
        }else{
            return 0;
        }
    }
}