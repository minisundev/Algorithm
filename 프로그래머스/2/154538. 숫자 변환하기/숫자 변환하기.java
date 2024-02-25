import java.util.HashSet;

class Solution {
    public int solution(int x, int y, int n) {

        int depth = 0;
        HashSet<Integer> queue = new HashSet<>();
        HashSet<Integer> next = null;
        queue.add(x);

        while (!queue.isEmpty()) {
            if (queue.contains(y))
                return depth;
            next = new HashSet<>();
            for (int val : queue) {
                int left = val + n;
                int middle = val * 2;
                int right = val * 3;
                if (left <= y) next.add(left);
                if (middle <= y) next.add(middle);
                if (right <= y) next.add(right);
            }
            queue = next;
            depth++;
        }
        return -1;
    }
}