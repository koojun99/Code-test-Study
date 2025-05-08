import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<int[] > items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int val = sc.nextInt();

            items.add(new int[]{weight, val});
        }

        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            int weight = items.get(i-1)[0];
            int value = items.get(i-1)[1];

            for (int w = 0; w <= m; w++) {
                if (w < weight) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight] + value);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}