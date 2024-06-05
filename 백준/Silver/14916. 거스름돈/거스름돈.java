import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;


        int i = 0;
        //5
        while(i<n){
           if((n-i)%5==0){
               break;
           }
           i += 2;
           count++;
        }

        //2
        if((n-i)%5==0){
            count += (n-i)/5;
            i = n;
        }

        if((n-i)!=0){
            count = -1;
        }

        System.out.println(count);
    }

}