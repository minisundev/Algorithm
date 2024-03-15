import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        min = 100001;
        move(n,k);
        System.out.println(min);


    }

    static void move(int n, int k){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        queue.offer(new int[]{n, 0}); // 현재 위치와 이동 횟수를 큐에 추가
        visit[n] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int count = current[1];

            if (pos == k) {
                min = Math.min(min, count);
                return;
            }

            if (pos + 1 <= 100000 && !visit[pos + 1]) {
                queue.offer(new int[]{pos + 1, count + 1});
                visit[pos + 1] = true;
            }
            if (pos - 1 >= 0 && !visit[pos - 1]) {
                queue.offer(new int[]{pos - 1, count + 1});
                visit[pos - 1] = true;
            }
            if (pos * 2 <= 100000 && !visit[pos * 2]) {
                queue.offer(new int[]{pos * 2, count + 1});
                visit[pos * 2] = true;
            }
        }
    }
}