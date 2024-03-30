import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//

        int answer = 0;

        for(int i=1;i<=n;i++){
            String s = Integer.toString(i);
            if(s.length()<=1){
                answer++;
                continue;
            }
            int d = s.charAt(1)-s.charAt(0);
            boolean fine = true;
            for(int j=1;j<s.length()-1;j++){
                if(d!= s.charAt(j+1)-s.charAt(j)){
                    fine = false;
                    break;
                }
            }
            if(fine){
                answer ++;
            }
        }
        System.out.println(answer);
    }
}

