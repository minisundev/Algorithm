import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        long zeroStreak = 0;
        long oneStreak = 0;

        char last = '2';

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='1'){
                if(last!=c){
                    oneStreak++;
                }
            }else{
                if(last!=c) {
                    zeroStreak++;
                }
            }
            last = c;
        }

        System.out.println(Math.min(zeroStreak,oneStreak));

    }

}