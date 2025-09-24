import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단 수
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];

        if (n >= 1) dp[1] = score[1];
        if (n >= 2) dp[2] = score[1] + score[2];
        if (n >= 3) dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(
                dp[i - 2] + score[i],
                dp[i - 3] + score[i - 1] + score[i]
            );
        }

        System.out.println(dp[n]);
    }
}