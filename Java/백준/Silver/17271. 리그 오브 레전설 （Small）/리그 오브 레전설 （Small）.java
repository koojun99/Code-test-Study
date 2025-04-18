import java.util.*;

public class Main {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i] + dp[i-1]) % MOD;

            if (i - m >= 0) {
                dp[i] = (dp[i] + dp[i-m]) % MOD;
            }
        }

        System.out.println(dp[n]);
    }

}