import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    // 상하좌우 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
        }

        int answer = 0;
        for (int rain = 0; rain <= maxHeight; rain++) {
            visited = new boolean[n][n];
            int safeAreas = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && grid[i][j] > rain) {
                        dfs(i, j, rain);
                        safeAreas++;
                    }
                }
            }
            answer = Math.max(answer, safeAreas);
        }
        System.out.println(answer);

    }

    private static void dfs(int x, int y, int rain) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && grid[nx][ny] > rain) {
                    dfs(nx, ny, rain);
                }
            }
        }
    }
}
