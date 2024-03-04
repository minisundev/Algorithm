import java.util.*;
import java.lang.Math;

public class Main {

    static long [] dp;
    static int [] list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        list = new int[n];

        //초기화
        for(int i=0;i<n;i++){
            String s = scanner.nextLine();
            list[i] = Integer.parseInt(s);
        }

        for(int i=0;i<list.length;i++){
            System.out.println(getNumber(list[i]));
        }

    }

    public static long getNumber(int n) {
        dp = new long[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        if(dp.length>1){
            dp[1] = 1;
        }
        if(dp.length>2){
            dp[2] = 1;
        }
        if(dp.length>3){
            dp[3] = 1;
        }
        if(dp.length>4){
            dp[4] = 2;
        }
        if(dp.length>5){
            dp[5] = 2;
        }
        return dp(n);
    }

    public static long dp(int n){
        if(n<=0){
            return 0;
        }else if(n<=5){
            return dp[n];
        }
        long element = dp[n];
        if(element==-1){
            element = dp(n-1)+dp(n-5);
            dp[n]= element;
        }
        return element;
    }
}