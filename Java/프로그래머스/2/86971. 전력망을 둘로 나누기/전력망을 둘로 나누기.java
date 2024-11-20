import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDifference = Integer.MAX_VALUE;

        // 그래프 생성
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        // 전선 하나 끊기
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];

            // 전선 제거
            graph.get(node1).remove((Integer) node2);
            graph.get(node2).remove((Integer) node1);

            // 하나의 서브트리 크기 계산
            boolean[] visited = new boolean[n + 1];
            int subTreeSize = dfs(node1, graph, visited);

            // 두 전력망의 송전탑 개수 차이 계산
            int otherSubTreeSize = n - subTreeSize;
            minDifference = Math.min(minDifference, Math.abs(subTreeSize - otherSubTreeSize));

            // 전선 복원
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        return minDifference;
    }

    private int dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1; // 현재 노드 포함

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited);
            }
        }

        return count;
    }
}
