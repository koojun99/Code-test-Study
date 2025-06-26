import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] sessions = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int duration = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            sessions[i][0] = duration;
            sessions[i][1] = cost;
        }

        int[] dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            int end = i + sessions[i][0];
            if (end <= n) {
                dp[end] = Math.max(dp[end], dp[i] + sessions[i][1]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[n]);

    }
}