import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int[] answer = new int[2];
            answer[0] = dp[num][0];
            answer[1] = dp[num][1];
            System.out.println(answer[0] + " " + answer[1]);
        }

    }
}