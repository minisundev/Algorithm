import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> list;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

         list = new ArrayList<>();

        ArrayList<Integer> array = new ArrayList<>();

        append(array);

        for (int i=0;i<list.size();i++) {
            ArrayList<Integer> temp = list.get(i);
            for(int j : temp){
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }

    static void append(ArrayList<Integer> arr){
        if(arr.size()>=m){
            list.add(arr);
            return;
        }
        boolean [] exist = new boolean[n+1];

        for(int i: arr){
            exist[i] = true;
        }

        for(int i=1;i<=n;i++){
            if(!exist[i]){
                append(plus(arr,i));
            }
        }
    }

    static ArrayList<Integer> plus(ArrayList<Integer> arr, int x){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i : arr){
            array.add(i);
        }
        array.add(x);
        return array;
    }

}