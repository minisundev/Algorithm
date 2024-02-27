import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class Main {

    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i : array) {
            int [] count = getNumber(i);
            System.out.println(count[0]+" "+count[1]);
        }
    }

    public static int [] getNumber(int n) {
        int [] answer = {0,0};
        dp = new int [n+2];

        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=0;
        answer[0]=dp(n);

        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        answer[1]=dp(n);

        return answer;
    }

    public static int dp(int n){
        int element = dp[n];
        if(element==-1){
            element = dp(n-1)+dp(n-2);
            dp[n] = element;
        }
        return element;
    }
}