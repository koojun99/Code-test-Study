import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(kindOfFibo(n));
    }

    private static long kindOfFibo(int n) {
        if (n <= 3) {
            return 1;
        }
        long[] dp = new long[n+1];
        // 초기값 설정
        dp[1] = dp[2] = dp[3] = 1;

        // 점화식: dp[i] = dp[i-1] + dp[i-3]
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-3];
        }
        return dp[n];
    }
}