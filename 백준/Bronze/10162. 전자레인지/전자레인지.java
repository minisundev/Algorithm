import java.util.*;

public class Main {

    static int n = 0;
    static int [] N;

    static int m = 0;

    static int [] M;

    static HashMap<String,Integer> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] buttons = {300,60,10};
        int [] times = new int[3];

        n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<buttons.length; i++){
            int cnt = n/buttons[i];
            n = n%buttons[i];
            times[i] = cnt;
        }

        if(n!=0){
            System.out.println(-1);
            return;
        }

        for(int x : times){
            System.out.print(x+" ");
        }

    }

}