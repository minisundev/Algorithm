import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);//정렬되어야만 BST사용가능

        int m = in.nextInt();
        
        for(int i=0;i<m;i++){

            //값이 있을 경우 1, 없을 경우 0을 출력
            if(binarySearch(arr, in.nextInt())>=0){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
    public static int binarySearch(int[] arr, int key) {

        int lowest = 0;//왼쪽 끝
        int highest = arr.length-1;//오른쪽 끝

        //lowest가 highest보다 커지기 전까지 반복
        while(lowest<=highest) {

            int mid=(lowest+highest)/2;	//중간
            
            if(key<arr[mid]) {
                highest = mid-1;//-> 왼쪽 서브트리로 옮겨서 탐색
            }
            else if(key>arr[mid]) {
                lowest = mid+1;//->오른쪽 서브트리로 옮겨서 탐색
            }
            //key==highest
            else {
                return mid;
            }
        }
        //찾는 값이 존재하지 않음
        return -1;

    }
}