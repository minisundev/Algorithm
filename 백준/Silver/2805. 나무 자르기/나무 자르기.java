import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    static int [] trees;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//나무의 수
        int m = Integer.parseInt(st.nextToken());//집으로 가져갈 나무의 길이

        trees = new int[n];

        int biggest = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            trees[i] = x;
            if(biggest<x){
                biggest = x;
            }
        }

        int min = 0;
        int max = biggest;//제일 큰 나무 높이를 넣어봄
        int h = 0;//벨 수 있는 최대 나무의 높이

        while(min<=max){
            int mid = (min+max)/2;//벨 나무의 높이
            long sum = 0;//벤 나무의 길이의 총합

            for(int i : trees){
                int cut = i-mid;
                if(cut<0){//나무보다 톱이 높아서 안 잘린 상황이라 0
                    cut = 0;
                }
                sum += cut;//나무 베어서 합침
            }
            if(sum>=m){//조건 충족, 나무의 길이의 총합이 m보다 같거나 큼
                h = Math.max(h,mid);
                min = mid+1;//높이를 올려봄
            }else{//나무의 길이의 총합이 m보다 작음
                max = mid-1;//높이를 줄여봄
            }

        }
        System.out.println(h);

    }
}