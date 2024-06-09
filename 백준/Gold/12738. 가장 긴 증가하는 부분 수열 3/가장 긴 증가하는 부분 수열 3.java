import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] LIS = new int[n];

        int length = 0;

        for(int i=0; i<n; i++){
            int key = arr[i];

            if(length ==0 || LIS[length-1]<key){//0이거나 LIS의 마지막 원소가 key보다 작다면 붙인다
                LIS[length] = key;
                length++;

            }else{//마지막 원소가 key보다 크다면
                //LIS 안에서 어디에다 붙여야 할지 이분탐색으로 결정한다
                int min = 0;
                int max = length -1;

                while(min<max){
                    int mid = (min+max)/2;

                    if(LIS[mid] >= key){//중간값이 key보다 크거나 같으면 max를 내린다
                        max = mid;
                    }else{//중간값이 key보다 작으면 min을 올린다
                        min = mid+1;
                    }
                }
                LIS[min] = key; //찾은 위치에 key를 넣는다
            }
        }

        System.out.println(length);

    }
}