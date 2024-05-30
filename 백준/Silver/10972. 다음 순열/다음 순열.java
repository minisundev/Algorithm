import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean last = false;
        int i = N-1;

        while(i>0 && arr[i-1] >= arr[i]){ // arr[i-1] < arr[i] 인 가장 큰 i를 찾는다고 함
            i--;
        }

        if(i<=0){
            last = true; //desc
        }else{
            int j = N-1;
            while(arr[i-1] >= arr[j]){ //arr[j] > arr[i-1]을 만족하는 가장 큰 j
                j--;
            }

            //arr[i-1]와 arr[j]를 바꿈
            swap(i-1,j);

            j = N-1;
            //arr[i] 부터 순열을 뒤집음
            while(i<j){
                swap(j--,i++);
            }
        }

        if(last){
            sb.append(-1);

        }else{
            for(int t : arr){
                sb.append(t).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}