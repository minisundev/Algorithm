import java.util.*;

public class Main {

    static int K=0;
    static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true) {
            K=sc.nextInt();

            if(K==0)
                break;
            arr= new int[K];

            for(int i=0;i<K;i++)
                arr[i]=sc.nextInt();

            search("",-1,0);
            System.out.println();
        }

    }

    public static void search(String s ,int max, int count){
        if(6==count){
            System.out.println(s);
            return;
        }

        for(int i=max+1;i<arr.length;i++){
            search(s+arr[i]+" ",i,count+1);
        }
    }

}