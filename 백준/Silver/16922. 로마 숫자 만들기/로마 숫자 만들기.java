import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int arr[] = {1,5,10,50};
    static int[] index;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        index = new int[N];
        set = new HashSet<>();

        //최대한 단순하게 for문 네번 돌림 ㅜ
        for(int i=0; i<=N;i++){
            for(int j=0; j<=N-i;j++){
                for(int k=0; k<=N-i-j ;k++){
                    int l = N-i-j-k;

                    set.add(i+j*5+k*10+l*50);

                }
            }
        }

        System.out.println(set.size());
    }
}