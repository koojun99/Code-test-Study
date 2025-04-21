import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 가로
        int n = sc.nextInt(); // 세로
        sc.nextLine(); // 🔥 줄바꿈 제거

        String[][] grid = new String[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().split("");
        }

        boolean[][] visited = new boolean[n][m];
        int white = 0, blue = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    int size = bfs(i, j, grid, grid[i][j], visited);
                    int power = size * size;
                    if (grid[i][j].equals("W")) white += power;
                    else blue += power;
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    private static int bfs(int x, int y, String[][] grid, String team, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int count = 1;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                    if (!visited[nx][ny] && grid[nx][ny].equals(team)) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

