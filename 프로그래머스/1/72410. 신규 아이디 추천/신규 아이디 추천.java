class Solution {
    //String allow = "-_.~!@#$%^&*()=+[{]}:?,<>/";//new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.
    String allow = "-_.";//2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        int end = new_id.length();
        // if(end>=16){//new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     end = 15;
        // }
        
        for(int i=start; i<end; i++){
            char c = new_id.charAt(i);
            if(c>='A'&&c<='Z'){
                c -= 'A'-'a';//대문자를 대응되는 소문자로 치환
            }else if(c=='.'){
                if(i==start||i==end-1){
                    continue;//마침표(.)가 처음이나 끝에 위치한다면 제거
                    //제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
                }
                if(sb.length()>0 && sb.charAt(sb.length()-1)=='.'){
                    continue;//연속된 부분을 하나의 마침표(.)로 치환
                }
            }else if((c<='z'&& c>='a')||(c<='9'&&c>='0')){
                //숫자나 소문자면 당근 포함~~
            }else if(!allowed(c)){
                continue;//허용문자 제외 모든 문자 제거.
            }
            sb.append(c);
        }
        
        boolean flag = (sb.length()>0 && sb.charAt(0)=='.')
            ||(sb.length()>0 && sb.charAt(sb.length()-1)=='.')
            ||sb.length()==0
            ||sb.length()<=3
            ||sb.length()>=16
           ;
        // 아래는 마무리 조건들~~
        while(flag){
            if(sb.length()>0 && sb.charAt(0)=='.'){
                //마침표(.)가 처음이나 끝에 위치한다면 제거
                //제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
                sb.delete(0,1);
            }
            if(sb.length()>0 && sb.charAt(sb.length()-1)=='.'){
                //마침표(.)가 처음이나 끝에 위치한다면 제거
                //제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
                sb.delete(sb.length()-1,sb.length());
            }

            if(sb.length()==0){
                sb.append('a');
            }
            if(sb.length()<=3){
                //new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
                for(int i=sb.length(); i<3; i++){
                    sb.append(sb.charAt(sb.length()-1));
                }
                return sb.toString();
            }else if(sb.length()>=16){
                sb.delete(15,sb.length());
            }
            flag = (sb.length()>0 && sb.charAt(0)=='.')
            ||(sb.length()>0 && sb.charAt(sb.length()-1)=='.')
            ||sb.length()==0
            ||sb.length()<=3
            ||sb.length()>=16
           ;
        }
        
        return sb.toString();
    }
    
    boolean allowed(char c){
        for(int i=0; i<allow.length(); i++){
            if(allow.charAt(i)==c) return true;
        }
        return false;
    }
}