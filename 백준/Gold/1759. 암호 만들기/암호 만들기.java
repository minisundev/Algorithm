import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean [] visit;
    static char [] letter;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        letter = new char[C];
        visit = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            char c = st.nextToken().charAt(0);
            letter[i] = c;

        }
        Arrays.sort(letter);

        String s = "";
        search(L,s);

    }

    public static void search(int limit, String s){
        if(limit==s.length()){
            if(check(limit,s)){
                System.out.println(s);
            }
            return;
        }

        Arrays.fill(visit,false);

        int max = -1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            for(int j = 0;j<letter.length;j++){
                if(c==letter[j]){
                    visit[j] = true;
                    max = j;
                    break;
                }
            }
        }

        for(int i=max+1;i<letter.length;i++){
            if(visit[i]){
                continue;
            }
            String temp = new String(s);

            temp += letter[i];
            search(limit,temp);
        }
    }

    public static boolean check(int limit,String s){
        if(s.length()!=limit){
            return false;
        }
        int upper = 0;
        int lower = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                lower++;
            }else{
                upper++;
            }
        }
        if(upper>=2&&lower>=1){
            return true;
        }
        return false;
    }
}