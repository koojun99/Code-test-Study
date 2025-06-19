import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);  // 양방향 연결
        }

        dfs(1); // 루트를 1로 시작

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : tree[node]) {
            if (!visited[next]) {
                parent[next] = node;
                dfs(next);
            }
        }
    }
}