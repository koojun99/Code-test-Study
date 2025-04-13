import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // nextInt 후 남은 개행문자 소비

        // 각 행이 하나의 문자열 형태로 주어지므로, 문자열을 읽어 각 문자를 정수로 변환함.
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                // 문자를 '0'과의 차로 변환하여 정수 0 또는 1로 저장
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[n][n];

        int complexCount = 0;
        List<Integer> apartCounts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, grid, visited, n, apartCounts);
                    complexCount++;
                }
            }
        }

        System.out.println(complexCount);
        Collections.sort(apartCounts);
        for (int i = 0; i < apartCounts.size(); i++) {
            System.out.println(apartCounts.get(i));
        }
    }

    private static void bfs(int x, int y, int[][] grid, boolean[][] visited, int n, List<Integer> apartCounts) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int apartCount = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        apartCount++;
                    }
                }
            }
        }
        apartCounts.add(apartCount);

    }
}
