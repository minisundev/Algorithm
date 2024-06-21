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

        boolean smallest = false;
        int pivot = N-1;

        while(pivot>0 && arr[pivot-1] <= arr[pivot]){ //내림차순이 깨지는 pivot을 찾음(뒤에서부터 오름차순이 꺠지는)
            pivot--;
        }
        pivot--;

        if(pivot<0){
            smallest = true; //pivot이 0이거나 더 작다 -> 뒤에서부터 끝까지 오름차순이다 -> 더 작은것이 없다
        }else{
            int target = N-1;
            while(arr[pivot] <= arr[target]){ // pivot보다 더 작으면서 가장 오른쪽에 있는 것을 찾음
                target--;
            }

            //pivot과 target을 바꿈
            swap(pivot,target);

            //pivot+1 부터 순열을 뒤집음
            int i = pivot+1;
            int j = N-1;
            while(i<j){
                swap(j--,i++);
            }
        }

        if(smallest){
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