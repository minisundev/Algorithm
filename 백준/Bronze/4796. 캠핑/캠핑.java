import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i = 1;

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;

            int l = Integer.parseInt(st.nextToken());//l일 사용 가능
            int p = Integer.parseInt(st.nextToken());//연속하는 p일 중
            int v = Integer.parseInt(st.nextToken());//총 휴가 일수

            if(l==0 && p==0 && v==0){
                break;
            }

            while(v>=p){
                v -= p;
                max += l;
            }

            if(v<=l){
                max += v;
            }else{
                max += l;
            }
            sb.append("Case ").append(i++).append(": ").append(max).append("\n");

        }
        System.out.println(sb);

    }
}
