import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1}; // 동남서북
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0'; // 붙어서 입력됨
            }
        }

        bfs(0, 0);
        System.out.println(dist[n - 1][m - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        dist[x][y] = 1; // 시작칸 포함

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1 && dist[nx][ny] == 0) {
                        dist[nx][ny] = dist[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}