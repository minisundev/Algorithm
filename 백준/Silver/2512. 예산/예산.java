import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    static int [] countries;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//국가의 개수

        countries = new int[n];

        int biggest = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            countries[i] = x;
            if(biggest<x){
                biggest = x;
            }
        }

        int m = Integer.parseInt(br.readLine());//총예산

        Arrays.sort(countries);

        int min = 0;
        int max = m;//-> 아 뭐지.. 최댓값 뭐지 진짜.. 예산으로 넣어봄 일단
        int limit = 0;//예산 한도, 상한액

        while(min<=max){
            int mid = (min+max)/2;//-> 이걸 상한액으로 써봄
            int sum = 0;

            for(int i=0;i<n;i++){//countries를 돌면서 예산으로 가능한지 봐봄...?

                if(countries[i]>=mid){//상한액보다 같거나 크면
                    sum += mid;
                }else{//상한액보다 작으면
                    sum += countries[i];
                }
            }

            if(sum>m){//저 상한액으로 필요한 예산이 총 예산보다 크면
                max = mid-1;//상한액을 내린다
            }else if(sum==m){//필요한 예산이 총 예산과 같으면
                limit = Math.max(limit,mid);
                max = mid-1;
            }else{//필요한 예산이 총 예산보다 작으면
                limit = Math.max(limit,mid);
                limit = Math.min(biggest,limit);
                min = mid+1;//상한액을 올린다
            }
        }
        System.out.println(limit);

    }
}