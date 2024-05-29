import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//기타의 줄이 끊어짐
        int M = Integer.parseInt(st.nextToken());//기타 브랜드

        int six = Integer.MAX_VALUE;
        int one = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            six = Math.min(six,Integer.parseInt(st.nextToken()));
            one = Math.min(one,Integer.parseInt(st.nextToken()));
        }

        //걍 제일 싼거부터 사가지고? 가격 채우면 되지 않나?
        while(N>0){
            if(N>=6){
                if(six<one*6){
                    int count = N/6;
                    N -= 6*count;
                    sum += six*count;
                }else{//1로 다 빼
                    sum += N*one;
                    N=0;
                }
            }else{
                if(six<one*N){
                    sum += six*1;
                    N=0;
                }else{//1로 다 빼
                    sum += N*one;
                    N=0;
                }
            }
        }

        System.out.println(sum);

    }
}