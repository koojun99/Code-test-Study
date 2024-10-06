import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] grid = new int[n][n];
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int num = 1;
        int x = 0;
        int y = 0;
        int d = 0;
        while (num <= n*(n+1) / 2) {
	        grid[x][y] = num++;
	        int nx = x + dx[d];
	        int ny = y + dy[d];
	        if (!isValid(nx, ny, n, grid)) {
		        d = (d + 1) % 3;         // 방향을 전환 (아래 -> 오른쪽 -> 왼쪽 위)
                nx = x + dx[d];          // 새로운 방향으로 좌표 갱신
                ny = y + dy[d];
	        }
	        x = nx;
	        y = ny;
        }
        int[] answer = new int[n*(n+1) / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
	        for (int j = 0; j <= i; j++) {
		        answer[idx++] = grid[i][j];
	        }
        }
        return answer;
    }
    
    public boolean isValid(int x, int y, int n, int[][] grid) {
	    return x >= 0 && y >= 0 && x < n && y < n && (grid[x][y] == 0);
    }
}