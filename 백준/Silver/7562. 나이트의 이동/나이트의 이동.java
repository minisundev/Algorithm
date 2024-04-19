import java.io.*;
import java.util.*;

public class Main {
    static boolean [][] visit;

    public static void main(String[] args) throws IOException {

        List<int []> coord = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){

            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            coord.add(new int []{startX,startY,endX,endY,n});

        }

        for(int [] c : coord){
            visit = new boolean[c[4]][c[4]];
            int count = search(c[0],c[1],c[2],c[3]);
            System.out.println(count);
        }
    }

    //나이트의 움직임
    static int [][] ds = {{1,2},{2,1}
            ,{-1,2},{-2,1}
            ,{-1,-2},{-2,-1}
            ,{1,-2},{2,-1}
    };

    public static int search(int startX, int startY, int endX, int endY){

        int count = -1;
        List<int []> list = new ArrayList<>();
        List<int []> next;
        list.add(new int []{startX,startY});
        visit[startX][startY] = true;

        while(!list.isEmpty()){

            count++;
            next = new ArrayList<>();
            
            for(int [] element : list){
                int x = element[0];
                int y = element[1];

                if(x==endX&&y==endY){
                    return count;
                }

                for(int [] move : ds){
                    int X = x+move[0];
                    int Y = y+move[1];
                    if(X>=0&&Y>=0&&X<visit.length&&Y<visit[0].length&&!visit[X][Y]){
                        visit[X][Y] = true;
                        next.add(new int []{X,Y});
                    }
                }
            }
            list = next;
        }
        return count;
    }
}