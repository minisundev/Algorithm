import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long [] roads = new long [n-1];
        long [] stations = new long[n];
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            roads[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            stations[i] = Long.parseLong(st.nextToken());
        }

        long oil = stations[0];
        for(int i=0;i<stations.length-1;i++){
            oil = Math.min(stations[i],oil);
            sum+= oil*roads[i];
        }

        System.out.println(sum);

    }
}