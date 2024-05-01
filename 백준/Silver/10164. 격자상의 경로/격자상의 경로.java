import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); //반드시 지나가야 하는 칸

        int mustX;
        int mustY;

        if(k!=0){
            mustX = k/m;
            mustY = k%m;
            if(mustY>0){
                mustX++;//나머지가 있다면 다음 행이 됨
            }
        }else{
            mustX = 1;
            mustY = 1;
        }

        long result = combination(mustX-1, mustY-1);
        result *= combination(n-mustX, m-mustY);

        System.out.println(result);
    }

    public static long combination(int n_r, int r){

        int max = Math.max(r,n_r);
        int min = Math.min(r,n_r);
        long combination = 1;
        for(int i=n_r+r; i>max; i--){
            combination *= i;
        }
        for(int i=min; i>=2; i--){
            combination /= i;
        }

        return combination;
    }
}
