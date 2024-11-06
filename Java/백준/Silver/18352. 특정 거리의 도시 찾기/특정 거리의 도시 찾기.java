import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도시 개수
        int m = sc.nextInt(); // 도로 개수
        int k = sc.nextInt(); // 거리 정보
        int x = sc.nextInt(); // 출발 도시 번호

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력 및 양방향 그래프 구성
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        // 최단 거리 정보 초기화
        int[] distances = new int[n + 1];

        boolean[] visited = new boolean[n+1];

        // 출발 도시의 최단 거리는 0
        distances[x] = 0;

        bfs(x, graph, distances, visited);

        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == k) {
                System.out.println(i);
                found = true;
            }
        }

        // 목표 거리에 해당하는 도시가 없는 경우 -1 출력
        if (!found) {
            System.out.println(-1);
        }
    }

    private static void bfs(int x, List<List<Integer>> graph, int[] distances, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    distances[next] = distances[current] + 1;
                }
            }
        }
    }
}