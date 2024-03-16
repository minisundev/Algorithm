import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [][] arr;
    static boolean [][] visit;

    static ArrayList<Integer> x = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();

    static int max;

    static int walls;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];
        walls = 0;
        max = 0;

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if(temp==2){
                    x.add(i);
                    y.add(j);
                }else if(temp==1){
                    walls++;
                }
            }
        }


        wall(0);

        System.out.println(max);

    }

    static void wall(int count){
        if(count == 3){
            int result = search() + x.size();
            int safe = arr.length*arr[0].length - result - (walls+3);

            if(safe>max){
                max = safe;
            }
            return;
        }
        for(int i=0; i<arr.length;i++){//벽 세우기
            for(int j=0; j<arr[0].length;j++) {
                if(arr[i][j]==0){
                    arr[i][j] = 1;
                    wall(count+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static int search(){

        int count = 0;

        for(int j = 0; j<visit.length;j++){
            Arrays.fill(visit[j],false);
        }

        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();

        for(int i=0;i<x.size();i++){
            xq.add(x.get(i));
            yq.add(y.get(i));
        }

        while(!xq.isEmpty()&&!yq.isEmpty()){
            int i = xq.poll();
            int j = yq.poll();

            if(i+1<arr.length&&arr[i+1][j]==0&&!visit[i+1][j]){
                visit[i+1][j] = true;
                count++;
                xq.add(i+1);
                yq.add(j);
            }
            if(i-1>=0&&arr[i-1][j]==0&&!visit[i-1][j]){
                visit[i-1][j] = true;
                count++;
                xq.add(i-1);
                yq.add(j);
            }
            if(j+1<arr[0].length&&arr[i][j+1]==0&&!visit[i][j+1]){
                visit[i][j+1] = true;
                count++;
                xq.add(i);
                yq.add(j+1);
            }
            if(j-1>=0&&arr[i][j-1]==0&&!visit[i][j-1]){
                visit[i][j-1] = true;
                count++;
                xq.add(i);
                yq.add(j-1);
            }
        }

        return count;
    }

}