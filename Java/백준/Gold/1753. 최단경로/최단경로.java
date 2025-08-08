import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to;
        int weight;

        Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            graph.get(a).add(new Node(b, w));
        }

        int[] dist = dijkstra(graph, v, start);

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static int[] dijkstra(List<List<Node>> graph, int vertexCount, int start) {
        int[] dist = new int[vertexCount+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[] > pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});

        boolean[] visited = new boolean[vertexCount+1];

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int currentNode = current[1];

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            for (Node node : graph.get(currentNode)) {
                int nextNode = node.to;
                int newDist = currentDist + node.weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{newDist, nextNode});
                }
            }
        }
        return dist;
    }
}