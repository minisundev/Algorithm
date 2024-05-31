import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken()) - 1;
        int second = Integer.parseInt(st.nextToken()) - 1;

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            arr[child] = parent + 1;
        }

        ArrayList<Integer> firstAncestors = new ArrayList<>();
        ArrayList<Integer> secondAncestors = new ArrayList<>();

        int current = first;
        while (current != -1) {
            firstAncestors.add(current);
            current = arr[current] - 1;
        }

        current = second;
        while (current != -1) {
            secondAncestors.add(current);
            current = arr[current] - 1;
        }

        int lca = -1;
        for (int i = 0; i < firstAncestors.size(); i++) {
            if (secondAncestors.contains(firstAncestors.get(i))) {
                lca = firstAncestors.get(i);
                break;
            }
        }

        if (lca == -1) {
            System.out.println(-1);
        } else {
            int firstDistance = firstAncestors.indexOf(lca) + 1;
            int secondDistance = secondAncestors.indexOf(lca) + 1;
            System.out.println(firstDistance + secondDistance - 2);  
        }
    }
}
