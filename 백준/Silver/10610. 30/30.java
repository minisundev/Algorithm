import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        long[] arr = new long[10];//0~9 개수 저장
        long sum = 0;

        for (int i = 0; i < N.length(); i++) {
            int temp = Integer.parseInt(N.charAt(i) + "");
            arr[temp]++;
            sum += temp;
        }

        if (arr[0] == 0) {//0이 존재하지 않으면 30의 배수가 불가능
            System.out.print(-1);
            return;
        }

        if(sum%3!=0){
            System.out.print(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        //반대로 뒤집어서 출력함
        for (int i = arr.length-1; i >= 0; i--) {
            for(int j=1;j<=arr[i];j++){
                sb.append(i);
            }
        }

        System.out.print(sb.toString());
    }
}