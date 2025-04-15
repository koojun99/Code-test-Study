import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wines = new int[n];

        for (int i = 0; i < n; i++) {
            wines[i] = sc.nextInt();
        }

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(wines[0]);
            return;
        }
        if (n == 2) {
            System.out.println(wines[0] + wines[1]);
            return;
        }

        int[] dp = new int[n];
        dp[0] = wines[0];
        dp[1] = wines[0] + wines[1];
        dp[2] = Math.max(wines[0] + wines[2], Math.max(wines[1] + wines[2], dp[1]));

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wines[i],
                    dp[i-3] + wines[i-1] + wines[i]));
        }

        System.out.println(dp[n-1]);

    }
}
