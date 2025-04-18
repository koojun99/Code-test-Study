import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) continue;

                int nj = j + board[i][j];
                if (nj < n){
                    dp[i][nj] += dp[i][j];
                }
                int ni = i + board[i][j];
                if (ni < n) {
                    dp[ni][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }

}
