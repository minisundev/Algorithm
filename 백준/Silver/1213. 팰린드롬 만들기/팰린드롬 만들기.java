import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            int count = map.getOrDefault(c,0);
            count++;
            map.put(c,count);
        }

        PriorityQueue<Letter> pq = new PriorityQueue<>(
                (o1,o2)-> o1.c - o2.c
        );
        StringBuilder first = new StringBuilder();
        String middle = null;
        String end = new String();

        String result = null;

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()%2==1){
                if(middle!=null){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                middle = entry.getKey()+"";
                pq.add(new Letter(entry.getKey(),entry.getValue()-1));
                continue;
            }
            pq.add(new Letter(entry.getKey(),entry.getValue()));
        }

        while(!pq.isEmpty()){
            Letter l = pq.poll();
            String letter = ""+l.c;
            String half = letter.repeat(l.count/2);
            first.append(half);
            end = half+end;
        }

        if(middle==null){
            result = first+end;
        }else {
            result = first+middle+end;
        }

        System.out.println(result);
    }
}
class Letter{
    public char c;
    public int count;
    public Letter(char c, int count){
        this.c = c;
        this.count = count;
    }

}