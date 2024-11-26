import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] boxes = new int[n];

        for (int i = 0; i < n; i++) {
            boxes[i] = sc.nextInt();
        }

        System.out.println(dp(boxes, n));
    }

    public static long dp(int[] boxes, int n) {
        if (n == 1) {
            return 1;
        }

        long[] dp = new long[n];
        dp[0] = 1;

        // DP 계산
        long maxLIS = 1; // 전체 LIS 중 최대값
        for (int i = 1; i < n; i++) {
            dp[i] = 1; // 기본 길이는 1 (자기 자신만 포함하는 경우)
            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }
}

