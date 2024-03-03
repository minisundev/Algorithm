import java.util.*;
import java.lang.Math;

public class Main {

    static int [] dp;
    static int max;
    static int [] list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        list = new int[n];

        //초기화

            String s = scanner.nextLine();
            String [] arr = s.split(" ");
            list = new int[arr.length];
            for(int j=0; j<arr.length;j++){
                list[j] = Integer.parseInt(arr[j]);
            }

        System.out.println(getNumber(n));
    }

    public static int getNumber(int n) {
        dp = new int [n];
        max = list[0];
        dp[0] = list[0];
        dp(n-1);
        return max;
    }

    public static int dp(int n){
        if(n<0){
            return 0;
        }
        int element = dp[n];
        if(element==0){
            element = list[n];
            element = Math.max(dp(n-1)+element,element);
            dp[n] = element;
        }
        max = Math.max(element, max);
        return element;
    }
}