import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int [] a = new int[A];
            int [] b = new int[B];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<A; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<B; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int sum = 0;

            int indexB = 0;
            for(int indexA=0; indexA<A; indexA++) {
                while(indexB<B && a[indexA]>b[indexB]){
                    indexB++;
                }
                sum += indexB;
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}