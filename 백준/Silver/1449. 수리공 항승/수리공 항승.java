import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //물이 새는 곳의 개수
        int L = Integer.parseInt(st.nextToken()); //테이프의 길이

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st =  new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int covered = 0;
        int count = 0;

        while(!pq.isEmpty()){
            int location = pq.poll();
            if(covered<location){
                covered = location -1  + L;
                count++;
            }
        }

        System.out.println(count);

    }
}