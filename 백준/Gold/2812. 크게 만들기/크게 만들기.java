import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        String number = br.readLine();
        
        System.out.println(findLargestNumber(N, K, number));
    }
    
    public static String findLargestNumber(int N, int K, String number) {
        Stack<Character> stack = new Stack<>();
        int toRemove = K;
        
        for (int i = 0; i < N; i++) {
            char current = number.charAt(i);
            while (!stack.isEmpty() && toRemove > 0 && stack.peek() < current) {
                stack.pop();
                toRemove--;
            }
            stack.push(current);
        }
        
        // 만약 아직 지워야 할 숫자가 남아있는 경우 뒤에서부터 지움
        while (toRemove > 0) {
            stack.pop();
            toRemove--;
        }
        
        // 스택의 내용을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}