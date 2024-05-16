import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int curious = Integer.parseInt(st.nextToken());

            Queue<File> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                q.add(new File(Integer.parseInt(st.nextToken()), j));
            }

            int count = 0;

            while (!q.isEmpty()) {
                File file = q.poll();
                boolean hasPrior = false;

                for (File f : q) {
                    if (f.priority > file.priority) {
                        hasPrior = true;
                        break;
                    }
                }

                if (hasPrior) {
                    q.add(file);
                } else {
                    count++;
                    if (file.index == curious) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.print(sb.toString());
    }
}

class File {
    public int priority;
    public int index;

    public File(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}
