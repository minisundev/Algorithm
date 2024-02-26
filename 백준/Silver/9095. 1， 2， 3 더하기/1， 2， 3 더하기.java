import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i : array) {
            System.out.println(getNumber(i));
        }

    }

    public static int getNumber(int target) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {

            int val = stack.pop();
            if (val == target) count++;

            int left = val + 1;
            int right = val + 2;
            int middle = val + 3;

            if (left <= target) {
                stack.push(left);
            }
            if (right <= target) {
                stack.push(right);
            }
            if (middle <= target) {
                stack.push(middle);
            }
        }
        return count;
    }
}