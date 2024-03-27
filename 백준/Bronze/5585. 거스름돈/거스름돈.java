import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pay = Integer.parseInt(st.nextToken());//타로가 지불한 돈

        int [] money = {500,100,50,10,5,1};
        int count = 0;

        pay = 1000 - pay;

        for(int i=0;i<money.length;i++){
            int temp = pay/money[i];
            count += temp;
            pay = pay%money[i];
        }

        System.out.println(count);
    }
}
