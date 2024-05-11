import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    static boolean [] visit;
    static int [] number;
    static int [] sign;
    static String maxString;
    static String minString;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sign = new int[n];
        number = new int[n+1];
        visit = new boolean[10];

        maxString = "0".repeat(n+1);
        minString = "9".repeat(n+1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            sign[i] = st.nextToken().charAt(0)== '<' ? -1 : 1;// a < b -> a-b < 0 그리고  a>b -> a-b>0 부등호 <는 음수 부등호 >는 양수로 표현해야겠음
        }

        set(0);

        System.out.println(maxString);
        System.out.println(minString);

    }

    public static void set(int depth){
        if(depth==number.length){
            calculate();
            return;
        }

        for(int i=0;i<10; i++){
            if(!visit[i] && check(depth, i)){
                visit[i] = true;
                number[depth] = i;
                set(depth+1);
                visit[i] = false;
            }
        }
    }

    public static boolean check(int depth, int i){

        if(depth==0){
            return true;
        }

        int before = depth-1;

        if(sign[before]<0){
            if(number[before]-i<0){
                return true;
            }else{
                return false;
            }
        }else{
            if(number[before]-i>0){
                return true;
            }else{
                return false;
            }
        }
    }
    public static void calculate(){

        StringBuilder sb = new StringBuilder();
        for(int i : number){
            sb.append(i);
        }
        String result = sb.toString();

        if(minString.compareTo(result)>0){
            minString = result;
        }
        if(maxString.compareTo(result)<0){
            maxString = result;
        }
    }
}