import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(minPathWithNoRepeat(grid, n, m));
    }

    // d=0: 왼쪽 대각선 ↙ (j-1), d=1: 아래 ↓ (j), d=2: 오른쪽 대각선 ↘ (j+1)
    private static final int[] DJ = {-1, 0, 1};

    private static int minPathWithNoRepeat(int[][] grid, int n, int m) {
        final int INF = Integer.MAX_VALUE / 2;
        // dp[i][j][d]: i행 j열 마지막 이동이 방향 d일 때의 최소 합
        int[][][] dp = new int[n][m][3];

        // 첫 행 초기화: 시작 시 방향은 없으므로
        // 편의상 모든 d에 동일하게 grid[0][j]를 넣어줍니다.
        for (int j = 0; j < m; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = grid[0][j];
            }
        }

        // 2행부터 DP 갱신
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 각 방향 d로 내려올 때
                for (int d = 0; d < 3; d++) {
                    int prevJ = j - DJ[d];
                    if (prevJ < 0 || prevJ >= m) {
                        dp[i][j][d] = INF;
                        continue;
                    }
                    // 이전 방향 p != d 인 것만 골라 최소값
                    int best = INF;
                    for (int p = 0; p < 3; p++) {
                        if (p == d) continue;
                        best = Math.min(best, dp[i - 1][prevJ][p]);
                    }
                    dp[i][j][d] = best + grid[i][j];
                }
            }
        }

        // 마지막 행(n-1)에서 j=0..m-1, d=0..2 중 최소값
        int answer = INF;
        for (int j = 0; j < m; j++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[n - 1][j][d]);
            }
        }
        return answer;
    }
}
