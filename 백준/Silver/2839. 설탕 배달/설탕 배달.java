import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getNumber(n));
    }

    public static int getNumber(int target){
        int count = 0;
        HashSet<Integer> queue = new HashSet<>();
        HashSet<Integer> next = null;
        queue.add(0);

        while(!queue.isEmpty()){
            if(queue.contains(target))
                return count;

            next = new HashSet<>();
            for(int val : queue){
                int left = val +3;
                int right = val + 5;

                if (left <= target) next.add(left);
                if (right <= target) next.add(right);
            }
            queue = next;
            count++;
        }
        return -1;
    }
}