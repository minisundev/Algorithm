import java.io.*;
import java.util.*;

public class Main {

    static int t;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int [] arr = new int[t];
        for(int i=0;i<t;i++){
            arr[i] = sc.nextInt();
        }

        int [] coin = {25,10,5,1};
        int [] count = new int [4];

        for(int i=0;i<t;i++){

            int money = arr[i];

            for(int j=0;j<coin.length;j++){
                count[j] = money/coin[j];
                money = money%coin[j];
            }

            for(int x : count){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}