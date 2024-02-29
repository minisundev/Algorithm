import java.util.*;
import java.lang.Math;

public class Main {

    static int [][] dp;
    static int [][] cost;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        cost = new int[n+1][3];

        //초기화
        for(int i=1;i<cost.length;i++){
            String s = scanner.nextLine();
            String [] arr = s.split(" ");
            for(int j=0;j<arr.length;j++){
                cost[i][j] = Integer.parseInt(arr[j]);
            }
        }
        System.out.println(getNumber(n));
    }

    public static int getNumber(int n) {
        dp = new int[n+1][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        for(int i=1;i<dp.length;i++){
            dp(i,0);
            dp(i,1);
            dp(i,2);
        }

        int min = Math.min(dp[dp.length-1][0],dp[dp.length-1][1]);
        min = Math.min(dp[dp.length-1][2],min);
        return min;
    }

    public static int dp(int index, int color){
        int other = (color+1)%3;
        int another = (color+2)%3;
        int element = dp[index][color];
        if(element ==0){
            element = Math.min(dp[index-1][other]+cost[index][color] , dp[index-1][another] +cost[index][color]);
            dp[index][color] = element;
        }
        return element;
    }

}