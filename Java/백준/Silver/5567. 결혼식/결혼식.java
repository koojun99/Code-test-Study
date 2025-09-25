import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n; // 사람 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b= sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(bfs(1));
    }

    private static int bfs(int start) {
        Queue<int[] > queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int person = curr[0];
            int depth = curr[1];

            if (depth >= 2) {
                continue;
            }

            for (int next : graph.get(person)) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.offer(new int[] {next, depth+1});
                }
            }
        }
        return count;
    }
}