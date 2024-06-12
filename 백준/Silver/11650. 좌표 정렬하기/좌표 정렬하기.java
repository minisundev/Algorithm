import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Coord> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if(o1.x!=o2.x){
                        return o1.x-o2.x;
                    }
                    return o1.y-o2.y;
                }
        );

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Coord(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Coord coord = pq.poll();
            sb.append(coord.x).append(" ").append(coord.y).append("\n");
        }

        System.out.println(sb);
    }
}

class Coord{
    public int x;
    public int y;
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}