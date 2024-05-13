import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());//탑의 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> indexStack = new Stack<>();

        for(int i=arr.length-1; i>=0;i--){
            int h = arr[i];
            while(!indexStack.isEmpty() && arr[indexStack.peek()]<=h){//Stack이 비어있지 않고, 현재 원소가 Stack의 top에 해당하는 원소보다 크거나 같은 경우에는 stack에서 pop
                arr[indexStack.pop()] = i+1;

            }
            indexStack.push(i);
        }

        //어차피 0이라 안 넣어줘도 될 것 같은데...arr 재활용이라 넣어야됨
        if (!indexStack.isEmpty()) {
            while (!indexStack.isEmpty()) {
                arr[indexStack.pop()] = 0;
            }
        }

        StringBuilder sb =  new StringBuilder();
        for(int i : arr){
             sb.append(i);
             sb.append(" ");
        }

        System.out.println(sb);
    }
}