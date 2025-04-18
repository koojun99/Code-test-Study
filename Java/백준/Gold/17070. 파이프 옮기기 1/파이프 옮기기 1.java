import java.util.*;

public class Main {
    static final int HORIZONTAL = 0;
    static final int VERTICAL   = 1;
    static final int DIAGONAL   = 2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 3) {
            System.out.println(1);
            return;
        }
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }


        int[][][] dp = new int[n][n][3];
        dp[0][1][HORIZONTAL] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j][HORIZONTAL] > 0) { // if horizontal
                    if (j+1 < n && grid[i][j+1] == 0) { // go horizontal
                        dp[i][j+1][HORIZONTAL] += dp[i][j][HORIZONTAL];
                    }

                    if (i+1 < n && j+1 < n
                    && grid[i][j+1] == 0
                    && grid[i+1][j+1] == 0
                    && grid[i+1][j] == 0) { // go diagonal
                        dp[i+1][j+1][DIAGONAL] += dp[i][j][HORIZONTAL];
                    }
                }

                if (dp[i][j][VERTICAL] > 0) { // if vertical
                    if (i+1 < n && grid[i+1][j] == 0) { // go vertical
                        dp[i+1][j][VERTICAL] += dp[i][j][VERTICAL];
                    }

                    if (i+1 < n && j+1 < n
                            && grid[i][j+1] == 0
                            && grid[i+1][j+1] == 0
                            && grid[i+1][j] == 0) { // go diagonal
                        dp[i+1][j+1][DIAGONAL] += dp[i][j][VERTICAL];
                    }
                }

                if (dp[i][j][DIAGONAL] > 0) { // if diagonal
                    if (j+1 < n && grid[i][j+1] == 0) { // go horizontal
                        dp[i][j+1][HORIZONTAL] += dp[i][j][DIAGONAL];
                    }

                    if (i+1 < n && grid[i+1][j] == 0) { // go vertical
                        dp[i+1][j][VERTICAL] += dp[i][j][DIAGONAL];
                    }

                    if (i+1 < n && j+1 < n
                            && grid[i][j+1] == 0
                            && grid[i+1][j+1] == 0
                            && grid[i+1][j] == 0) { // go diagonal
                        dp[i+1][j+1][DIAGONAL] += dp[i][j][DIAGONAL];
                    }
                }
            }
        }

        int answer = dp[n-1][n-1][HORIZONTAL] + dp[n-1][n-1][VERTICAL] + dp[n-1][n-1][DIAGONAL];
        System.out.println(answer);
    }

}
