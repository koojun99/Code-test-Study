import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int computer = sc.nextInt();
        int network = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= computer; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < network; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[computer+1];
        int answer = dfs(graph, visited, 1);
        System.out.println(answer);
    }

    private static int dfs(List<List<Integer>> graph, boolean[] visited, int start) {
        int count = 0;
        visited[start] = true;
        for (int nextComputer : graph.get(start)) {
            if (!visited[nextComputer]) {
                count++;
                count += dfs(graph, visited, nextComputer);
            }
        }
        return count;
    }
}