import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long[][] dp = new long[n-1][21];
        dp[0][nums[0]] = 1;
        for (int i = 1; i < n-1; i++) {
            for (int sum = 0; sum <= 20; sum++) {
                int plus = sum + nums[i];
                int minus = sum - nums[i];

                if (plus <= 20) {
                    dp[i][plus] += dp[i-1][sum];
                }

                if (minus >= 0) {
                    dp[i][minus] += dp[i-1][sum];
                }
            }
        }

        System.out.println(dp[n-2][nums[n-1]]);
    }
}
