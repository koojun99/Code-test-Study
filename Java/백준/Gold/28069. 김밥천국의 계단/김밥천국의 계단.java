import java.util.*;

public class Main {
    static int n, k;
    static final int INF = 1000001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (i + 1 <= n) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
            if (i + i / 2 <= n) {
                dp[i + i / 2] = Math.min(dp[i + i / 2], dp[i] + 1);
            }
        }
        System.out.println(dp[n] <= k ? "minigimbob" : "water");
    }
}
