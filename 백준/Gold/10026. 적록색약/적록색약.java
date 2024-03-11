import java.io.*;
import java.util.*;

public class Main {

    static char [][] arr;
    static boolean [][] checked;
    static boolean [][] checkedBG;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new char[n][n];
        checked = new boolean[n][n];
        checkedBG = new boolean[n][n];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j] = s.charAt(j);
            }
        }
        br.close();

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

    public static void search(int x, int y, char c){

        checked[x][y] = true;

            if(x-1>=0&&!checked[x-1][y]&&arr[x-1][y]==c){
                search(x-1,y,c);
            }
            if(x+1<arr.length&&!checked[x+1][y]&&arr[x+1][y]==c){
                search(x+1,y,c);
            }
            if(y+1<arr[0].length&&!checked[x][y+1]&&arr[x][y+1]==c){
                search(x,y+1,c);
            }
            if(y-1>=0&&!checked[x][y-1]&&arr[x][y-1]==c){
                search(x,y-1,c);
            }
    }

    public static void searchBG(int x, int y, char c){

        checkedBG[x][y] = true;

            if(x-1>=0&&!checkedBG[x-1][y]&&isSame(arr[x-1][y],c)){
                searchBG(x-1,y,c);
            }
            if(x+1<arr.length&&!checkedBG[x+1][y]&&isSame(arr[x+1][y],c)){
                searchBG(x+1,y,c);
            }
            if(y+1<arr[0].length&&!checkedBG[x][y+1]&&isSame(arr[x][y+1],c)){
                searchBG(x,y+1,c);
            }
            if(y-1>=0&&!checkedBG[x][y-1]&&isSame(arr[x][y-1],c)){
                searchBG(x,y-1,c);
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