class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String [] able = {"aya", "ye", "woo", "ma"};
        Loop1:
        for(String s : babbling){
            String str = new String(s);
            for(int i=0; i<able.length; i++ ){
                str = str.replace(able[i],Integer.toString(i));
                if(str.contains(i+""+i)){
                    continue Loop1;
                }
            }
            str = str.replaceAll("[0-9]","");
            if(str.length()==0){
                answer++;
            }
        }
        return answer;
    }
}