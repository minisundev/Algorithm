import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 민호의 집에 있는 물건의 종류의 수
        int M = Integer.parseInt(st.nextToken()); // 최대 무게
        int[] dp = new int[M + 1]; // 가방의 최대 무게에 따른 만족도 저장 배열

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 물건의 무게
            int C = Integer.parseInt(st.nextToken()); // 물건의 만족도
            int K = Integer.parseInt(st.nextToken()); // 물건의 개수

            // 물건을 이진 분할로 나누어 배낭 문제 해결
            for (int count = 1; K > 0; count *= 2) {
                int take = Math.min(count, K); // 남은 개수 중에서 최대한의 이진 분할 개수 선택
                K -= take; // 사용한 개수만큼 감소
                int weight = V * take; // 선택한 물건의 총 무게
                int value = C * take; // 선택한 물건의 총 만족도

                // 무게가 큰 쪽에서 작은 쪽으로 역순으로 dp 테이블 갱신
                for (int j = M; j >= weight; j--) {
                    dp[j] = Math.max(dp[j], dp[j - weight] + value);
                }
            }
        }

        System.out.println(dp[M]);
    }
}
