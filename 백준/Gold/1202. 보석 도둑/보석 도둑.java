import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석의 개수
        int K = Integer.parseInt(st.nextToken()); // 가방의 개수

        List<Jewel> list = new ArrayList<>();

        // N개의 보석의 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long m = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            list.add(new Jewel(m, v));
        }

        // 보석을 무게별로 오름차순 정렬, 무게가 같으면 가격 내림차순 정렬
        Collections.sort(list, (o1, o2) -> {
            if (o1.weight != o2.weight) {
                return Long.compare(o1.weight, o2.weight);
            } else {
                return Long.compare(o2.value, o1.value);
            }
        });

        PriorityQueue<Long> bags = new PriorityQueue<>();

        // K개의 가방의 정보
        for (int i = 0; i < K; i++) {
            long m = Long.parseLong(br.readLine());
            bags.add(m);
        }

        long sum = 0;
        PriorityQueue<Jewel> availableJewels = new PriorityQueue<>((o1, o2) -> Long.compare(o2.value, o1.value));
        int jewelIndex = 0;

        // 가방에 넣어본다
        while (!bags.isEmpty()) {
            long capacity = bags.poll(); // 작은 크기의 가방부터 출력

            // 가방의 용량보다 작은 보석들을 후보에 넣는다
            while (jewelIndex < list.size() && list.get(jewelIndex).weight <= capacity) {
                availableJewels.add(list.get(jewelIndex));
                jewelIndex++;
            }

            // 후보 중 가장 비싼 보석을 가방에 넣는다
            if (!availableJewels.isEmpty()) {
                sum += availableJewels.poll().value;
            }
        }
        System.out.println(sum);
    }
}

class Jewel {
    public long weight;
    public long value;

    public Jewel(long weight, long value) {
        this.weight = weight;
        this.value = value;
    }
}