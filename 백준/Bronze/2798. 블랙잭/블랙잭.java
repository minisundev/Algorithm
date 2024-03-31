import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int cards [];

    static int m;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cards = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        max();
        System.out.println(max);
    }

    public static void max(){
        for(int i=0;i<cards.length-2;i++){
            for(int j=i+1;j<cards.length-1;j++){
                for(int k=j+1;k<cards.length;k++){
                    int temp = cards[i] + cards[j] +  cards[k];
                    if(temp>m){
                        continue;
                    }
                    if(m-temp<m-max){
                        max = temp;
                    }
                    if(max==m){
                        return;
                    }
                }
            }
        }
    }
}