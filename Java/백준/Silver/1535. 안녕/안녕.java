import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] health = new int[n];
        int[] happiness = new int[n];

        for (int i = 0; i < n; i++) {
            health[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            happiness[i] = sc.nextInt();
        }

        int[] dp = new int[100]; // 체력이 0~99까지 가능한 최대 행복도 저장

        for (int i = 0; i < n; i++) {
            for (int j = 99; j >= health[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - health[i]] + happiness[i]);
            }
        }

        // 100 이상의 체력은 불가능하므로, dp[0~99] 중 최댓값 출력
        int maxHappiness = 0;
        for (int val : dp) {
            maxHappiness = Math.max(maxHappiness, val);
        }

        System.out.println(maxHappiness);
    }
}