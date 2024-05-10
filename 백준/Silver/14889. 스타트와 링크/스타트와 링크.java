import java.util.Scanner;

public class Main {

    static int N;
    static int[][] S;
    static int[] visited;
    static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        S = new int[N][N];
        visited = new int[N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = scanner.nextInt();
            }
        }

        team(0, 0);
        System.out.println(result);
    }

    public static void team(int a, int n) {
        if (a == N / 2) {
            int start = 0, link = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i] == 1 && visited[j] == 1) {
                        start += S[i][j];
                    } else if (visited[i] == 0 && visited[j] == 0) {
                        link += S[i][j];
                    }
                }
            }
            result = Math.min(result, Math.abs(start - link));
            return;
        } else {
            for (int x = n; x < N; x++) {
                if (visited[x] == 0) {
                    visited[x] = 1;
                    team(a + 1, x + 1);
                    visited[x] = 0;
                }
            }
        }
    }
}