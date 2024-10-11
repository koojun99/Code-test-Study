import java.util.*;

class Solution {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        return bfs(maps, visited, n, m);
    }
    
    private int bfs(int[][] maps, boolean[][] visited, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1}); // 시작 위치와 시작 거리를 큐에 추가
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            // 목표 지점에 도달하면 거리를 반환
            if (x == n - 1 && y == m - 1) {
                return distance;
            }
            
            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                // 다음 위치가 유효하고 방문하지 않았으며, 이동할 수 있는 경우
                if (isValid(maps, nx, ny, visited)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, distance + 1});
                }
            }
        }
        
        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }
    
    private boolean isValid(int[][] maps, int x, int y, boolean[][] visited) {
        return (x >= 0 && y >= 0 && x < maps.length && y < maps[0].length && maps[x][y] == 1 && !visited[x][y]);
    }
}
