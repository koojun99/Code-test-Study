import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int n = sc.nextInt();
            System.out.println(padovan(n));
        }

    }

    public static long padovan(int n) {
        if (n <= 3) {
            return 1;
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        // DP 계산
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}

