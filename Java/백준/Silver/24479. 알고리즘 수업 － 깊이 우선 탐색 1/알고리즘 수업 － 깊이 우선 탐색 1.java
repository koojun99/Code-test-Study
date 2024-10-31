import java.util.*;

public class Main {
    static int[] visitOrder;         // 방문 순서 저장 배열
    static boolean[] visited;        // 방문 여부 확인 배열
    static int order = 1;            // 방문 순서 카운터

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점의 수
        int m = sc.nextInt(); // 간선의 수
        int r = sc.nextInt(); // 시작 정점

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
            graph.get(v).add(u);
        }

        // 각 정점의 인접 정점을 오름차순 정렬
        for (List<Integer> edges : graph) {
            Collections.sort(edges);
        }

        // 방문 순서 배열과 방문 여부 배열 초기화
        visitOrder = new int[n + 1];
        visited = new boolean[n + 1];

        // DFS 시작
        dfs(graph, r);

        // 방문 순서 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    // DFS 함수 정의
    private static void dfs(List<List<Integer>> graph, int current) {
        visited[current] = true;
        visitOrder[current] = order++; // 방문 순서 기록

        for (int next : graph.get(current)) {
            if (!visited[next]) {
                dfs(graph, next);
            }
        }
    }
}
