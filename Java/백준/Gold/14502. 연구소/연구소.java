import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};  // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int maxSafe = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        dfs(n, m, grid, 0);

        System.out.println(maxSafe);
    }

    static void dfs(int n, int m, int[][] grid, int wallCount) {
        // 벽 3개 다 세웠으면 → 바이러스 퍼뜨리기
        if (wallCount == 3) {
            spreadVirus(n, m, grid);
            return;
        }

        // 빈 칸(0)에 벽을 세운다 → 모든 경우 시도
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;  // 벽 세우기
                    dfs(n, m, grid, wallCount + 1);
                    grid[i][j] = 0;  // 다시 원복 (백트래킹)
                }
            }
        }
    }

    static void spreadVirus(int n, int m, int[][] grid) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            temp[i] = grid[i].clone();
        }

        Queue<int[] > queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int cx = current[0];
            int cy = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < n && ny >=0 && ny < m) {
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        int safeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    safeCount++;
                }
            }
        }

        maxSafe = Math.max(maxSafe, safeCount);
    }
}