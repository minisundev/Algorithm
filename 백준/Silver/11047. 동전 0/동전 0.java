import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<number;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp<=target){
                arr.add(temp);
            }
        }
        br.close();

        arr.sort(Collections.reverseOrder());

        int sum = 0;
        int count = 0;
        for(int x :arr){
            while(sum<target){
                sum = sum+x;
                count++;
            }
            if(sum==target) {
                break;
            }else if(sum>target){
                sum = sum -x;
                count--;
            }
        }

        System.out.println(count);
    }

}