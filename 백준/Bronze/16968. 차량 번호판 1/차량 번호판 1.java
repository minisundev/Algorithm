import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char [] arr = s.toCharArray();
        int [] number = {26,10};

        int answer = 1;

        int count = 1;
        char last = arr[0];

        for(int i=1; i<arr.length; i++){
            char now = arr[i];
            if(now==last){
                count++;
            }else{
                answer *= fact(number[(int)(last-'c')],count);
                count = 1;
            }
            last = now;
        }
        answer *= fact(number[(int)(last-'c')],count);
        System.out.println(answer);
    }

    static int fact(int number, int count){
        int result = number;
        if(count>=2){
            number--;//아 문제 잘못 읽었음 연속 2번만 안 된다고 했음...
        }
        for(int i=1; i<count; i++){
            result = result*number;
        }
        return result;
    }
}