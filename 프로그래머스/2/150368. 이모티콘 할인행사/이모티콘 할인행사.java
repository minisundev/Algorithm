import java.util.*;

class Solution {
    
    int [][] user;
    int [] emoticon;
    
    int maxPlus = 0;
    int maxCost = 0;
    
    int maxDiscount = 40;
        
    public int[] solution(int[][] users, int[] emoticons) {
        
        user = users;
        emoticon = emoticons;

        //백트래킹 느낌으로 하자~~
        int [] discount = new int[emoticon.length];
        search(discount,0);
        
        int[] answer = {maxPlus,maxCost};//이모티콘 플러스 서비스 가입 수와 이모티콘 매출액
        return answer;
    }
    
    public void search(int [] discount, int depth){
        //할인율 점점 올려보면서 이모티콘플러스 가입자수가 max가 될때 매출액 update하는 걸로 풀면 될듯함
        if(depth>=emoticon.length){
            return;
        }
        
        for(int j=0;j<=40;j+=10){
            int [] temp = discount.clone();
            temp[depth] = temp[depth]+j;
            calculate(temp);
            search(temp, depth+1);
        }
    }
    
    public void calculate(int [] discount){
        int people = 0;
        int money = 0;
        
        for(int u = 0; u<user.length; u++){
            int sum = 0;
            for(int i=0;i<discount.length;i++){
                if(user[u][0]<=discount[i]){
                    int plus = emoticon[i]*(100-discount[i])/100;
                    sum += plus;
                }
            }
            if(sum>=user[u][1]){
                people++;//이모티콘을 구독하면 비용 발생 x
            }else{
                money += sum;
            }
        }
        if(people>maxPlus){
            maxPlus = people;
            maxCost = money;
        }else if(people == maxPlus){
            if(money>maxCost){
                maxCost = money;
            }
        }
    }
}