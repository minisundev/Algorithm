class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        String [] array = new String[t.length() - p.length()+1];
        for(int i=0; i<array.length;i++){
            array[i]=t.substring(i,i+p.length());
        }
        for(int i=0; i<array.length;i++){
            if(array[i].compareTo(p)<=0){ 
                answer++;
            }
        }
        return answer;
    }
}