import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    static int max = -1000000000;
    static int min = 1000000000;
    static int [] arr;
    static int [] operator;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        search(arr[0],1);

        System.out.println(max);
        System.out.println(min);

    }

    public static void search(int sum,int depth){
        if(depth>=arr.length){
            min = Math.min(sum,min);
            max = Math.max(sum,max);
            return;
        }
        
        //plus
        if(operator[0]>0){
            operator[0]--;
            search(sum+arr[depth],depth+1);
            operator[0]++;
        }

        //minus
        if(operator[1]>0){
            operator[1]--;
            search(sum-arr[depth],depth+1);
            operator[1]++;
        }

        //multiply
        if(operator[2]>0){
            operator[2]--;
            search(sum*arr[depth],depth+1);
            operator[2]++;
        }

        //divide
        if(operator[3]>0){
            operator[3]--;
            if(arr[depth]>0){
                search(sum/arr[depth],depth+1);
            }
            operator[3]++;
        }
    }
}