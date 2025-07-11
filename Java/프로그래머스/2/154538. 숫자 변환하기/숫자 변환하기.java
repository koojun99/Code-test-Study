import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{x, 0});
        visited.add(x);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int steps = cur[1];

            int[] nexts = new int[]{num + n, num * 2, num * 3};
            for (int next : nexts) {
                if (next > y || visited.contains(next)) continue;
                if (next == y) return steps + 1;

                visited.add(next);
                queue.offer(new int[]{next, steps + 1});
            }
        }

        return -1;
    }
}