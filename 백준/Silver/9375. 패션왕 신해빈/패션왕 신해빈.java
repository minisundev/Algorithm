import java.util.*;

public class Main {

    static int n = 0;
    static int t = 0;

    static HashMap<String,Integer> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = Integer.parseInt(sc.nextLine());

        loop:
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(sc.nextLine());
            //map에 의상별 개수 등록
            map = new HashMap<>();
            for (int j = 0; j < n; j++) {

                if(!sc.hasNextLine()){
                    break loop;
                }

                String s = sc.nextLine();
                String[] arr = s.split(" ");
                int count = map.getOrDefault(arr[1], 0);
                count++;
                map.put(arr[1], count);
            }

            int sum = 1;
            //map에서 의상별로 꺼내서 곱하기
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            for (Map.Entry<String, Integer> entry : list) {
                sum *= (1+entry.getValue());
            }
            System.out.println(sum - 1);

        }

    }

}