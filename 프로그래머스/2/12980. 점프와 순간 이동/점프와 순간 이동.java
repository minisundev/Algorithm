import java.util.*;
import java.lang.Math;

public class Solution {
    
    int minCost = Integer.MAX_VALUE;
    
    public int solution(int n) {
        search(n,0);
        return minCost;
    }
    
    public void search(int n, int cost){
        //2의 배수가 될 때까지 뺌 과 2로 나눔 의 연산을 하면서 뭐가 최소값인지 알아본다..?
        if(n==0){
            minCost = Math.min(cost,minCost);
            return;
        }
        
        if(n%2!=0){
            int gap = 0;
            int number = n;
            while(number%2!=0){
                gap++;
                number--;
            }
            search(number,cost+gap);
        }
        
        if(n%2==0 && n/2>=0){
            search(n/2,cost);
        }
    }
}



