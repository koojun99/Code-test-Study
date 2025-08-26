import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = 0; // 1은 이미 1이므로 연산 0회

        for (int i = 2; i <= n; i++) {
            // 기본: i -> i-1 (한 번 연산)
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지면 고려
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            // 3으로 나누어 떨어지면 고려
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}