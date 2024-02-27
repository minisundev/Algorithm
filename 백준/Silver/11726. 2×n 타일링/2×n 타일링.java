import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static int [][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        dp = new int[2*n][2*n];
        //초기화
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<dp.length;i++){
            dp[i][1] = i+1;
            dp[i][0] = 1;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 1;
            dp[1][j] = j+1;
        }

        System.out.println(getNumber(n));
    }

    public static int getNumber(int n) {
        int answer = 0;
        for(int i=0;i<=n/2;i++){
            int two = i;
            int one = n-i*2;
            answer = (answer + getCount(two,one))%10007;
        }
        return answer;
    }

    public static int getCount(int two, int one){
        int element = dp[two][one];
        if(element==-1){
            element = (getCount(two-1,one) + getCount(two,one-1))%10007;
            dp[two][one] = element;
        }
        return element;
    }
}