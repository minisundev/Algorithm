import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//용액의 개수

        long [] arr = new long[n];

        //중간 값을 찾아보자~~
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            long x = Long.parseLong(st.nextToken());
            arr[i] = x;
        }

        Arrays.sort(arr);

        int min = 0;
        int max = arr.length-1;

        long minMix = Long.MAX_VALUE;// 0에 가까운 mid일때 저장함
        long mixMin = 0;
        long mixMax = 0;

        while(min<max){
            long mix = arr[min]+arr[max];//이게 mix임

            if(Math.abs(mix)<minMix){
                minMix = Math.abs(mix);
                mixMin = arr[min];
                mixMax = arr[max];

                if(mix==0){
                    break;
                }
            }

            if(mix<=0){//알칼리성이면 알칼리를 줄여봄
                min++;
            }else if(mix>0){//산성이면 산성을 줄여봄
                max--;
            }
        }

        System.out.println(mixMin+" "+mixMax);

    }
}