import java.util.*;

public class Main {
    static boolean hasPathWithoutFan = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        // 팬클럽이 있는 정점들 입력
        int S = sc.nextInt(); // 팬클럽 곰곰이의 위치 개수
        Set<Integer> fanLocations = new HashSet<>();
        for (int i = 0; i < S; i++) {
            int s = sc.nextInt();
            fanLocations.add(s);
        }

        // 정점 1에서부터 도달 가능한 모든 노드를 탐색
        boolean[] visited = new boolean[N + 1];
        dfs(1, graph, visited, fanLocations, false);

        System.out.println(hasPathWithoutFan ? "yes" : "Yes");
    }

    private static void dfs(int current, List<List<Integer>> graph, boolean[] visited, Set<Integer> fanLocations, boolean encounteredFan) {
        visited[current] = true;

        // 경로 중간에 팬클럽 노드를 만나면 encounteredFan을 true로 설정
        if (fanLocations.contains(current)) {
            encounteredFan = true;
        }

        // 현재 노드가 리프 노드(더 이상 갈 곳이 없음)
        if (graph.get(current).isEmpty()) {
            // 리프 노드에 도달했을 때 경로 중간에 팬클럽 노드가 없었다면 경로는 팬클럽 없이 끝남
            if (!encounteredFan) {
                hasPathWithoutFan = true;
            }
            return;
        }

        for (int next : graph.get(current)) {
            if (!visited[next]) {
                dfs(next, graph, visited, fanLocations, encounteredFan);
                // 탐색 후에는 다른 경로를 위해 visited 초기화
                visited[next] = false;
            }
        }
    }
}
