import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    static int [] address;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//집의 개수
        int c = sc.nextInt();//공유기의 개수

        address = new int[n];

        for(int i=0;i<n;i++){
            if(!sc.hasNextInt()){
                break;
            }
            address[i] = sc.nextInt();
        }

        Arrays.sort(address);

        int min = 1; //최소 거리
        int max = address[n-1]-address[0]; //최대 거리
        int result = 0;

        while(min<=max){
            int mid = (min+max)/2;
            int count = 1;//0에는 이미 설치했다고 간주하는듯
            int lastAddress = address[0];

            for(int i=1;i<n;i++){//처음부터 끝까지 가면서 설정한 구간의 중간에다 공유기 설치함
                if(address[i]-lastAddress>=mid){//최소거리과 최대거리의 중간거리만큼 공유기 설치
                    count++;//공유기를 하나 더 설치했다
                    lastAddress = address[i];//여기부터 또 구간 세어서 설치함
                }
            }
            //설치 거리를 이분탐색으로 찾는다
            if(count>=c){//필요힌 공유기의 개수와 같거나 많이 설치함
                result = Math.max(result,mid);
                min = mid+1;
            }else{//공유기를 적게 설치함
                max = mid-1;//-> 공유기 설치 거리를 줄여본다
            }
        }
        System.out.println(result);
    }
}