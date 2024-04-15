import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());//랜선의 개수 -> 길이가 각자 다 다르다
        long n = Long.parseLong(st.nextToken());//필요한 랜선의 개수
        //같은 길이의 N개의 랜선으로 만들어야 한다

        long [] arr = new long[k];

        long longest = 0;
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            arr[i] = x;
            if(x>longest){
                longest = x;
            }
        }

        //뭘 찾는지 : 자른 개수!
        //비교조건 : 잘라내는 길이!
        long min = 1;
        long max = longest;
        long maxLength = 0;// 잘라낸 랜선의 최대 길이

        while(min<=max){
            long mid = (min+max)/2;
            long count = 0;
            for(long i : arr){
                count += i/mid;//랜선을 길이로 자르면 몇개 나오는지
            }

            if(count>=n){//잘린 갯수가 n과 같거나 많으면 -> 길이를 늘려본다
                maxLength = Math.max(mid,maxLength);//조건 달성
                min = mid+1;
            }else{//잘린 갯수가 n보다 적으면 -> 길이를 줄여본다
                max = mid-1;
            }
        }

        System.out.println(maxLength);

    }
}