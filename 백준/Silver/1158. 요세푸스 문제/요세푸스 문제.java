import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //순서대로 K번째 사람을 제거한다
        //원에서 사람들이 모두 제거될때까지, 사람들이 제거되는 순서를 기록
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int number = 0;

        while (list.size()>1) {
            number = (number-1+K)%list.size();
            sb.append(list.remove(number));
            sb.append(", ");

        }
        sb.append(list.get(0));
        sb.append(">");

        System.out.println(sb);
    }
}