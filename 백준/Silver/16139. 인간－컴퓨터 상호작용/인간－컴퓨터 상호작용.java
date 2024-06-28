import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int n = s.length();

        Map<Character, int[]> charCumulativeCounts = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            charCumulativeCounts.put(c, new int[n + 1]);
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                charCumulativeCounts.get(ch)[i + 1] = charCumulativeCounts.get(ch)[i] + (ch == c ? 1 : 0);
            }
        }

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char target = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int[] cumulative = charCumulativeCounts.get(target);
            int diff = cumulative[end + 1] - cumulative[start];
            sb.append(diff).append("\n");
        }
        System.out.println(sb);
    }
}
