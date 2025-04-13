import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[k+1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i-coin];
            }
        }

        System.out.println(dp[k]);
    }
}
