import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>(
                (o1,o2) -> {
                    if(o1.length()!=o2.length()){
                        return o1.length()-o2.length();
                    }

                    return o1.compareTo(o2);
                }
        );
        for(int i=0; i<n; i++){
            String s = br.readLine();
            pq.add(s);
        }

        StringBuilder sb = new StringBuilder();
        String last = pq.poll();
        sb.append(last).append("\n");
        while(!pq.isEmpty()){
            String now = pq.poll();
            if(!last.equals(now)){
                sb.append(now).append("\n");
            }
            last = now;
        }

        System.out.println(sb);
    }
}