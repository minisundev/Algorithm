import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);

        int [] neg = neg(n, arr);
        
        StringBuilder sb = new StringBuilder();

        for (int i : neg) {
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    public static int [] neg(int n, int [] arr){
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);

        for (int i = 1; i < n; i++) {
            while (!indexStack.isEmpty() && arr[indexStack.peek()] < arr[i]) {
                arr[indexStack.pop()] = arr[i];
            }
            indexStack.push(i);
        }

        if (!indexStack.isEmpty()) {
            while (!indexStack.isEmpty()) {
                arr[indexStack.pop()] = -1;
            }
        }
        return arr;

    }
}