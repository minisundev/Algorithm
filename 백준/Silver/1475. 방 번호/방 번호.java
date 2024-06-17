import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNumber = br.readLine();
        long [] count = new long[10];
        for(char c: roomNumber.toCharArray()){
            count[c-'0']++;
        }
        //6과 9는 혼용 가능 -> 두개 더해서 절반으로 나눠서 넣자...
        long same = count[6]+count[9];
        if(same%2==0){
            count[6] = count[9] = same/2;
        }else{
            count[6] = count[9] = same/2+1;
        }

        long max = 0;
        for(long l : count){
            max = Math.max(l,max);
        }
        System.out.println(max);

    }
}
