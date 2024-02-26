import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getNumber(n));
    }

    public static int getNumber(int n){
        int count = 0;
        HashSet<Integer> queue = new HashSet<>();
        HashSet<Integer> next = null;
        queue.add(n);
        int target = 1;

        while(!queue.isEmpty()){
            if(queue.contains(target))
                return count;

            next = new HashSet<>();
            for(int val : queue){
                int left = val/3;
                int right = val/2;
                int middle = val -1;

                if (val%3==0&& left >= target) next.add(left);
                if (val%2==0&& right >= target) next.add(right);
                if(middle>=target) next.add(middle);
            }
            queue = next;
            count++;
        }
        return -1;
    }
}