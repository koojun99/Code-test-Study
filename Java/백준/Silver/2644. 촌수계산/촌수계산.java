import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사람 수
        int personA = sc.nextInt(); // 첫 번째 사람
        int personB = sc.nextInt(); // 두 번째 사람
        int m = sc.nextInt(); // 관계의 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 관계 입력
        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            graph.get(parent).add(child);
            graph.get(child).add(parent); // 양방향 그래프
        }

        // BFS를 이용한 촌수 계산
        int kinship = calculateKinship(graph, personA, personB, n);

        System.out.println(kinship);
    }

    private static int calculateKinship(List<List<Integer>> graph, int start, int target, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start, 0 }); // {현재 사람, 촌수}
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int kinship = current[1];

            if (person == target) {
                return kinship;
            }

            for (int relative : graph.get(person)) {
                if (!visited[relative]) {
                    visited[relative] = true;
                    queue.offer(new int[] { relative, kinship + 1 });
                }
            }
        }

        return -1; // 연결이 되지 않은 경우
    }
}