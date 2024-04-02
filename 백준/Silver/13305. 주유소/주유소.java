import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;

public class Main {

    static int [] roads;
    static int [] stations;

    static int sum = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        roads = new int [n-1];
        stations = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            roads[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            stations[i] = Integer.parseInt(st.nextToken());
        }

        int oil = stations[0];
        for(int i=0;i<stations.length-1;i++){
            oil = Math.min(stations[i],oil);
            sum+= oil*roads[i];
        }

        System.out.println(sum);

    }
}