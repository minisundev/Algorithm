import java.util.*;
import java.lang.Math;

public class Main {

    static long [][] dp;
    static int [][] list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        list = new int[n][2];

        //초기화
        for(int i=0;i<n;i++){
            String s = scanner.nextLine();
            String [] arr = s.split(" ");
            list[i][0] = Integer.parseInt(arr[0]);
            list[i][1] = Integer.parseInt(arr[1]);
        }

        for(int i=0;i<list.length;i++){
            System.out.println(getNumber(list[i][0], list[i][1]));
        }

    }

    public static long getNumber(int from,int to) {
        //몇개중에 몇개 고르는지
        int max = Math.max(from,to);
        int min = Math.min(from,to);
        dp = new long[max+1][min+1];
        return dp(max,min);
    }

    public static long dp(int max, int min){
        if(max<0||min<0){
            return 0;
        }else if(min==0||min==max){
            return 1;
        } else if(min==1){
            return max;
        }
        long element = dp[max][min];
        if(element==0){
            element = dp(max-1,min-1)+dp(max-1,min);
            dp[max][min]= element;
        }
        return element;
    }
}