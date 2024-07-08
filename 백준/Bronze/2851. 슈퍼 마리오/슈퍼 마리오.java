import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int [] arr = new int[11];
        for(int i=1; i<=10; i++){
            arr[i] = arr[i-1]+Integer.parseInt(br.readLine());
            if(Math.abs(100-arr[i])<=100-answer){
                answer = arr[i];
            }
        }
        System.out.println(answer);
    }
}