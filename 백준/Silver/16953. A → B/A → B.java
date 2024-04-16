import java.io.*;
import java.util.*;

public class Main {

    static long min = Long.MAX_VALUE;
    static long target;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        search(n);

        if(min==Long.MAX_VALUE){
            min = -1;
        }

        System.out.println(min);

    }

    public static void search(long n){
        int count = 0;

        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Long> next;

        list.add(n);

        while(!list.isEmpty()){

            count++;
            next = new ArrayList<>();

            for(long i : list){
                if(i>target){
                    continue;
                }else if(i==target){
                    min = count;
                    return;
                }
                next.add(i*10+1);
                next.add(i*2);
            }

            list = next;
        }
    }
}