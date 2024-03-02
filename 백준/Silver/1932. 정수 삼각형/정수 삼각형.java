import java.util.*;
import java.lang.Math;

public class Main {

    static int [][] dp;
    static int [][] list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        list = new int[n][];

        //초기화
        for(int i=0;i<list.length;i++){
            String s = scanner.nextLine();
            String [] arr = s.split(" ");
            list[i] = new int[arr.length];
            for(int j=0; j<arr.length;j++){
                list[i][j] = Integer.parseInt(arr[j]);
            }
        }
        System.out.println(getNumber(n));
    }

    public static int getNumber(int n) {
        dp = new int[n][];
        for(int i=0;i<n;i++){
            dp[i] = new int[list[i].length];
        }
        for(int i = 0; i<dp[n-1].length; i++){
            dp[n-1][i] = list[n-1][i];
        }
        return dp(0,0);
    }

    public static int dp(int row, int col){
        if(row>=dp.length||col>=dp[col].length){
            return 0;
        }
        int element = dp[row][col];
        if(element==0){
            element = Math.max(dp(row+1,col),dp(row+1,col+1)) + list[row][col];
            dp[row][col] = element;
        }
        return element;
    }
}