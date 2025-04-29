import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[n][m];
        List<int[] > coins = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = input.charAt(j);
                if (grid[i][j] == 'o') {
                    coins.add(new int[]{i, j});
                }
            }
        }

        int answer = bfs(grid, coins.get(0), coins.get(1), n, m);
        System.out.println(answer);
    }

    private static int bfs(char[][] grid, int[] coin1, int[] coin2, int n, int m) {
        Queue<CoinSet> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][m][n][m];
        queue.offer(new CoinSet(coin1[0], coin1[1], coin2[0], coin2[1], 0));
        visited[coin1[0]][coin1[1]][coin2[0]][coin2[1]] = true;

        while(!queue.isEmpty()) {
            CoinSet curr = queue.poll();

            if (curr.moves >= 10) return -1;
            for (int d = 0; d < 4; d++) {
                int nx1 = curr.x1 + dx[d];
                int ny1 = curr.y1 + dy[d];
                int nx2 = curr.x2 + dx[d];
                int ny2 = curr.y2 + dy[d];

                boolean out1 = isOut(nx1, ny1, n, m);
                boolean out2 = isOut(nx2, ny2, n, m);

                if (out1 && !out2 || !out1 && out2) {
                    return curr.moves+1;
                }
                if (out1 && out2) continue;;

                if (!out1 && grid[nx1][ny1] == '#') {
                    nx1 = curr.x1;
                    ny1 = curr.y1;
                }

                if (!out2 && grid[nx2][ny2] == '#') {
                    nx2 = curr.x2;
                    ny2 = curr.y2;
                }

                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    queue.offer(new CoinSet(nx1, ny1, nx2, ny2, curr.moves+1));
                }
            }
        }
        return -1;
    }

    private static boolean isOut(int x, int y, int n, int m) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }

    static class CoinSet {
        private int x1, y1, x2, y2, moves;
        public CoinSet(int x1, int y1, int x2, int y2, int moves ) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.moves = moves;
        }
    }
}
