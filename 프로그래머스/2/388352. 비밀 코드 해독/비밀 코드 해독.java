import java.util.*;

class Solution {
    int [][] questions;
    int [] ans;
    int answer = 0;
    int n;
    public int solution(int n, int[][] questions, int[] ans) {
        this.questions = questions;
        this.ans = ans;
        this.n = n;
        //오오 이거 야구게임같은거네
        //비밀 코드로 가능한 정수 조합 개수를 return => 확정된 숫자 빼고 0~9까지 들어갈 수 있으니까 10배를 하기!!!
        //5자리를 맞추는것임
        //진짜 야구게임처럼 푼다고 생각하면
        //두개씩 겹치는거 놓고 숫자로 하나 빠지면 하나 빼고 나머지 확정하고 이렇게 풀지 않나?
        //이거 그냥 완탐으로는 풀 수 있을거같아 걍 임의의 다섯개 골라서 시스템응답이랑 일치하는지 보는것임 ㅎ 하하 엄청 비효율적~
        
        for(int i=1; i<=n-4; i++){//시작숫자 정하기~ 시작숫자가 6넘어가면 5개 못함~ => n이지 반드시 10이 아닌것을 ㅎㅎ...
            List<Integer> list = new ArrayList<>();
            //하하 여기서 넣는거 빼먹음 ㅎㅎ
            list.add(i);
            add(i,list);
        }
        
        return answer;
    }
    
    void add(int max, List<Integer> list){
        if(list.size()==5){
            check(list);
            return;
        }
        for(int i=max+1; i<=n; i++){
            list.add(i);
            add(i,list);
            list.remove(list.size()-1);
        }
    }
    
    void check(List<Integer> list){
        for(int i=0; i<ans.length; i++){
            int [] q = questions[i];
            int a = ans[i];
            int hit = 0;
            for(int n : q){
                if(list.contains(n)){
                    hit++;
                }
            }
            if(hit!=a){
                //return false;
                return;
            }
        }
        //return true;
        answer++;
        return;
    }
}