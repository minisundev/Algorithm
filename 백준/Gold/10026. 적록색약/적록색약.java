import java.io.*;
import java.util.*;

public class Main {

    static char [][] arr;
    static boolean [][] checked;
    static boolean [][] checkedBG;

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        arr = new char[n][n];
        checked = new boolean[n][n];
        checkedBG = new boolean[n][n];

        for(int i=0;i<n;i++){
            String s = scanner.nextLine();
            for(int j=0;j<s.length();j++){
                arr[i][j] = s.charAt(j);
            }
        }
        int count = 0;
        int countBG = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!checked[i][j]){
                    char c = arr[i][j];
                    search(i,j,c);
                    count++;
                }
                if(!checkedBG[i][j]){
                    char c = arr[i][j];
                    searchBG(i,j,c);
                    countBG++;
                }
            }
        }
        System.out.println(count+" "+countBG);
    }

    public static void search(int i, int j, char c){

        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();

        xq.add(i);
        yq.add(j);
        checked[i][j] = true;

        while(!xq.isEmpty()&&!yq.isEmpty()) {

            int x = xq.poll();
            int y = yq.poll();

            if(x-1>=0&&!checked[x-1][y]&&arr[x-1][y]==c){
                xq.add(x-1);
                yq.add(y);
                checked[x-1][y] = true;
            }
            if(x+1<arr.length&&!checked[x+1][y]&&arr[x+1][y]==c){
                xq.add(x+1);
                yq.add(y);
                checked[x+1][y] = true;
            }
            if(y+1<arr[0].length&&!checked[x][y+1]&&arr[x][y+1]==c){
                xq.add(x);
                yq.add(y+1);
                checked[x][y+1] = true;
            }
            if(y-1>=0&&!checked[x][y-1]&&arr[x][y-1]==c){
                xq.add(x);
                yq.add(y-1);
                checked[x][y-1] = true;
            }
        }
    }

    public static void searchBG(int i, int j, char c){

        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();

        xq.add(i);
        yq.add(j);
        checkedBG[i][j] = true;

        while(!xq.isEmpty()&&!yq.isEmpty()) {

            int x = xq.poll();
            int y = yq.poll();

            if(x-1>=0&&!checkedBG[x-1][y]&&isSame(arr[x-1][y],c)){
                xq.add(x-1);
                yq.add(y);
                checkedBG[x-1][y] = true;
            }
            if(x+1<arr.length&&!checkedBG[x+1][y]&&isSame(arr[x+1][y],c)){
                xq.add(x+1);
                yq.add(y);
                checkedBG[x+1][y] = true;
            }
            if(y+1<arr[0].length&&!checkedBG[x][y+1]&&isSame(arr[x][y+1],c)){
                xq.add(x);
                yq.add(y+1);
                checkedBG[x][y+1] = true;
            }
            if(y-1>=0&&!checkedBG[x][y-1]&&isSame(arr[x][y-1],c)){
                xq.add(x);
                yq.add(y-1);
                checkedBG[x][y-1] = true;
            }
        }
    }

    public static boolean isSame(char c, char target){
        if(c==target){
            return true;
        }else if(target=='R'&&c=='G'){
            return true;
        }else if(target=='G'&&c=='R'){
            return true;
        }
        return false;
    }
}