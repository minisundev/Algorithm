import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.Math;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int min = Math.min(r,n-r);
        int max = Math.max(r,n-r);
        BigInteger combination = BigInteger.ONE;

        for(int i=n;i>max; i--){//n! ~ r!
            combination = combination.multiply(BigInteger.valueOf(i));
        }
        for(int i=min;i>=2; i--){//을 (n-r)!로 나누기~
            combination = combination.divide(BigInteger.valueOf(i));
        }

        System.out.println(combination);
    }
}