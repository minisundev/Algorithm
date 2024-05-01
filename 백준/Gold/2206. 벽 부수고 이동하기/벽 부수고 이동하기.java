import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][][] visit;
    static int N;
    static int M;
    static int[][] ds = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new int[N][M][2];

        for (int i = 0; i < arr.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        min = Math.min(search(0, 0, N - 1, M - 1),min);

        System.out.println(min);
    }

    static int search(int startX, int startY, int targetX, int targetY) {

        int count = 1;

        List<Node> list = new ArrayList<>();
        List<Node> next;

        list.add(new Node(startX, startY, 0));
        visit[startX][startY][0] = 1;

        while (!list.isEmpty()) {

            next = new ArrayList<>();

            for(Node now : list) {
                int x = now.x;
                int y = now.y;
                int b = now.brokeWall;

                if (x == targetX && y == targetY) {
                    return visit[x][y][b];
                }

                for (int[] move : ds) {
                    int X = x + move[0];
                    int Y = y + move[1];

                    if (X >= 0 && X < N && Y >= 0 && Y < M ) {
                        if (arr[X][Y] == 1 && b == 0) {
                            visit[X][Y][1] = visit[x][y][0] + 1;
                            next.add(new Node(X, Y, 1));
                        } else if (arr[X][Y] == 0 && visit[X][Y][b] == 0) {
                            visit[X][Y][b] = visit[x][y][b] + 1;
                            next.add(new Node(X, Y, b));
                        }
                    }
                }
            }
            list = next;
            count++;
        }

        return -1;
    }
}

class Node {
    public int x;
    public int y;
    public int brokeWall;

    public Node(int x, int y, int b) {
        this.x = x;
        this.y = y;
        this.brokeWall = b;
    }
}
